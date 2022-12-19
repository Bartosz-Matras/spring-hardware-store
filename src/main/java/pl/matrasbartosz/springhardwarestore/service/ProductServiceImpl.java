package pl.matrasbartosz.springhardwarestore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.matrasbartosz.springhardwarestore.dao.ProductRepository;
import pl.matrasbartosz.springhardwarestore.entity.Product;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public Product findProductById(Long id) {
        return productRepository.findProductById(id);
    }

    @Override
    @Transactional
    public void save(Product product) {
        productRepository.save(product);
    }
}
