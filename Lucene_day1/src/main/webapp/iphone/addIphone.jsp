<%--
  Created by IntelliJ IDEA.
  User: ljf
  Date: 2017/6/23
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>添加手机</title>
</head>
<body>
        <form action="/Lucene_day1/iphone/add" enctype="multipart/form-data" method="post">
         上传手机图片：   <input type="file" name="aaa"/>
            <br/>
            手机型号: <input name="name" type="text">
            <br/>
            手机价格: <input name="price" type="text">
            <br/>
            手机描述: <input name="info" type="text">
            <br/>
            <input type="submit" value="提交">
        </form>
</body>
</html>
