package com.paccy.demo.service;

import com.paccy.demo.entity.Department;
import com.paccy.demo.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    private  DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;
    @BeforeEach
    void setUp() {
        Department department=  Department.builder().
                                departmentName("Developer")
                                .departmentAddress("KGL")
                .departmentCode("DEV-001")
                .departmentID(1L).build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);
    }
    @Test
    @DisplayName("Get Data based on the valid department name")
    public void  whenValidDepartmentName_thenDepartmentFound(){
        String departmentName= "Developer";
        Department found= departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentName,found.getDepartmentName());
    }
}