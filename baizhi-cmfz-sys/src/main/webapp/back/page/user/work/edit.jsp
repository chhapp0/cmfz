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
$("#updateform8").form('load', '/baizhi-cmfz-sys/work/queryOne?id=${param.id}');
});
</script>

<script>
    $('#cc12').combobox({
        url: '/baizhi-cmfz-sys/user/queryAllAdd',
        valueField: 'id',
        textField: 'name'
    });
</script>

<div style="text-align: center;">
    <form  id="updateform8" method="post">
        <div style="margin-top: 70px;">
            <input type="hidden" name="id" value="${param.id}" class="easyui-textbox" data-options="required:true"/><br/>
        </div>
        <div style="margin-top: 70px">
            功课名称:<input name="category" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"><br/>
        </div>
        <div style="margin-top: 70px">
            所属用户:
            <input id="cc12" name="user.id">
        </div>
    </form>
</div>
</script>