<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>add Product</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
		<link href="${pageContext.request.contextPath}/css/common.css" type="text/css" rel="stylesheet" />
		
		<script type="text/javascript">
			function chenggong()
			{
				var ss=	document.getElementById("name").value;
				var bb=document.getElementById("price").value;
				if(ss==""||bb=="")
					{
					alert("商品名字或者价格不能为空");
					return false;
					}
				else{
					return true;
				}
			}
		</script>
		
		
	</head>

	<body>
		
		
		<%
		
			   String yonghu2=(String)session.getAttribute("login");			
			   if(yonghu2==null)
			   {
				   %>
				   <script type="text/javascript">
				   alert("你还没有的登陆，请先登陆！！");
				    location.href="${pageContext.request.contextPath }/login.jsp";
				    </script>
				   <%
			   }
		
		 %>
		<%
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");
		java.util.Date currentTime = new java.util.Date();//得到当前系统时间
		String str_date1 = formatter.format(currentTime);
		
		 %>
		 
		<div id="wrap">
			<div id="top_content">
					<div id="header">
						<div id="rightheader">
							<p>
								
								<input type="button" class="button" value="安全退出" onclick="location='${pageContext.request.contextPath }/login.jsp'"/>
								<br />
							</p>
						</div>
						<div id="topheader">
							<h1 id="title">
								<a href="#"><%=str_date1%></a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						注册用户信息:
					</h1>
					<form action="${pageContext.request.contextPath }/headler/zhuceyonghu" method="post" onsubmit="return chenggong()">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right" >
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="username" id="username"  />
									<font color="red">${requestScope.bbb }</font>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									密码:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="password" id="password" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									存额:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="prices" />
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="注册" />
							<a href="${pageContext.request.contextPath }/headler/yonghucaozuo">
										<input type="button" value="返回页面">
							</a>
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