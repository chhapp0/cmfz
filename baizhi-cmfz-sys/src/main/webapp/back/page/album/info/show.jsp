
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    var $show3;
    var $dg3;
    var $tb3;
    $(function () {
        $dg3=$("#dg3")
        $show3=$("#show3");
        $tb3=$("#tb3");
        $show3.datagrid({
            url:'/baizhi-cmfz-sys/album/queryAll',
            columns:[[
                {title:"编号",field:"id",width:200,align:'center'},
                {title:"专辑图片",field:"thumbnail",width:200,align:'center'},
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
            pagination:true,
            pageNumber:1,
            pageSize:4,
            pageList:[2,4,6],
            toolbar:'#tb3',
        });
    });
    //删除的操作
    function del(id){
        $.messager.confirm("提示","您确定要删除吗?",function(r){
            if(r){
                //发送异步请求删除数据
                $.post('/baizhi-cmfz-sys/album/delete',{id:id});
                        $show3.datagrid('reload');
            }
        });
    }
    //修改资料
    function editRow(id) {
        $dg3.dialog({
            width:600,
            height:300,
            title:"个人详细信息",
            iconCls:"icon-man",
            href:'/baizhi-cmfz-sys/back/page/album/info/edit.jsp?id='+id,
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:updateAlb,
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeDa,
            }],
        });
    }

    function insert(){
        $dg3.dialog({
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
       $dg3.dialog('close',true);
    }


    //保存专辑
    function saveAlb(){
        $("#inputform2").form('submit',{
            url:'/baizhi-cmfz-sys/album/add',
            success:function(){
                $dg3.dialog('close',true);
                $show3.datagrid('reload');
            }
        });
    }


    //保存用户
    function updateAlb() {
        $("#updateform2").form('submit', {
            url: '/baizhi-cmfz-sys/album/update',
            success: function () {
                $dg3.dialog('close',true);
                $show3.datagrid('reload');
            }
        });
    }

    //关闭对话框
    function closeDa(){
        $dg3.dialog('close',true);
    }
</script>

<div data-options="region:'center',fit:'true',">
    <table id="show3">
    </table>

    <div id="dg3"></div>
    <div id="tb3">
        <a href="javascript:;"  onclick="insert()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
    </div>

</div>




