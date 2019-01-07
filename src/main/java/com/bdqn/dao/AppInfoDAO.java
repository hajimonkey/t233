package com.bdqn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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
	/**
	 * 添加基本信息
	 * @param appInfo
	 * @return
	 */
	int save(AppInfo appInfo);
	
	/**
	 * 根据id获取应用信息
	 * @param appId
	 * @return
	 */
	AppInfo findById(int appId);
	/**
	 * 更新应用基本信息
	 * @param appInfo
	 * @return
	 */
	int update(AppInfo appInfo);
	/**
	 * 获取当前应用所有版本的文件
	 * @param appId
	 * @return
	 */
	List<String> findVersionApk(int appId);
	/**
	 * 删除指定应用所有的版本信息
	 * @param appId
	 * @return
	 */
	int deleteVersion(int appId);
	/**
	 * 删除基本信息
	 * @param appId
	 * @return
	 */
	int deleteApp(int appId);
	/**
	 * 修改应用状态
	 * @param appId
	 * @param appState
	 * @return
	 */
	int updateAppState(
			@Param("appId")int appId,
			@Param("appState")int appState);
	/**
	 * 更新最新版本号
	 * @param appId
	 * @param lastVersion
	 * @return
	 */
	int updateAppLastVersion(
			@Param("appId")int appId,
			@Param("lastVersion")String lastVersion);
}







