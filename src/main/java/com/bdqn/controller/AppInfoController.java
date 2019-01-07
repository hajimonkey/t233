package com.bdqn.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bdqn.pojo.AppCategory;
import com.bdqn.pojo.AppInfo;
import com.bdqn.pojo.AppInfoPage;
import com.bdqn.pojo.AppVersion;
import com.bdqn.pojo.DataDictionary;
import com.bdqn.pojo.DevUser;
import com.bdqn.service.AppInfoService;
import com.bdqn.service.AppVersionService;

@Controller
public class AppInfoController {
	@Autowired
	private AppInfoService appInfoService;
	@Autowired
	private AppVersionService appVersionService;
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
		
		request.setAttribute("softwareName", appInfoPage.getAppSoftwarename());
		request.setAttribute("status", appInfoPage.getAppState());
		request.setAttribute("flateform", appInfoPage.getAppPlateform());
		request.setAttribute("cateLevel1", appInfoPage.getAppCatelevel1());
		request.setAttribute("cateLevel2", appInfoPage.getAppCatelevel2());
		request.setAttribute("cateLevel3", appInfoPage.getAppCatelevel3());
		
		
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
	
	@RequestMapping(value="/dev/addAppInfo",method=RequestMethod.GET)
	public String saveAppInfo() {
		return "dev/addAppInfo";
	}
	
	@RequestMapping(value="/dev/addAppInfo",method=RequestMethod.POST)
	public String saveAppInfo(AppInfo appInfo,MultipartFile appLogoImg
			,HttpServletRequest request) throws Exception {
		if(!appLogoImg.isEmpty()) {
			String savePath = request.getSession()
					.getServletContext().getRealPath("/statics/apklogo/");
			String oldName=  appLogoImg.getOriginalFilename();
			Random ran = new Random();
			String newName = "apklogo_"+ System.currentTimeMillis()
					+ ran.nextInt(100000) + 
					oldName.substring(oldName.lastIndexOf("."));
			File saveFile = new File(savePath,newName);
			appLogoImg.transferTo(saveFile);
			appInfo.setAppLogo(newName);
		}
		
		int count = appInfoService.save(appInfo);
		if(count > 0) {
			return "redirect:appList";
		}else {
			request.setAttribute("msg", "保存失败");
			return "dev/addAppInfo";
		}
	}
	
	@RequestMapping(value="/dev/updateAppInfo",method=RequestMethod.GET)
	public String update(int appId,Model model) {
		AppInfo appInfo = appInfoService.findById(appId);
		model.addAttribute("appInfo",appInfo);
		return "dev/updateAppInfo";
	}
	@RequestMapping(value="/dev/updateAppInfo",method=RequestMethod.POST)
	public String update(AppInfo appInfo,MultipartFile appLogoImg,HttpServletRequest request) throws Exception {
		if(!appLogoImg.isEmpty()) {
			String savePath = request.getSession()
					.getServletContext().getRealPath("/statics/apklogo/");
			String oldName=  appLogoImg.getOriginalFilename();
			Random ran = new Random();
			String newName = "apklogo_"+ System.currentTimeMillis()
					+ ran.nextInt(100000) + 
					oldName.substring(oldName.lastIndexOf("."));
			File saveFile = new File(savePath,newName);
			appLogoImg.transferTo(saveFile);
			appInfo.setAppLogo(newName);
		}
		int count = appInfoService.update(appInfo);
		if(count > 0) {
			return "redirect:appList";
		}else {
			return "dev/updateAppInfo";
		}
	}
	@RequestMapping(value="/dev/deleteLogo" ,method=RequestMethod.GET)
	@ResponseBody
	public Object deleteLogo(String logo,HttpServletRequest request) {
		String savePath = request.getSession()
				.getServletContext().getRealPath("/statics/apklogo/");
		File file = new File(savePath,logo);
		if(file.exists()) {
			file.delete();//删除文件
		}
		return "done";
	}
	
