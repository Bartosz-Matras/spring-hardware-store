package pl.matrasbartosz.springhardwarestore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import pl.matrasbartosz.springhardwarestore.entity.ProductAlsoWatched;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "productsAlsoWatched", path = "productsAlsoWatched")
public interface ProductAlsoWatchedRepository extends JpaRepository<ProductAlsoWatched, Long> {

    List<ProductAlsoWatched> findAllByOrderByWatchedCountDesc();
}
