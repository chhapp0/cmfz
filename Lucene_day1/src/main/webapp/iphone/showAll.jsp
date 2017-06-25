<%--
  Created by IntelliJ IDEA.
  User: ljf
  Date: 2017/6/23
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <script type="text/javascript" src="/Lucene_day1/js/jquery.min.js"></script>
    <title>查看索引页面</title>

</head>
<body>
     <c:forEach var="iphone" items="${requestScope.iphones}" >
                <form action="/Lucene_day1/lucene/add" method="post">
                    <input type="hidden" name="id" value="${iphone.id}" >
                    手机型号: <input name="name" type="text" value="${iphone.name}" readonly="readonly">

         图片：  <img src="${iphone.href}" style="height: 120px;  right: 120px">
                    <input name="href" type="hidden" value="${iphone.href}" readonly="readonly">
         价格: <input name="price" type="text" value="${iphone.price}" readonly="readonly">

         描述: <input name="info" type="text" value="${iphone.info}" readonly="readonly">

                    <c:if test="${iphone.flag==0}">
           索引:<input name="flag" type="text" value="${iphone.flag}" readonly="readonly">
                    </c:if>
             <c:if test="${iphone.flag==1}">
                 索引:<input name="flag" type="text" value="${iphone.flag}" readonly="readonly">
             </c:if>



                    <c:if test="${iphone.flag==0}">
          操作:           <input type="submit" value="创建索引">
                    </c:if>


                    <c:if test="${iphone.flag==1}">
                        <a href="<c:url value='/lucene/update'/>?href=${iphone.href}">
                           更新索引
                        </a>
                    </c:if>

                        <c:if test="${iphone.flag==1}">
                           <a href="<c:url value='/lucene/delete'/>?href=${iphone.href}">
                                删除索引
                            </a>

                         </c:if>
                </form>
         <br/>
     </c:forEach>
</body>
</html>
