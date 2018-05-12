<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
 <%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="/favicon.ico" >
<link rel="Shortcut Icon" href="/favicon.ico" />

<link rel="stylesheet" type="text/css" href="h-ui/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="h-ui/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="h-ui/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="h-ui/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="h-ui/static/h-ui.admin/css/style.css" />

<!--/meta 作为公共模版分离出去-->
</head>
<body>
<article class="page-container">
	<form action="loginUsers/register" method="post" class="form form-horizontal" id="form-member-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用户名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="username" name="username"
				onblur="isLogin()" >
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>密码：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="password" class="input-text" value="" placeholder="" id="password" name="password">
			</div>
		</div>
		
		
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>邮箱：(必须激活邮箱才能登录)</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="315759265@qq.com"" placeholder=" name="email" id="email">
			</div>
		</div>
		
		
		
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
		</div>
	</form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="h-ui/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="h-ui/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="h-ui/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="h-ui/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本--> 
<script type="text/javascript" src="h-ui/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="h-ui/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="h-ui/lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="h-ui/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});	
	$("#form-member-add").validate({
		rules:{
			username:{
				required:true,
				minlength:2,
				maxlength:16
			},
			password:{
				required:true,
				minlength:2,
				maxlength:10
			},
			sex:{
				required:true,
			},
			mobile:{
				required:true,
				isMobile:true,
			},
			email:{
				required:true,
				email:true,
			},
			uploadfile:{
				required:true,
			},
			
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			var uname=$("#username").val();
			var upass=$("#password").val();

			$.ajax({
				type:"post",
				url:"loginUsers/register",
				data:{"username":uname,"password":upass,"email":"123"},
				success:function(data){
					//http://www.bubuko.com/infodetail-2414287.html
					var index = parent.layer.getFrameIndex(window.name);//获取当前弹出层的层级
				
					//parent.$('.btn-refresh').click();
					window.parent.location.reload();//刷新父页面
					parent.layer.close(index);//关闭当前页面层
				}
			});
	
		
		}
	});
});
//ajax验证用户名是否存在
function isLogin(){
	var uname=document.getElementById("username");
	if(uname.value.length<1){
		layer.msg('请输入用户名',{icon: 5,time:2000});
		//光标回去
		uname.focus();//光标定位
		return ;
	}
	$.ajax({
		type:"post",
		url:"loginUsers/isLoginUserName",
		data:{"username":uname.value},
		success:function(data){
			if("2"==data){
				layer.msg('用户名已存在，请更换',{icon: 5,time:2000});
				uname.focus();//光标定位
				uname.select();//选中标识
			}
		}
	});
	
}

</script> 
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>