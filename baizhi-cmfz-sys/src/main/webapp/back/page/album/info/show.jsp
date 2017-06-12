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
    $(function () {
        $show=$("#show");
        $show.datagrid({
            url:'/easyui_day3/page/admin/show.json',
            columns:[[
                {title:"编号",field:"id",width:200,align:'center'},
                {title:"姓名",field:"name",width:200,align:'center'},
                {title:"年龄",field:"age",width:200,align:'center'},
                {title:"注册日期",field:"date",width:200,align:'center'},
                {title:"性别",field:"sex",width:200,align:'center'},
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
                console.log("删除");
                //$dg.datagrid('reload');
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
            href:'/easyui_day3/page/admin/edit.jsp?id='+id,
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:saveStu,
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
            title:"新加员工",
            iconCls:"icon-man",
            href:'/easyui_day3/page/admin/add.jsp',
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                //handler:saveAdmin(),
            },{
                text:'关闭',
                iconCls:'icon-cancel',
              //  handler:closeAdmin(),
            }],
        });
    }
  /*  //保存功课
    function saveAdmin(){
        $("#inputForm").form('submit',{
            url:'xiaohei',
            success:function(){
                $insert.dialog('close',true);
                //$dg.datagrid('reload');
            }
        });
    }*/
    //关闭对话框
/*    function closeAdmin(){
        $insert.dialog('close',true);
    }*/


    //保存用户
    function saveStu(){
        $("#inputForm").form('submit',{
            url:'xiaohei',
            success:function(){
                $show.dialog('close',true);
                //$dg.datagrid('reload');
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

    <div id="tb">
        <a href="javascript:;"  onclick="insert()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
    </div>

</div>