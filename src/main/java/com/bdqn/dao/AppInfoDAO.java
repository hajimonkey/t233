package com.bdqn.dao;

import java.util.List;

import com.bdqn.pojo.AppCategory;
import com.bdqn.pojo.AppInfo;
import com.bdqn.pojo.AppInfoPage;
import com.bdqn.pojo.DataDictionary;

public interface AppInfoDAO {
	/**
	 * 有条件地查询应用信息列表
	 * @param appInfo
	 * @return
	 */
	List<AppInfo> findAppInfoList(AppInfoPage appInfopage);
	/**
	 * 有条件地查询应用数量
	 * @param appInfopage
	 * @return
	 */
	int findAppInfoCount(AppInfoPage appInfopage);
	/**
	 * 根据指定的字典类型获取字典数据
	 * @param dictType
	 * @return
	 */
	List<DataDictionary> findDataDic(String dictType);
	/**
	 * 根据上级id获取对应的下级菜单
	 * @param pid
	 * @return
	 */
	List<AppCategory> findAppCateByPid(int pid);
	
}







