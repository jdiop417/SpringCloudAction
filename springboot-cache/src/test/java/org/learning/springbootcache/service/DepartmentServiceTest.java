package org.learning.springbootcache.service;

import org.junit.jupiter.api.Test;
import org.learnging.springcloud.feignapi.dto.DepartmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @Test
    void getBatchByIdIn() {
        List<DepartmentDTO> batchByIdIn = departmentService.getBatchByIdIn(Arrays.asList(1, 2));
        batchByIdIn.forEach(System.out::println);
    }
}