<%--
  Created by IntelliJ IDEA.
  User: ljf
  Date: 2017/6/11
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    var $counterAll;
    $(function () {
        $counterAll=$("#counterAll");
        $counterAll.datagrid({
            url:'/easyui_day3/page/lesson/lessonAll.json',
            columns:[[
                {
                    title:"名称",field:"countName",width:200,align:'center',
                    formatter:function (value,row,index) {
                        return row.count.name;
                    }
                },
                {
                    title:"次数",field:"countTimes",width:200,align:'center',
                    formatter:function (value,row,index) {
                        return row.count.times;
                    }
                },
                {
                    title: "操作", field: "options", width: 300, align: 'center',
                    formatter: function (value, row, index) {
                        return "<a class='del' onClick=\"del('" + row.id + "')\" href='javascript:;'>删除</a>&nbsp;&nbsp;" +
                                "<a class='edit' onClick=\"editRow('" + row.id + "')\"  href='javascript:;'>修改</a>";
                    }
                }
            ]],
            onLoadSuccess:function (data) {
                $(".del").linkbutton({
                    plain:true,
                    iconCls:'icon-remove',
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
               // $dg.datagrid('reload');
            }
        });
    }
    //修改的操作
    function editRow(id){
        $counterAll.dialog({
            width:600,
            height:300,
            title:"修改计数器",
            iconCls:"icon-man",
            href:'/easyui_day3/page/counter/edit.jsp?id='+id,
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
</script>



<div data-options="region:'center',fit:'true'">
    <table id="counterAll">
    </table>

</div>