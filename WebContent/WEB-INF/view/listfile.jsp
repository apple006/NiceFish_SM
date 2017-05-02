<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件列表</title>
</head>
<body>
	<p style="color:red;">${message }</p>
	 <!-- 遍历Map集合 -->
	<c:forEach var="me" items="${filenameMap}" varStatus="var">
		<label>${var.index+1 }、
		</label><c:url value="/download.do" var="downurl">
			<c:param name="filename" value="${me.key}"></c:param>
		</c:url>
        ${me.value}<a href="${downurl}">下载</a>
		<br />
	</c:forEach>
</body>
</html>