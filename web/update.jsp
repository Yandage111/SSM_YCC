<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>update Product</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/style.css" />
		<link href="${pageContext.request.contextPath }/css/common.css" type="text/css" rel="stylesheet" />
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
		
		<div id="wrap">
			<div id="top_content">
					<div id="header">
						<div id="rightheader">
							<p>
								<input type="button" class="button" value="安全退出" onclick="location='login.jsp'"/>
								<br />
							</p>
						</div>
						<div id="topheader">
							<h1 id="title">
								<a href="#">2018/6/26</a>
								
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						修改商品信息:
					</h1>
					<form action="${pageContext.request.contextPath }/headler/update" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									商品ID:
								</td>
								<td valign="middle" align="left">
									${requestScope.user.id } <input type="text" class="inputgri" value="${requestScope.user.id }" name="id" hidden /> 
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									商品名称:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" value="${requestScope.user.name }" name="name" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									商品价格:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" value="${requestScope.user.price }" name="price" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									商品描述:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" value="${requestScope.user.describle }" name="describle" />
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="修改" />
							<a href="${pageContext.request.contextPath }/headler/showAll">
										<input type="button" value="返回商品页面">
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
