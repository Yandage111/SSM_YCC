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
							<input type="button" class="button" value="安全退出" onclick="location='${pageContext.request.contextPath }/login.jsp'"/>
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
						<form action="${pageContext.request.contextPath }/headler/likecommodity" method="post">
							最低价<input type="text"  name="lowprice" value="" style="width:50px"/>
							最高价<input type="text"  name="highprice" value=""style="width:50px"/>
							商品查询<input type="text"  name="like" value=""style="width:100px"/>
							<input type="submit"  value="搜索"/>
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
									<a href="${pageContext.request.contextPath }/headler/xiaofei?id=${commodity.id}">
										<input type="button" value="添加购物车">
									</a>
									
								</td>
							 </tr>
						</c:forEach>
					</table>
					本次消费总额为：<%=session.getAttribute("prices") %>
					<p style="height: 39px; ">
						
						<a href="${pageContext.request.contextPath }/headler/customerproductlist"><input type="button" value="返回商品>>"></a>
						<a href="${pageContext.request.contextPath }/headler/xiadangoumai?username=<%=(String)session.getAttribute("username") %>"><input type="button" value="下单购买>>"></a>
						<a href="${pageContext.request.contextPath }/headler/qingkong"><input type="button" value="清空购物车>>"></a>
					</p>
					
					
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
				你的存额 为： <%=(int)session.getAttribute("pricess") %>
				</div>
			</div>
		</div>
	</body>
</html>
