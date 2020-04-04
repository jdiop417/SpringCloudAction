package org.learning.springbootcache.service;

import org.learnging.springcloud.feignapi.dto.EmployeeDTO;
import org.learning.springbootcache.convert.EmployeeConvert;
import org.learning.springbootcache.entity.Employee;
import org.learning.springbootcache.mapper.EmployeeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

@Service
@CacheConfig(cacheNames = "emp")
public class EmployeeService {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private EmployeeMapper employeeMapper;

    @Cacheable(/*cacheNames = "emp",*/ key = "#id", condition = "#id>0")
    public EmployeeDTO getEmpById(Integer id) {
        logger.debug("查询" + id + "号员工");
        Employee empById = employeeMapper.getEmpById(id);
        return new EmployeeConvert().convert(empById);
    }


    @CachePut(/*value = "emp",*/ key = "#result.id")
    public EmployeeDTO updateEmp(EmployeeDTO employeeDTO) {
        logger.debug("更新" + employeeDTO.getId() + "号员工");
        Employee employee = new EmployeeConvert().reverse().convert(employeeDTO);
        employeeMapper.updateEmp(employee);
        return employeeDTO;
    }

    @CacheEvict(key = "#id", beforeInvocation = true)
    public void deleteEmp(@NotNull Integer id) {
        logger.debug("删除" + id + "号员工");
        employeeMapper.deletEmpById(id);
    }


    @Caching(
            cacheable = @Cacheable(key = "#lastname"),
            put = {
                    @CachePut(key = "#result.id"),
                    @CachePut(key = "#result.email")
            }
    )
    public EmployeeDTO getEmpByLastName(String lastname) {
        Employee empByLastName = employeeMapper.getEmpByLastName(lastname);
        return new EmployeeConvert().convert(empByLastName);
    }
}
