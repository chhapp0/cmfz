
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    var $show;
    var $dg;
    $(function () {
        $dg=$("#dg")
        $show=$("#show");

        $show.datagrid({
            url:'/baizhi-cmfz-sys/chapter/queryAll',
            columns:[[
                {title:"编号",field:"id",width:200,align:'center'},
                {title:"章节标题",field:"title",width:200,align:'center'},
                {title:"下载链接",field:"url",width:200,align:'center'},
                {title:"大小",field:"cdsize",width:200,align:'center'},
                {title:"音频时长",field:"duration",width:200,align:'center'},
                {title:"所属专辑",field:"aid",width:200,align:'center'},
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
                $.post('/baizhi-cmfz-sys/chapter/delete',{id:id});
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
            href:'/baizhi-cmfz-sys/back/page/chapter/info/edit.jsp?id='+id,
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:updateCha,
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
            href:'/baizhi-cmfz-sys/back/page/chapter/info/add.jsp',
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:saveCha,
            },{
                text:'关闭',
                iconCls:'icon-cancel',
               handler:closeCha,
            }],
        });
    }
    //关闭对话框
   function closeCha(){
       $dg.dialog('close',true);
    }


    //保存专辑
    function saveCha(){
        $("#inputform").form('submit',{
            url:'/baizhi-cmfz-sys/chapter/add',
            success:function(){
                $dg.dialog('close',true);
                $show.datagrid('reload');
            }
        });
    }


    //保存用户
    function updateCha() {
        $("#updateform").form('submit', {
            url: '/baizhi-cmfz-sys/chapter/update',
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




