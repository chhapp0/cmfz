
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    var $show19;
    var $dg19;
    var $tb19;
    $(function () {
        $dg19=$("#dg19")
        $show19=$("#show19");
        $tb19=$("#tb19");
        $show19.datagrid({
            url:'/baizhi-cmfz-sys/work/queryAll',
            columns:[[
                {title:"编号",field:"id",width:200,align:'center'},
                {title:"功课名字",field:"category",width:200,align:'center'},
                {title:"创建日期",field:"createdate",width:200,align:'center'},
                {title:"所属用户",field:"tel",width:200,align:'center',
                    formatter: function (value, row, index) {
                        return "<span>"+ row.user.phone + "</sapn>" ;
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
            toolbar:'#tb19',
        });
    });
    //删除的操作
    function del(id){
        $.messager.confirm("提示","您确定要删除吗?",function(r){
            if(r){
                //发送异步请求删除数据
                $.post('/baizhi-cmfz-sys/work/delete',{id:id});
                        $show19.datagrid('reload');
            }
        });
    }
    //修改资料
    function editRow(id) {
        $dg19.dialog({
            width:600,
            height:300,
            title:"个人详细信息",
            iconCls:"icon-man",
            href:'/baizhi-cmfz-sys/back/page/work/edit.jsp?id='+id,
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
        $dg19.dialog({
            width:600,
            height:300,
            title:"添加新功课",
            iconCls:"icon-man",
            href:'/baizhi-cmfz-sys/back/page/user/work/add.jsp',
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
       $dg19.dialog('close',true);
    }


    //保存专辑
    function saveAlb(){
        $("#inputform8").form('submit',{
            url:'/baizhi-cmfz-sys/work/add',
            success:function(){
                $dg19.dialog('close',true);
                $show19.datagrid('reload');
            }
        });
    }


    //保存用户
    function updateAlb() {
        $("#updateform8").form('submit', {
            url: '/baizhi-cmfz-sys/work/update',
            success: function () {
                $dg19.dialog('close',true);
                $show19.datagrid('reload');
            }
        });
    }

    //关闭对话框
    function closeDa(){
        $dg19.dialog('close',true);
    }
</script>

<div data-options="region:'center',fit:'true',">
    <table id="show19">
    </table>

    <div id="dg19"></div>
    <div id="tb19">
        <a href="javascript:;"  onclick="insert()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
    </div>

</div>




