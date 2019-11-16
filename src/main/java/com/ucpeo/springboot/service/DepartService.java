package com.ucpeo.springboot.service;

import com.ucpeo.springboot.bean.Department;
import com.ucpeo.springboot.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class DepartService {

    private static Map<Integer, Department> departmentMap;

    @Autowired
    public  void setDepartmentMap(Map<Integer, Department> departmentMap) {
        DepartService.departmentMap = departmentMap;
    }

    public void add(Department department) {
        if (department.getId()==null)
            department.setId(UserDao.getDid());

        departmentMap.put(department.getId(), department);
    }

    public void update(Department department) {
        add(department);
    }

    public void delete(Integer id) {
        departmentMap.remove(id);
    }

    public Department get(Integer id) {
        return departmentMap.get(id);
    }

    public  List<Department> getDepartments() {
        List<Department> departments = new ArrayList<>();
        departments.addAll(departmentMap.values());
        return departments;
    }
}
