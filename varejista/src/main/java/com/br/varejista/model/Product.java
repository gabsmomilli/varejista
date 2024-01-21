package com.br.varejista.model;

import jakarta.persistence.*;
import lombok.*;

import java.awt.image.BufferedImage;
@Entity
@Table(name ="product")
@Getter
@Builder
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @Column(name = "prd_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "product_sequence")
    private Integer id;

    @Column(name = "prd_name")
    private String name;

    @Column(name = "prd_description")
    private String description;

    @Column(name = "prd_price")
    private Double price;

    @Column(name = "prd_size")
    private Integer size;

    @Column(name = "prd_quantity_in_stock")
    private Integer quantityInStock;

    @Column(name = "prd_color")
    private String color;
}
