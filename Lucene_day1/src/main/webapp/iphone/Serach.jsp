<%--
  Created by IntelliJ IDEA.
  User: ljf
  Date: 2017/6/24
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>全文检索</title>
</head>
<body>
    <form action="/Lucene_day1/lucene/selectOne" method="post">
        <input type="text" name="name">
        <input type="submit" value="搜索">
    </form>
</body>
</html>
