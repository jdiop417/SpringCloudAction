package org.learning.springboot.hystrix.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Place implements Serializable {
    private String name;
    private String code;
}
