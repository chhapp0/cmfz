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
$("#updateform5").form('load', '/baizhi-cmfz-sys/essay/queryOne?id=${param.id}');
});
</script>

<div style="text-align: center;">
    <form  id="updateform5" method="post" enctype="multipart/form-data" >
        <div style="margin-top: 70px;">
            <input type="hidden" name="id" value="${param.id}" class="easyui-textbox" data-options="required:true"/><br/>
        </div>
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