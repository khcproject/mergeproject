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
		
		$('#update').bind('click', updateRun);
		$('#delete').bind('click', deleteRun);
	});
	
	function listRun() {
		
		$('#frm').attr('action', "notice.do").submit();
	}


	function updateRun() {
		$('#frm').attr('action', "noupdate.do").submit();
	}

	function deleteRun() {
		$('#frm').attr('action', "nodelete.do").submit();
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

<div class="view">
<table border="1" width="1100px">
		<tr>
			<td width="220px">작성자</td>
			<td>${dto.id}</td>
			<td width="150px">조회수</td>
			<td>${dto.n_viewcnt}</td>
		</tr>

		<tr>
			<td>제목</td>
			<td colspan="3">${dto.n_title}</td>
		</tr>
</table>

<table border="1" width="1100px">
		
			<td colspan="3">${dto.n_contents}</td>
</table>
		<input type="button" id="list" value="목록" />
 		<c:if test="${mdto[0].userchk=='A'}"> 
		<input type="button" id="update" value="수정" /> 
		<input type="button" id="delete" value="삭제" />
 		</c:if> 
	
</div>
		
	<form name="frm" id="frm" method="get" >	 
	    <input type="hidden" name="num" value="${dto.n_num}" />	
		<input type="hidden" name="currentPage" id="currentPage" value="${currentPage}" /> 
		<input type="hidden" name="id" value="${dto.id}" /> 
		
		</form>
	
 	</div>
 	
 	
</body>
</html>







