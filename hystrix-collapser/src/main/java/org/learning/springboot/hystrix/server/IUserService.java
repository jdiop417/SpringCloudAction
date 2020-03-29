package org.learning.springboot.hystrix.server;

import org.learning.springboot.hystrix.entity.User;

import java.util.List;

public interface IUserService {
    User getById(Long id);

    List<User> getUserBatchById(List<Long> id);
}
