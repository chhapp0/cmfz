
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    var $show;
    var $dg;
    var $tb;
    $(function () {
        $dg=$("#dg")
        $show=$("#show");
        $tb=$("#tb");
        $show.datagrid({
            url:'/baizhi-cmfz-sys/guru/queryAll',
            columns:[[
                {title:"编号",field:"id",width:200,align:'center'},
                {title:"上师姓名",field:"name",width:200,align:'center'},
                {title:"上师头像",field:"head",width:200,align:'center'},
                //{title:"内容介绍",field:"brief",width:200,align:'center'},
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
            toolbar:'#tb',
        });
    });
    //删除的操作
    function del(id){
        $.messager.confirm("提示","您确定要删除吗?",function(r){
            if(r){
                //发送异步请求删除数据
                $.post('/baizhi-cmfz-sys/essay/delete',{id:id});
                        $show.datagrid('reload');
            }
        });
    }
    //修改资料
    function editRow(id) {
        $dg.dialog({
            width:600,
            height:300,
            title:"个人详细信息",
            iconCls:"icon-man",
            href:'/baizhi-cmfz-sys/back/page/essay/guru/edit.jsp?id='+id,
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:updateGur,
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeDa,
            }],
        });
    }

    function insert(){
        $dg.dialog({
            width:600,
            height:300,
            title:"添加新专辑",
            iconCls:"icon-man",
            href:'/baizhi-cmfz-sys/back/page/essay/guru/add.jsp',
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:saveGur,
            },{
                text:'关闭',
                iconCls:'icon-cancel',
               handler:closeGur,
            }],
        });
    }
    //关闭对话框
   function closeGur(){
       $dg.dialog('close',true);
    }


    //保存专辑
    function saveGur(){
        $("#inputform").form('submit',{
            url:'/baizhi-cmfz-sys/guru/add',
            success:function(){
                $dg.dialog('close',true);
                $show.datagrid('reload');
            }
        });
    }


    //保存用户
    function updateGur() {
        $("#updateform").form('submit', {
            url: '/baizhi-cmfz-sys/guru/update',
            success: function () {
                $dg.dialog('close',true);
                $show.datagrid('reload');
            }
        });
    }

    //关闭对话框
    function closeDa(){
        $dg.dialog('close',true);
    }
</script>

<div data-options="region:'center',fit:'true',">
    <table id="show">
    </table>

    <div id="dg"></div>
    <div id="tb">
        <a href="javascript:;"  onclick="insert()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
    </div>

</div>




