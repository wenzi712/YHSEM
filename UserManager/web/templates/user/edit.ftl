<#assign base=request.contextPath />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="edit_form" method="post">
		<input type="hidden" id="accid" name="accountId" value="${user.accountId!}">
		<table>
			<tr>
				<td>新密码：</td>
				<td>
				<input id="pwd" name="accountPwd" type="password" class="easyui-validatebox textbox" data-options="required:true" />
				</td>
			</tr><br/>
			<tr>
				<td>确认密码：</td>
				<td>
				<input id="rpwd" name="rpassword" type="password" class="easyui-validatebox textbox" required="required" validType="equals['#pwd']" />  
				</td>
			</tr>
			
		</table>
	</form>
	
	<script type="text/javascript">
	
		$.extend($.fn.validatebox.defaults.rules, {    
		    equals: {    
		        validator: function(value,param){    
		            return value == $(param[0]).val();    
		        },    
		        message: '密码不一致'   
		    }    
		}); 
	  
	</script>
</body>
</html>
<table>