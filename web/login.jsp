<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>login</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/style.css" />
		<link href="${pageContext.request.contextPath }/css/common.css" type="text/css" rel="stylesheet" />
		
		<script type="text/javascript">
			function chenggong()
			{
				var ss=	document.getElementById("UserName").value;
				var bb=document.getElementById("password").value;
				if(ss==""||bb=="")
					{
					alert("账号或密码不能为空");
					return false;
					}
				else{
					return true;
				}
			}
			function refresh(){
				   document.getElementById("randImage").src = "code.jsp?" + Math.random();
			}
		</script>
		
	</head>

	<body>
	
		
		<div id="wrap">
			<div id="top_content">
					<div id="header">
						<div id="rightheader">
							<p>
								<div id="time">
                            <script>
                                document.getElementById('time').innerHTML = new Date().toLocaleString() ;
                                setInterval(
                                    "document.getElementById('time').innerHTML=new Date().toLocaleString();",
                                    1000);
                            </script>
                        </div>
								<br />
							</p>
						</div>
						<div id="topheader">
							<h1 id="title">
								<a href="#">main</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						<img src="${pageContext.request.contextPath }/img/header_logo.gif"/>
					</h1>
					<form action="${pageContext.request.contextPath }/headler/login" method="post" onsubmit="return chenggong()">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="UserName" id="UserName"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									密码:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="password" id="password" /><br>
     								<font color="red">${requestScope.loginMessage }</font>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									请选择用户：
								</td>
								<td>
									<select name="yonghu">
										<option value="顾客">顾客</option>
										<option value="管理员">管理员</option>
									</select>
								</td>
								
							</tr>
							<tr>
								<td valign="middle" align="right">
									验证码:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" style="width:108px" name="code" />
									<img name="randImage" id="randImage" src="${pageContext.request.contextPath }/code.jsp" style="width:70px;height:25px" onclick="refresh()" />
									<br>
									<font color="red">${requestScope.codeMessage }</font>
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="登陆&raquo;" />
							<input type="button" onclick="javascript:location.href='${pageContext.request.contextPath }/regist.jsp'" class="button"  value="点我注册&raquo;" />
						</p>
					</form>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
					ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
