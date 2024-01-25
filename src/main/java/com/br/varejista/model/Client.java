package com.br.varejista.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@Table(name ="client")
@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @Column(name = "cln_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "client_sequence")
    private Integer id;

    @Column(name = "cln_name")
    private String name;

    @Column(name = "cln_cpf")
    private String cpf;

    @Column(name = "cln_phone")
    private String phone;

    @Column(name = "cln_email")
    private String email;

    @Column(name = "cln_birth")
    private LocalDate birth;

    @Column(name = "cln_gender")
    private String gender;

}
