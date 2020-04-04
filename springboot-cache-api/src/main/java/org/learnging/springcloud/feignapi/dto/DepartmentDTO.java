package org.learnging.springcloud.feignapi.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DepartmentDTO implements Serializable {
    private String id;
    private String departmentName;
}
