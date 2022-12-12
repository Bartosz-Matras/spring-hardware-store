package pl.matrasbartosz.springhardwarestore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.matrasbartosz.springhardwarestore.entity.ScrapperProduct;
import pl.matrasbartosz.springhardwarestore.service.ScrapperProductServiceImpl;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ScrapperProductController {

    @Autowired
    private ScrapperProductServiceImpl scrapperProductService;

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/scrapperProducts/search/findScrapperProductsBySku")
    public List<ScrapperProduct> one(@RequestParam("sku") String sku) {
        List<ScrapperProduct> scrapperProduct = scrapperProductService.getScrapperProducts(sku);
        if (scrapperProduct.isEmpty()){
            return new ArrayList<>();
        }
        return scrapperProduct;
    }



}
