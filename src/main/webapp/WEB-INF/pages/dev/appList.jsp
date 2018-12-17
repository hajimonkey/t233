<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="devTop.jsp" %>
	 	<div class="right_col" role="main">
          <div class="">
            <div class="row">
           	 <div class="col-md-12 col-sm-12 col-xs-12">
           	 	<div class="x_panel">
           	 	  <div class="x_title">
                    <h2>App信息管理维护<i class="fa fa-user"></i></h2>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <br />
                    <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left" method="post">
                    	<input type="hidden" name="pageNow" value="${pageNow==null?1:pageNow }">
                    	<div class="form-group">
	                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">软件名称 
	                        </label>
	                        <div class="col-md-3 col-sm-3 col-xs-12">
	                          <input type="text" id="first-name" name="appSoftwarename"  class="form-control col-md-7 col-xs-12">
	                        </div>
	                        <label class="control-label col-md-3 col-sm-3 col-xs-12">APP状态</label>
                        	<div class="col-md-3 col-sm-3 col-xs-12">
                          <select id="appState" name="appState" class="form-control">
                            <option value="0">请选择</option>
                          </select>
                        </div>
	                      </div>
                      	<div class="form-group">
                        
                      </div>
                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">所属平台</label>
                        <div class="col-md-3 col-sm-3 col-xs-12">
                          <select id="plateform" name="appPlateform" class="form-control">
                             <option value="0">请选择</option>
                          </select>
                        </div>
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">一级分类</label>
                        <div class="col-md-3 col-sm-3 col-xs-12">
                          <select id="catelv1" name="appCatelevel1" class="form-control">
                             <option value="0">请选择</option>
                          </select>
                        </div>
                      </div>
                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">二级分类</label>
                        <div class="col-md-3 col-sm-3 col-xs-12">
                          <select id="catelv2" name="appCatelevel2" class="form-control">
                             <option value="0">请选择</option>
                          </select>
                        </div>
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">三级分类</label>
                        <div class="col-md-3 col-sm-3 col-xs-12">
                          <select id="catelv3" name="appCatelevel3" class="form-control">
                             <option value="0">请选择</option>
                          </select>
                        </div>
                      </div>
                      <div class="form-group">
	                      <div class="col-md-3 col-sm-3 col-xs-12 col-md-push-3">
	                      	<button class="btn btn-primary">查询</button>
	                      </div>
                      </div>
                    </form>
                  </div>
           	 	</div>
           	 	<div class="x_panel">
         	 	 <div class="x_content">
           	 	 	<p class="text-muted font-13 m-b-30">
           	 	 		<button class="btn btn-success" type="button">新增APP基础信息</button>
           	 	 	</p>
           	 	 	<table id="datatable" class="table table-striped table-bordered">
           	 	 	  <thead>
                        <tr>
                          <th>软件名称</th>
                          <th>APK名称</th>
                          <th>软件大小（单位:M）</th>
                          <th>所属平台</th>
                          <th>所属分类（一级分类、二级分类、三级分类）</th>
                          <th>状态</th>
                          <th>下载次数</th>
                          <th>最新版本号</th>
                          <th>操作</th>
                        </tr>
                      </thead>
                      <tbody>
                      	<c:forEach items="${appList }" var="app">
                      		<tr>
                      		 <td>${app.appSoftwarename }</td>
                      		 <td>${app.appApkname }</td>
                      		 <td>${app.appSize }</td>
                      		 <td>${app.plateformname }</td>
                      		 <td>${app.catelv1name }->${app.catelv2name }->${app.catelv3name }</td>
                      		 <td>${app.statename }</td>
                      		 <td>${app.appDowncount }</td>
                      		 <td>${app.appLastversion }</td>
                      		 <td>
                      		 	<div class="btn-group">
			                      <button type="button" class="btn btn-danger">点击操作</button>
			                      <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
			                        <span class="caret"></span>
			                        <span class="sr-only">Toggle Dropdown</span>
			                      </button>
			                      <ul class="dropdown-menu" role="menu">
			                        <c:if test="${app.appState==2 || app.appState==5 }">
			                        <li><a href="#">上架</a>
			                        </li>
			                        </c:if>
			                        <c:if test="${app.appState ==4 }">
			                        <li><a href="#">下架</a>
			                        </li>
			                        </c:if>
			                        <li><a href="#">新增版本</a>
			                        </li>
			                        <li><a href="#">修改版本</a>
			                        </li>
			                        <li><a href="#">修改</a>
			                        </li>
			                        <li><a href="#">查看</a>
			                        </li>
			                        <li><a href="#">删除</a>
			                        </li>
			                      </ul>
			                    </div>
                      		 </td>
                      		</tr>
                      	</c:forEach>
                      </tbody>
                      <tfoot>
                      <tr>
                       <td colspan="3">
                       	共${count}条记录 第${pageNow }/${pageCount }页</td>
                       <td colspan="6">
                       	<button class="btn btn-default">首页</button>
                       	<button class="btn btn-default">上一页</button>
                       	<button class="btn btn-default">下一页</button>
                       	<button class="btn btn-default">末页</button>
                       </td>
                      </tr>
                      </tfoot>
           	 	 	</table>
           	 	 </div>
           	 	</div>
           	 </div>
            </div>
          </div>
        </div>
	<%@ include file="devFoot.jsp"%>
	<script src="${pageContext.request.contextPath }/localjs/applist.js"></script>