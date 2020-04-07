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

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = new String("abc");
        String str3 = str2.intern();
        System.out.println(str1 == str2);
        System.out.println(str2 == str3);
        System.out.println(str1 == str3);
    }
}
