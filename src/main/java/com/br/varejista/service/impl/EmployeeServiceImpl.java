package com.br.varejista.service.impl;

import com.br.varejista.model.Employee;
import com.br.varejista.repository.EmployeeRepository;
import com.br.varejista.service.EmployeeService;
import com.br.varejista.validator.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee save(final Employee employee, Operation operation) {
        return repository.saveAndFlush(employee);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Employee> findAllByEmployeeName(String nome) {
        return repository.findAllByEmployeeName(nome);
    }

    @Override
    public List<Employee> findAllByEmployeeCpf(String cpf) {
        return repository.findAllByEmployeeCpf(cpf);
    }

    @Override
    public List<Employee> findAllByEmployeeSalary(Double salary) {
        return repository.findAllByEmployeeSalary(salary);
    }

    @Override
    public List<Employee> findAllByEmployeeAddress(String address) {
        return repository.findAllByEmployeeAddress(address);
    }
}
