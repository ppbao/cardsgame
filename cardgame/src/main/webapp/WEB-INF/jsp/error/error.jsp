<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<style type="text/css">
body, dl, dt, dd, ul, ol, li, h1, h2, h3, h4, h5, h6, hr, form, input, p, th, td { margin:0; padding:0;}
body { color:#444; background:#fff; font:12px/2 Tahoma, Helvetica, Arial, sans-serif;}
a:link, a:visited { color:#226cc0; text-decoration:none;}
a:hover, a:active { color:#226cc0; text-decoration:underline;}
.error_top_box, .error_header, .error_content { width:1000px; margin:0 auto;}
.error_top { height:27px; line-height:27px; border-bottom:1px solid #ececec; background:#f9f9f9;}
.error_top_box { text-align:right;}
.error_top_box a:link, .error_top_box a:visited { color:#444;}
.error_top_box a:hover, .error_top_box a:active { color:#444;}
.error_header { height:111px;}
.error_header h1 { float:left; width:164px; height:46px; margin:30px 0; padding-left:25px; overflow:hidden;}
.error_header h1 a { display:block; width:164px; height:46px; background: url(${ctx}/static/images/logo.jpg) no-repeat; text-indent:-9999px;}
.error_content { background:url(${ctx}/static/images/error.jpg) no-repeat center 50px; width:575px; height:380px; padding:120px 0 0 425px; border-top:1px solid #ececec;}
.content_404 { background:url(${ctx}/static/images/404.jpg) no-repeat center 50px; width:545px; padding-left:455px;}
.error_footer { width:100%; text-align:center; line-height:30px; padding:20px 0; border-top:1px solid #ececec; position:absolute; bottom:0;}
</style>

<title>Card game</title>

</head>



<body>

<div class="error_header">
	<h1><a href="#">logo</a></h1>
</div>
<div class="error_content">
	<p style="font-size:14px;">Customer support Bruce.liu.02@gmail.com</p><br />
	<p>Click the following links to continue!</p>
	<a href=<c:url value='/'">·Back to the front page</a><br />
	<a href=<c:url value='/'">·back to game history</a>
	 
</div>
<div class="error_footer">
	 
	copyright© 2014 All rights reserved 
</div>
</body>

</html>

 
