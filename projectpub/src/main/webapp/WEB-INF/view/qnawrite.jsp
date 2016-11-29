<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>

<script type="text/javascript">
	$(document).ready(function() {

		$('#btnList').bind('click', function() {
			$('#frm').attr('action', 'qna.do');
			$('#frm').submit();
			// $('#frm').attr('action','list.sb').submit();
		});

		$('#btnSave').bind('click', function() {
			$('#frm').attr('action', 'qnawrite.do').submit();
		});
		
	
		function process() {
			//document.frm.content.value = 
				// document.frm.content.value.replace( /\n/gi, '<br/>');
				$('[name=q_contents]').val(
						$('[name=q_contents]').val().replace(/\n/gi, '<br/>'));
			
				return true;
			}
		
	});
</script>

</head>
<body>


<div id="bodywrap">
	<form name="frm" id="frm" method="post" enctype="multipart/form-data">

<table>
		  <tr>
      <td>&nbsp;</td>
      <td align="center">이름</td>
      <td><input name="id" size="40" maxlength="50" value="${dto.id}"></td>
      <td>&nbsp;</td>
     </tr>
      <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
		 
     <tr>
      <td>&nbsp;</td>
      <td align="center">제목</td>
      <td><c:if test="${dto!=null}">답변</c:if>
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
      <td>&nbsp;</td>
      <td colspan="2"><input type="button" id="btnSave" value="등록" />
       <input type=button value="취소" OnClick="javascript:history.back(-1)">
      <td>&nbsp;</td>
     </tr>
</table>
<!-- 답변글일때.... --> 
				<c:if test="${dto!=null}">
					<input type="hidden" name="q_num" id="num" value="${dto.q_num}" />
					<input type="hidden" name="currentPage" id="currentPage"
						value="${currentPage}" />
					<input type="hidden" name="qr_num" value="${dto.qr_num}" />
					<input type="hidden" name="qr_step" value="${dto.qr_step}" />
					<input type="hidden" name="qr_level" value="${dto.qr_level}" />
				</c:if>
		

		<input type="button" id="btnList" value="리스트" />
		
	</form>
	</div>
	
	
</body>
</html>










