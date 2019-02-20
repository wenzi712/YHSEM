<#assign base=request.contextPath />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<#-- 引入easyui核心样式 -->
<link rel="stylesheet" type="text/css" href="${base}/static/easyui/themes/default/easyui.css">
<#-- 引入easyui图标样式 -->
<link rel="stylesheet" type="text/css" href="${base}/static/easyui/themes/icon.css">
<#-- 引入layui样式 -->
<link rel="stylesheet" href="${base}/static/layui/css/layui.css">
<link rel="stylesheet" href="${base}/static/layui/css/modules/layer/default/layer.css">
</head>
<body>

<#-- 引入jquery -->
<script type="text/javascript" src="${base}/static/jquery.min.js"></script>
<#-- 引入easyui核心包 -->
<script type="text/javascript" src="${base}/static/easyui/jquery.easyui.min.js"></script>
<#-- 引入easyui语言包 -->
<script type="text/javascript" src="${base}/static/easyui/locale/easyui-lang-zh_CN.js"></script>
<#-- 引入layui核心包 -->
<script src="${base}/static/layui/layui.all.js"></script>

<script type="text/javascript">

</script>

	<#include "main.ftl">

</body>
</html>
