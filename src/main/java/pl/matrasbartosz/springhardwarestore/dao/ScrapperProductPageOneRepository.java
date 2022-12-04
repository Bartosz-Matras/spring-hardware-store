package pl.matrasbartosz.springhardwarestore.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import pl.matrasbartosz.springhardwarestore.entity.ScrapperProductPageOne;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "productsOne", path = "productsOne")
public interface ScrapperProductPageOneRepository extends JpaRepository<ScrapperProductPageOne, Long> {

    ScrapperProductPageOne findScrapperProductPageOneBySku(@Param("sku") String sku);
    ScrapperProductPageOne getScrapperProductPageOneBySku(String sku);
}
