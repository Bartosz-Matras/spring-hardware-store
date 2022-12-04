package pl.matrasbartosz.springhardwarestore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import pl.matrasbartosz.springhardwarestore.entity.ScrapperProductPageTwo;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "productsTwo", path = "productsTwo")
public interface ScrapperProductPageTwoRepository extends JpaRepository<ScrapperProductPageTwo, Long> {

    ScrapperProductPageTwo findScrapperProductPageTwoBySku(@Param("sku") String sku);
    ScrapperProductPageTwo getScrapperProductPageTwoBySku(String sku);
}
