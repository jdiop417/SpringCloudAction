package org.learning.springbootcache.convert;

import com.google.common.base.Converter;
import org.learnging.springcloud.feignapi.dto.DepartmentDTO;
import org.learning.springbootcache.entity.Department;
import org.springframework.beans.BeanUtils;

public class DepartmentConvert extends Converter<Department, DepartmentDTO> {

    protected DepartmentDTO doForward(Department department) {
        DepartmentDTO departmentDTO = new DepartmentDTO();
        BeanUtils.copyProperties(department, departmentDTO);
        return departmentDTO;
    }

    protected Department doBackward(DepartmentDTO departmentDTO) {
        Department department = new Department();
        BeanUtils.copyProperties(departmentDTO, department);
        return department;
    }
}
