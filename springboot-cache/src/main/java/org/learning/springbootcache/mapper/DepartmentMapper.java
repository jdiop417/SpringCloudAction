package org.learning.springbootcache.mapper;


import org.apache.ibatis.annotations.Param;
import org.learning.springbootcache.entity.Department;

import java.util.List;

public interface DepartmentMapper {

    Department getDeptById(Integer id);

    List<Department> getBatchByIdIn(@Param("ids") List<Integer> ids);
}
