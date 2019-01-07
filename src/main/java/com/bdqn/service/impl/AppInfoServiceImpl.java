package com.bdqn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int save(AppInfo appInfo) {
		// TODO Auto-generated method stub
		return appInfoDAO.save(appInfo);
	}
	@Override
	@Transactional(readOnly=true)
	public AppInfo findById(int appId) {
		// TODO Auto-generated method stub
		return appInfoDAO.findById(appId);
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int update(AppInfo appInfo) {
		// TODO Auto-generated method stub
		return appInfoDAO.update(appInfo);
	}
	@Override
	@Transactional(readOnly=true)
	public List<String> findVersionApk(int appId) {
		// TODO Auto-generated method stub
		return appInfoDAO.findVersionApk(appId);
	}
	@Override
	public int deleteVersion(int appId) {
		// TODO Auto-generated method stub
		return appInfoDAO.deleteVersion(appId);
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int deleteApp(int appId) {
		// TODO Auto-generated method stub
		int count = deleteVersion(appId);
		if(count > 0) {
			count = appInfoDAO.deleteApp(appId);
		}
		return count;
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int updateAppState(int appId, int appState) {
		// TODO Auto-generated method stub
		return appInfoDAO.updateAppState(appId, appState);
	}
	
	
	

}
