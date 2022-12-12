package pl.matrasbartosz.springhardwarestore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.matrasbartosz.springhardwarestore.dao.ProductAlsoWatchedRepository;
import pl.matrasbartosz.springhardwarestore.entity.ProductAlsoWatched;

@Service
public class CorrelationServiceImpl implements CorrelationService{

    private final ProductAlsoWatchedRepository productAlsoWatchedRepository;

    @Autowired
    public CorrelationServiceImpl(ProductAlsoWatchedRepository productAlsoWatchedRepository) {
        this.productAlsoWatchedRepository = productAlsoWatchedRepository;
    }


    @Override
    @Transactional
    public ProductAlsoWatched findProductAlsoWatchedByIdFatherProductAndIdProduct(Long idFatherProduct, Long idProduct) {
        return productAlsoWatchedRepository.findProductAlsoWatchedByIdFatherProductAndIdProduct(idFatherProduct, idProduct);
    }

    @Transactional
    public void save(ProductAlsoWatched productAlsoWatched) {
        productAlsoWatchedRepository.save(productAlsoWatched);
    }
}
