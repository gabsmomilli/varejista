package com.br.varejista.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name ="cupom")
@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Cupom {
    @Id
    @Column(name = "cpm_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "cupom_sequence")
    private Integer id;

    @Column(name = "cpm_name")
    private String name;

    @Column(name = "cpm_value")
    private Double value;

    @Column(name = "cpm_description")
    private String description;


}
