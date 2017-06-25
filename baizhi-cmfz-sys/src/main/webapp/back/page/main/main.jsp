
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/baizhi-cmfz-sys/back/easyui/css/themes/metro-orange/easyui.css">
    <link rel="stylesheet" type="text/css" href="/baizhi-cmfz-sys/back/easyui/css/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/baizhi-cmfz-sys/back/easyui/css/IconExtension.css">
    <script type="text/javascript" src="/baizhi-cmfz-sys/back/easyui/js/jquery.min.js"></script>
    <script type="text/javascript" src="/baizhi-cmfz-sys/back/easyui/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/baizhi-cmfz-sys/back/easyui/js/form.validator.rules.js"></script>
    <script type="text/javascript" src="/baizhi-cmfz-sys/back/easyui/js/easyui-lang-zh_CN.js"></script>
    <script>

        var $aa,$tt;
        $(function(){
            $aa = $("#menus");
            $tt = $("#tt");


            //初始化系统菜单
            $.post("/baizhi-cmfz-sys/menu/queryOne",function(menu){

                window.alert("欢迎您登陆!");
                $.each(menu,function(i,aa){
                    var content = "<div style='text-align: center;'>";
                    $.each(aa.menu,function(j,child){
                        content +="<div onclick=\"addTabs('"+child.name+"','"+child.iconCls+"','"+child.href+"')\" class='easyui-linkbutton' data-options=\"plain:true,iconCls:'"+child.iconCls+"'\" style='border:1px solid green; width:90%;margin: 5 0 5 0 ;'>"+child.name+"</div>";
                    })
                    content +="</div>";
                    $aa.accordion('add',{
                        title:aa.name,
                        iconCls:aa.iconCls,
                        content:content,
                    });
                });
            },"JSON");
        })



        //添加选项卡
        function  addTabs(title,iconCls,href){
            if(!$tt.tabs('exists',title)){
                $tt.tabs('add',{
                    title:title,
                    iconCls:iconCls,
                    href:"${pageContext.request.contextPath}/"+href,
                    closable:true,
                });
            }else{
                $tt.tabs('select',title)
            }
        }
    </script>
</head>
<body class="easyui-layout">
        <div data-options="region:'north',split:false" style="height:100px;">
            <h1 style="align-content: center">欢迎:<shiro:principal/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="/baizhi-cmfz-sys/user/logout">注销</a></h1>
            <hr/>
        </div>
        <div data-options="region:'south',split:false" style="height:40px;"></div>
        <div data-options="region:'west',title:'系统菜单',split:false" style="width:200px;">
            <div id="menus" class="easyui-accordion" data-options="fit:true">
            </div>
        </div>
        <div data-options="region:'center',title:'主页',iconCls:'icon-house'">
            <div id="tt" class="easyui-tabs"></div>
        </div>
</body>
</html>
