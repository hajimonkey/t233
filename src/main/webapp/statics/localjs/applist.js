$(function(){
	/*网站路径*/
	var path = $("#path").val();
	var $catelv1 = $("#catelv1");
	var $catelv2 = $("#catelv2");
	var $catelv3 = $("#catelv3");
	
	var status = $("#status").val();/*app状态*/
	var flateform = $("#flateform").val();/*所属平台*/
	var cateLevel1 = $("#cateLevel1").val();/*一级分类*/
	var cateLevel2 = $("#cateLevel2").val();/*二级分类*/
	var cateLevel3 = $("#cateLevel3").val();/*三级分类*/
 	/*load appState*/
	$.ajax({
		url:path + "/appstate",
		type:"POST",
		dataType:"json",
		success:function(data){
			var $appState = $("#appState");
			for(var i = 0;i < data.length;i++){
				var option = $("<option></option>");
				if(status == data[i].dictValue){
					option.attr("selected","selected");
				}
				option.attr("value",data[i].dictValue);
				option.text(data[i].dictText);
				$appState.append(option);
			}
		},error:function(data){
			alert(data.responseText);
		}
	});
	
	
	$.ajax({
		url:path + "/plateform",
		type:"POST",
		dataType:"json",
		success:function(data){
			var $plateform = $("#plateform");
			for(var i = 0;i < data.length;i++){
				var option = $("<option></option>");
				if(flateform == data[i].dictValue){
					option.attr("selected","selected");
				}
				option.attr("value",data[i].dictValue);
				option.text(data[i].dictText);
				$plateform.append(option);
			}
		},error:function(data){
			alert(data.responseText);
		}
	});
	
	
	function getAppCate($obj,pid,cateLevel){
		$obj.find("option:not(:first)").remove();
		$.ajax({
			url:path+"/appcatelist",
			data:{"pid":pid},
			type:"POST",
			dataType:"json",
			success:function(data){
				for(var i = 0;i < data.length;i++){
					var option = $("<option></option>");
					if(cateLevel == data[i].cateId){
						option.attr("selected","selected");
					}
					option.attr("value",data[i].cateId);
					option.text(data[i].cateName);
					$obj.append(option);
				}
			},error:function(data){
				alert(data.responseText);
			}
		});
	}
	
	/*初始加载一级分类*/
	function getCateLevel1(){
		getAppCate($catelv1,0,cateLevel1);
		if(cateLevel2 != 0){/*查询条件中包含二级分类的值*/
			getAppCate($catelv2,cateLevel1,cateLevel2);
		}
		if(cateLevel3 != 0){
			getAppCate($catelv3,cateLevel2,cateLevel3);
		}
	}
	getCateLevel1();
	/*一级分类修改加载二级分类*/
	$catelv1.on("change",function(){
		var pid = $(this).val();
		if(pid != 0){
			getAppCate($catelv2,pid);
		}
	});
	$catelv2.on("change",function(){
		var pid = $(this).val();
		if(pid != 0){
			getAppCate($catelv3,pid);
		}
	});
	
	
	$(".pagebtn").on("click",function(){
		var txt = $(this).text();
		var pageNow = $("#demo-form2 [name=pageNow]").val();
		var pageCount = $("#pageCount").val();
		switch(txt){
		case "首页":
			pageNow = 1;
			break;
		case "上一页":
			pageNow = pageNow - 1 <=1?1:pageNow -1;
			break;
		case "下一页":
			pageNow = parseInt(pageNow) + 1 >=pageCount?pageCount:parseInt(pageNow) + 1;
			break;
		case "末页":
			pageNow = pageCount;
			break;
		default:
			pageNow = 1;
		}
		$("#demo-form2").submit();/*提交表单*/
	});
	
	
	$(".deletelink").click(function(){
		var delLike = $(this);
		var appId = $(this).attr("data-id");
		var appName= $(this).attr("data-name");
		if(confirm("是否要删除【" +appName+ "】？")){
			$.ajax({
				url : path+ "/dev/deleteapp",
				data:{"appId":appId},
				type:"GET",
				dateType:"text",
				success:function(data){
					if(data=="true"){
						alert("删除成功");
						//刷新网页
//						window.loaction.href=path+"/dev/appList";
						//删除超链接所在的行
						delLike.parents("tr").remove();
					}else{
						alert("删除失败！");
					}
				},error:function(data){
					alert(data.responseText);
				}
			});
		}
	});
	//修改状态
	function changeState(appId,appState,objTd,cssTd,textTd){
		$.ajax({
			url:path + "/updateAppState",
			data:{"appId":appId,"appState":appState},
			type:"GET",
			dataType:"text",
			success:function(data){
				if(data=="true"){
					objTd.html(textTd);
					objTd.css("background",cssTd);
				}else{
					alert("修改失败！");
				}
			},error:function(data){
				alert(data.responseText);
			}
		})
	}
	
	
	
	function onsaleclick(){
		var appId = $(this).attr("data-id");
		var appState = 4;
		var objTd = $(this).parents("tr").find("td:eq(5)");
		var textTd = "已上架";
		var cssTd = "green";
		changeState(appId,appState,objTd,cssTd,textTd);
		
		$(this).text("下架");
		$(this).off("click");//解除原有click事件绑定
		$(this).on("click",offsaleclick);
	}
	
	function offsaleclick(){
		var appId = $(this).attr("data-id");
		var appState = 5;
		var objTd = $(this).parents("tr").find("td:eq(5)");
		var textTd = "已下架";
		var cssTd = "red";
		changeState(appId,appState,objTd,cssTd,textTd);
		$(this).text("上架");
		$(this).off("click");//解除原有click事件绑定
		$(this).on("click",onsaleclick);
	}
	
	
	$(".onsale").on("click",onsaleclick);
	$(".offsale").on("click",offsaleclick);
	
	
	$(".upvlink").on("click",function(){
		var appId = $(this).attr("data-id");
		var sn = $(this).attr("data-sn");
		var $upvForm = $("#upvForm");
		$upvForm.find("[name='verSn']").val(sn);
		$upvForm.find("[name='appId']").val(appId);
		$upvForm.submit();
	});
	
	
	
	
	
});