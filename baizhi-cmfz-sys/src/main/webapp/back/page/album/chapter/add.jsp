<%--
  Created by IntelliJ IDEA.
  User: ljf
  Date: 2017/6/11
  Time: 17:09
  To change this template use File | Settings | File Templates.
  action="${pageContext.request.contextPath}/album/add"
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    $('#cc1').combobox({
        url: '/baizhi-cmfz-sys/album/queryAllAdd',
        valueField: 'id',
        textField: 'title'
    });
</script>
<div style="text-align: center;">
    <form id="inputform1" method="post" enctype="multipart/form-data">
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
            所属专辑:<%--<input id="cc1" class="easyui-combobox" name="album"
                        data-options="valueField:'id',textField:'title',url:'/baizhi-cmfz-sys/album/queryAll'" />--%>
            <input id="cc1" name="album.id">
        </div>
    </form>
</div>
</script>