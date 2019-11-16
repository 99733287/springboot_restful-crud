package com.ucpeo.springboot;


import com.ucpeo.springboot.bean.User;
import com.ucpeo.springboot.service.DepartService;
import com.ucpeo.springboot.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
public class test {

    UserService service;
    DepartService departService;

    @Autowired
    public void setDepartService(DepartService departService) {
        this.departService = departService;
    }

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @Test
    public void test() {
        System.out.println(departService.getDepartments());
        System.out.println(service.getUsers());
        service.add(new User(6,"temp",0,new Date(2019,12,31),departService.get(3)));
        System.out.println(service.getUsers());
    }

}
