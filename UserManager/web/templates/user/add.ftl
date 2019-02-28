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

				<td>账户姓名：</td>
				<td>
				<input name="accountName" class="easyui-textbox">
				</td>
			</tr>
			
			<tr>
				<td>账户密码：</td>
				<td>
				<input name="accountPwd" class="easyui-textbox" >
				</td>
			</tr>

			<tr>
				<td>账户类型：</td>
				<td>
				<input id="add_type" name="accountType">
				</td>
			</tr>
			<tr>
				<td>是否开启信息流服务：</td>
				<td>
				<input type="radio" name="enabledInfoFlow" value="1">是
				<input type="radio" name="enabledInfoFlow" value="2">否
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

	//初始化部门下拉框（条查）
		$('#add_type').combobox({
		    url:'${base}/user/queryAccountType',    
		    valueField:'accountType',    
		    textField:'accountType'   
		}); 
		


	
	//提交表单
	$("#add_user").click(function() {

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
