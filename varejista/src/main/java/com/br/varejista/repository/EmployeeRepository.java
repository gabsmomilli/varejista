package com.br.varejista.repository;

import com.br.varejista.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


    @Query("SELECT c FROM Employee c WHERE c.name like :name")
    List<Employee> findAllByEmployeeName(@Param("name") String name);

    @Query("SELECT c FROM Employee c WHERE c.cpf like :cpf")
    List<Employee> findAllByEmployeeCpf(@Param("cpf") String cpf);

    @Query("SELECT c FROM Employee c WHERE c.salary like :salary")
    List<Employee> findAllByEmployeeSalary(@Param("salary") Double salary);
    @Query("SELECT c FROM Employee c WHERE c.address like :address")
    List<Employee> findAllByEmployeeAddress(@Param("address") String address);


}
