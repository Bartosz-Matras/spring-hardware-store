package pl.matrasbartosz.springhardwarestore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import pl.matrasbartosz.springhardwarestore.entity.ProductSubCategory;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "productsSubCategory", path = "productsSubCategory")
public interface ProductSubCategoryRepository extends JpaRepository<ProductSubCategory, Long> {
    List<ProductSubCategory> findProductSubCategoryByProductCategoryId(@Param("id") Long id);
}
