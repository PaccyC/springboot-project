package com.paccy.demo.controller;

import com.paccy.demo.entity.Department;
import com.paccy.demo.error.DepartmentNotFoundError;
import com.paccy.demo.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
class DepartmentControllerTest {
    @Autowired
private MockMvc mockMvc;
    @MockBean
    private DepartmentService departmentService;
    private Department department;
    @BeforeEach
    void setUp() {
        department=Department.builder().
                departmentName("IT")
                .departmentAddress("KGL")
                .departmentCode("IT-001")
                .departmentID(1L).build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment= Department.builder().
                departmentName("IT")
                .departmentAddress("KGL")
                .departmentCode("IT-001")
                .build();
        Mockito.when(departmentService.saveDepartment(inputDepartment))
                .thenReturn(department);
        mockMvc.perform(MockMvcRequestBuilders.post("/departments").contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        " \"departmentName\": \"IT\",\n" +
                        "    \"departmentAddress\": \"KGL\",\n" +
                        "    \"departmentCode\": \"IT-001\"\n" +
                        "}")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(departmentId:1L)).thenReturn(department);


        mockMvc.perform(MockMvcRequestBuilders.get("/departments/1").contentType(MediaType.APPLICATION_JSON)
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName").value(department.getDepartmentName()));
    }
}