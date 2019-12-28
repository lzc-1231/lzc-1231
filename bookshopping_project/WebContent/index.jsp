<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
		<script type="text/javascript" src="easyui/jquery.min.js"></script>
		<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="js/index.js"></script>
	</head>
	<body>
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'north'" style="height:50px">
				欢迎(${sessionScope.USER_OBJ.userName})登录!
			</div>
			<div data-options="region:'west',split:true" title="当当书城" style="width:200px;">
				<div class="easyui-accordion" data-options="fit:true">
					<c:forEach items="${sessionScope.AUTHOTIRY_MENU_MAP}" var="authorityMenuEntry">
						<div title="${authorityMenuEntry.key}" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
							<c:forEach items="${authorityMenuEntry.value}" var="authorityObj">
								<a id="${authorityObj.authImg}" title="${authorityObj.authUrl}" name="secondMenu" style="display:block;width:150px;height:25px;color:white;background:red;text-decoration:none;text-align:center;line-height:25px;margin-top:2px;">${authorityObj.authName}</a>
							</c:forEach>
						</div>
					</c:forEach>
				</div>
			</div>
			<div data-options="region:'center',iconCls:'icon-ok'">
				<div id="shoppingtabs" class="easyui-tabs" data-options="fit:true">
					
				</div>
			</div>
		</div>
	</body>
</html>