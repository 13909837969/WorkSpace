<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<link href="h-ui/static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="h-ui/static/h-ui.admin/css/H-ui.login.css" rel="stylesheet" type="text/css" />
<link href="h-ui/static/h-ui.admin/css/style.css" rel="stylesheet" type="text/css" />
<link href="h-ui/lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
	//看不清，换一张
	function changeCode(){

		var img=document.getElementById("imgCodeId");
		img.src="validate.code?aafdsafdsa="+Math.random();
	}

</script>
<title>后台登录</title>
</head>
<body>
<input type="hidden" id="TenantId" name="TenantId" value="" />

<div class="loginWraper">
  <div id="loginform" class="loginBox">
    <form class="form form-horizontal" action="loginUsers/login" method="post">
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
        <div class="formControls col-xs-8">
          <input id="" name="username" type="text" placeholder="账户" value="${username}" class="input-text size-L">
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
        <div class="formControls col-xs-8">
          <input id="" name="password" type="password" placeholder="密码"  value="${password}" class="input-text size-L">
        </div>
      </div>
       <div class="row cl">
        
        <div class="formControls col-xs-8" style="font-size: 12px;color: red">
            ${loginMsg}
        </div>
      </div>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <input class="input-text size-L" name="loginCode" type="text" placeholder="验证码" onblur="if(this.value==''){this.value='验证码:'}" onclick="if(this.value=='验证码:'){this.value='';}" value="验证码:" style="width:150px;">
          <img id="imgCodeId" src="validate.code"> <a id="kanbuq" href="javascript:changeCode();">看不清，换一张</a> </div>
      </div>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <label for="online">
            <input type="checkbox" name="online" id="online" value="">
            使我保持登录状态</label>
        </div>
      </div>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <input name="" type="submit" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
          <input name="" type="reset" class="btn btn-default radius size-L" value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
        </div>
      </div>
    </form>
  </div>
</div>
<div class="footer">Copyright 公司名称 by 微会议管理系统</div>
<script type="text/javascript" src="h-ui/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="h-ui/static/h-ui/js/H-ui.min.js"></script>

</body>
</html>