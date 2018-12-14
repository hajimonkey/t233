package com.bdqn.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bdqn.pojo.DevUser;
import com.bdqn.service.DevUserService;

@Controller
public class UserController {
	@Autowired
	private DevUserService devUserService;
	
	@RequestMapping(value="/devLogin",method=RequestMethod.GET)
	public String devLogin() {
		return "devLogin";
	}
	@RequestMapping(value="/devLogin",method=RequestMethod.POST)
	public String devLogin(DevUser user,HttpServletRequest request ) {
		DevUser loginUser = devUserService.findDevUserByDevName(user.getDevName());
		if(loginUser == null) return "devLogin";
		if(loginUser.getDevPassword().equals(user.getDevPassword())) {
			request.getSession().setAttribute("loginUser", loginUser);
			return "redirect:dev/devMain";
		}else {
			return "devLogin";
		}
	}
	@RequestMapping(value="/dev/devMain",method=RequestMethod.GET)
	public String devMain() {
		return "dev/devMain";
	}
	
	
	
	
	
	public void setDevUserService(DevUserService devUserService) {
		this.devUserService = devUserService;
	}
	
	
	
}
