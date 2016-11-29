<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/view.css">
<title>Insert title here</title>
 <script src="http://code.jquery.com/jquery-latest.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#list').bind('click', listRun);
		$('#replay').bind('click', replayRun);
		$('#update').bind('click', updateRun);
		$('#delete').bind('click', deleteRun);
	});
	
	function listRun() {
		
		$('#frm').attr('action', "qna.do").submit();
	}
	
	function replayRun() {
		$('#frm').attr('action', "qnawrite.do").submit();
	}

	function updateRun() {
		$('#frm').attr('action', "qnaupdate.do").submit();
	}

	function deleteRun() {
		$('#frm').attr('action', "qnadelete.do").submit();
	} 
	
	

	
	
	</script>
</head>
<body>

<!-- 치환 변수 선언 -->
<c:set var="cr" value="\r" scope="page" />
<c:set var="cn" value="\n" scope="page" />
<c:set var="crcn" value="\r\n" scope="page" />
<c:set var="br" value="<br/>" scope="page" />


<div id="bodywrap">


<div>
<table border="1" width="1100px">
		<tr>
			<td width="220px">작성자</td>
			<td>${dto.id}</td>
			<td width="150px">조회수</td>
			<td>${dto.q_viewcnt}</td>
		</tr>

		<tr>
			<td>제목</td>
			<td colspan="3">${dto.q_title}</td>
		</tr>
		<tr>
			<td>파일</td>
			<td colspan="3">
			
			${fn:substringAfter(dto.q_upload,'_')}
			
				<c:if test="${empty dto.q_upload }">
					<c:out value="첨부파일 없음" />
				</c:if></td>
		</tr>
</table>
	<table>
        <tr>
        <c:if test="${dto.q_upload!=null}">
		<td><img src="\projectpub\temp//${dto.q_upload}" style="width: 1100px;height: 300px;"/></td>
        </c:if>
		</tr>
	</table>

<table border="1" width="1100px">
		
			<td colspan="3" align="center">${dto.q_contents}</td>
</table>


</div>

	
	<form name="frm" id="frm" method="get" >
	
	    <input type="hidden" name="num" value="${dto.q_num}" />	
		<input type="hidden" name="currentPage" id="currentPage" value="${currentPage}" /> 
		<input type="hidden" name="id" value="${dto.id}" /> 
		<input type="hidden" name="qr_num" value="${dto.qr_num}" /> 
		<input type="hidden" name="qr_step" value="${dto.qr_step}" /> 
		<input type="hidden" name="qr_level" value="${dto.qr_level}" /> 
		<input type="button" id="list" value="목록" />
		
		<!-- 관리자 전용-->
		<%-- <c:if test="${mdto[0].userchk=='A'}"> --%>
		<input type="button" id="replay" value="답변" /> 
		<%-- </c:if> --%>
		
		
	 
		</form>
		
	<!-- 아이디 값으로 들어왔을때 나와주는걸로  수정해야함-->
		<input type="button" id="update" value="수정" /> 
		<input type="button" id="delete" value="삭제" />
	
	</div>
	
</body>
</html>







