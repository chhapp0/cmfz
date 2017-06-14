<%--
  Created by IntelliJ IDEA.
  User: ljf
  Date: 2017/6/11
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <script>
    var $All;
    var $insert;
    $(function () {
        $All=$("#pictureAll");
        $All.datagrid({
            url:'/baizhi-cmfz-sys/banner/queryAll',
          //  width:'500px',
            //height:'500px',
            columns:[[
                {title:"编号",field:"id",width:200,align:'center'},
                {title:"轮播图名称",field:"desc",width:200,align:'center'},
                {title:"图片路径",field:"thumbnail",width:200,align:'center'},
                {title:"状态",field:"type",width:200,align:'center'},
                {title:"操作",field:"options",width:300,align:'center',formatter:function (value,row,index) {
                    return "<a class='del' onClick=\"del('"+row.id+" ')\" href='javascript:;'>删除</a>&nbsp;&nbsp;"+                                "<a class='edit' onClick=\"editRow('" + row.id + "')\"  href='javascript:;'>修改</a>";
                }}
            ]],
            onLoadSuccess: function (data) {
                $(".del").linkbutton({
                    plain: true,
                    iconCls: 'icon-remove',

                });
                $(".edit").linkbutton({
                    plain: true,
                    iconCls: 'icon-edit',
                });
            },
        });
    });
    //新加轮播图
    function insert(){
        $insert= $("#tb");
        $insert.dialog({
            width:600,
            height:300,
            title:"新加图片",
            iconCls:"icon-man",
            href:'/baizhi-cmfz-sys/back/page/banner/add.jsp',
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:saveLesson,
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeLesson,
            }],
        });
    }

    //修改的操作
    function editRow(id){
        $All.dialog({
            width:600,
            height:300,
            title:"修改图片资料",
            iconCls:"icon-man",
            href:'/baizhi-cmfz-sys/back/page/banner/edit.jsp?id='+id,
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                //handler:saveStu,
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                //handler:closeDa,
            }],
        });
    }



    //删除的操作
    function del(id){
        $.messager.confirm("提示","您确定要删除吗?",function(r){
            if(r){
                //发送异步请求删除数据
                //$dg.datagrid('reload');
            }
        });
    }
</script>
<body class="easyui-layout">
<div data-options="region:'center',fit:'true',">
    <table id="pictureAll">
    </table>
    <div id="tb">
        <a href="javascript:;" onclick="insert()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
    </div>

</div>
