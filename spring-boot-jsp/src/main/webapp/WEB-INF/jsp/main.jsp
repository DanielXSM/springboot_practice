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
<p>Ȩ�޿���ҳ��</p>
<sec:authorize access="hasRole('R_ADMIN')">
    ���ǳ�������Ա���Թ�����Ϣ
</sec:authorize>
</br>

<sec:authorize access="hasRole('R_USER')">
    ������ͨ�û�ֻ�ܲ鿴��Ϣ
</sec:authorize>
</body>
</html>
