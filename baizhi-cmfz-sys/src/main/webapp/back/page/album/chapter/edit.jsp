<%--
  Created by IntelliJ IDEA.
  User: ljf
  Date: 2017/6/11
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<script>
$(function(){
//构建子页面元素的操作
console.log("${param.id}");
//$("#inputForm").form('load','更新的url?id='+${param.id});
$("#updateform1").form('load', '/baizhi-cmfz-sys/chapter/queryOne?id=${param.id}');
});
</script>

<script>
    $('#cc2').combobox({
        url: '/baizhi-cmfz-sys/album/queryAllAdd',
        valueField: 'id',
        textField: 'title'
    });

</script>

<div style="text-align: center;">
    <form  id="updateform1" method="post" enctype="multipart/form-data" >
        <div style="margin-top: 70px;">
            <input type="hidden" name="id" value="${param.id}" class="easyui-textbox" data-options="required:true"/><br/>
        </div>
        上传章节: <input type="file" name="aaa"/>
        <div style="margin-top: 70px">
            章节标题:<input name="title" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"><br/>
        </div>
        <div style="margin-top: 70px">
            章节大小:<input name="csize" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"><br/>
        </div>
        <div style="margin-top: 70px">
            章节时长:<input name="duration" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"><br/>
        </div>
        <div style="margin-top: 70px">
            所属专辑:
            <input id="cc2" name="album.id">
        </div>
    </form>
</div>
</script>