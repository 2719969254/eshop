<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>show</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/del.js"></script>
	-->
	<script type="text/javascript">
		function selectAll(){
			alert("select all");
		}
	</script>
  </head>
  
  <body>
	 
	  <form id="frm" method="post" action="${pageContext.request.contextPath}/DelUserServlet">
	  	
	  	<table border="1px">
	    	<tbody>
	    		<tr>
	    			<td>��Ʒ����</td>
	    			<td>��Ʒ�۸�</td>
	    			<td>���</td>
	    		</tr>
	    	</tbody>
	    	
	    	 <!-- ��ȡ �������е�  ��������Ϊ findAllSer ��ֵ ���б���
		         		����������� ΪUser����  ��ŵ���  userall ����
		         		��ͨ�� userall ��ȡ�� User����ĸ�������ֵ
		         		${pageContext.request.contextPath}/UpdateServlet?userId=${allSerUser.id}
		          -->
	    	<c:forEach items="${selectGoods}" var="goods" varStatus="temp">
	    		<tbody>
	    			<tr>
	    				<td>${goods.goodsName}</td>
	    				<td>${goods.goodsPrice}</td>
	    				<td>${goods.goodsNum}</td>
	    				<td><a href="${pageContext.request.contextPath}/checkGoodsCon?goodsCode=${goods.goodsCode}">�鿴</a></td>
	    				<td><a href="${pageContext.request.contextPath}/shoppingCartCon?goodsCode=${goods.goodsCode}">��ӹ��ﳵ</a></td>
	    			</tr>
	    		</tbody>
	    	</c:forEach>
	    </table>
	  </form>
   </body>
</html>
