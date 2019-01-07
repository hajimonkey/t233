package com.bdqn.service;

import java.util.List;

import com.bdqn.pojo.AppVersion;

public interface AppVersionService {
	List<AppVersion> findVersionByAppId(int appId);
	int save(AppVersion appVersion);
	int updateAppLastVersion(int appId,String lastVersion);
	AppVersion findBySnAndAppId(String verSn,int appId);
	int update(AppVersion appVersion);

}
