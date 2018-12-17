package com.bdqn.service;

import com.bdqn.pojo.BackendUser;

public interface BackendUserService {
	BackendUser findUserByName(String name);
}
