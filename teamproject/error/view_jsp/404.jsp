<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
    <%@ page isErrorPage="true" %>
<% response.setStatus(200); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/404.css">
</head>
<body>
<div class="error">
  <h1>404 </h1>
  <h2>Page not found</h2>
</div>

</body>
</html>