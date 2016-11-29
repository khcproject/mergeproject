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
			$('#frm').attr('action', 'notice.do');
			$('#frm').submit();
			// $('#frm').attr('action','list.sb').submit();
		});

		$('#btnSave').bind('click', function() {
			$('#frm').attr('action', 'nowrite.do').submit();
		});
		
	
		function process() {
			//document.frm.content.value = 
				// document.frm.content.value.replace( /\n/gi, '<br/>');
				$('[name=n_contents]').val(
						$('[name=n_contents]').val().replace(/\n/gi, '<br/>'));
			
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
      <td><input name="id" size="50" maxlength="50"></td>
      <td>&nbsp;</td>
     </tr>
      <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
		 
     <tr>
      <td>&nbsp;</td>
      <td align="center">제목</td>
      <td><input name="n_title" size="50" maxlength="100"></td>
      <td>&nbsp;</td>
     </tr>
     <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
   
    
     <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
     <tr>
      <td>&nbsp;</td>
      <td align="center">내용</td>
      <td><textarea name="n_contents" cols="50" rows="13"></textarea></td>
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
		

		<input type="button" id="btnList" value="리스트" />
		
	</form>
	</div>
	
</body>
</html>










