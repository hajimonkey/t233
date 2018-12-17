package com.bdqn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bdqn.dao.AppInfoDAO;
import com.bdqn.pojo.AppCategory;
import com.bdqn.pojo.AppInfo;
import com.bdqn.pojo.AppInfoPage;
import com.bdqn.pojo.DataDictionary;
import com.bdqn.service.AppInfoService;

@Service
public class AppInfoServiceImpl implements AppInfoService {
	@Autowired
	private AppInfoDAO appInfoDAO;
	@Override
	@Transactional(readOnly=true)
	public List<AppInfo> findAppInfoList(AppInfoPage appInfopage) {
		// TODO Auto-generated method stub
		return appInfoDAO.findAppInfoList(appInfopage);
	}
	public void setAppInfoDAO(AppInfoDAO appInfoDAO) {
		this.appInfoDAO = appInfoDAO;
	}
	@Override
	@Transactional(readOnly=true)
	public int findAppInfoCount(AppInfoPage appInfopage) {
		// TODO Auto-generated method stub
		return appInfoDAO.findAppInfoCount(appInfopage);
	}
	@Override
	@Transactional(readOnly=true)
	public List<DataDictionary> findDataDic(String dictType) {
		// TODO Auto-generated method stub
		return appInfoDAO.findDataDic(dictType);
	}
	@Override
	@Transactional(readOnly=true)
	public List<AppCategory> findAppCateByPid(int pid) {
		// TODO Auto-generated method stub
		return appInfoDAO.findAppCateByPid(pid);
	}
	
	
	

}
