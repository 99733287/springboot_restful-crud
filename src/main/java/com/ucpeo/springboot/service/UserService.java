package com.ucpeo.springboot.service;

import com.ucpeo.springboot.bean.User;
import com.ucpeo.springboot.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    private static Map<Integer, User> users;

    private DepartService departService;

    @Autowired
    public void setDepartService(DepartService departService) {
        this.departService = departService;
    }

    @Autowired
    public void setUsers(Map<Integer, User> us) {
        users = us;
    }

    public void add(User user) {
        if (user.getId() == null)
            user.setId(UserDao.getUid());

        user.setDepartment(departService.get(user.getDepartment().getId()));

        users.put(user.getId(), user);
    }

    public void update(User user) {
        add(user);
    }

    public void delete(Integer id) {
        users.remove(id);
    }

    public User get(Integer id) {
        User user = users.get(id);
        user.setDepartment(departService.get(user.getDepartment().getId()));
        return user;
    }


    public List<User> getUsers() {
        for (Integer integer : users.keySet()) {
            User user = users.get(integer);
            user.setDepartment(departService.get(user.getDepartment().getId()));
        }

        Collection<User> collection = users.values();
        List<User> users = new ArrayList<>();
        users.addAll(collection);
        return users;

    }


}
