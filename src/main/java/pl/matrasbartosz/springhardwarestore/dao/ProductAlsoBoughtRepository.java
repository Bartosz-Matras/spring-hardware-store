package pl.matrasbartosz.springhardwarestore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import pl.matrasbartosz.springhardwarestore.entity.ProductAlsoBought;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "productsAlsoBought", path = "productsAlsoBought")
public interface ProductAlsoBoughtRepository extends JpaRepository<ProductAlsoBought, Long> {

    List<ProductAlsoBought> findAllByOrderByBoughtCountDesc();

    List<ProductAlsoBought> findAllByIdFatherProductInOrderByBoughtCountDesc(@Param("ids") List<Long> ids);

    ProductAlsoBought findProductAlsoBoughtByIdFatherProductAndIdProduct(Long idFatherProduct, Long idProduct);
}
