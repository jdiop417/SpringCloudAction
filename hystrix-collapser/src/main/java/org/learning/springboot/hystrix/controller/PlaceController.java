package org.learning.springboot.hystrix.controller;

import org.learning.springboot.hystrix.pojo.Place;
import org.learning.springboot.hystrix.server.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/place")
public class PlaceController {
    @Autowired
    private PlaceService placeService;

    @RequestMapping("/get")
    public Place get(@RequestParam("id") Integer id) {
        return placeService.getById(id);
    }

}
