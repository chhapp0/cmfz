<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<body>


<h1>欢迎:<shiro:principal/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/Shiro/user/logout">注销</a></h1>
<hr/>

</body>
</html>
