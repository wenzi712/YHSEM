<#assign base=request.contextPath />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body class="easyui-layout">
	<div data-options="region:'north', height:100, title:'上', collapsible:false, split:true">
		<center><h2>YH后台管理界面</h2></center>
		
	</div>
    
    <div data-options="region:'west', width:160, title:'左', split:true">
    	<#-- 菜单树容器 -->
    	<ul id="main_left_tree"></ul>
    </div>
    <div data-options="region:'center', title:'中', split:true">
    	<#-- 选项卡容器 -->
    	<div id="tt" class="easyui-tabs" data-options="fit:true">   
		    <div title="主页">   
		        	
		    </div>   
		</div> 
    </div>

<script type="text/javascript">


	//初始化菜单树
	$('#main_left_tree').tree({
		url:"${base}/menu/selectTreeList2",
		onClick:function(node){
			if (null != node.href && "" != node.href) {
				open_tabs(node.text, node.href);
			}
		},   
	}); 

	//打开选项卡
	function open_tabs(tab_title, tab_href) {
		//判断选项卡是否被打开
		var tab_exists = $('#tt').tabs("exists", tab_title);
		if (tab_exists) {
			//激活已打开的选项卡
			$('#tt').tabs("select", tab_title);
			//刷新当前选项卡内容
			$('#tt').tabs("getSelected").panel("refresh");
		} else {
			$('#tt').tabs('add',{    
			    title:tab_title, 
			    href:"${base}" + tab_href,   
			   
			    closable:true,    
			});
		}
		 
	}

</script>

</body>
</html>
