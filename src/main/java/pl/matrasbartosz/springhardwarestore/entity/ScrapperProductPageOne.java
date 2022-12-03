package pl.matrasbartosz.springhardwarestore.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "scrapper_product_narzedzia")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScrapperProductPageOne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "sku")
    private String sku;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "page_url")
    private String pageUrl;

    @Column(name = "page_name")
    private String pageName;
}
