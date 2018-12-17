$(function(){
	var path = $("#path").val();
 	/*load appState*/
	$.ajax({
		url:path + "/appstate",
		type:"POST",
		dataType:"json",
		success:function(data){
			var $appState = $("#appState");
			for(var i = 0;i < data.length;i++){
				var option = $("<option></option>");
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
				option.attr("value",data[i].dictValue);
				option.text(data[i].dictText);
				$plateform.append(option);
			}
		},error:function(data){
			alert(data.responseText);
		}
	});
	var $catelv1 = $("#catelv1");
	var $catelv2 = $("#catelv2");
	var $catelv3 = $("#catelv3");
	
	function getAppCate($obj,pid){
		$obj.find("option:not(:first)").remove();
		$.ajax({
			url:path+"/appcatelist",
			data:{"pid":pid},
			type:"POST",
			dataType:"json",
			success:function(data){
				for(var i = 0;i < data.length;i++){
					var option = $("<option></option>");
					option.attr("value",data[i].cateId);
					option.text(data[i].cateName);
					$obj.append(option);
				}
			},error:function(data){
				alert(data.responseText);
			}
		});
	}
	
	//初始加载一级分类
	getAppCate($catelv1,0);
	//一级分类修改加载二级分类
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
	
});