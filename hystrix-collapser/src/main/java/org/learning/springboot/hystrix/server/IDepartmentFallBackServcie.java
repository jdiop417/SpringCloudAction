package org.learning.springboot.hystrix.server;

import org.learnging.springcloud.feignapi.dto.DepartmentDTO;

import java.util.List;

public class IDepartmentFallBackServcie implements IDepartmentFeignService {
    @Override
    public DepartmentDTO getDept(Integer id) {
        return null;
    }

    @Override
    public List<DepartmentDTO> getDepts(List<Integer> ids) {
        return null;
    }
}
