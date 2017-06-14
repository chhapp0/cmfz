
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    var $show;
    var $dg;
    $(function () {
        $dg=$("#dg")
        $show=$("#show");

        $show.datagrid({
            url:'/baizhi-cmfz-sys/essay/queryAll',
            columns:[[
                {title:"编号",field:"id",width:200,align:'center'},
                {title:"名称",field:"title",width:200,align:'center'},
                {title:"标记",field:"flag",width:200,align:'center'},
                {title:"作者",field:"author",width:200,align:'center'},
                {title:"创建日期",field:"pubdate",width:200,align:'center'},
                {title:"上师",field:"guru",width:200,align:'center'},
                {title:"文章链接",field:"link",width:200,align:'center'},
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
            title:"文章详细信息",
            iconCls:"icon-man",
            href:'/baizhi-cmfz-sys/back/page/essay/info/edit.jsp?id='+id,
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:updateEss,
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
            title:"添加新文章",
            iconCls:"icon-man",
            href:'/baizhi-cmfz-sys/back/page/essay/info/add.jsp',
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:saveEss,
            },{
                text:'关闭',
                iconCls:'icon-cancel',
               handler:closeEss,
            }],
        });
    }
    //关闭对话框
   function closeEss(){
       $dg.dialog('close',true);
    }


    //保存专辑
    function saveEss(){
        $("#inputform").form('submit',{
            url:'/baizhi-cmfz-sys/essay/add',
            success:function(){
                $dg.dialog('close',true);
                $show.datagrid('reload');
            }
        });
    }


    //保存用户
    function updateEss() {
        $("#updateform").form('submit', {
            url: '/baizhi-cmfz-sys/essay/update',
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




