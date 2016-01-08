package com.myweb.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myweb.entity.User;
import com.myweb.service.impl.UserServiceImp;
@Controller
@RequestMapping("/user")
public class UserController {
	public UserController(){
	}
    @Autowired
    @Qualifier("serviceImpl")
    UserServiceImp userService;
    @RequestMapping(value = "/register.do", method = RequestMethod.POST)
    public String register(User user) {
        userService.save(user);
        return "login";
    }
    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public String login(@ModelAttribute("user") User user,HttpServletRequest request) {
    	User u = userService.find(user);
    	if(u != null){
    		user = u;
    		request.setAttribute("user",user);
    	}
    	else{
    		request.setAttribute("user",user);
    	}
        return "self";
    }
}