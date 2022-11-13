package pl.matrasbartosz.springhardwarestore.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product_sub_category")
@Getter
@Setter
public class ProductSubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "sub_category_name")
    private String subCategoryName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productSubCategory")
    private Set<Product> products;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", nullable = false)
    private ProductCategory productCategory;
}
