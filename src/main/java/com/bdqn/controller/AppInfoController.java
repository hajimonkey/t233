package com.bdqn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdqn.pojo.AppCategory;
import com.bdqn.pojo.AppInfo;
import com.bdqn.pojo.AppInfoPage;
import com.bdqn.pojo.DataDictionary;
import com.bdqn.pojo.DevUser;
import com.bdqn.service.AppInfoService;

@Controller
public class AppInfoController {
	@Autowired
	private AppInfoService appInfoService;
	/**
	 * 开发者用户获取应用列表
	 * @return
	 */
	@RequestMapping(value="dev/appList")
	public String devAppList(AppInfoPage appInfoPage,HttpServletRequest request) {
		DevUser user = (DevUser) request.getSession().getAttribute("loginUser");
		//开发者用户固定只查询自己发布的应用
		appInfoPage.setAppCreatedby(user.getDevId());
		List<AppInfo> appList = appInfoService.findAppInfoList(appInfoPage);
		//根据条件获取应用总记录数
		int count = appInfoService.findAppInfoCount(appInfoPage);
		//计算总页数
		int pageCount = (int)Math.ceil(count*1.0/appInfoPage.getRows());
		request.setAttribute("appList", appList);
		request.setAttribute("count", count);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageNow", appInfoPage.getPageNow());
		return "dev/appList";
	}
	/**
	 * 后台管理员获取应用列表
	 * @return
	 */
	@RequestMapping(value="backend/appList")
	public String backendAppList(AppInfoPage appInfoPage,HttpServletRequest request) {
		appInfoPage.setAppState(1);//后台管理员固定只查询待审核的应用
		List<AppInfo> appList = appInfoService.findAppInfoList(appInfoPage);
		//根据条件获取应用总记录数
		int count = appInfoService.findAppInfoCount(appInfoPage);
		int pageCount = (int)Math.ceil(count*1.0/appInfoPage.getRows());
		request.setAttribute("appList", appList);
		request.setAttribute("count", count);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageNow", appInfoPage.getPageNow());
		return "backend/appList";
	}

	public void setAppInfoService(AppInfoService appInfoService) {
		this.appInfoService = appInfoService;
	}
	
	@RequestMapping(value="/appstate")
	@ResponseBody
	public Object findAppState() {
		List<DataDictionary> appStateList
			= appInfoService.findDataDic("应用状态");
		return appStateList;
	}
	@RequestMapping(value="/plateform")
	@ResponseBody
	public Object findPlateform() {
		List<DataDictionary> plateformList 
		= appInfoService.findDataDic("所属平台");
		return plateformList;
	}
	@RequestMapping(value="/appcatelist")
	@ResponseBody
	public Object findAppCate(int pid) {
		List<AppCategory> appCateList 
			= appInfoService.findAppCateByPid(pid);
		return appCateList;
	}
	
	
}
