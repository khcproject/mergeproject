<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-1.10.2.js"></script>

<script type="text/javascript">
	/* function loginchk(){
	
	 var popUrl = 'gotomessage.do?id='+mdto_id;	
	 var popOption = "width=780, height=500, resizable=no, scrollbars=no, top=200, left=600, status=no;";    
	 window.open(popUrl,"",popOption);
	
	 };//end gotomessage()///////////
	 */
	$(document).ready(function() {
		$('#loginchk').on('click', function() {
			$('#frm').attr('action', "loginchk.do").submit();
		});
	})
</script>

</head>
<body>
	<form method="post" id="frm">
		<input type="hidden" name="id" value="${param.id}" /> <input
			type="button" id="loginchk" value="인증하기" />
	</form>
</body>
</html>