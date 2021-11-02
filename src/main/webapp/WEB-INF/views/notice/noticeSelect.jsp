<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function CallEdit(str) {
		if (str == 'E') {
			frm.action = "noticeEdit.do";
		} else {
			frm.action = "noticeDelete.do";
		}
		frm.submit();
	}
</script>
</head>
<body>
	<jsp:include page="../home/header.jsp" />
	<div align="center">
		<div>
			<h1>공지사항 상세보기</h1>
		</div>
		<form id="frm" action="" method="post">
			<div>
				<table border="1">
					<tr>
						<th width="70">번호</th>
						<td width="70" align="center">${notice.no }</td>
						<th width="70">작성자</th>
						<td width="100" align="center">${notice.name }</td>
						<th width="70">작성일자</th>
						<td width="150" align="center">${notice.writeDate }</td>
						<th width="70">조회수</th>
						<td width="70" align="center">${notice.hit }</td>
					</tr>
					<tr>
						<th>제목</th>
						<td align="center" colspan="7"><input type="text"
							name="title" id="title" value="${notice.title }"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="7"><textarea rows="10" cols="90" name="content"
								id="textarea">${notice.content }</textarea></td>
					</tr>
				</table>
			</div>
			<div>
				<button type="button" onclick="location.href='noticeList.do'">목록</button>
				<c:if test="${notice.name eq sessionScope.name or sessionScope.author eq 'ADMIN' }">
				&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="button" onclick="CallEdit('E')">수정</button>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="button" onclick="CallEdit('D')">삭제</button>
				&nbsp;&nbsp;&nbsp;&nbsp;
				</c:if>
			</div>
				<input type="hidden" id="no" name="no" value="${notice.no }">
				<input type="hidden" id="title" name="title"> <input
					type="hidden" id="content" name="content">
		</form>
	</div>
</body>
</html>