	@RequestMapping(value="/dev/deleteapp",method=RequestMethod.GET)
	@ResponseBody
	public Object deleteAppinfo(int appId,HttpServletRequest request) {
		//获取所有版本的文件
		List<String> apkList = 
				appInfoService.findVersionApk(appId);
		//删除应用信息
		int count = appInfoService.deleteApp(appId);
		if(count > 0) {
			//数据删除完毕后删除文件
			String savePath = request.getSession()
					.getServletContext().getRealPath("/statics/apkfile/");
			for(String apkname : apkList) {
				File file = new File(savePath,apkname);
				if(file.exists()) {
					file.delete();
				}
			}
			return "true";
		}
		return "false";
	}
	@RequestMapping(value="/updateAppState",method=RequestMethod.GET)
	@ResponseBody
	public String updateAppState(int appId,int appState) {
		int count = 
		appInfoService.updateAppState(appId, appState);
		if(count > 0) {
			return "true";
		}
		return "false";
	}
	
	@RequestMapping(value="/dev/addversion/{appId}",method=RequestMethod.GET)
	public String addVersion(@PathVariable("appId")int appId,HttpServletRequest request) {
		List<AppVersion> versionList = appVersionService.findVersionByAppId(appId);
		request.setAttribute("versionList", versionList);
		return "dev/addversion";
		
	}
	
	@RequestMapping(value="/dev/addversion/{appId}",method=RequestMethod.POST)
	public String addVersion(@PathVariable("appId")int appId,AppVersion version,MultipartFile apkfile,HttpServletRequest request) throws Exception {
		if(!apkfile.isEmpty()) {
			String savePath = request.getSession()
					.getServletContext().getRealPath("/statics/apkfile/");
			String oldName=  apkfile.getOriginalFilename();
			Random ran = new Random();
			String newName = "apklogo_"+ System.currentTimeMillis()
					+ ran.nextInt(100000) + 
					oldName.substring(oldName.lastIndexOf("."));
			File saveFile = new File(savePath,newName);
			apkfile.transferTo(saveFile);
			version.setVerApk(newName);
		}
		DevUser devUser = (DevUser)request.getSession().getAttribute("loginUser");
		version.setVerCreatedBy(devUser.getDevId());
		version.setVerCreationDate(new Date());
		version.setVerAppId(appId);
		int count = appVersionService.save(version);
		if(count > 0 ) {
			return "redirect:/dev/appList";
		}
		return "dev/addversion";
	}
	
	@RequestMapping(value="/dev/updateversion",method=RequestMethod.POST)
	public String updateVersion(int appId,
			String verSn,HttpServletRequest request) {
		List<AppVersion> versionList = appVersionService.findVersionByAppId(appId);
		AppVersion version = appVersionService.findBySnAndAppId(verSn, appId);
		request.setAttribute("versionList", versionList);
		request.setAttribute("appVersion", version);
		return "dev/updateversion";
		
	}
	
	@RequestMapping(value="/dev/doupdateversion",method=RequestMethod.POST)
	public String updateVersion(AppVersion version,MultipartFile apkfile,HttpServletRequest request) throws Exception {
		if(apkfile!=null && !apkfile.isEmpty()) {
			String savePath = request.getSession()
					.getServletContext().getRealPath("/statics/apkfile/");
			String oldName=  apkfile.getOriginalFilename();
			Random ran = new Random();
			String newName = "apklogo_"+ System.currentTimeMillis()
					+ ran.nextInt(100000) + 
					oldName.substring(oldName.lastIndexOf("."));
			File saveFile = new File(savePath,newName);
			apkfile.transferTo(saveFile);
			version.setVerApk(newName);
		}
		DevUser devUser = (DevUser)request.getSession().getAttribute("loginUser");
		version.setVerModifyBy(devUser.getDevId());
		version.setVerModifyDate(new Date());
		
		int count = appVersionService.update(version);
		if(count > 0 ) {
			return "redirect:/dev/appList";
		}
		return "dev/updateversion";
	}
	
	
	
	public void setAppVersionService(AppVersionService appVersionService) {
		this.appVersionService = appVersionService;
	}
	
	
	
	
	
	
	
	
}
