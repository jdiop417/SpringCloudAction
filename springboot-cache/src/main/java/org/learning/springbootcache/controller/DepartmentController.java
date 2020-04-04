package org.learning.springbootcache.controller;

import org.learnging.springcloud.feignapi.dto.DepartmentDTO;
import org.learnging.springcloud.feignapi.service.IDepartmentService;
import org.learning.springbootcache.service.DepartmentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/dept")
public class DepartmentController implements IDepartmentService {

    @Resource
    private DepartmentService departmentService;

    @Override
    public DepartmentDTO getDept(Integer id) {
        return departmentService.getDeptById(id);
    }

    @Override
    public List<DepartmentDTO> getDepts(List<Integer> ids) {
        return departmentService.getBatchByIdIn(ids);
    }

}
