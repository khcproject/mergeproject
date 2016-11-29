<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<title>event</title>

</head>
<body>




<!--리스트 출력  -->
<div id="bodywrap">
<br>
<table width=100% border=0 cellpadding=0 cellspacing=0>
 
<c:forEach var="dto" items="${aList}">
	
	<tr><td colspan=10 height=1 bgcolor=#E0DFDF></td></tr>
 	<tr align=center >
	<td width="450px" align="right"><img src="\projectpub\temp//${dto.e_upload}" style="width: 150px;height: 100px;"/></td>
	<td width="100px"></td>
	<td align="left" ><c:url var="e_title" value="eview.do">
	<c:param name="currentPage" value="${pv.currentPage}"/>
	<c:param name="num" value="${dto.e_num}"/>
	<c:param name="id" value="${mdto.id}"/>
	</c:url><a href="${currentPage}" >${dto.e_title}</a><br>${dto.e_date}</td>
	
	</tr>
	<tr><td colspan=10 height=1 bgcolor=#E0DFDF></td></tr>
</c:forEach>
</table>

<!-- 관리자 글쓰기 -->
<form id="frm" name="frm" method="get" action="ewrite.do">
<%-- <c:if test="${mdto[0].userchk=='A'}"> --%>
	<input type="submit" id="btnWrite" value="글쓰기" />
<%-- </c:if> --%>
	</form>
<!-- 관리자 글쓰기 끝 -->
<br>



<!-- PageDTO -->
<div id="page">
			<!-- 이전 출력 -->
			<c:if test="${pv.startPage>1}">
				<a href="qna.do?currentPage=${pv.startPage-pv.blockPage}">이전</a>
			</c:if>
			<!-- 이전 끝 -->

			<c:forEach begin="${pv.startPage }" end="${pv.endPage }" step="1"
				var="i">
				<c:url var="currPage" value="qna.do">
					<c:param name="currentPage" value="${i}" />
				</c:url>

				<a href="${currPage }"> <c:out value="${i}" /></a>

			</c:forEach>

			<!-- 다음 출력 -->
			<c:if test="${pv.totalPage>pv.endPage}">
				<a href="qna.do?currentPage=${pv.startPage+pv.blockPage}">다음</a>
			</c:if>
			<!-- 다음 끝 -->

		</div>

</div>
<!--리스트 출력 끝  -->



</body>
</html>