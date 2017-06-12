<%--
  Created by IntelliJ IDEA.
  User: ljf
  Date: 2017/6/11
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    var $showAll;
    var $insert;

    $(function () {
         //$tb=$("#tb");
        $showAll=$("#showAll");
        $showAll.datagrid({
            url:'/easyui_day3/page/lesson/lessonAll.json',
            columns:[[
                {title:"编号",field:"id",width:200,align:'center'},
                {title:"名字",field:"name",width:200,align:'center'},
                {title:"操作",field:"options",width:300,align:'center',formatter:function (value,row,index) {
                    return "<a class='del' onClick=\"del('"+row.id+" ')\" href='javascript:;'>删除</a>&nbsp;&nbsp;"+                                "<a class='edit' onClick=\"editRow('" + row.id + "')\"  href='javascript:;'>修改</a>";
                }},
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
                }
            ]]
        })
    })

    //新加功课
    function insert(){
        $insert=$("#tb");
        $insert.dialog({
            width:600,
            height:300,
            title:"新加员工",
            iconCls:"icon-man",
            href:'/easyui_day3/page/lesson/add.jsp',
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
               // handler:saveLesson,
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                //handler:closeLesson,
            }],
        });
    }

    //修改的操作
    function editRow(id){
        $showAll.dialog({
            width:600,
            height:300,
            title:"修改计数器",
            iconCls:"icon-man",
            href:'/easyui_day3/page/lesson/edit.jsp?id='+id,
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


    //保存功课
    function saveLesson(){
        $("#inputForm").form('submit',{
            url:'xiaohei',
            success:function(){
                $insert.dialog('close',true);
                //$dg.datagrid('reload');
            }
        });
    }
    //关闭对话框
    function closeLesson(){
        $insert.dialog('close',true);
    }

</script>


<div data-options="region:'center',fit:'true',">
    <table id="showAll">
    </table>

    <div id="tb">
        <a href="javascript:;"  onclick="insert()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
    </div>

</div>