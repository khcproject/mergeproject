<%@page import="java.util.Random"%>
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
<title>Insert title here</title>
 <script src="http://code.jquery.com/jquery-latest.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#list').bind('click', listRun);
		$('#update').bind('click', updateRun);
		$('#delete').bind('click', deleteRun);
		$('#coupon').bind('click', couponRun);
		$('#coupon2').bind('click', couponRun2);
		$('#coupon3').bind('click', couponRun3);
		
	});
	
	function listRun() {
		
		$('#frm').attr('action', "event.do").submit();
	}


	function updateRun() {
		$('#frm').attr('action', "eupdate.do").submit();
	}

	function deleteRun() {
		$('#frm').attr('action', "edelete.do").submit();
	}
	
	function couponRun() {
			
		alert("쿠폰이 발급되었습니다. MY Page에서 확인 하세요")
		$('#cfrm').attr('action', "coupon.do").submit();
	
	} 
	
	function couponRun2() {
		alert("쿠폰이 발급되었습니다. MY Page에서 확인 하세요")
		$('#cfrm2').attr('action', "coupon2.do").submit();
	}
	
	function couponRun3() {
		alert("쿠폰이 발급되었습니다. MY Page에서 확인 하세요")
		$('#cfrm3').attr('action', "coupon3.do").submit();
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
<table border="1" width="1100px" >
		<tr>
			<th width="250px">작성자</th>
			<td>${dto.id}</td>
			<th width="220px" >조회수</th>
			<td>${dto.e_viewcnt}</td>
		</tr>

		<tr>
			<th>제목</th>
			<td colspan="3">${dto.e_title}</td>
		</tr>
</table>

<td><img src="\projectpub\temp//${dto.e_uploads}" style="width: 1000px;height: 300px;"/></td>
<table border="1" width="1100px">
		
			<td colspan="3">${dto.e_contents}</td>
		
		
</table>




		<br>
	
	<form name="frm" id="frm" method="get" >
		 
	    <input type="hidden" name="num" value="${dto.e_num}" />	
		<input type="hidden" name="currentPage" id="currentPage" value="${currentPage}" /> 
		<input type="hidden" name="id" value="${dto.id}" /> 
	
		
<br>
<!-- 쿠폰만들기 -->
	<!--50%쿠폰  -->
	<form id="cfrm" name="cfrm" method="post" >

		<input type="hidden" name="id" value="${param.mdtoid}" onclick="javascript:this.onclick=null;" />
		<c:if test="${dto.e_num==1}"> 
		<input type="button" id="coupon" name="c_contents" value="50%쿠폰발급 받기" />
		</c:if>
	</form>
	<!-- 30%쿠폰 -->
	<form id="cfrm2" name="cfrm2" method="post" >

		<input type="hidden" name="id" value="${param.mdtoid}" onclick="javascript:this.onclick=null;" />
		 <c:if test="${dto.e_num==2}"> 
		<input type="button" id="coupon2" name="c_contents" value="30%쿠폰발급 받기" />
		</c:if>
	</form>
	<!-- 10%쿠폰 -->
	<form id="cfrm3" name="cfrm3" method="post" >

		<input type="hidden" name="id" value="${param.mdtoid}" onclick="javascript:this.onclick=null;" />
		<c:if test="${dto.e_num==3}"> 
		<input type="button" id="coupon3" name="c_contents" value="10%쿠폰발급 받기" />
	 	</c:if>
	</form>
<!-- 쿠폰만들기 끝 -->
	
		<br>
		
		<input type="button" id="list" value="목록" />
		<%-- 	<c:if test="${mdto[0].userchk=='A'}"> --%>
		<input type="button" id="update" value="수정" /> 
		<input type="button" id="delete" value="삭제" />
<%-- 	</c:if>  --%>
		
		</form>

	</div>

</body>
</html>







