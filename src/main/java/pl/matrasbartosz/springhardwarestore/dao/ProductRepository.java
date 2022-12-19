package pl.matrasbartosz.springhardwarestore.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import pl.matrasbartosz.springhardwarestore.entity.Product;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findProductByProductSubCategoryIdInAndActive(@Param("ids") List<Long> productIdList, @Param("active") Boolean active, Pageable pageable);

    Page<Product> findProductByProductSubCategoryIdAndActive(@Param("id") Long id, @Param("active") Boolean active, Pageable pageable);

    Page<Product> findByNameContainingAndActive(@Param("name") String name, @Param("active") Boolean active, Pageable pageable);

    Page<Product> findProductByActive(@Param("active") Boolean active, Pageable pageable);

    Product findProductById(@Param("id") Long id);

    List<Product> findProductByIdIn(@Param("ids") List<Long> productIdList);
}
