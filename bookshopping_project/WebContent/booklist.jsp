<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
		<script type="text/javascript" src="easyui/jquery.min.js"></script>
		<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript" src="js/booklist.js"></script>
	</head>
	<body>
	
		<table id="bookinfotable">
		
		</table>
		
		<div id="allbth">
			<a id="add" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">增加书籍信息</a>
			<a id="delete" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除书籍信息</a>
			<a id="update" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改书籍信息</a>
			<a id="select" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询书籍信息</a>
		</div>
		
		<div id="dd" class="easyui-dialog" title="新增图书信息" style="width: 280px; height: 380px;"
			data-options="iconCls:'icon-save',resizable:true,modal:true">
		<form id="ff" method="post">
			<table>
				<tr>
					<td>图书编号<input type="hidden" name="flag" value="add"/></td>
					<td>
						<input id="bNo" name="bookNo" class="easyui-validatebox" data-options="iconCls:'icon-lock',required:true,readonly:true"/>  
					</td>
				</tr>
				<tr>
					<td>图书名称:</td>
					<td>
						<input id="vv" name="bookName" class="easyui-validatebox" data-options="required:true" placeholder="请输入图书名称"/>  
					</td>
				</tr>
				<tr>
					<td>图书作者:</td>
					<td>
						<input id="vv" name="bookAuthor" class="easyui-validatebox" data-options="required:true" placeholder="图书作者"/>  
					</td>
				</tr>
				<tr>
					<td>出版社名:</td>
					<td>
						<input id="vv" name="bookPublisher" class="easyui-validatebox" data-options="required:true" placeholder="出版社名称"/>  
					</td>
				</tr>
				<tr>
					<td>出版日期:</td>
					<td>
						<input class="easyui-datetimebox" name="bookPubDateStr" data-options="required:true,showSeconds:true" value="3/4/2010 2:3" style="width: 150px">
					</td>
				</tr>
				<tr>
					<td>图书价格:</td>
					<td><input type="text" class="easyui-numberbox" name="bookPrice" value="0.00" data-options="min:0,precision:2"></input></td>
				</tr>
				<tr>
					<td>图书图片:</td>
					<td><input class="easyui-validatebox" name="bookImage" data-options="required:true" placeholder="图书图片"></td>
				</tr>
				<tr>
					<td>图书内容:</td>
					<td><input class="easyui-textbox" name="bookContent" data-options="iconCls:'icon-',multiline:true" style="width: 300px,height: 300px"></td>
				</tr>
				<tr>
					<td>图书描述:</td>
					<td><input class="easyui-textbox" name="bookDesciption" data-options="iconCls:'icon-',multiline:true" style="width: 300px,height: 300px"></td>
				</tr>
				<tr>
					<td>图书类型:</td>
					<td><input id="cc" class="easyui-combobox" name="bookTypeNo" data-options="valueField:'id',textField:'text',url:'get_data.php'" /></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<a id="ok" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">确认</a>  
						<a id="cancel" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a>  
					</td>
				</tr>
				
			</table>
		</form>
	</div>
	</body>
</html>