package org.learning.springbootcache.convert;

import com.google.common.base.Converter;
import org.learnging.springcloud.feignapi.dto.EmployeeDTO;
import org.learning.springbootcache.entity.Employee;
import org.springframework.beans.BeanUtils;

public class EmployeeConvert extends Converter<Employee, EmployeeDTO> {
    @Override
    protected EmployeeDTO doForward(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        BeanUtils.copyProperties(employee, employeeDTO);
        return employeeDTO;
    }

    @Override
    protected Employee doBackward(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        return employee;
    }


}
