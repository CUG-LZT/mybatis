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
				username: $('#username').val(),
				role: $('#role').val()
			});
		}
		function delelist(){
			var selectlist = [];
			var rows = $('#tt').datagrid('getSelections');
			for (var i = 0; i < rows.length; i++) {
				selectlist[i] = rows[i].id;
			}
			  $.ajax({
					type : "POST",
					url : "http://localhost:8080/mybatis/useraction.action",
					data : {
						"ids" : selectlist,
						"action" : "delelist"
					},
					dataType : "json",
					traditional: true,//属性在这里设置
					success : function(data) {
						alert("删除成功");
						$('#tt').datagrid('load',{});
					},
					error : function(err) {
						alert("error!");
					}
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
	
	<table id="tt" class="easyui-datagrid" style="width:570px;height:500px;"
			url="http://localhost:8080/mybatis/getUserByPage.action"
			title="Searching" iconCls="icon-search" toolbar="#tb"
			rownumbers="false" pagination="true" pagination="false" fitColumns="false" showFooter="false" >
		<thead>
			<tr>
				<th field="id" width="80" align="center">ID</th>
				<th field="username" width="120" align="center">username</th>
				<th field="password" width="120"  align="center">password</th>
				<th field="role" width="120"  align="center">role</th>
				<th field="apart_id" width="120" align="center">apartment</th>
			</tr>
		</thead>
	</table>
	<div id="tb" style="padding:3px">
		<span>username:</span>
		<input id="username" style="line-height:26px;border:1px solid #ccc;width:100px">
		<span>role:</span>
		<input id="role" style="line-height:26px;border:1px solid #ccc;width:100px">
		<a href="#" class="easyui-linkbutton" plain="true" onclick="doSearch()">Search</a>
		
		<a href="#" class="easyui-linkbutton" plain="true" onclick="delelist()">delelist</a>
	</div>
	
	
</body>
</html>