package com.bdqn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bdqn.pojo.AppVersion;

public interface AppVersionDAO {
	/**
	 * 根据基本信息id获取版本列表
	 * @param appId
	 * @return
	 */
	List<AppVersion> findVersionByAppId(int appId);
	/**
	 * 新增版本信息
	 * @param appVersion
	 * @return
	 */
	int save(AppVersion appVersion);
	/**
	 * 根据最新版本号和应用ID获取最新版本信息
	 * @param verSn
	 * @param appId
	 * @return
	 */
	AppVersion findBySnAndAppId(
			@Param("verSn")String verSn,
			@Param("appId")int appId);
	/**
	 * 修改版本信息
	 * @param appVersion
	 * @return
	 */
	int update(AppVersion appVersion);
	
	
	
	
	
	
}
