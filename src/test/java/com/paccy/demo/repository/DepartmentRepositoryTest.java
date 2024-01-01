package com.paccy.demo.repository;

import com.paccy.demo.entity.Department;
import jakarta.persistence.Id;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {
@Autowired
    private  DepartmentRepository departmentRepository;
@Autowired
private TestEntityManager entityManager;
    @BeforeEach
    void setUp() {
        Department department= Department.builder().
                departmentName("IT")
                .departmentAddress("Kayonza")
                .departmentCode("IT-001")
                 .build();

        entityManager.persist(department);
    }
    @Test
    public  void  whenFindById_thenReturnDepartment(){
         Department department=departmentRepository.findById(1L).get();
         assertEquals(department.getDepartmentName(),"IT");

    }

}