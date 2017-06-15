
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    var $show1;
    var $dg1;
    $(function () {
        $dg1=$("#dg1")
        $show1=$("#show1");

        $show1.datagrid({
            url:'/baizhi-cmfz-sys/admin/queryOne?id='+id,
            columns:[[
                {title:"编号",field:"id",width:200,align:'center'},
                {title:"姓名",field:"username",width:200,align:'center'},
                {title:"密码",field:"title",width:200,align:'center'},
                {title:"盐",field:"score",width:200,align:'center'},
             /*   {
                    title: "操作", field: "options", width: 300, align: 'center',
                    formatter: function (value, row, index) {
                        return "<a class='del' onClick=\"del('" + row.id + "')\" href='javascript:;'>删除</a>&nbsp;&nbsp;" +
                                "<a class='edit' onClick=\"editRow('" + row.id + "')\"  href='javascript:;'>修改</a>";
                    }
                }*/
            ]],

       /*     onLoadSuccess: function (data) {
                $(".del").linkbutton({
                    plain: true,
                    iconCls: 'icon-remove',

                });
                $(".edit").linkbutton({
                    plain: true,
                    iconCls: 'icon-edit',
                });
            },*/
        });
    });
   /* //删除的操作
    function del(id){
        $.messager.confirm("提示","您确定要删除吗?",function(r){
            if(r){
                //发送异步请求删除数据
                $.post('/baizhi-cmfz-sys/admin/delete',{id:id});
                        $show1.datagrid('reload');
            }
        });
    }
    //修改资料
    function editRow(id) {
        $dg1.dialog({
            width:600,
            height:300,
            title:"个人详细信息",
            iconCls:"icon-man",
            href:'/baizhi-cmfz-sys/back/page/admin/info/edit.jsp?id='+id,
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
        $dg1.dialog({
            width:600,
            height:300,
            title:"添加新专辑",
            iconCls:"icon-man",
            href:'/baizhi-cmfz-sys/back/page/admin/info/add.jsp',
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
       $dg1.dialog('close',true);
    }


    //保存专辑
    function saveAlb(){
        $("#inputform").form('submit',{
            url:'/baizhi-cmfz-sys/admin/add',
            success:function(){
                $dg1.dialog('close',true);
                $show1.datagrid('reload');
            }
        });
    }


    //保存用户
    function updateAlb() {
        $("#updateform").form('submit', {
            url: '/baizhi-cmfz-sys/admin/update',
            success: function () {
                $dg1.dialog('close',true);
                $show1.datagrid('reload');
            }
        });
    }

    //关闭对话框
    function closeDa(){
        $dg1.dialog('close',true);
    }*/
</script>

<div data-options="region:'center',fit:'true',">
    <table id="show1">
    </table>

    <div id="dg1"></div>
    <div id="tb1">
    <%--    <a href="javascript:;"  onclick="insert()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>--%>
    </div>

</div>




