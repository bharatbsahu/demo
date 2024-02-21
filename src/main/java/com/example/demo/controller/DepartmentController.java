package com.example.demo.controller;

import com.example.demo.entity.Department; 
import com.example.demo.service.DepartmentService; 
import java.util.List; 
// Importing required classes 
//import javax.validation.Valid; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.*; 
  
// Annotation 
@RestController
  
// Class 
public class DepartmentController { 
  
    @Autowired private DepartmentService departmentService; 
  
    // Save operation 
    @PostMapping("/departments") 
    public Department saveDepartment( 
        //@Valid @RequestBody Department department) 
    		@RequestBody Department department) 
    { 
        return departmentService.saveDepartment(department); 
    } 
  
    // Read operation 
    @GetMapping("/departments") 
    public List<Department> fetchDepartmentList() 
    { 
        return departmentService.fetchDepartmentList(); 
    } 
  
    // Update operation 
    @PutMapping("/departments/{id}") 
    public Department 
    updateDepartment(@RequestBody Department department, 
                     @PathVariable("id") Long departmentId) 
    { 
        return departmentService.updateDepartment( 
            department, departmentId); 
    } 
  
    // Delete operation 
    @DeleteMapping("/departments/{id}") 
    public String deleteDepartmentById(@PathVariable("id") 
                                       Long departmentId) 
    { 
        departmentService.deleteDepartmentById( 
            departmentId); 
  
        return "Deleted Successfully"; 
    } 
}
