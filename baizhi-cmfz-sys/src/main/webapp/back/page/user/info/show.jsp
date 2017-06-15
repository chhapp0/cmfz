
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    var $show8;
    var $dg8;
    var $tb8;
    $(function () {
        $dg8=$("#dg8")
        $show8=$("#show8");
        $tb8=$("#tb8");
        $show8.datagrid({
            url:'/baizhi-cmfz-sys/user/queryAll',
            columns:[[
                {title:"编号",field:"id",width:200,align:'center'},
                {title:"昵称",field:"nickname",width:200,align:'center'},
                {title:"法名",field:"farmington",width:200,align:'center'},
                {title:"性别",field:"gender",width:200,align:'center'},
                {title:"签名",field:"description",width:200,align:'center'},
                {title:"电话",field:"phone",width:200,align:'center'},
                {title:"盐",field:"salt",width:200,align:'center'},
                {title:"密码",field:"pwd",width:200,align:'center'},
                {title:"头像",field:"photo",width:200,align:'center'},
                {title:"上师",field:"aid",width:200,align:'center',
                    formatter: function (value, row, index) {
                        return "<span>"+row.guru.name+ "</span>" ;
                    }
                },
                {title:"省份",field:"b",width:200,align:'center',
                    formatter: function (value, row, index) {
                        return "<span>"+row.province.pname+ "</span>" ;
                    }
                },
                {title:"城市",field:"c",width:200,align:'center',
                    formatter: function (value, row, index) {
                        return "<span>"+row.city.name+ "</span>" ;
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
            toolbar:'#tb8',
        });
    });
    //删除的操作
    function del(id){
        $.messager.confirm("提示","您确定要删除吗?",function(r){
            if(r){
                //发送异步请求删除数据
                $.post('/baizhi-cmfz-sys/user/delete',{id:id});
                        $show8.datagrid('reload');
            }
        });
    }
    //修改资料
    function editRow(id) {
        $dg8.dialog({
            width:600,
            height:300,
            title:"个人详细信息",
            iconCls:"icon-man",
            href:'/baizhi-cmfz-sys/back/page/user/info/edit.jsp?id='+id,
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:updateUse,
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeDa,
            }],
        });
    }

    function insert(){
        $dg8.dialog({
            width:600,
            height:300,
            title:"添加新专辑",
            iconCls:"icon-man",
            href:'/baizhi-cmfz-sys/back/page/user/info/add.jsp',
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:saveUse,
            },{
                text:'关闭',
                iconCls:'icon-cancel',
               handler:closeUse,
            }],
        });
    }
    //关闭对话框
   function closeUse(){
       $dg8.dialog('close',true);
    }


    //保存专辑
    function saveUse(){
        $("#inputform7").form('submit',{
            url:'/baizhi-cmfz-sys/user/add',
            success:function(){
                $dg8.dialog('close',true);
                $show8.datagrid('reload');
            }
        });
    }


    //保存用户
    function updateUse() {
        $("#updateform7").form('submit', {
            url: '/baizhi-cmfz-sys/user/update',
            success: function () {
                $dg8.dialog('close',true);
                $show8.datagrid('reload');
            }
        });
    }

    //关闭对话框
    function closeDa(){
        $dg8.dialog('close',true);
    }
</script>

<div data-options="region:'center',fit:'true',">
    <table id="show8">
    </table>

    <div id="dg8"></div>
    <div id="tb8">
        <a href="javascript:;"  onclick="insert()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
    </div>

</div>




