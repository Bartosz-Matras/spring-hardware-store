package pl.matrasbartosz.springhardwarestore.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "product_details")
@Getter
@Setter
public class ProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(mappedBy = "productDetails", cascade = CascadeType.ALL)
    private Product product;

    @Column(name = "data_1")
    private String data1;

    @Column(name = "data_2")
    private String data2;

    @Column(name = "data_3")
    private String data3;

    @Column(name = "data_4")
    private String data4;

    @Column(name = "data_5")
    private String data5;

    @Column(name = "data_6")
    private String data6;

    @Column(name = "data_7")
    private String data7;

    @Column(name = "data_8")
    private String data8;

    @Column(name = "data_9")
    private String data9;

    @Column(name = "data_10")
    private String data10;

    @Column(name = "data_11")
    private String data11;

    @Column(name = "data_12")
    private String data12;

    @Column(name = "data_13")
    private String data13;

    @Column(name = "data_14")
    private String data14;

    @Column(name = "data_15")
    private String data15;

    @Column(name = "data_16")
    private String data16;

    @Column(name = "data_17")
    private String data17;

    @Column(name = "data_18")
    private String data18;

    @Column(name = "data_19")
    private String data19;

    @Column(name = "data_20")
    private String data20;

}
