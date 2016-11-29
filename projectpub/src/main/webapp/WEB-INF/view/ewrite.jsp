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
	$(document).ready(
			function() {

				$('#btnList').bind('click', function() {
					$('#frm').attr('action', 'event.do');
					$('#frm').submit();

				});

				$('#btnSave').bind('click', function() {
					$('#frm').attr('action', 'ewrite.do').submit();
					
				});

				function process() {
					//document.frm.content.value = 
					// document.frm.content.value.replace( /\n/gi, '<br/>');
					$('[name=e_contents]').val(
							$('[name=e_contents]').val().replace(/\n/gi,
									'<br/>'));

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
				<td width="20%" align="center">작성자</td>
				<td><input type="text" name="id" size="10" maxlength="10" /></td>
			</tr>

			<tr>
				<td width="20%" align="center">제목</td>
				<td><input type="text" name="e_title" size="30" maxlength="30" /></td>
				
			</tr>


			<tr>
				<td width="20%" align="center">내용</td>
				<td><textarea name="e_contents" rows="13" cols="40"></textarea></td>
			</tr>

			<tr>
				<td width="20%" align="center">첨부파일</td>
				<td><input type="file" name="filename" />
			</tr>
			<tr>
				<td width="20%" align="center">In첨부파일</td>
				<td><input type="file" name="filename2" />
			</tr>

		</table>
			

		 <input type="button" id="btnList" value="리스트" />
		 <input type="button" id="btnSave" value="저장" />
		
	</form>
	
	</div>
</body>
</html>










