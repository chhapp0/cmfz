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
$("#updateform").form('load', '/baizhi-cmfz-sys/banner/queryOne?id=${param.id}');
});
</script>

<div style="text-align: center;">
    <form  id="updateform" method="post" enctype="multipart/form-data" >
            上传轮播图: <input type="file" name="aaa"/>
            <div style="margin-top: 70px">
                名称:<input name="descr" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"><br/>
            </div>
            <div style="margin-top: 70px">
                状态:<input name="btype" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"><br/>
            </div>
    </form>
</div>
</script>