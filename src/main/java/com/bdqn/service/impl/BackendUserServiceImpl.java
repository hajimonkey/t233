package com.bdqn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bdqn.dao.BackendUserDAO;
import com.bdqn.pojo.BackendUser;
import com.bdqn.service.BackendUserService;

@Service
public class BackendUserServiceImpl implements BackendUserService {
	@Autowired
	private BackendUserDAO userDAO;
	@Override
	@Transactional(readOnly=true)
	public BackendUser findUserByName(String name) {
		// TODO Auto-generated method stub
		return userDAO.findUserByName(name);
	}
	public BackendUserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(BackendUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	
}
