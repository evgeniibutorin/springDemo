package com.example.springdemo.controller;

import com.example.springdemo.model.Employee;
import com.example.springdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController{
        @Autowired
        private EmployeeService employeeService;

        //@RequestMapping(value = "/persons", method = RequestMethod.GET)
        @GetMapping(value = "/employees")
        public String listEmployees(Model model) {
                model.addAttribute("employee", new Employee());
                model.addAttribute("listEmployees", this.employeeService.listEmployees());
                return "employee";
        }

        //For add and update person both
        //@RequestMapping(value= "/person/add", method = RequestMethod.POST)
        @PostMapping(value= "/employee/add")
        public String addEmployee(@ModelAttribute("employee") Employee e){

                if(e.getId() == 0){
                        //new employee, add it
                        this.employeeService.addEmployee(e);
                }else{
                        //existing employee, call update
                        this.employeeService.updateEmployee(e);
                }

                return "redirect:/employees";

        }

        @RequestMapping("/remove/{id}")
        public String removeEmployee(@PathVariable("id") int id){

                this.employeeService.removeEmployee(id);
                return "redirect:/employees";
        }

        @RequestMapping("/edit/{id}")
        public String editEmployee(@PathVariable("id") int id, Model model){
                model.addAttribute("employee", this.employeeService.getEmployeeById(id));
                model.addAttribute("listEmployees", this.employeeService.listEmployees());
                return "employee";
        }

}
