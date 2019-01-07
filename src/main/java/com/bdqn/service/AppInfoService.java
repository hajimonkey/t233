package com.bdqn.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bdqn.pojo.AppCategory;
import com.bdqn.pojo.AppInfo;
import com.bdqn.pojo.AppInfoPage;
import com.bdqn.pojo.DataDictionary;

public interface AppInfoService {
	List<AppInfo> findAppInfoList(AppInfoPage appInfopage);
	int findAppInfoCount(AppInfoPage appInfopage);
	
	List<DataDictionary> findDataDic(String dictType);
	List<AppCategory> findAppCateByPid(int pid);
	int save(AppInfo appInfo);	
	AppInfo findById(int appId);	
	int update(AppInfo appInfo);
	List<String> findVersionApk(int appId);
	int deleteVersion(int appId);
	int deleteApp(int appId);
	int updateAppState(int appId,int appState);
}
