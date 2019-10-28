<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
<form action="login" method="post">

    用户名<input type="text" name="username"><font color="red">${requestScope.msg}</font>
    <br/>密码<input type="password" name="password">
   <br/> <input type="submit" value="登录"><button onclick="on()">注册</button>
</form>
</body>
</html>










</body>
</html>
