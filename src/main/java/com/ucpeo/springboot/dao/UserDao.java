package com.ucpeo.springboot.dao;

import com.ucpeo.springboot.bean.Department;
import com.ucpeo.springboot.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


import java.util.*;

@Component
public class UserDao {
    static Integer uid = 1;
    static Integer did = 1;

    //    创建用户集合并加入IOC容器 注意请保持用户的部门和部门集合相对应
    @Bean
    public static Map<Integer, User> Users() {
        Map<Integer, User> users = new HashMap<>();
        Department department = new Department(1, "总经理");
        User user = new User(uid++, "李彪", 1, new Date(System.currentTimeMillis()), department);
        users.put(user.getId(), user);

        department = new Department(2, "经理");
        user = new User(uid++, "李世民", 1, new Date(System.currentTimeMillis()), department);
        users.put(user.getId(), user);

        user = new User(uid++, "假名字", 1, new Date(System.currentTimeMillis()), department);
        users.put(user.getId(), user);

        department = new Department(3, "员工");
        user = new User(uid++, "张三", 1, new Date(System.currentTimeMillis()), department);
        users.put(user.getId(), user);

        user = new User(uid++, "李四", 0, new Date(System.currentTimeMillis()), department);
        users.put(user.getId(), user);

        user = new User(uid++, "王五", 1, new Date(System.currentTimeMillis()), department);
        users.put(user.getId(), user);
        return users;
    }


//    创建部门集合并加入IOC容器
    @Bean
    public static Map<Integer, Department> departments() {

        Department department = new Department(did++, "总经理");
        Map<Integer, Department> departments = new HashMap<>();
        departments.put(department.getId(), department);

        department = new Department(did++, "经理");
        departments.put(department.getId(), department);

        department = new Department(did++, "员工");
        departments.put(department.getId(), department);
        return departments;

    }

    //    模拟Id自增
    public static Integer getUid() {
        return uid++;
    }

    //    模拟Id自增
    public static Integer getDid() {
        return did++;
    }


}
