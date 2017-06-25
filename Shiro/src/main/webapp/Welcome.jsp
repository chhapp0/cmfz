<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<body>

<shiro:guest>
    <h1>您当前还是游客身份,<a href="/Shiro/back/login.jsp">点击登陆更加精彩...</a></h1>
</shiro:guest>
<shiro:user>
    <h1>欢迎:<shiro:principal/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/Shiro/user/logout">注销</a></h1>
</shiro:user>
<hr/>
欢迎进入我的欢迎页面........

</body>
</html>
