<%--
  Created by IntelliJ IDEA.
  User: ljf
  Date: 2017/6/11
  Time: 17:09
  To change this template use File | Settings | File Templates.
  action="${pageContext.request.contextPath}/album/add"
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="text-align: center;">
    <form  id="inputform2" method="post" enctype="multipart/form-data" >
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