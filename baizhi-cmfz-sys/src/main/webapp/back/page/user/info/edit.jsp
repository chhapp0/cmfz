<%--
  Created by IntelliJ IDEA.
  User: ljf
  Date: 2017/6/11
  Time: 17:09
  To change this template use File | Settings | File Templates.
  action="${pageContext.request.contextPath}/album/add"
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<script>
    $(function(){
//构建子页面元素的操作
        console.log("${param.id}");
        $("#updateform7").form('load', '/baizhi-cmfz-sys/user/queryOne?id=${param.id}');
    });
</script>

<script>
    $('#cc14').combobox({
        url: '/baizhi-cmfz-sys/guru/queryAllAdd',
        valueField: 'id',
        textField: 'name'
    });
</script>
<script type="text/javascript">
    $(function(){
        //获取所有省份信息
        $.ajax({
            type:"GET",
            url:"/baizhi-cmfz-sys/province/queryAllAdd",
            //dataType:"JSON",
            success:function(result){
                $.each(result,function(i,province){
                    var option = $("<option></option>").text(province.pname).val(province.id);
                    $("#cc15").append(option);
                });
                //触发省的改变
                $("#cc15").change();
            }
        });

        //给省份的下拉列表绑定change事件
        $("#cc15").change(function(){
            //每次发送请求之前清空原有的数据
            $("#cc16").empty();
            //获取当前选中的省份的code
            var provinceCode = $(this).val();
            //根据省份信息查询所有市
            $.ajax({
                type:"POST",
                data:"id="+provinceCode,
                url:"/baizhi-cmfz-sys/city/queryAllAdd",
                //dataType:"JSON",
                success:function(result){
                    $.each(result,function(i,city){
                        var option = $("<option></option>").text(city.name).val(city.id);
                        $("#cc16").append(option);
                    });
                }
            });
        });
    });
</script>

<div style="text-align: center;">
    <form  id="updateform7" method="post" enctype="multipart/form-data" >
        <div style="margin-top: 70px;">
            <input type="hidden" name="id" value="${param.id}" class="easyui-textbox" data-options="required:true"/><br/>
        </div>
        上传头像: <input type="file" name="aaa"/>
        <div style="margin-top: 70px">
            昵称:<input name="nickname" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"><br/>
        </div>
        <div style="margin-top: 70px">
            法名:<input name="farmington" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"><br/>
        </div>
        <div style="margin-top: 70px">
            性别:<input name="gender" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"><br/>
        </div>
        <div style="margin-top: 70px">
            签名:<input name="description" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"><br/>
        </div>
        <div style="margin-top: 70px">
            电话:<input name="phone" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"><br/>
        </div>
        <div style="margin-top: 70px">
            密码:<input name="pwd" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"><br/>
        </div>
        <div style="margin-top: 70px">
            选择的上师:
            <input id="cc14" name="guru.id">
        </div>
        <div style="margin-top: 70px">
            省:<select id="cc15" name="province.id"></select>
        </div>
        <div style="margin-top: 70px">
            市:<select id="cc16" name="city.id"></select>
        </div>
    </form>
</div>
</script>