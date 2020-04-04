package org.learnging.springcloud.feignapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO implements Serializable {

    private Integer id;
    private String lastName;
    private String email;
    private Integer gender; //1:男，0：女
    private Integer did;

}
