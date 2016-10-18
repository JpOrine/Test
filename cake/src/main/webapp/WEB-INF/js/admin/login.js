$(function(){
	 $("body").keydown(function() {
		 if($("input[name=code]").val() != ""){
			 if (event.keyCode == "13") {//keyCode=13是回车键
		         $('#loginAdmin').click();
		     }
		 }else{
			 $("#loginAdmin").attr('disabled',false);
		 }
	 });
	 
	$("#loginAdmin").click(function() {
		var username = $("input[name=username]").val();
		var password = $("input[name=password]").val();
		if(username==""){
			alert("请输入用户名");
		}else if(password==""){
			alert("请输入密码");
		}else if($("input[name=code]").val() == ""){
			alert("验证码不能为空");
		}else{
			var user = {
				"username" : username,
				"password" : password,
			};
			$.ajax({
				type : "post",
				dataType : "json",
				data : user,
				contentType : "application/x-www-form-urlencoded;charset=UTF-8",
				url : "admin/login",
				// 同步async: false,（默认是true）;
				// 如上：false为同步，这个方法中的Ajax请求将整个浏览器锁死，
				// 只有test.jsp执行结束后，才可以执行其它操作。
				async : false,
				success : function(data) {
					if (false == data.result) {
						alert("用户名或者密码错误，请重新登录！");
					} else if (true == data.result) {
						var indexUrl = window.location.protocol+"//"+window.location.host+"/cake/html/admin/index.html";
						window.location = indexUrl;
					}
				},
				error : function() {
					alert("服务器发生故障，请尝试重新登录！");
				}
			});
		}
		
	});
	
	$("input[name=code]").blur(function(){
		$.ajax({
			type : "post",
			dataType : "json",
			data : { Code: $("input[name=code]").val() },
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : "admin/code",
			// 同步async: false,（默认是true）;
			// 如上：false为同步，这个方法中的Ajax请求将整个浏览器锁死，
			// 只有test.jsp执行结束后，才可以执行其它操作。
			async : false,
			success : function(data) {
				if (false == data.codeResult) {
					$("em").removeClass("codeRestar").removeClass("codeOk");
					$("em").addClass("codeError");
					$("input[name=code]").val("");
					$("#loginAdmin").attr('disabled',true);
				} else if (true == data.codeResult) {
					$("em").removeClass("codeRestar").removeClass("codeError");
					$("em").addClass("codeOk");
					$("#loginAdmin").attr('disabled',false);
				}
			}
		});
	});
})

function reloadcode(obj,base){    
  var rand=new Date().getTime(); //这里用当前时间作为参数加到url中，是为了使URL发生变化，这样验证码才会动态加载，    
  obj.src=base+"admin/loginCode?a"+rand; //其实服务器端是没有a的字段的。    
  }
