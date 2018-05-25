<%--
  Created by IntelliJ IDEA.
  User: Daniel
  Date: 2018/5/25
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=gbk" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>权限控制页面</p>
<sec:authorize access="hasRole('R_ADMIN')">
    您是超级管理员可以管理信息
</sec:authorize>
</br>

<sec:authorize access="hasRole('R_USER')">
    您是普通用户只能查看信息
</sec:authorize>
</body>
</html>
