package com.bdqn.dao;

import com.bdqn.pojo.BackendUser;

public interface BackendUserDAO {
	
	BackendUser findUserByName(String name);
}
