package pl.matrasbartosz.springhardwarestore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.matrasbartosz.springhardwarestore.dao.ProductAlsoBoughtRepository;
import pl.matrasbartosz.springhardwarestore.dao.ProductAlsoWatchedRepository;
import pl.matrasbartosz.springhardwarestore.entity.ProductAlsoBought;
import pl.matrasbartosz.springhardwarestore.entity.ProductAlsoWatched;

@Service
public class CorrelationServiceImpl implements CorrelationService{

    private final ProductAlsoWatchedRepository productAlsoWatchedRepository;
    private final ProductAlsoBoughtRepository productAlsoBoughtRepository;

    @Autowired
    public CorrelationServiceImpl(ProductAlsoWatchedRepository productAlsoWatchedRepository, ProductAlsoBoughtRepository productAlsoBoughtRepository) {
        this.productAlsoWatchedRepository = productAlsoWatchedRepository;
        this.productAlsoBoughtRepository = productAlsoBoughtRepository;
    }


    @Override
    @Transactional
    public ProductAlsoWatched findProductAlsoWatchedByIdFatherProductAndIdProduct(Long idFatherProduct, Long idProduct) {
        return productAlsoWatchedRepository.findProductAlsoWatchedByIdFatherProductAndIdProduct(idFatherProduct, idProduct);
    }

    @Override
    public ProductAlsoBought findProductAlsoBoughtByIdFatherProductAndIdProduct(Long idFatherProduct, Long idProduct) {
        return productAlsoBoughtRepository.findProductAlsoBoughtByIdFatherProductAndIdProduct(idFatherProduct, idProduct);
    }

    @Transactional
    public void save(ProductAlsoWatched productAlsoWatched) {
        productAlsoWatchedRepository.save(productAlsoWatched);
    }

    @Override
    public void save(ProductAlsoBought productAlsoBought) {
        productAlsoBoughtRepository.save(productAlsoBought);
    }
}
