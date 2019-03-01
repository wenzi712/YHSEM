<#assign base=request.contextPath />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'north', height:100">
		<#-- 条查 -->
		账户姓名:<input id="list_name" class="easyui-textbox">	
		<a onclick="userSearch()" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
		</div>
		<div data-options="region:'center'">
		<#-- 声明数据表格容器 -->
		<table id="table_dg"></table>
		</div>
	</div>

<script type="text/javascript">


	//用户名称下拉展示
	$('#list_name').combogrid({
		panelWidth:450,
		idField:'accountName',
		textField:'accountName',
		url:'${base}/user/queryDisabledlist',
		//开启分页
		pagination:true,
		//可选每页条数
		pageList:[3,6,9],
		//每页条数
		pageSize:3,
		//列属性
		columns:[[
		{field:'user_XX',checkbox:true},
	        {field:'accountId',title:'账户编号'},    
	        {field:'accountName',title:'账户姓名'}, 
	        {field:'accountPwd',title:'账户密码',hidden:'true'},
	        {field:'accountType',title:'账户类型', width:80, formatter:function(v, r, i) {
	        	if (1 == v) {
	        		return "百度";
	        	}
	        	if (2 == v) {
	        		return "搜狗";
	        	}
			if (3 == v) {
	        		return "神马";
	        	}
	        }},
	        {field:'token',title:'认证',hidden:'true'},
		{field:'accountStatus',title:'账户状态',hidden:'true'},
		{field:'enabledInfoFlow',title:'是否开启信息流服务', width:120, formatter:function(v, r, i) {
	        	if (1 == v) {
	        		return "是";
	        	}
	        	if (2 == v) {
	        		return "否";
	        	}
	        }},  
	    ]],
	});
	

	//初始化数据表格
	$("#table_dg").datagrid({
		//数据接口
		url:"${base}/user/queryDisabledlist",
		//开启分页
		pagination:true,
		//可选每页条数
		pageList:[3,6,9],
		//每页条数
		pageSize:3,
		//分页工具栏位置
		//pagePosition:'bottom',
		//自适应窗口大小
		fit:true,
		//只能选一条
		//singleSelect:true,
		//按ctrl键多选
		ctrlSelect:true,
		//列属性
		columns:[[
		{field:'user_XX',checkbox:true},
	        {field:'accountId',title:'账户编号'},    
	        {field:'accountName',title:'账户姓名'}, 
	        {field:'accountPwd',title:'账户密码',hidden:'true'},
		{field:'token',title:'认证',hidden:'true'},
		{field:'accountStatus',title:'账户状态',hidden:'true'},
		{field:'accountType',title:'账户类型', width:80, formatter:function(v, r, i) {
	        	if (1 == v) {
	        		return "百度";
	        	}
	        	if (2 == v) {
	        		return "搜狗";
	        	}
			if (3 == v) {
	        		return "神马";
	        	}
	        }},
	        {field:'enabledInfoFlow',title:'是否开启信息流服务', width:120, formatter:function(v, r, i) {
	        	if (1 == v) {
	        		return "是";
	        	}
	        	if (2 == v) {
	        		return "否";
	        	}
	        }},
	       
	    ]],
	    //工具栏
	    toolbar: [{
		text:"解禁",
			iconCls: 'icon-remove',
			handler: function(){openDels()}
		
		}]
	});

	//用户搜索
	function userSearch(searchType) {
		var list_name = $("#list_name").textbox("getValue");
		
		
		var paramJson = {
			accountName:list_name,
			
		};
		
		if (null == searchType) {
		searchType = "load";
		}
		//调用搜索方法
		$("#table_dg").datagrid(searchType, paramJson);
	}
	
	


	//批量恢复
	function openDels() {
		//是否选中了数据
		var selected_delete_array = $("#table_dg").datagrid("getSelections");
		var count = selected_delete_array.length;
		if (0 == selected_delete_array.length) {
			$.messager.alert("提示", "请至少选中一条数据！");
		} else {
			$.messager.confirm("确认","您确认想要禁用这"+count+"个用户吗？",function(r){    
			    if (r){    
			        //禁用操作
				var accountStatus=1;
			        var userIds = "";
			        for (var i = 0; i < selected_delete_array.length; i++) {
			        	userIds += "," + selected_delete_array[i].accountId;
			        }
			        if (0 < userIds.length) {
			        	userIds = userIds.substr(1);
			        }
			        $.ajax({
			        	url:"${base}/user/deleteUser",
			        	data:{userIds:userIds,accountStatus:accountStatus},
			        	type:"post",
			        	success:function(data) {
			        		userSearch();
			        	}
			        });
			    }    
			});
		}
	}
	
</script>
</body>
</html>
