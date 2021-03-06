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
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta http-equiv="Cache-Control" content="no-cache,must-revalidate">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta name="format-detection" content="telephone=no, address=no">
		<meta content="yes" name="apple-mobile-web-app-capable">
		<meta content="black-translucent" name="apple-mobile-web-app-status-bar-style">
		<title></title>
		<link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css">
		<link href="https://cdn.bootcss.com/jquery-mobile/1.4.5/jquery.mobile.theme.css" rel="stylesheet">
		
		<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
		<script src="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script>


  	
	<script type="text/javascript">
	
			$(function(){
				//加载下拉课题类别数据
				ajaxLoadMeetingType();
			});
			//加载下拉课题类别数据
			function ajaxLoadMeetingType(){
				$.ajax({
					type:"post",
					url:"weixin/meetingType/getAll",
					success:function(msg){
						var appendHtml="";
						for(var i=0;i<msg.length;i++){
							appendHtml+=" <option value='"+msg[i].tname+"'>"+msg[i].tname+"</option>  ";
						}
						$("#mname").append(appendHtml);
					}
				});
			}
	
			function showPubDiv() {
				$("#two_line").css("border-top", "5px solid #4E90C7");
				//$("#two_tab").css("color","#777777");
				$("#one_line").css("border-top", "5px solid white");
				//$("#one_tab").css("color","white");
				$("#two").css("display", "none");
				$("#one").css("display", "block");
			}

			function showMyMeetings() {

				$("#two_line").css("border-top", "5px solid white");
				$("#one_line").css("border-top", "5px solid #4E90C7");
			
					$("#one").css("display", "none");
					$("#two").css("display", "block");

					$("#two").empty();
					var mname="学习SpringBoot";
					var remark="备注";
					var dateCurr="时间";
					var appendHtml = "<font style='padding: 10px 10px 10px 15px;display: block;color: #777777;'>您共发布了8场会议</font>";

				

						appendHtml += "<div style='width: 100%;background-color: white;margin-top: -3px;padding:10px 10px 10px 15px;display: inline-block;'>" +
							"<div style='width: 70%;float: left;' onclick='showMeetingInfo(\"" + 1 + "\");'>" +
							"<div style='white-space: nowrap;overflow: hidden;text-overflow:ellipsis;display: block;font-size:18px;'>" +
							mname + "</div>" +
							"<div style='white-space: nowrap;overflow: hidden;text-overflow:ellipsis;display: block;color: #777777;font-size:16px;padding-top:1px'>" +
							remark + " / " + dateCurr + "</div></div>" +
							"<div style='width: 30%;float: right;'>" +
							"<button class='able-btn' >选择讲者</button></div></div>";
							
							
							
						appendHtml += "<div style='width: 100%;background-color: white;margin-top: -3px;padding:10px 10px 10px 15px;display: inline-block;'>" +
							"<div style='width: 70%;float: left;' onclick='showMeetingInfo(\"" + 1 + "\");'>" +
							"<div style='white-space: nowrap;overflow: hidden;text-overflow:ellipsis;display: block;font-size:18px;'>" +
							mname + "</div>" +
							"<div style='white-space: nowrap;overflow: hidden;text-overflow:ellipsis;display: block;color: #777777;font-size:16px;padding-top:1px'>" +
							remark + " / " + dateCurr + "</div></div>" +
							"<div style='width: 30%;float: right;'>" +
							"<button class='able-btn' >选择讲者</button></div></div>";	
					
					$("#two").append(appendHtml);
			
			}
			//会议发布
			function subMeetingPub(){
				//非空验证
				var ptitle=$("#ptitle").val();
				if(ptitle.length<1){
					alert("会议名称不能为空");
					return ;
				}
				//会议日期 pubtime
				var pubtime=$("#ptime").val();
				if(pubtime.length<1){
					alert("会议召开时间不能为空");
					return ;
				}
				//ajax会议添加
				
			}
			
		</script>
</head>
<body>
	
<div data-role="page" id="pageDetail">
			<div style="padding:0px;background-color: #4E90C7;width: 100%;height:40px;line-height:40px;font-size:18px;text-align: center;cursor: pointer;" data-role="none">
				<div style="width: 50%;float: left;color: white;" onclick="showPubDiv();" id="one_tab">
					发布
					<div style="border-right: 1px solid white;float: right;margin-top: 10px;height: 20px;"></div>
				</div>
				<div style="width: 50%;float: left;color: white;" onclick="showMyMeetings();" id="two_tab">我的会议</div>
				<div style="border-top:5px solid white;width: 50%;float: left;" id="one_line"></div>
				<div style="border-top:5px solid #4E90C7;width: 50%;float: left;" id="two_line"></div>
			</div>
			<div id="one" class="ui-body-d ui-content" style="padding:0;display: block;width: 100%;">
				<font style="padding:10px 10px 10px 15px;display: block;color: #777777;">请填写会议相关信息</font>
				<div style="width: 100%;background-color: white;padding:10px 0 10px 0;">
					
					<form id="pubForm" method="post">
						<input type="hidden" name="uid" value="${param.uid}">
						<div style="padding-right:15px;padding-left:15px">
							<label for="ptitle" class="font-label">会议名称:</label>
							<input name="ptitle" id="ptitle" placeholder="请输入会议名称" ></input>
						</div>						
						<div  style="padding-right:15px;padding-left:15px">			
								<label for="ptime" class="font-label">会议日期</label>
	      					   <input type="datetime-local" name="ptime" id="ptime" />							
						</div>
						<div style="padding-right:15px;padding-left:15px">
							<label for="mname" class="font-label">类别：</label>
							<select name="tid" id="mname">
								
							</select>
						</div>
						<div style="padding-right:15px;padding-left:15px">
							<label for="pcompany" class="font-label">所属单位：</label>
							<textarea name="pcompany" id="pcompany" placeholder="请输入内容" maxlength="100" class="font-blue input-lightblue" style="box-shadow: none;"></textarea>
						</div>
						<div style="padding-right:15px;padding-left:15px">
							<label for="pzone" class="font-label">讲者区域：</label>
							<select name="pzone" id="pzone">
								<option value="全国">全国</option>
								<option value="东区">东区</option>
								<option value="西区">西区</option>
								<option value="南区">南区</option>
								<option value="北区">北区</option>
							</select>
						</div>
						
						<div style="padding-right:15px;padding-left:15px">
							<input type="button" value="发布会议"  onclick="subMeetingPub()" id="btnId" />
						</div>
					</form>
				</div>
			</div>
			

	
	
			
	<div id="two" class="ui-body-d ui-content" style="padding: 0;display: none;width: 100%;">
		
	</div>
	</body>

</html>