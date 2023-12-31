package com.paccy.demo.service;

import com.paccy.demo.entity.Department;
import com.paccy.demo.error.DepartmentNotFoundError;
import com.paccy.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> fetchDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundError {
         Optional<Department> department=departmentRepository.findById(departmentId);
         if(!department.isPresent()){
             throw new DepartmentNotFoundError("Department NOt Found");
         }
         return  department.get();
    }

    @Override
    public  void deleteDepartmentById(Long departmentId) {
      departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
     Department depDB= departmentRepository.findById(departmentId).get();
     if(Objects.nonNull(department.getDepartmentName()) && ! "".equalsIgnoreCase(department.getDepartmentName())){
         depDB.setDepartmentName(department.getDepartmentName());
     }
     if(Objects.nonNull(department.getDepartmentAddress()) && ! "".equalsIgnoreCase(department.getDepartmentAddress())){
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }
     if(Objects.nonNull(department.getDepartmentCode()) && ! "".equalsIgnoreCase(department.getDepartmentCode())){
            depDB.setDepartmentCode(department.getDepartmentCode());
        }
     return departmentRepository.save(depDB);
    }

    @Override
    public Department findDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }



}
