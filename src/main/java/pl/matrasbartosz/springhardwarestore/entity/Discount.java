package pl.matrasbartosz.springhardwarestore.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "discount_table")
@Data
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "discount_code")
    private String discountCode;

    @Column(name = "discount_percent")
    private Integer discountPercent;
}
