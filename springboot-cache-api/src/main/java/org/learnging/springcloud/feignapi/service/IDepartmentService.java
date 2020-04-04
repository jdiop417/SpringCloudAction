package org.learnging.springcloud.feignapi.service;

import org.learnging.springcloud.feignapi.dto.DepartmentDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/dept")
public interface IDepartmentService {
    @GetMapping("/{id}")
    DepartmentDTO getDept(@PathVariable("id") Integer id);

    @GetMapping("/in")
    List<DepartmentDTO> getDepts(@RequestParam("ids") List<Integer> ids);
}
