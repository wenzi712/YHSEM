<#assign base=request.contextPath />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="edit_form" method="post">
		<input type="hidden" name="userId" value="${user.userId!}">
		
		<table>
			
			<tr>
				<td>用户姓名：</td>
				<td>
				<input name="userName" value="${user.userName!}" class="easyui-textbox">
				</td>
			</tr>
			<tr>
				<td>用户年龄：</td>
				<td>
				<input  name="userAge" value="${user.userAge!}" class="easyui-textbox">
				</td>
			</tr>
			<tr>
				<td>用户手机号：</td>
				<td>
				<input name="userPhone" value="${user.userPhone!}" class="easyui-textbox">
				</td>
			</tr>
			<tr>
				<td>用户性别：</td>
				<td>
				<input type="radio" name="userSex" value="1"
					<#if user.userSex == 1>checked</#if>
				>男
				<input type="radio" name="userSex" value="2"
					<#if user.userSex == 2>checked</#if>
				>女
				</td>
			</tr>
		</table>
	</form>	
</body>
</html>
