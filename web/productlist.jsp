<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>productlist</title>
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
							<input type="button" class="button" value="安全退出" onclick="location='${pageContext.request.contextPath }/headler/anquantuichu'"/>
							<br />
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#"><div id="time">
                            <script>
                                document.getElementById('time').innerHTML = new Date().toLocaleString() ;
                                setInterval(
                                    "document.getElementById('time').innerHTML=new Date().toLocaleString();",
                                    1000);
                            </script>
                        </div></a>
							
						</h1>
					</div>
					<div id="navigation" align="right">
						<form action="${pageContext.request.contextPath }/headler/showAll" method="post">
							<input type="submit"  value="对商品的操作"/>
							<a href="${pageContext.request.contextPath }/headler/yonghucaozuo "><input type="button"  value="对用户的操作"/></a>
						</form>
						
					</div>
				</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						Welcome <%=(String)session.getAttribute("username") %>
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								商品ID
							</td>
							<td>
								商品名称
							</td>
							<td>
								价格
							</td>
							<td>
								描述
							</td>
							<td>
								操作
							</td>
						</tr>
						
						<c:forEach items="${requestScope.commoditys }" var="commodity" varStatus="Status">
							<tr class="row1">
								<td>${commodity.id}</td>
								<td>${commodity.name}</td>
								<td>${commodity.price}</td>
								<td>${commodity.describle}</td>
								
								<td>
									<a href="${pageContext.request.contextPath }/headler/delete?id=${commodity.id}">
										<input type="button" value="删除">
									</a>
									&nbsp;&nbsp;
									<a href="${pageContext.request.contextPath }/headler/toUpdate?id=${commodity.id}">
										<input type="button" value="修改">
									</a>
								</td>
							 </tr>
						</c:forEach>
					</table>
					<p style="height: 39px; ">
						<input type="button" onclick="javascript:location.href='${pageContext.request.contextPath }/add.jsp'" class="button"  value="添加商品&raquo;" />
						
					</p>
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
