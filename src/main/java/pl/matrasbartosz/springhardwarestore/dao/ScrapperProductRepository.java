package pl.matrasbartosz.springhardwarestore.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import pl.matrasbartosz.springhardwarestore.entity.ScrapperProduct;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "scrapperProducts", path = "scrapperProducts")
public interface ScrapperProductRepository extends JpaRepository<ScrapperProduct, Long> {

    ScrapperProduct findScrapperProductBySku(@Param("sku") String sku);
    List<ScrapperProduct> findScrapperProductsBySku(@Param("sku") String sku);
    ScrapperProduct getScrapperProductBySkuAndPageName(String sku, String pageName);
}
