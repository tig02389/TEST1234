<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../home/header.jsp" />
	<div align="center">
		<div>
			<h1>회원 목록 보기</h1>
		</div>
		<div>
			<table border="1">
				<tr>
					<th width="150">id</th>
					<th width="150">pwd</th>
					<th width="150">name</th>
					<th width="250">addr</th>
					<th width="200">phone</th>
					<th width="150">author</th>
				</tr>
				<c:forEach items="${members }" var="member">
					<tr>
						<td align="center">${member.id }</td>
						<td align="center">${member.pwd }</td>
						<td align="center">${member.name }</td>
						<td align="center">${member.addr }</td>
						<td align="center">${member.phone }</td>
						<td align="center">${member.author }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>