package pl.matrasbartosz.springhardwarestore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.matrasbartosz.springhardwarestore.entity.ScrapperProductPageTwo;

public interface ScrapperProductPageTwoRepository extends JpaRepository<ScrapperProductPageTwo, Long> {

    ScrapperProductPageTwo getScrapperProductPageTwoBySku(String sku);
}
