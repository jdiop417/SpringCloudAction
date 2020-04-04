package org.learning.springboot.hystrix.server;


import org.learnging.springcloud.feignapi.service.IDepartmentService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "spring-cache",path = "/spring-cache",fallback = IDepartmentFallBackServcie.class)
public interface IDepartmentFeignService extends IDepartmentService {

}
