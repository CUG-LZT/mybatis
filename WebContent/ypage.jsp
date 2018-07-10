<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="keywords" content="jquery,ui,easy,easyui,web">
	<meta name="description" content="easyui help you build your web page easily!">
	<title>Demo</title>
		
	<link rel="stylesheet" type="text/css" href="js/framejs/jquery-easyui-1.3.2/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="js/framejs/jquery-easyui-1.3.2/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="js/framejs/jquery-easyui-1.3.2/demo/demo.css">
	<script type="text/javascript" src="js/framejs/jquery-easyui-1.3.2/jquery-1.8.0.min.js"></script>
	<script type="text/javascript" src="js/framejs/jquery-easyui-1.3.2/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/framejs/jquery-easyui-1.3.2/locale/easyui-lang-zh_CN.js"></script>

	<script type="text/javascript">
		 function doSearch(){
			$('#tt').datagrid('load',{
				apart_name: $('#apart_name').val(),
				apart_number: $('#apart_number').val()
			});
		}
		
	</script>
<title>Insert title here</title>
</head>
<body>
	<div style="width:100%;">
		<a href="index.jsp" class="easyui-linkbutton" plain="true" style="float:left">无分页展示</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="dpage.jsp" class="easyui-linkbutton" plain="true">分页展示</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="ypage.jsp" class="easyui-linkbutton" plain="true">一对多、多对一展示</a>
	</div>
	<hr/>
	<p>通过一对多的关系，将部门和用户关联了起来，但是展示的时候去掉了部门信息！</p>
	<hr/>
	
	<table id="tt" class="easyui-datagrid" style="width:630px;height:470px;"
			url="http://localhost:8080/mybatis/getUserByApartmentServlet.action"
			title="Searching" iconCls="icon-search" toolbar="#tb"
			rownumbers="false" pagination="false" fitColumns="false" showFooter="false" >
		<thead>
			<tr>
				<th field="id" width="120"  align="center">userid</th>
				<th field="username" width="120" align="center">username</th>
				<th field="password" width="120" align="center">password</th>
				<th field="role" width="120" align="center">role</th>
				<th field="apart_id" width="120" align="center">apart_id</th>
			</tr>
		</thead>
	</table>
	<div id="tb" style="padding:3px">
		<span>apart_name:</span>
		<input id="apart_name" style="line-height:26px;border:1px solid #ccc;width:100px">
		<span>apart_number:</span>
		<input id="apart_number" style="line-height:26px;border:1px solid #ccc;width:100px">
		<a href="#" class="easyui-linkbutton" plain="true" onclick="doSearch()">Search</a>
	</div>
	
	
</body>
</html>