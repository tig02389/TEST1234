<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<h1>로그인</h1>
		</div>
		<div>
			<form id="frm" name="frm" action="signIn.do" method="post">
				<div>
					<table border="1">
						<tr>
							<th width="150">ID</th>
							<td width="200"><input type="text" id="id" name="id"
								required="required" placeholder="enter ID"></td>
						</tr>
						<tr>
							<th width="150">PW</th>
							<td width="200"><input type="password" id="pwd" name="pwd"
								required="required" placeholder="enter PWD"></td>
						</tr>
					</table>
				</div><br>
				<div><input type="submit" value="Sign in">&nbsp;&nbsp;&nbsp;<input type="reset" value="cancel">&nbsp;&nbsp;&nbsp;</div>
			</form>
		</div>
	</div>
</body>
</html>