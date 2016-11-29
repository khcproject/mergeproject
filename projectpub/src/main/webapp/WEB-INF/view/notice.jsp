<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/main.css">

<title>notice</title>
</head>
<body>

		<div id="bodywrap">

			<!-- 공지사항 /Q&A 버튼  -->
			<div id="noticebtn">
				<form id="frma" name="frma" method="get" action="notice.do">
					<input type="submit" id="btna" value="공지사항" />
				</form>

				<form id="frmb" name="frmb" method="get" action="qna.do">
					<input type="submit" id="btnb" value="Q&A" />
				</form>
			</div>
			<!-- 공지사항 /Q&A 버튼  끝-->
			<!--리스트 출력  -->
			<div>
				<br>
				<table width=100% border=0 cellpadding=0 cellspacing=0>
					<tr bgcolor="#000000" align=center height="30">
						<td width="220px"><b><font color='#ffffff'>번호</font></b></td>
						<td width="220px"><b><font color='#ffffff'>제목</font></b></td>
						<td width="220px"><b><font color='#ffffff'>작성자</font></b></td>
						<td width="200px"><b><font color='#ffffff'>작성일</font></b></td>
						<td width="150px"><b><font color='#ffffff'>조회수</font></b></td>
					</tr>


					<c:forEach var="dto" items="${aList}">
						<tr align=center height="30">
							<td width="220px">${dto.n_num}</td>
							<td width="220px"><c:url var="n_title" value="noview.do">
									<c:param name="currentPage" value="${pv.currentPage}" />
									<c:param name="num" value="${dto.n_num}" />
								</c:url><a href="${n_title}">${dto.n_title}</a></td>
							<td width="220px">${dto.id}</td>
							<td width="200px">${dto.n_date}</td>
							<td width="150px">${dto.n_viewcnt}</td>
						</tr>
						<tr height="2" bgcolor="#000000">
							<td colspan="5"></td>
						</tr>

					</c:forEach>
					<tr height="2" bgcolor="#000000">
						<td colspan="5"></td>
					</tr>
				</table>
			</div>
			<!--리스트 출력 끝  -->

			<!-- 관리자 글쓰기 -->
			<form id="frm" name="frm" method="get" action="nowrite.do">
				<%--  <c:if test="${mdto[0].userchk=='A'}">  --%>
				<input type="submit" id="btnWrite" value="글쓰기" />
				<%-- </c:if>  --%>
			</form>
			<!-- 관리자 글쓰기 끝 -->
			<br>



			<!-- PageDTO -->
			<div id="page">

				<!-- 이전 출력 -->
				<c:if test="${pv.startPage>1}">
					<a href="notice.do?currentPage=${pv.startPage-pv.blockPage}">이전</a>
				</c:if>
				<!-- 이전 끝 -->

				<c:forEach begin="${pv.startPage }" end="${pv.endPage }" step="1"
					var="i">
					<c:url var="currPage" value="notice.do">
						<c:param name="currentPage" value="${i}" />
					</c:url>

					<a href="${currPage }"> <c:out value="${i}" /></a>

				</c:forEach>

				<!-- 다음 출력 -->
				<c:if test="${pv.totalPage>pv.endPage}">
					<a href="notice.do?currentPage=${pv.startPage+pv.blockPage}">다음</a>
				</c:if>
				<!-- 다음 끝 -->

			</div>
		</div>


</body>
</html>