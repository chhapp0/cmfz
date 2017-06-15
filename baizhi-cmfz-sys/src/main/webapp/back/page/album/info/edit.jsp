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
$("#updateform2").form('load', '/baizhi-cmfz-sys/album/queryOne?id=${param.id}');
});
</script>

<div style="text-align: center;">
    <form  id="updateform2" method="post" enctype="multipart/form-data" >
        <div style="margin-top: 70px;">
            <input type="hidden" name="id" value="${param.id}" class="easyui-textbox" data-options="required:true"/><br/>
        </div>
        上传专辑封面: <input type="file" name="aaa"/>
        <div style="margin-top: 70px">
            名称:<input name="title" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"><br/>
        </div>
        <div style="margin-top: 70px">
            评分:<input name="score" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"><br/>
        </div>
        <div style="margin-top: 70px">
            作者:<input name="author" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"><br/>
        </div>
        <div style="margin-top: 70px">
            播音员:<input name="broadcast" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"><br/>
        </div>
        <div style="margin-top: 70px">
            内容介绍:<input name="brief" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"><br/>
        </div>
    </form>
</div>
</script>