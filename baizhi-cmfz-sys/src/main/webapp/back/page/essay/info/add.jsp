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
    $('#cc3').combobox({
        url: '/baizhi-cmfz-sys/guru/queryAllAdd',
        valueField: 'id',
        textField: 'name'
    });
</script>
<div style="text-align: center;">
    <form  id="inputform5" method="post" enctype="multipart/form-data" >
        上传文章图片: <input type="file" name="aaa"/>
        <div style="margin-top: 70px">
            标题:<input name="title" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"><br/>
        </div>
        <div style="margin-top: 70px">
            标记:<input name="flag" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"><br/>
        </div>

        <div style="margin-top: 70px">
            所属上师:
            <input id="cc3" name="guru.id">
        </div>
    </form>
</div>
</script>