package pl.matrasbartosz.springhardwarestore.service;


import pl.matrasbartosz.springhardwarestore.entity.ScrapperProduct;

import java.util.List;

public interface ScrapperProductService {

    void saveScrapperProduct(ScrapperProduct scrapperProduct);

    ScrapperProduct getScrapperProduct(String sku, String pageName);

    List<ScrapperProduct> getScrapperProducts(String sku);
}
