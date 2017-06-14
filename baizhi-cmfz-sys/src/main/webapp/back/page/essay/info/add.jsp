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
    <form  id="inputform" method="post" enctype="multipart/form-data" >
        上传文章图片: <input type="file" name="aaa"/>
        <div style="margin-top: 70px">
            标题:<input name="title" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"><br/>
        </div>
        <div style="margin-top: 70px">
            标记:<input name="flag" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"><br/>
        </div>
        <div style="margin-top: 70px">
            出版日期:<input name="pubDate" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"><br/>
        </div>
        <div style="margin-top: 70px">
            上师:<input name="guru" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"><br/>
        </div>
        <div style="margin-top: 70px">
            链接:<input name="link" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"><br/>
        </div>
    </form>
</div>
</script>