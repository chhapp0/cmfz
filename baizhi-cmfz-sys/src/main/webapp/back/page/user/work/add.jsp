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
    $('#cc11').combobox({
        url: '/baizhi-cmfz-sys/user/queryAllAdd',
        valueField: 'id',
        textField: 'phone'
    });
</script>

<div style="text-align: center;">
    <form  id="inputform8" method="post" >
        <div style="margin-top: 70px">
            功课名称:<input name="category" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"><br/>
        </div>
        <div style="margin-top: 70px">
            所属用户:
            <input id="cc11" name="user.id">
        </div>
    </form>
</div>
</script>