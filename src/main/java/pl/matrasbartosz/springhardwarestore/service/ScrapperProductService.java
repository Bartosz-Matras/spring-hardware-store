package pl.matrasbartosz.springhardwarestore.service;


import pl.matrasbartosz.springhardwarestore.entity.ScrapperProductPageOne;
import pl.matrasbartosz.springhardwarestore.entity.ScrapperProductPageTwo;

public interface ScrapperProductService {

    void saveScrapperProductOne(ScrapperProductPageOne scrapperProductPageOne);

    ScrapperProductPageOne getScrapperProductOne(String sku);

    void saveScrapperProductTwo(ScrapperProductPageTwo scrapperProductPageTwo);

    ScrapperProductPageTwo getScrapperProductTwo(String sku);

}
