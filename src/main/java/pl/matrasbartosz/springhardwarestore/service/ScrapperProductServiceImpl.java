package pl.matrasbartosz.springhardwarestore.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.matrasbartosz.springhardwarestore.dao.ScrapperProductRepository;
import pl.matrasbartosz.springhardwarestore.entity.ScrapperProduct;

import java.util.List;

@Service
public class ScrapperProductServiceImpl implements ScrapperProductService{

    private final ScrapperProductRepository scrapperProductRepository;

    @Autowired
    public ScrapperProductServiceImpl(ScrapperProductRepository scrapperProductRepository){
        this.scrapperProductRepository = scrapperProductRepository;
    }

    @Override
    @Transactional
    public void saveScrapperProduct(ScrapperProduct scrapperProduct){
        scrapperProductRepository.save(scrapperProduct);
    }

    @Override
    @Transactional
    public ScrapperProduct getScrapperProduct(String sku, String pageName){
        return scrapperProductRepository.getScrapperProductBySkuAndPageName(sku, pageName);
    }

    @Override
    @Transactional
    public List<ScrapperProduct> getScrapperProducts(String sku) {
        return scrapperProductRepository.findScrapperProductsBySku(sku);
    }
}
