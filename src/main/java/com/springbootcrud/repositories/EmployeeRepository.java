package com.springbootcrud.repositories;



import org.springframework.data.repository.CrudRepository;

import com.springbootcrud.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

    
}
