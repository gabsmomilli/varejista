package com.br.varejista.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name ="storage")
@Getter
@Builder
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Storage {
    @Id
    @Column(name = "stg_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "storage_sequence")
    private Integer id;

    @OneToMany
    @JoinTable(name = "storage_product",
            joinColumns = @JoinColumn(name = "stg_id"),
            inverseJoinColumns = @JoinColumn(name = "prd_id"))
    private Set<Product> products;

    @Column(name = "stg_name")
    private String name;

    @Column(name = "stg_cpj")
    private String cnpj;

    @Column(name = "stg_franchise")
    private String franchise;

    @Column(name = "stg_address")
    private String address;

}
