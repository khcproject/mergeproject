<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<title>수정</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#update').bind('click', updateRun);
		
		$("#back").bind('click', backRun);
		$('[name=q_contents]').val($('[name=q_contents]').val().trim());
		$('[name=q_contents]').val(
				$('[name=q_contents]').val().replace(/<br\s?\/?>/g, "\n"));
		
	});

	function updateRun() {
		$('[name=q_contents]').val(
				$('[name=q_contents]').val().replace(/\n/gi, '<br/>'));

		$('#frm').attr('action', 'qnaupdate.do').submit();
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
	<table>
		  <tr>
      <td>&nbsp;</td>
      <td align="center">이름</td>
      <td><input name="id" size="40" maxlength="50"></td>
      <td>&nbsp;</td>
     </tr>
      <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
		 
     <tr>
      <td>&nbsp;</td>
      <td align="center">제목</td>
      <td> 
      <input type="text" name="q_title" size="40" /></td>
      <td>&nbsp;</td>
     </tr>
     <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
   
    
     <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
     <tr>
      <td>&nbsp;</td>
      <td align="center">내용</td>
      <td><textarea name="q_contents" cols="40" rows="13"></textarea></td>
      <td>&nbsp;</td>
     </tr>
      <tr>
     	<td>&nbsp;</td>
		<td align="center">첨부파일</td>
		<td><input type="file" name="filename" />
		<td>&nbsp;</td>
	 </tr>
    
    
     <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
     <tr height="1" bgcolor="#82B5DF"><td colspan="4"></td></tr>
     <tr align="center">
     	</table>
     	
     	
		<input type="hidden" name="q_num" value="${dto.q_num}" /> 
		<input type="hidden" name="currentPage" value="${currentPage}" /> 
		<input type="button" id="update" value="수정" /> 
		<input type="button" id="back" value="뒤로" />
	</form>
	</div>
</body>
</html>









