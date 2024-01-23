package com.br.varejista.controller;

import com.br.varejista.model.Employee;
import com.br.varejista.service.EmployeeService;
import com.br.varejista.validator.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity saveNew(@RequestBody final Employee newEmployee) {
        Employee savedEmployee = service.save(newEmployee, Operation.INSERT);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/find-by-name/{name}")
    public List<Employee> findAllByEmployeeName(@PathVariable("name") String name){
        return service.findAllByEmployeeName(name);
    }

    @GetMapping("/find-by-cpf/{cpf}")
    public List<Employee> findAllByEmployeeCpf(@PathVariable("cpf") String cpf){
        return service.findAllByEmployeeCpf(cpf);
    }

    @GetMapping("/find-by-salary/{salary}")
    public List<Employee> findAllByEmployeeSalary(@PathVariable("salary") Double salary){
        return service.findAllByEmployeeSalary(salary);
    }

    @GetMapping("/find-by-address/{address}")
    public List<Employee> findAllByEmployeeAddress(@PathVariable("address") String address){
        return service.findAllByEmployeeAddress(address);
    }
}
