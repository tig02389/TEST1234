<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function CallValidation() {
		var pw = frm.pwd.value;
		var cpw = frm.cpwd.value;
		if(frm.name.value==""){
			alert("plz enter name");
			frm.name.focus();
			return false;
		}
		if (pw == cpw) {
			frm.submit();
		} else {
			alert("plz check your password");
			frm.pwd.value = "";
			frm.cpwd.value = "";
			frm.pwd.focus();
			return false;
		}
	}
</script>
</head>
<body>
	<jsp:include page="../home/header.jsp" />
	<div align="center">
		<div>
			<h1>Sign Up</h1>
		</div>
		<div>
			<form id="frm" name="frm" action="signUp.do" method="post">
				<div>
					<table border="1">
						<tr>
							<th width="100">ID</th>
							<td width="200"><input type="text" id="id" name="id"
								required placeholder="Enter your ID"></td>
						</tr>
						<tr>
							<th width="100">password</th>
							<td width="200"><input type="password" id="pwd" name="pwd"
								required placeholder="Enter your password"></td>
						</tr>
						<tr>
							<th width="100">password check</th>
							<td width="200"><input type="password" id="cpwd" name="cpwd"
								required placeholder="RE Enter your password">
							</td>
						</tr>
						<tr>
							<th width="100">Name</th>
							<td width="200"><input type="text" id="name" name="name"
								required placeholder="Enter your Name"></td>
						</tr>
						<tr>
							<th width="100">ADDR</th>
							<td width="200"><input type="text" id="addr" name="addr"
								placeholder="Enter your Address"></td>
						</tr>
						<tr>
							<th width="100">Phone</th>
							<td width="200"><input type="text" id="phone" name="phone"
								placeholder="Enter your Phone"></td>
						</tr>
					</table>
				</div>
				<br> <input type="hidden" id="author" name="author"
					value="USER"> <input type="button" value="SignUp"
					onclick="CallValidation()">&nbsp;&nbsp;&nbsp; <input
					type="reset" value="reset">&nbsp;&nbsp;&nbsp;
			</form>
		</div>
	</div>
</body>
</html>