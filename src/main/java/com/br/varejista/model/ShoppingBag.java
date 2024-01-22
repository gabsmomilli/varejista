package com.br.varejista.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
@Entity
@Table(name ="shopping_bag")
@Getter
@Builder
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingBag {

    @Id
    @Column(name = "shp_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "shopping_bag_sequence")
    private Integer id;

    @OneToMany
    @JoinTable(name = "shopping_bag_product",
            joinColumns = @JoinColumn(name = "shp_id"),
            inverseJoinColumns = @JoinColumn(name = "prd_id"))
    private Set<Product> products;

    @OneToOne
    @JoinColumn(name = "cln_id", referencedColumnName = "cln_id")
    private Client client;

    @OneToOne
    @JoinColumn(name = "cpm_id", referencedColumnName = "cpm_id")
    private Cupom cupom;

    @Column(name = "shp_total_price")
    private Double totalPrice;

    @Column(name = "shp_discount")
    private Double discount;
}
