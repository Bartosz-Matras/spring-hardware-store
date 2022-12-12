package pl.matrasbartosz.springhardwarestore.scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import pl.matrasbartosz.springhardwarestore.entity.ScrapperProduct;
import pl.matrasbartosz.springhardwarestore.exception.UrlNotFoundException;
import pl.matrasbartosz.springhardwarestore.service.ScrapperProductServiceImpl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

@Component
@PropertySource("classpath:scrapper.properties")
public class WrapperNarzedzia {

    @Value("${url.narzedzia}")
    private String URL;

    @Value("${url.pages.narzedzia}")
    private String URL_PAGES;

    @Value("${resource.path.narzedzia}")
    private String RESOURCE_PATH;

    private static final String ERROR_MSG = "Cannot connect to ";

    private final ScrapperProductServiceImpl scrapperProductServiceImpl;

    @Autowired
    public WrapperNarzedzia(ScrapperProductServiceImpl scrapperProductServiceImpl) {
        this.scrapperProductServiceImpl = scrapperProductServiceImpl;
    }

    public void startWrap() {
        int numberOfPages = getNumberOfPages();

        for (int i = 1; i <= numberOfPages; i++) {
            String url = String.format(URL_PAGES, i);
            saveToFile(url, " ", "urls.txt");
            scrapPage(url);
        }
    }

    private void saveToFile(String text1, String text2, String fileName) {
        try (OutputStreamWriter writer =
                     new OutputStreamWriter(new FileOutputStream(RESOURCE_PATH + fileName, true), StandardCharsets.UTF_8)){
            writer.append(text1).append(" ").append(text2).append("\n");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Integer getNumberOfPages(){
        int max;

        try {
            Document parsedDocument = Jsoup.connect(URL).get();
            Elements pageSize = parsedDocument.select(".page");
            max = getMax(pageSize.text().split(" ")[3]);
        }catch (IOException e){
            saveToFile("Scrapper stopped cannot connect to " + URL + "\n\n", e.getMessage(), "exception.txt");
            max = - 1;
        }
        return max;
    }

    private int getMax(String maxString){
        int max;
        try{
            max = Integer.parseInt(maxString);
        }catch (NumberFormatException e){
            saveToFile("Error trying parse: " + maxString + "\n", e.getMessage(), "numberFormatException.txt");
            max = -1;
        }
        return max;
    }

    private void scrapPage(String url) {
        try {
            Document parsedDocument = Jsoup.connect(url).get();
            Elements pageElements = parsedDocument.select(".title a");

            Set<String> modelsPrice = pageElements.stream()
                    .map(jobLink -> jobLink.attr("href"))
                    .map(this::scrapeThroughOfferPage)
                    .collect(Collectors.toSet());

            modelsPrice.forEach(s -> {
                if(!s.isEmpty()){
                    saveToFile(s, "", "modelPrice2.txt");
                    List<String> items = Arrays.stream(s.split("\\|")).map(String::trim).toList();
                    ScrapperProduct scrapperProduct
                            = scrapperProductServiceImpl.getScrapperProduct(items.get(0), items.get(3));

                    if (scrapperProduct == null){
                        ScrapperProduct newScrapperProduct
                                = new ScrapperProduct(0L, items.get(0), new BigDecimal(items.get(1).replace(" ", "")), items.get(2), items.get(3));
                        scrapperProductServiceImpl.saveScrapperProduct(newScrapperProduct);
                    }else if(!scrapperProduct.getUnitPrice().equals(new BigDecimal(items.get(1)))){
                        scrapperProduct.setSku(items.get(0));
                        scrapperProduct.setUnitPrice(new BigDecimal(items.get(1)));
                        scrapperProduct.setPageUrl(items.get(2));
                        scrapperProduct.setPageName(items.get(3));
                        scrapperProductServiceImpl.saveScrapperProduct(scrapperProduct);
                    }
                }
            });
        }catch (IOException e){
            saveToFile("UrlNotFoundException: ", new UrlNotFoundException(url).getMessage(), "exception.txt");
        }
    }

    private String scrapeThroughOfferPage(String subUrl) {
        String data = "";
        saveToFile(subUrl, " ", "urls.txt");

        try {
            Document subParsedDocument = Jsoup.connect(subUrl).get();

            Element catalogNumber = subParsedDocument.selectFirst(".catalogue_number strong");
            Element price = subParsedDocument.selectFirst(".price strong span");

            if(catalogNumber != null && price != null) {
                String catalogNumberString = catalogNumber.text().trim();
                String priceString = price.text().replace(",", ".").trim();
                data = catalogNumberString + " | " + priceString.replace(" ", "") + " | " + subUrl + " | " + "Narzedzia.pl";
                saveToFile(data, "", "modelPrice.txt");
            }

        }catch (IOException e) {
            saveToFile("UrlNotFoundException: ", new UrlNotFoundException(ERROR_MSG + subUrl).getMessage(), "exception.txt");
        }
        return data;
    }
}