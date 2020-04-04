package org.learning.springboot.hystrix.convert;

import com.google.common.base.Converter;
import org.learnging.springcloud.feignapi.dto.DepartmentDTO;
import org.learning.springboot.hystrix.pojo.Place;

public class PlaceConvert extends Converter<Place, DepartmentDTO> {
    @Override
    protected DepartmentDTO doForward(Place place) {
        DepartmentDTO dept = new DepartmentDTO();
        dept.setId(place.getCode());
        dept.setDepartmentName(place.getName());
        return dept;
    }

    @Override
    protected Place doBackward(DepartmentDTO dept) {
        Place place = new Place();
        place.setName(dept.getDepartmentName());
        place.setCode(dept.getId());
        return place;
    }
}
