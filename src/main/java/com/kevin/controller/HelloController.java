package com.kevin.controller;

import com.kevin.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kevin on 2018/1/14.
 */
@RestController
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say() {
        return girlProperties.getCupSize();
    }
}
