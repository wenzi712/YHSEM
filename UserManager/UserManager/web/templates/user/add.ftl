<#assign base=request.contextPath />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="add_form" method="post">
		
		<table>
			<tr>
				<td>用户姓名：</td>
				<td>
				<input name="userName" class="easyui-textbox">
				</td>
			</tr>
			
			<tr>
				<td>用户年龄：</td>
				<td>
				<input name="userAge" class="easyui-textbox" >
				</td>
			</tr>
			<tr>
				<td>用户手机号：</td>
				<td>
				<input name="userPhone" class="easyui-textbox">
				</td>
			</tr>
			<tr>
				<td>用户性别：</td>
				<td>
				<input type="radio" name="userSex" value="1">男
				<input type="radio" name="userSex" value="2">女
				</td>
			</tr>
			<tr>
			<td colspan="2" align="center">
				<input type="button" value="保存" id="add_user">
				<input type="button" value="关闭" id="close_user">
			</td>
			</tr>
		</table>
	</form>

<script type="text/javascript">


	
	//提交表单
	$("#add_user").click(function() {
		alert("123");
		
		$.ajax({
			url:"${base}/user/insertUserInfo",
			data:$("#add_form").serialize(),
			type:"post",
			dataType:"json",
			success:function(data) {
				open_tabs("用户列表", "/user/queryUserInfo");
			}
		});
	});
	
	//关闭
	$("#close_user").click(function() {
		window.parent.tabsClose();
	});
	
   
</script>
</body>
</html>
