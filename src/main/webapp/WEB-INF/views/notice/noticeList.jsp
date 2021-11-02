<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function CallNotice(no){
	frm.no.value=no;
	frm.submit();
}
function DeleteNotice(){
	deletef.submit();
}
function checkboxchecked(no){
	var a = 'tar'+no;
	var b = document.getElementById(a);
	if(b.checked===true){
		b.checked= false;
	}else{
		b.checked = true;
	}
}
</script>

</head>
<body>
	<jsp:include page="../home/header.jsp" />
	<div align="center">
		<div>
			<h1>공지 목록</h1>
		</div>
		<div>
			<form id="deletef" name="delete" action="noticeSelectDelete.do"
				method="post">
				<table border="1">
					<tr>
						<th width="100">글번호</th>
						<th width="150">작성자</th>
						<th width="250">제목</th>
						<th width="150">작성일</th>
						<th width="100">조회수</th>
						<c:if test="${author eq 'ADMIN'}">
							<th width="100">선택</th>
						</c:if>
					</tr>
					<c:forEach items="${notices }" var="notice">
						<tr style="cursor: pointer;"
							onmouseover="this.style.background='#fcecae';"
							onmouseleave="this.style.background='#FFFFFF';"
							onclick="CallNotice(${notice.no })">
							<td align="center">${notice.no }</td>
							<td align="center">${notice.name }</td>
							<td align="center">${notice.title }</td>
							<td align="center">${notice.writeDate }</td>
							<td align="center">${notice.hit }</td>
							<c:if test="${author eq 'ADMIN'}">
								<td align="center"
									onclick="event.cancelBubble=true; checkboxchecked(${notice.no})">
									<input type="checkbox" onclick="event.cancelBubble=true" name="target" id="tar${notice.no }"
									value=${notice.no }>
								</td>
							</c:if>
						</tr>
					</c:forEach>
				</table>
			</form>
		</div>
		<br>
		<button type="button" onclick="location.href='noticeForm.do'">글쓰기</button>
		<c:if test="${author eq 'ADMIN'}">
			<button type="button" onclick="DeleteNotice()">삭제</button>
		</c:if>
		&nbsp;&nbsp;&nbsp;
		<div>
			<c:forEach var="page" items="${noticess }" begin="0"
				end="${fn:length(noticess ) }" step="10">
				<a
					href="noticeList.do?rno=<fmt:formatNumber value="${(page.rno+9)/10 }" pattern="####" />">
					<fmt:formatNumber value="${(page.rno+9)/10 }" pattern="####" />
				</a>
			</c:forEach>


		</div>
		<div>
			<form id="search" name="search" method="post"
				action="noticeSelectSearch.do">
				<select name="what">
					<option value="author">Author</option>
					<option value="title">Title</option>
					<option value="number">Number</option>
				</select> <input type="text" id="sea" name="sea" size="10"> <input
					type="submit" value="Search">
			</form>
		</div>
	</div>
	<div>
		<form id="frm" name="frm" method="post" action="noticeSelect.do">
			<input type="hidden" id="no" name="no">
		</form>
	</div>
</body>
</html>