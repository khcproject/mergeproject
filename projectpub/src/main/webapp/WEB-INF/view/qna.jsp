<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<title>Q&A</title>


</head>
<body>


<div id="bodywrap">



<!-- 공지사항 /Q&A 버튼  -->
<div id="noticebtn"> 
<form id="frma" name="frma" method="get" action="notice.do" >
<input type="submit" id="btna" value="공지사항"/>
</form>


<form id="frmb" name="frmb" method="get" action="qna.do">
<input type="submit" id="btnb" value="Q&A"/>
</form>
</div>
<!-- 공지사항 /Q&A 버튼  끝-->


<!--리스트 출력  -->

<div > 
<br> 
<table width=100% border=0 cellpadding=0 cellspacing=0>
<tr bgcolor="#000000"  align=center height="30">
<td width="220px"><b><font color='#ffffff'>번호</font></b></td>
<td width="220px"><b><font color='#ffffff'>제목</font></b></td>
<td width="220px"><b><font color='#ffffff'>작성자</font></b></td>
<td width="200px"><b><font color='#ffffff'>작성일</font></b></td>
<td width="150px"><b><font color='#ffffff'>조회수</font></b></td>
</tr>


<c:forEach var="dto" items="${aList}">
	<tr align=center height="30">
	<td width="220px">${dto.q_num}</td>
	<td width="220px"><c:url var="q_contents" value="qnaview.do">
	<c:choose>
	<c:when test="${pv==null }">
	<c:param name="currentPage" value="${spv.currentPage}"/>	
	</c:when>	
	<c:otherwise>
	<c:param name="currentPage" value="${pv.currentPage}"/>	
	</c:otherwise>
	</c:choose>
	<c:param name="num" value="${dto.q_num}"/>
	</c:url><c:if test="${dto.qr_level!=0}">
	<img src="images/level.gif" width="${20*dto.qr_level}" height="15">
	<img src="images/re.gif">
	</c:if>
	<a href="${q_contents}">${dto.q_title}</a></td>
	<td width="220px">${dto.id}</td>
	<td width="200px">${dto.q_date}</td>
	<td width="150px">${dto.q_viewcnt}</td>
	</tr>
	
	 
</c:forEach>
 <tr height="2" bgcolor="#000000"><td colspan="5"></td></tr>
</table>
</div> 
<!--리스트 출력 끝  -->

<!-- 유저&관리자 글쓰기 -->
	<form id="frm" name="frm" method="get" action="qnawrite.do">
	<input type="submit" id="btnWrite" value="글쓰기" />
	</form>
<!-- 유저&관리자 글쓰기 끝 -->

<!--검색  -->
  <form name="frms" class="frms" action="qna2.do">
          
            <select id="word" name="word">
                <option value="titlecontents">제목+내용</option>
                <option value="searchid">ID</option>       			
            </select>
          
            <input type="text" name="search" id="search" />
            <input type="button" id="search_btn" value="검색" />
            
            
            </form>
<!--검색  끝-->	




<!-- PageDTO -->
<div id="page">

	<c:choose>
			<c:when test="${pv!=null}">

			<!-- 이전 출력 -->
			<c:if test="${pv.startPage>1}">
				<a href="qna.do?currentPage=${pv.startPage-pv.blockPage}">이전</a>
			</c:if>
			<!-- 이전 끝 -->

			<!-- 페이지 출력 시작 -->
			<c:forEach begin="${pv.startPage }" end="${pv.endPage }" step="1"
				var="i">
				<c:url var="currPage" value="qna.do">
					<c:param name="currentPage" value="${i}" />
				</c:url>

				<a href="${currPage }"> <c:out value="${i}" /></a>
			</c:forEach>
			<!-- 페이지 출력 끝 -->

			<!-- 다음 출력 -->
			<c:if test="${pv.totalPage>pv.endPage}">
				<a href="qna.do?currentPage=${pv.startPage+pv.blockPage}">다음</a>
			</c:if>
			<!-- 다음 끝 -->
			</c:when>
			
			<c:otherwise>
			
			<!-- 이전  -->
				<c:if test="${spv.startPage>1}">
					<c:url var="prePage" value="qna2.do">
						<c:param name="currentPage" value="${spv.startPage-spv.blockPage}" />

						<c:param name="word" value="${word}" />
						<c:param name="search" value="${search}" />

					</c:url>
					<a href="${prePage}"><c:out value="이전" /></a>
				</c:if>

				<!-- 페이지 출력 시작 -->
				<c:forEach var="i" begin="${spv.startPage}" end="${spv.endPage}">
					<c:url var="currPage" value="qna2.do">
						<c:param name="currentPage" value="${i}" />
												
						<c:param name="word" value="${word}" />
						<c:param name="search" value="${search}" />
					</c:url>
					<a href="${currPage}"><c:out value="${i}" /></a>
				</c:forEach>
				<!-- 페이지 출력 끝 -->

				<!-- 다음 -->
				<c:if test="${spv.totalPage>spv.endPage}">
					<c:url var="nextPage" value="qna2.do">
						<c:param name="currentPage" value="${spv.startPage+spv.blockPage}" />
						
						<c:param name="word" value="${word}" />
						<c:param name="search" value="${search}" />
					</c:url>
					<a href="${nextPage}"><c:out value="다음" /></a>
				</c:if>
			
			
			
			</c:otherwise>
	</c:choose>
		</div>
</div>


</body>
</html>