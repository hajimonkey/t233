package com.bdqn.service;

import com.bdqn.pojo.DevUser;

public interface DevUserService {
	/**
	 * 根据用户名查询用户对象
	 * @param devName
	 * @return
	 */
	DevUser findDevUserByDevName(String devName);
}
