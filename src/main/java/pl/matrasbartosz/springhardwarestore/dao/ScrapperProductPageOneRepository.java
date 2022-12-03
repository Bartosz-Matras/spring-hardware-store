package pl.matrasbartosz.springhardwarestore.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import pl.matrasbartosz.springhardwarestore.entity.ScrapperProductPageOne;

public interface ScrapperProductPageOneRepository extends JpaRepository<ScrapperProductPageOne, Long> {

    ScrapperProductPageOne getScrapperProductPageOneBySku(String sku);
}
