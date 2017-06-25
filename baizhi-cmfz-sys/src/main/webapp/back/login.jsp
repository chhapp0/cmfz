
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/css/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/css/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/js/form.validator.rules.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/js/easyui-lang-zh_CN.js"></script>

    <script>
    </script>
</head>
<body style=" background-image: url(/baizhi-cmfz-sys/back/img/29054-106.jpg);">

    <form method="get" id="ff" action="/baizhi-cmfz-sys/admin/login" method="post">
        <div id="w" style="width:400px;padding:150px 70px 20px 70px;margin-left:700px;;margin-right: auto;border:transparent solid 1px;background-color:transparent";>
            <div style="text-align: center;height:88px;">
                <p  style="font-size: 50px; font-family: 'Adobe Caslon Pro Bold'; color:#b83400;">持明法洲</p><br><br>
            </div>
            <div>
                <div style="margin-bottom:10px">
                    <input class="easyui-textbox" name="username" id="logname" style="width:100%;height:30px;padding:12px" data-options="prompt:'用户',required:true,iconCls:'icon-man',iconWidth:38"><br>
                </div>
                <div style="margin-bottom:20px">
                    <input class="easyui-textbox" name="password" id="logpass" type="password" style="width:100%;height:30px;padding:12px;" data-options="prompt:'登录密码',required:true,iconCls:'icon-lock',iconWidth:38">
                </div>
                <div style="margin-bottom:20px">
                    <input type="checkbox" checked="checked" id="logrem">
                    <span>记住密码</span>
                </div>
                <div>
                    <input href="javascript:;"  type="submit"  id="btn" class="easyui-linkbutton" data-options="text:'登录',iconCls:'icon-ok'" style="padding:5px 0px;width:100%;">
                    <%--<input type="submit" value="提交"/>--%>
                    </a>
                </div>
            </div>
        </div>
    </form>
</body>
</html>
