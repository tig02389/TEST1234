<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 작성</title>
</head>
<body>
	<jsp:include page="../home/header.jsp" />
	<div align="center">
		<div>
			<h1>게시글 작성 페이지</h1>
		</div>
		<div>
			<form id="frm" action="noticeInsert.do" method="post">
				<div>
					<table border="1">
						<tr>
							<th width="100">작성날자</th>
							<td width="150"><input type="date" id="writeDate"
								name="writeDate" required="required"></td>
						</tr>
						<tr>
							<th>제 목</th>
							<td colspan="5"><input type="text" id="title" name="title" required="required"></td>
						</tr>

						<tr>
							<th>내 용</th>
							<td colspan="5"><textarea rows="10" cols="55" id="content"
									name="content" ></textarea></td>
						</tr>
					</table>
				</div>
				<br>
				<div>
					<input type="hidden" id="id" name="id" value=${member.id }>
					<input type="hidden" id="name" name="name" value=${member.name }>
					<input type="submit" value="저 장">&nbsp;&nbsp;&nbsp; <input
						type="reset" value="취소">&nbsp;&nbsp;&nbsp; <input
						type="button" value="목록" onclick="location.href='noticeList.do'">&nbsp;&nbsp;&nbsp;
				</div>
			</form>
		</div>
	</div>
</body>
</html>