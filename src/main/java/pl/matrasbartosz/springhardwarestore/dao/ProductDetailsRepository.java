package pl.matrasbartosz.springhardwarestore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import pl.matrasbartosz.springhardwarestore.entity.ProductDetails;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "productsDetails", path = "productsDetails")
public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Long> {
    ProductDetails findProductDetailsById(@Param("id") Long id);

    ProductDetails findProductDetailsByProductId(@Param("id") Long id);
}
