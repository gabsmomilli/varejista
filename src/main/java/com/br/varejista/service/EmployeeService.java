package com.br.varejista.service;

import com.br.varejista.model.Employee;
import java.util.List;

public interface EmployeeService extends GenericService<Employee> {

    List<Employee> findAllByEmployeeName(final String name);

    List<Employee> findAllByEmployeeCpf(final String cpf);

    List<Employee> findAllByEmployeeSalary(final Double salary);

    List<Employee> findAllByEmployeeAddress(final String address);
}
