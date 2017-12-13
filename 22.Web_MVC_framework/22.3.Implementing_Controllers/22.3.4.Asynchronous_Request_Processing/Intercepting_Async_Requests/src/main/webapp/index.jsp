<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8" content="text/html">
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/jquery.pjax.js"></script>
</head>
<body>
<div id="main">
    <a href="http://localhost:8080/user/save?name=Qiaogh&password=123&age=26&birthday=1988-10-07">测试</a>
</div>
</body>
</html>
<script type="text/javascript">
    //处理点浏览器返回时候最后一个不刷新页面内容问题
    $(function(){
        // pjax
        $(document).pjax('a', '#main');
    })
</script>