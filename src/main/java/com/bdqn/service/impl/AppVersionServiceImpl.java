package com.bdqn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bdqn.dao.AppInfoDAO;
import com.bdqn.dao.AppVersionDAO;
import com.bdqn.pojo.AppVersion;
import com.bdqn.service.AppVersionService;
@Service
public class AppVersionServiceImpl implements AppVersionService {
	@Autowired
	private AppVersionDAO versionDAO;
	@Autowired
	private AppInfoDAO appInfoDAO;
	@Override
	@Transactional(readOnly=true)
	public List<AppVersion> findVersionByAppId(int appId) {
		// TODO Auto-generated method stub
		return versionDAO.findVersionByAppId(appId);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int save(AppVersion appVersion) {
		// TODO Auto-generated method stub
		int count = versionDAO.save(appVersion);
		System.out.println("count:" + count);
		if(count > 0) {
			count = updateAppLastVersion(appVersion.getVerAppId()
					,appVersion.getVerSn());
		}
		return count;
	}

	@Override
	public int updateAppLastVersion(int appId, String lastVersion) {
		// TODO Auto-generated method stub
		return appInfoDAO.updateAppLastVersion(appId, lastVersion);
	}
	
	public AppVersionDAO getVersionDAO() {
		return versionDAO;
	}

	public void setVersionDAO(AppVersionDAO versionDAO) {
		this.versionDAO = versionDAO;
	}

	public AppInfoDAO getAppInfoDAO() {
		return appInfoDAO;
	}

	public void setAppInfoDAO(AppInfoDAO appInfoDAO) {
		this.appInfoDAO = appInfoDAO;
	}

	@Override
	@Transactional(readOnly=true)
	public AppVersion findBySnAndAppId(String verSn, int appId) {
		// TODO Auto-generated method stub
		return versionDAO.findBySnAndAppId(verSn, appId);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int update(AppVersion appVersion) {
		// TODO Auto-generated method stub
		return versionDAO.update(appVersion);
	}

	

}
