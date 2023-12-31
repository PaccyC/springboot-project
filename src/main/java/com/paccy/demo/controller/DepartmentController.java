package com.paccy.demo.controller;


import com.paccy.demo.entity.Department;
import com.paccy.demo.error.DepartmentNotFoundError;
import com.paccy.demo.service.DepartmentService;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private  DepartmentService departmentService;
    private  final Logger LOGGER= LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("At saveDepartment in DepartmentController");
     return  departmentService.saveDepartment(department);
    }
    @GetMapping("/departments")
    public List<Department> fetchDepartments(){
        LOGGER.info("At getDepartments in DepartmentController");
        return departmentService.fetchDepartments();
    }

    @GetMapping("/departments/{id}")
    public  Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundError {
        return departmentService.fetchDepartmentById(departmentId);
    }
    @DeleteMapping("/departments/{id}")
    public ResponseEntity<String> deleteDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundError{
        try {
            departmentService.deleteDepartmentById(departmentId);
            return ResponseEntity.ok("Department Deleted Successfully");
        } catch (Exception e) {
            // Log the exception or handle it appropriately
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error deleting department: " + e.getMessage());
        }
    }
    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){
        return  departmentService.updateDepartment(departmentId,department);

    }
    @GetMapping("/departments/name/{name}")
    public Department findDepartmentByName(@PathVariable("name") String departmentName){
        return  departmentService.findDepartmentByName(departmentName);
    }



}
