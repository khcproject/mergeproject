<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/reset.css">s
<link rel="stylesheet" type="text/css" href="css/main.css">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#update').bind('click', updateRun);
		$('#cancel').bind('click', cancelRun);
		$("#back").bind('click', backRun);
		$('[name=e_contents]').val($('[name=e_contents]').val().trim());
		$('[name=e_contents]').val(
				$('[name=e_contents]').val().replace(/<br\s?\/?>/g, "\n"));
		
	});

	function updateRun() {
		$('[name=e_contents]').val(
				$('[name=e_contents]').val().replace(/\n/gi, '<br/>'));

		$('#frm').attr('action', 'eupdate.do').submit();
	}

	function cancelRun() {
				
		$('#e_title').val('${dto.e_title}');
		$('#e_contents').val('${dto.e_contents}');
	}
	
	function backRun() {
		history.go(-1);
	}
</script>


</head>
<body>

	<%
		//치환 변수 선언
		pageContext.setAttribute("cr", "\r"); //Space
		pageContext.setAttribute("cn", "\n"); //Enter
		pageContext.setAttribute("crcn", "\r\n"); //Space, Enter
		pageContext.setAttribute("br", "<br/>"); //br 태그
	%>


<div id="bodywrap">




	<form name="frm" id="frm" method="post" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<th width="220px">작성자</th>
				<td>${dto.id}</td>
			</tr>

			<tr>
				<th>제목</th>
				<td colspan="3"><input type="text" name="e_title" id="e_title"
					value="${dto.e_title}" /></td>
			</tr>


			<tr>
				<th>내용</th>
				<td colspan="3">
				<textarea name="e_contents" id="e_contents" rows="13" cols="40">
						${dto.e_contents}
				</textarea></td>
			</tr>
		
			

			
		</table>
		<input type="hidden" name="e_num" value="${dto.e_num}" /> <input
			type="hidden" name="currentPage" value="${currentPage}" /> <input
			type="button" id="update" value="수정" /> <input type="button"
			id="cancel" value="취소" />
			<input type="button" id="back" value="뒤로" />
	</form>
	</div>


	
</body>
</html>









