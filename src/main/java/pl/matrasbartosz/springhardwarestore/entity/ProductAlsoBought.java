package pl.matrasbartosz.springhardwarestore.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "product_also_bought")
@Getter
@Setter
public class ProductAlsoBought {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_father_product")
    private Long idFatherProduct;

    @Column(name  = "id_product")
    private Long idProduct;

    @Column(name = "bought_count")
    private Long boughtCount;

}
