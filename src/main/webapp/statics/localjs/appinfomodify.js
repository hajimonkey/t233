$(function(){
	path = $("#path").val();
	$("#deleteLogolink").click(function(){
		var logo = $(this).attr("data-name");
		var $div = $(this).parent();
		$.ajax({
			url: path + "/dev/deleteLogo",
			data:{"logo":logo} ,
			type:"GET",
			dataType:"text",
			success:function(data){
				$div.html("<input type='file' name='appLogoImg'>")
			},error:function(data){
				alert(data.responseText);
			}
		})
	});
});