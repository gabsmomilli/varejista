package com.br.varejista.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name ="employee")
@Getter
@Builder
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @Column(name = "emp_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "employee_sequence")
    private Integer id;

    @Column(name = "emp_name")
    private String name;

    @Column(name = "emp_cpf")
    private String cpf;

    @Column(name = "emp_salary")
    private Double salary;

    @Column(name = "emp_address")
    private String address;
}
