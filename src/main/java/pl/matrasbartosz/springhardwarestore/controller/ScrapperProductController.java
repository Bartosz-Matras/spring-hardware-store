package pl.matrasbartosz.springhardwarestore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.matrasbartosz.springhardwarestore.entity.ScrapperProductPageOne;
import pl.matrasbartosz.springhardwarestore.entity.ScrapperProductPageTwo;
import pl.matrasbartosz.springhardwarestore.service.ScrapperProductServiceImpl;

import java.math.BigDecimal;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class ScrapperProductController {

    @Autowired
    ScrapperProductServiceImpl scrapperProductService;

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/productsOne/search/findScrapperProductPageOneBySku")
    public ScrapperProductPageOne one(@RequestParam("sku") String sku) {
        ScrapperProductPageOne scrapperProductPageOne = scrapperProductService.getScrapperProductOne(sku);
        return Objects.requireNonNullElseGet(scrapperProductPageOne, () -> new ScrapperProductPageOne(-1L, "", new BigDecimal(0), "", ""));
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/productsTwo/search/findScrapperProductPageTwoBySku")
    public ScrapperProductPageTwo two(@RequestParam("sku") String sku) {
        ScrapperProductPageTwo scrapperProductPageTwo = scrapperProductService.getScrapperProductTwo(sku);
        return Objects.requireNonNullElseGet(scrapperProductPageTwo, () -> new ScrapperProductPageTwo(-1L, "", new BigDecimal(0), "", ""));
    }


}
