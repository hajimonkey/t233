<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="devTop.jsp" %>
<div class="right_col" role="main">
	<div class="">
		<div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>修改应用基本信息 </h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        <ul class="dropdown-menu" role="menu">
                          <li><a href="#">Settings 1</a>
                          </li>
                          <li><a href="#">Settings 2</a>
                          </li>
                        </ul>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <br />
                    <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left">

                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">软件名称<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" name="appSoftwarename" required="required" class="form-control col-md-7 col-xs-12"
                          value="${appInfo.appSoftwarename }">
                        </div>
                      </div>
                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">APK名称 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" id="appApkname" name="appApkname"
                          value="${appInfo.appApkname }" disabled="disabled"
                            class="form-control col-md-7 col-xs-12 " readonly="readonly">
                        </div>
                      </div>
                      <div class="form-group">
                        <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">支持ROM <span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input id="appRom" name="appRom" class="form-control col-md-7 col-xs-12" type="text" 
                          value="${appInfo.appRom }">
                        </div>
                      </div>
                      <div class="form-group">
                        <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">界面语言<span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input id="appLanguage" class="form-control col-md-7 col-xs-12" type="text" name="appLanguage"
                          value="${appInfo.appLanguage }"
                          >
                        </div>
                      </div>
                      <div class="form-group">
                        <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">软件大小</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input id="appSize" class="form-control col-md-7 col-xs-12" type="number" name="appSize"
                          value="${appInfo.appSize }"
                          >
                        </div>
                      </div>
                      <div class="form-group">
                        <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">下载次数</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input id="appDowncount" class="form-control col-md-7 col-xs-12" type="number" name="appDowncount"
                          value="${appInfo.appDowncount }">
                        </div>
                      </div>                      
                       <div class="form-group">
                         <label class="control-label col-md-3 col-sm-3 col-xs-12">所属平台</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <select id="plateform" name="appPlateform" class="form-control">
                             <option value="0">请选择</option>
                          </select>
                        </div>
                      </div>
                      <div class="form-group">
                         <label class="control-label col-md-3 col-sm-3 col-xs-12">一级分类</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <select id="catelv1" name="appCatelevel1" class="form-control">
                             <option value="0">请选择</option>
                          </select>
                        </div>
                      </div>
                      <div class="form-group">
                         <label class="control-label col-md-3 col-sm-3 col-xs-12">二级分类</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <select id="catelv2" name="appCatelevel2" class="form-control">
                             <option value="0">请选择</option>
                          </select>
                        </div>
                      </div>
                      <div class="form-group">
                         <label class="control-label col-md-3 col-sm-3 col-xs-12">三级分类</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <select id="catelv3" name="appCatelevel3" class="form-control">
                             <option value="0">请选择</option>
                          </select>
                        </div>
                      </div>
                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">应用状态<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input id="appState" class="date-picker form-control col-md-7 col-xs-12"  type="text"
                          disabled="disabled" readonly="readonly" value="${appInfo.statename }"
                          >
                        </div>
                      </div>
                      <div class="form-group">
                      	<label class="control-label col-md-3 col-sm-3 col-xs-12">应用简介<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                           <textarea name="appDesc" class="form-control" rows="3" placeholder='rows="3"'>${appInfo.appDesc }</textarea>
                        </div>
                      </div>
                      <div class="form-group">
                      	<label class="control-label col-md-3 col-sm-3 col-xs-12">LOGO图片<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                           <c:if test="${appInfo.appLogo!=null }">
                           <img alt="" src="${pageContext.request.contextPath }/apklogo/${appInfo.appLogo}">
                           <a id="deleteLogolink" href="javascript:" data-name="${appInfo.appLogo}">删除</a>
                           </c:if>
                           <c:if test="${appInfo.appLogo == null }">
                            <input type="file" name="appLogoImg">
                           </c:if>
                           
                        </div>
                      </div>
                      <div class="ln_solid"></div>
                      <div class="form-group">
                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                          <button type="submit" class="btn btn-primary">Cancel</button>
                          <button type="submit" class="btn btn-success">Submit</button>
                        </div>
                      </div>
                      	<input id="flateform" type="hidden" value="${appInfo.appPlateform }">
                       	<input id="cateLevel1" type="hidden" value="${appInfo.appCatelevel1}">
                       	<input id="cateLevel2" type="hidden" value="${appInfo.appCatelevel2}">
                       	<input id="cateLevel3" type="hidden" value="${appInfo.appCatelevel3}">
                    </form>
                  </div>
                </div>
              </div>
            </div>
	</div>
</div>
<%@ include file="devFoot.jsp"%>
<script src="${pageContext.request.contextPath }/localjs/applist.js"></script>
<script src="${pageContext.request.contextPath }/localjs/appinfomodify.js"></script>