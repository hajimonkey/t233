<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	 <%@ include file="devTop.jsp" %>
	 	<div class="right_col" role="main">
          <div class="">
            <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
            	<div class="x_panel">
            	 <div class="x_title">
            	 	<h2>修改APP版本信息</h2>
            	 	<div class="clearfix"></div>
            	 </div>
            	 <div class="x_title">
            	 	<h2>历史版本列表</h2>
            	 	<div class="clearfix"></div>
            	 </div>
            	 <div class="x_content">
            	 <table id="datatable" class="table table-striped table-bordered">
           	 	 	  <thead>
                        <tr>
                          <th>软件名称</th>
                          <th>版本号</th>
                          <th>版本大小（单位:M）</th>
                          <th>发布状态</th>
                          <th>APK文件下载</th>
                          <th>最新更新时间</th>
                        </tr>
                      </thead>
                      <tbody>
                      <c:forEach items="${versionList }" var="version">
                      	<tr>
                      		<td>${version.softwarename }</td>
                      		<td>${version.verSn }</td>
                      		<td>${version.verSize }</td>
                      		<td>${version.verStatename }</td>
                      		<td><a href="${pageContext.request.contextPath }/apkfile/${version.verApk}">下载</a></td>
                      		<td>
                      		 <c:if test="${version.verModifyDate != null }">
                      		   <fmt:formatDate value="${version.verModifyDate }" pattern="yyyy-MM-dd"/>
                      		 </c:if>
                      		 <c:if test="${version.verModifyDate == null }">
                      		 	<fmt:formatDate value="${version.verCreationDate }" pattern="yyyy-MM-dd"/>
                      		 </c:if>
                      		</td>
                      	</tr>
                      </c:forEach>
                      </tbody>
                  </table>
            	 </div>
            	 <div class="x_title">
            	 	<h2>修改版本信息</h2>
            	 	<div class="clearfix"></div>
            	 </div>
            	  <div class="x_content">
            	  	<br />
            	  	<form id="demo-form2" action="${pageContext.request.contextPath }/dev/doupdateversion"
            	  	method="post" enctype="multipart/form-data"
            	  	 data-parsley-validate class="form-horizontal form-label-left">
            	  	  <input type="hidden" name="verId" value="${appVersion.verId }">
            	  	  <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">版本号<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" name="verSn" required="required" value="${appVersion.verSn }" readonly="readonly"
                          disabled="disabled" class="form-control col-md-7 col-xs-12" placeholder="请输入版本号">
                        </div>
                      </div>
                       <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">版本大小<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="number" value="${appVersion.verSize }" name="verSize" required="required" class="form-control col-md-7 col-xs-12" placeholder="请输入版本大小，单位为Mb">
                        </div>
                      </div>
                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">版本状态<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">预发布
                          <input type="hidden" name="verState" value="1">
                        </div>
                      </div>
                      <div class="form-group">
                      	<label class="control-label col-md-3 col-sm-3 col-xs-12">版本简介<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                           <textarea name="verDesc" class="form-control" rows="3" placeholder='rows="3"'>${appVersion.verDesc }</textarea>
                        </div>
                      </div>
                      <div class="form-group">
                      	<label class="control-label col-md-3 col-sm-3 col-xs-12">apk文件<span class="required">*</span>
                        </label>
                        
                        <div class="col-md-6 col-sm-6 col-xs-12">
                        <c:if test="${appVersion.verApk !=null }">${appVersion.verApk }
                        	<a href="${pageContext.request.contextPath }/apkfile/${appVersion.verApk }">下载</a>
                        </c:if>
                        <c:if test="${appVersion.verApk ==null }">
                                  <input type="file" name="apkfile" required="required">
                        </c:if> 
                         </div>
                      </div>
                      <div class="ln_solid"></div>
                      <div class="form-group">
                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                          <button type="button" class="btn btn-primary">Cancel</button>
                          <button type="submit" class="btn btn-success">保存</button>
                        </div>
                      </div>
            	  	</form>
            	 </div>
            	</div>
            </div>
            </div>
          </div>
        </div>
	<%@ include file="devFoot.jsp"%>