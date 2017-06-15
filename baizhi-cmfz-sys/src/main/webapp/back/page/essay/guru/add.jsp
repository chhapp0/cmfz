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
    <form  id="inputform4" method="post" enctype="multipart/form-data" >
        上师照片: <input type="file" name="aaa"/>
        <div style="margin-top: 70px">
            上师名字:<input name="name" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"><br/>
        </div>
    </form>
</div>
</script>