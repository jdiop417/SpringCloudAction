package org.learning.springboot.hystrix.server;

import com.google.common.collect.Lists;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.learnging.springcloud.feignapi.dto.DepartmentDTO;
import org.learning.springboot.hystrix.convert.PlaceConvert;
import org.learning.springboot.hystrix.pojo.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {

    @Autowired
    private IDepartmentFeignService iDepartmentFeignService;

    @HystrixCollapser(batchMethod = "getBatchByIdIn", scope = com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL, collapserProperties = {
            @HystrixProperty(name = HystrixPropertiesManager.TIMER_DELAY_IN_MILLISECONDS, value = "4000")
    })
    public Place getById(Integer id) {
        DepartmentDTO dept = iDepartmentFeignService.getDept(id);
        return new PlaceConvert().reverse().convert(dept);
    }


    @HystrixCommand
    public List<Place> getBatchByIdIn(List<Integer> ids) {
        List<DepartmentDTO> depts = iDepartmentFeignService.getDepts(ids);
        Iterable<Place> places = new PlaceConvert().reverse().convertAll(depts);
        return Lists.newArrayList(places);
    }

}
