package pl.matrasbartosz.springhardwarestore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import pl.matrasbartosz.springhardwarestore.entity.Discount;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "discounts", path = "discounts")
public interface DiscountRepository extends JpaRepository<Discount, Long> {

    Discount findDiscountByDiscountCode(@Param("discountCode") String discountCode);
}
