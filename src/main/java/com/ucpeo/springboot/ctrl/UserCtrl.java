package com.ucpeo.springboot.ctrl;

import com.ucpeo.springboot.bean.User;
import com.ucpeo.springboot.service.DepartService;
import com.ucpeo.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class UserCtrl {

    UserService userService;

    DepartService departService;

    @Autowired
    public void setDepartService(DepartService departService) {
        this.departService = departService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }




    @RequestMapping({"/index.html", "/"})
    public String hello() {
        return "login";
    }


    @PostMapping("/user/login")
    public String login(Map map, @RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            session.setAttribute("loginUser", username);
            return "redirect:/main.html";

        }
        map.put("msg", "用户名或密码错误！");
        return "login";
    }

    @GetMapping("/user/logout")
    public String Logout(HttpSession session) {
        session.removeAttribute("loginUser");
        return "login";
    }




    @GetMapping("/users")
    public String Users(Map map) {
        map.put("users", userService.getUsers());
        System.out.println(map.get("users"));
        return "list";
    }

    @GetMapping("/user")
    public String update(Map map) {
        map.put("departments", departService.getDepartments());
        return "add";
    }

    @PostMapping("/user")
    public String add(User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @PutMapping("/user")
    public String update(User user) {
        userService.update(user);
        return "redirect:/users";
    }

    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable("id") Integer id) {
        System.out.println("删除！！！");
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/user/{id}")
    public String toUpdatePage(Map map, @PathVariable("id") Integer id) {
        map.put("user", userService.get(id));
        map.put("departments", departService.getDepartments());
        return "add";
    }


}
