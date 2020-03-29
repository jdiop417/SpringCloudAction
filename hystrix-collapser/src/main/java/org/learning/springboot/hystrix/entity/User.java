package org.learning.springboot.hystrix.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
    private Long id;
    private String last_name;
    private String email;
    private String gender;
    private String d_id;

    public User(Long id, String last_name) {
        this.id = id;
        this.last_name = last_name;
    }
}
