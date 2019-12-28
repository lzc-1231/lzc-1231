<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="servlet/userAuthorityManagerMenetServlet" method="post">
		登录帐号:<input type="text" name="userLoginAccount"/><br/>
		登录密码:<input type="password" name="loginUserPass"/><br/>
		<input type="hidden" name="flag" value="login"/>
		<input type="submit" value="用户登录"/>
	</form>
</body>
</html>