package com.paccy.demo.service;


import com.paccy.demo.entity.Department;

import java.util.List;

public interface DepartmentService {
 
 List<Department> fetchDepartments();

    Department saveDepartment(Department department);

    Department fetchDepartmentById(Long departmentId);

    void deleteDepartmentById(Long departmentId);


    Department updateDepartment(Long departmentId, Department department);


    Department findDepartmentByName(String departmentName);



}
