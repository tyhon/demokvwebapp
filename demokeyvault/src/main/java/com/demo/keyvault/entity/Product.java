package com.demo.keyvault.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "PRODUCT")
public class Product implements Serializable {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "ProductSequence", sequenceName = "seq_product")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ProductSequence")
    private Integer id;

    @Column(name = "prod_name")
    private String prodName;

    @Column(name = "price")
    private Integer price;

    public Product() {
        super();
    }
}