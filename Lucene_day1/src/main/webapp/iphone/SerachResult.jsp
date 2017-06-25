<%--
  Created by IntelliJ IDEA.
  User: ljf
  Date: 2017/6/25
  Time: 9:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>查询结果</title>
</head>
<body

    <table class="table" align="center" border="1">
        <tr>
            <td>手机名字</td>
            <td>相似度</td>
            <td>价格</td>
            <td>简介</td>
            <td>操作</td>
        </tr>
        <br/>

        <c:forEach var="iphone" items="${requestScope.iphones}">
            <tr>
                <td>${iphone.name}</td>
                <td>${iphone.score}</td>
                <td>${iphone.price}</td>
                <td>${iphone.info}</td>
            <td><a href="<c:url value='/iphone/selectOne'/>?id=${iphone.id}">点击查看详情</a></td>
            </tr>
        </c:forEach>
    </table>

   <%-- <c:forEach var="iphone" items="${requestScope.iphones}">
        <input type="hidden" name="id" value="${iphone.id}">
        手机图片:<input type="text" name="href" value="${iphone.href}">
        <img src="${iphone.href}">
        <br/>
        手机型号: <input name="name" type="text" value="${iphone.name}" readonly="readonly">  (相似度):<input name="name" type="text"  style="font-size: x-small" value="${iphone.score}" readonly="readonly">
        <br/>
        价格: <input name="price" type="text" value="${iphone.price}" readonly="readonly">
        <br/>
        描述: <input name="info" type="text" value="${iphone.info}" readonly="readonly">
    <a href="<c:url value='/iphone/selectOne'/>?id=${iphone.id}">点击查看详情</a>
    </c:forEach>--%>
</body>
</html>
