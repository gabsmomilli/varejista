package com.br.varejista.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name ="product")
@Getter
@Setter
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

    @Column(name = "prd_category")
    private String category;

    @Column(name = "prd_brand")
    private String brand;

    @Column(name = "prd_date_register")
    private LocalDate dateRegister;
}
