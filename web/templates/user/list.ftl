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
		账户姓名:<input id="list_name1" class="easyui-textbox">	
		<a onclick="userSearch()" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
		</div>
		<div data-options="region:'center'">

		<#-- 声明按钮容器   上架 -->
			<span id="list_CZ_up" style="display:none">
				<a id="up" href="#" class="easyui-linkbutton" data-options="iconCls:''">开启</a>
			</span>
			<#-- 声明按钮容器  下架 -->
			<span id="list_CZ_down" style="display:none">
				<a id="down" href="#" class="easyui-linkbutton" data-options="iconCls:''">关闭</a>
			
			</span>

		<#-- 声明数据表格容器 -->
		<table id="table_dge"></table>
		
		</div>

	</div>

<script type="text/javascript">


	//用户名称下拉展示
	$('#list_name1').combogrid({
		panelWidth:450,
		idField:'accountName',
		textField:'accountName',
		url:'${base}/user/queryUserInfo',
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
	        {field:'accountPwd',title:'账户密码'},
	        {field:'accountType',title:'账户类型'},
	        {field:'token',title:'认证'},
		{field:'account_status',title:'账户状态',hidden:'true'},

		{field:'enabledInfoFlow',title:'是否开启信息流服务'},  
	    ]],
	});
	

	//初始化数据表格
	$("#table_dge").datagrid({
		//数据接口
		url:"${base}/user/queryUserInfo",
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
	        {field:'accountPwd',title:'账户密码'},
		{field:'token',title:'认证'},
		{field:'account_status',title:'账户状态',hidden:'true'},
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
	        		return "开启";
	        	}
	        	if (2 == v) {
	        		return "关闭";
	        	}
	        }},
	       {field:'account_CZ',title:'操作',formatter:function(v, r, i) {
	        	if(r.enabledInfoFlow == 1){
	        		$("#down").attr("onclick", "upDown("+r.accountId+","+r.enabledInfoFlow+")");
	        		return $("#list_CZ_down").html();	
				}else if(r.enabledInfoFlow == 2){
				$("#up").attr("onclick", "upDown("+r.accountId+","+r.enabledInfoFlow+")");
				return $("#list_CZ_up").html();
					
				}
	        }},
	    ]],
	    //工具栏
	    toolbar: [{
		text:"添加",
			iconCls: 'icon-add',
			handler: function(){openAdd()}
		},'-',{
			text:"修改",
			iconCls: 'icon-edit',
			handler: function(){openEdit()}
		
		},'-',{
			text:"禁用",
			iconCls: 'icon-remove',
			handler: function(){openDel()}
		
		}]
	});

	//用户搜索
	function userSearch(searchType) {
		var list_name1 = $("#list_name1").textbox("getValue");
		
		
		var paramJson = {
			accountName:list_name1,
			
		};
		
		if (null == searchType) {
		searchType = "load";
		}
		//调用搜索方法
		$("#table_dge").datagrid(searchType, paramJson);
	}
	
	//打开添加用户对话框
	function openAdd() {
		var add_dialog = $("<div></div>").dialog({
			title:"添加用户",
			width:800,
			height:560,
			modal:true,
			href:"${base}/user/toUserAdd",
			onClose:function() {
				add_dialog.dialog("destroy");
			},
			buttons:[{
				text:'保存',
				handler:function(){
					//把数据进行同步
					data_sync();
					//ajax提交表单
					$('#add_form').form('submit', {
						url:"${base}/user/insertUserInfo",
						novalidate:true,
					    success: function(data){ 
					    	//回掉函数中关闭对话框   
					        add_dialog.dialog("destroy");
					        //刷新datagrid列表
					        userSearch();
					    }    
					});
				}
			},{
				text:'关闭',
				handler:function(){
					add_dialog.dialog("destroy");
				}
			}]
		});
	}
	
	//打开编辑用户对话框
	function openEdit() {
		//是否选中了数据
		var selected_edit_array = $("#table_dge").datagrid("getSelections");
		if (1 == selected_edit_array.length) {
			var accountId = selected_edit_array[0].accountId;
			var edit_dialog = $("<div></div>").dialog({
				title:"修改账户密码",
				width:800,
				height:560,
				modal:true,
				href:"${base}/user/toEdit?accountId=" + accountId,
				onClose:function() {
					edit_dialog.dialog("destroy");
				},
				buttons:[{
					text:'保存',
					handler:function(){
						//ajax提交表单
						$('#edit_form').form('submit', {
						url:"${base}/user/updateUserInfo",
						    success: function(data){ 
						    	//回掉函数中关闭对话框   
						        edit_dialog.dialog("destroy");
						        //刷新datagrid列表
						       userSearch("reload");
						    }    
						});
					}
				},{
					text:'关闭',
					handler:function(){
						edit_dialog.dialog("destroy");
					}
				}]
			});
		} else {
			$.messager.alert('提示', '请编辑一条数据！');
		}
	}
	//关闭
	function tabsClose() {
		var tab = $('#tt').tabs("getSelected");
		var index = $('#tt').tabs("getTabIndex", tab);
		$('#tt').tabs("close", index);
	}


	//批量禁用
	function openDel() {
		//是否选中了数据
		var selected_delete_array = $("#table_dge").datagrid("getSelections");
		var count = selected_delete_array.length;
		if (0 == selected_delete_array.length) {
			$.messager.alert("提示", "请至少选中一条数据！");
		} else {
			$.messager.confirm("确认","您确认想要禁用这"+count+"个用户吗？",function(r){    
			    if (r){    
			        //禁用操作
				var accountStatus=0;
			        var userIds = "";
			        for (var i = 0; i < selected_delete_array.length; i++) {
			        	userIds += "," + selected_delete_array[i].accountId;
			        }
			        if (0 < userIds.length) {
			        	userIds = userIds.substr(1);
			        }
			        $.ajax({
			        	url:"${base}/user/deleteUser",
			        	data:{userIds:userIds},
			        	type:"post",
			        	success:function(data) {
			        		userSearch();
			        	}
			        });
			    }    
			});
		}
	}


	//服务流开启关闭
	function upDown(accountId,enabledInfoFlow) {
		$.ajax({
        	url:"${base}/user/updateEnabledInfoFlow",
        	data:{accountId:accountId,enabledInfoFlow:enabledInfoFlow},
        	type:"post",
        	success:function(data) {
        		userSearch();
        	}
        });
	}
	
</script>
</body>
</html>
