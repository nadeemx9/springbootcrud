package com.springbootcrud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springbootcrud.entities.Employee;
import com.springbootcrud.repositories.EmployeeRepository;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping("/add-employee")
    public String addEmployee(Model model, Employee employee) {
        model.addAttribute("employee", employee);
        return "add-employee";
    }

    @RequestMapping("/employee-list")
    public String employeeList(Model model) {
        List<Employee> employeeList = (List<Employee>) employeeRepository.findAll();
        model.addAttribute("employeeList", employeeList);
        return "employee-list";
    }

    @PostMapping("/processEmployee")
    public String processEmployee(Employee employee) {

        System.out.println(employee);
         employeeRepository.save(employee);

        return "redirect:employee-list";

    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("id") int id) {
        employeeRepository.deleteById(id);
        return "redirect:employee-list";
    }

    @RequestMapping("/updateEmployee")
    public String updateEmployee(@RequestParam("id") int id, Model model) {
        System.out.println(id);
        model.addAttribute("employee", employeeRepository.findById(id));
        return "add-employee";
    }

}
