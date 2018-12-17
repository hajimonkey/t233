package com.bdqn.service;

import java.util.List;

import com.bdqn.pojo.AppCategory;
import com.bdqn.pojo.AppInfo;
import com.bdqn.pojo.AppInfoPage;
import com.bdqn.pojo.DataDictionary;

public interface AppInfoService {
	List<AppInfo> findAppInfoList(AppInfoPage appInfopage);
	int findAppInfoCount(AppInfoPage appInfopage);
	
	List<DataDictionary> findDataDic(String dictType);
	List<AppCategory> findAppCateByPid(int pid);
}
