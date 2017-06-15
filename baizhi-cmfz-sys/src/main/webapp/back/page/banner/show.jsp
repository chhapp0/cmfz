
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    var $show4;
    var $dg4;
    var $tb4;
    $(function () {
        $dg4=$("#dg4")
        $show4=$("#show4");
        $tb4=$("#tb4");
        $show4.datagrid({
            url:'/baizhi-cmfz-sys/banner/queryAll',
            columns:[[
                {title:"编号",field:"id",width:200,align:'center'},
                {title:"轮播图名字",field:"descr",width:200,align:'center'},
                {title:"地址",field:"thumbnail",width:200,align:'center'},
                {title:"状态",field:"btype",width:200,align:'center'},
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
            toolbar:'#tb4',
        });
    });
    //删除的操作
    function del(id){
        $.messager.confirm("提示","您确定要删除吗?",function(r){
            if(r){
                //发送异步请求删除数据
                $.post('/baizhi-cmfz-sys/banner/delete',{id:id});
                        $show4.datagrid('reload');
            }
        });
    }
    //修改资料
    function editRow(id) {
        $dg4.dialog({
            width:600,
            height:300,
            title:"轮播图详细信息",
            iconCls:"icon-man",
            href:'/baizhi-cmfz-sys/back/page/banner/edit.jsp?id='+id,
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:updateBna,
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeDa,
            }],
        });
    }

    function insert(){
        $dg4.dialog({
            width:600,
            height:300,
            title:"添加轮播图",
            iconCls:"icon-man",
            href:'/baizhi-cmfz-sys/back/page/banner/add.jsp',
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:saveBna,
            },{
                text:'关闭',
                iconCls:'icon-cancel',
               handler:closeBna,
            }],
        });
    }
    //关闭对话框
   function closeBna(){
       $dg4.dialog('close',true);
    }


    //保存轮播图
    function saveBna(){
        $("#inputform3").form('submit',{
            url:'/baizhi-cmfz-sys/banner/add',
            success:function(){
                $dg4.dialog('close',true);
                $show4.datagrid('reload');
            }
        });
    }


    //保存用户
    function updateBna() {
        $("#updateform3").form('submit', {
            url: '/baizhi-cmfz-sys/banner/update',
            success: function () {
                $dg4.dialog('close',true);
                $show4.datagrid('reload');
            }
        });
    }

    //关闭对话框
    function closeDa(){
        $dg4.dialog('close',true);
    }
</script>

<div data-options="region:'center',fit:'true',">
    <table id="show4">
    </table>

    <div id="dg4"></div>
    <div id="tb4">
        <a href="javascript:;"  onclick="insert()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
    </div>

</div>




