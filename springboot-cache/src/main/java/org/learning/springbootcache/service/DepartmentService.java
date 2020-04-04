package org.learning.springbootcache.service;

import lombok.extern.slf4j.Slf4j;
import org.learnging.springcloud.feignapi.dto.DepartmentDTO;
import org.learning.springbootcache.convert.DepartmentConvert;
import org.learning.springbootcache.entity.Department;
import org.learning.springbootcache.mapper.DepartmentMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@CacheConfig(cacheNames = "dept")
public class DepartmentService  {

    @Resource
    private DepartmentMapper departmentMapper;

    @Cacheable(key = "#id", condition = "#id>0")
    public DepartmentDTO getDeptById(Integer id) {
        log.debug("查询" + id + "号员工");
        Department deptById = departmentMapper.getDeptById(id);
        return new DepartmentConvert().convert(deptById);
    }

    @Cacheable(key = "#ids")
    public List<DepartmentDTO> getBatchByIdIn(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return new ArrayList<>();
        }

        List<Department> departments = departmentMapper.getBatchByIdIn(ids);

        return departments.stream().map(department -> new DepartmentConvert().convert(department))
                .collect(Collectors.toList());
    }

}
