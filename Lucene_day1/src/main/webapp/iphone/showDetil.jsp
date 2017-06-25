<%--
  Created by IntelliJ IDEA.
  User: ljf
  Date: 2017/6/25
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>手机具体信息</title>
</head>
<body>
手机图片：  <input type="text" name="href" value="${requestScope.iphone.href}" readonly="readonly"/>
<br/>
手机型号: <input name="name" type="text" value="${requestScope.iphone.name}" readonly="readonly">
<br/>
价格: <input name="price" type="text" value="${requestScope.iphone.price}" readonly="readonly">
<br/>
描述: <input name="info" type="text" value="${requestScope.iphone.info}" readonly="readonly">
<br/>
上架日期: <input name="info" type="text" value="${requestScope.iphone.date}" readonly="readonly">
</body>
</html>
