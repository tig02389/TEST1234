<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/menu.css">
</head>
<body>
	<div align="center">
		<div>
			<br />
		</div>
		<div>
			<!-- 메뉴부분 -->
			<ul>
				<li><a class="active" href="home.do">Home</a></li>
				<c:if test="${empty id }">
					<li><a href="signInForm.do">Login</a></li>
					<li><a href="signUpForm.do">SignUp</a></li>
				</c:if>
				<c:if test="${not empty id }">
					<li><a href="noticeList.do">Notice</a></li>
					<li><a href="myPage.do">AboutMe</a></li>
					<c:if test="${author eq 'ADMIN' }">
						<li><a href="memberList.do">Members</a></li>
					</c:if>
					<li><a href="signOut.do">LogOut</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</body>
</html>