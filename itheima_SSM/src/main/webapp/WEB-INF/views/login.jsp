
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<div style="width: 100%">
    <div style="margin: 100px auto;width: 350px">
        <h1>账号登录</h1>
        <form name="accountForm" action="${pageContext.request.contextPath}/user/login" method="post">
            账户:<input type="text" name="username"><br><br>
            密码:<input type="password" name="password"><br><br>
            <input type="submit" value="登   录"><br>
        </form>
    </div>
</div>
</body>
</html>
