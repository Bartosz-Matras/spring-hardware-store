package pl.matrasbartosz.springhardwarestore.service;

import pl.matrasbartosz.springhardwarestore.entity.ProductAlsoWatched;

public interface CorrelationService {

    ProductAlsoWatched findProductAlsoWatchedByIdFatherProductAndIdProduct(Long idFatherProduct, Long idProduct);

    void save(ProductAlsoWatched productAlsoWatched);
}
