package org.learning.springboot.hystrix.server;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.learning.springboot.hystrix.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IUserServiceImpl implements IUserService {


    @HystrixCollapser(batchMethod = "getUserBatchById", collapserProperties = {
            @HystrixProperty(name = HystrixPropertiesManager.TIMER_DELAY_IN_MILLISECONDS, value = "100")})
    @Override
    public User getById(Long id) {
        return null;
    }


    @HystrixCommand
    @Override
    public List<User> getUserBatchById(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return new ArrayList<>();
        }

        return ids.stream().map(id -> getUser(id)).collect(Collectors.toList());
    }


    private User getUser(Long id) {
        return new User(id, "lisi-" + id);
    }
}
