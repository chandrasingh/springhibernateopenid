<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Login Page</title>
<%@ page isELIgnored="false"%>
<style>
.errorblock {
	color: #ff0000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
<body onload='document.f.j_username.focus();'>
	<h3>Login with Username and Password (Custom Page)</h3>

	<c:if test="${not empty error}">
		<div class="errorblock">
			Your login attempt was not successful, try again.<br /> Caused :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>

	<img src="/resources/google-logo.png"></img>
	<form action="j_spring_openid_security_check" method="post">
		For Google users: <input name="openid_identifier" type="hidden"
			value="https://www.google.com/accounts/o8/id" /> <input type="submit"
			value="Sign with Google" />
	</form>

</body>
</html>