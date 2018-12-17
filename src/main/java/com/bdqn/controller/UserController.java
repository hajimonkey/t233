package com.bdqn.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bdqn.pojo.BackendUser;
import com.bdqn.pojo.DevUser;
import com.bdqn.service.BackendUserService;
import com.bdqn.service.DevUserService;

@Controller
public class UserController {
	@Autowired
	private DevUserService devUserService;
	@Autowired
	private BackendUserService backendUserService;
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
	
	@RequestMapping(value="/backendLogin",method=RequestMethod.GET)
	public String backendLogin() {
		return "backendLogin";
	}
	@RequestMapping(value="/backendLogin",method=RequestMethod.POST)
	public String backendLogin(BackendUser user,HttpServletRequest request ) {
		BackendUser loginUser = backendUserService.findUserByName(user.getBackendName());
		if(loginUser == null) return "backendLogin";
		if(loginUser.getBackendPassword().equals(user.getBackendPassword())) {
			request.getSession().setAttribute("loginUser", loginUser);
			return "redirect:backend/backendMain";
		}else {
			return "backendLogin";
		}
	}
	@RequestMapping(value="/backend/backendMain",method=RequestMethod.GET)
	public String backendMain() {
		return "backend/backendMain";
	}
	@RequestMapping(value="/{state}/logout",method=RequestMethod.GET)
	public String logout(
			@PathVariable("state") String state,HttpServletRequest request) {
		switch(state) {
		case "backend":
			return "backendLogin";
		case "dev":
			return "devLogin";
		default:
			return "index";
		}
	}
	
	public void setBackendUserService(BackendUserService backendUserService) {
		this.backendUserService = backendUserService;
	}
	public void setDevUserService(DevUserService devUserService) {
		this.devUserService = devUserService;
	}
	
	
	
}
