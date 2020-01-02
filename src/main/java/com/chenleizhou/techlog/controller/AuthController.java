package com.chenleizhou.techlog.controller;

import com.chenleizhou.techlog.entity.User;
import com.chenleizhou.techlog.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.Map;

@Controller
public class AuthController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/user/login")
    public String userLogin(@PathParam("username") String username,
                            @PathParam("password") String password,
                            Map<String, Object> errors,
                            HttpSession session) {

        if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)) {
            User user = userService.findUserByName(username);

            if (user.getName().equals(username) && user.getPassword().equals(password)) {
                session.setAttribute("loginUser", username);
                return "redirect:/index.html";
            } else {
                errors.put("msg", "user name or password is wrong");
                return "login";
            }
        } else {
            errors.put("msg", "username or password can not be blank");
            return "index";
        }
    }

}
