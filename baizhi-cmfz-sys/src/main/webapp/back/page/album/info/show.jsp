<%--
  Created by IntelliJ IDEA.
  User: ljf
  Date: 2017/6/11
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    var $show;
    var $insert;
    var $dg;
    $(function () {
        $dg=$("#dg");
        $show=$("#show");
        $show.datagrid({
            url:'/baizhi-cmfz-sys/album/queryAll',
            columns:[[
                {title:"编号",field:"id",width:200,align:'center'},
                {title:"头像",field:"thumbnail",width:200,align:'center'},
                {title:"名称",field:"title",width:200,align:'center'},
                {title:"评分",field:"score",width:200,align:'center'},
                {title:"作者",field:"author",width:200,align:'center'},
                {title:"播音员",field:"broadcast",width:200,align:'center'},
                {title:"创建日期",field:"createdate",width:200,align:'center'},
                {title:"内容介绍",field:"brief",width:200,align:'center'},
                {
                    title: "操作", field: "options", width: 300, align: 'center',
                    formatter: function (value, row, index) {
                        return "<a class='del' onClick=\"del('" + row.id + "')\" href='javascript:;'>删除</a>&nbsp;&nbsp;" +
                                "<a class='edit' onClick=\"editRow('" + row.id + "')\"  href='javascript:;'>修改</a>";
                    }
                }
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
    //删除的操作
    function del(id){
        $.messager.confirm("提示","您确定要删除吗?",function(r){
            if(r){
                //发送异步请求删除数据
                href:'/baizhi-cmfz-sys/album/delete?id='+id,
                $dg.datagrid('reload');
            }
        });
    }
    //修改资料
    function editRow(id) {
        $show.dialog({
            width:600,
            height:300,
            title:"个人详细信息",
            iconCls:"icon-man",
            href:'/baizhi-cmfz-sys/album/update?id='+id,
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:saveAlb,
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeDa,
            }],
        });
    }
    function insert(){
        $insert=$("#tb");
        $insert.dialog({
            width:600,
            height:300,
            title:"添加新专辑",
            iconCls:"icon-man",
            href:'/baizhi-cmfz-sys/back/page/album/info/add.jsp',
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:saveAlb,
            },{
                text:'关闭',
                iconCls:'icon-cancel',
               handler:closeAlb,
            }],
        });
    }
    //关闭对话框
   function closeAlb(){
        $insert.dialog('close',true);
    }


    //保存专辑
    function saveAlb(){
        $("#inputForm").form('submit',{
            url:'/baizhi-cmfz-sys/album/add',
            success:function(){
                $show.dialog('close',true);
                $dg.datagrid('reload');
            }
        });
    }
    //关闭对话框
    function closeDa(){
        $show.dialog('close',true);
    }
</script>

<div data-options="region:'center',fit:'true',">
    <table id="show">
    </table>

    <table id="dg"></table>
    <div id="tb">
        <a href="javascript:;"  onclick="insert()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
    </div>

</div>