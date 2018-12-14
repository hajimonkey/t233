package com.bdqn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bdqn.dao.DevUserDAO;
import com.bdqn.pojo.DevUser;
import com.bdqn.service.DevUserService;

@Service
public class DevUserServiceImpl implements DevUserService {
	@Autowired
	private DevUserDAO devUserDAO;
	
	@Override
	@Transactional(readOnly=true)
	public DevUser findDevUserByDevName(String devName) {
		// TODO Auto-generated method stub
		return devUserDAO.findDevUserByDevName(devName);
	}

	public void setDevUserDAO(DevUserDAO devUserDAO) {
		this.devUserDAO = devUserDAO;
	}
	
}
