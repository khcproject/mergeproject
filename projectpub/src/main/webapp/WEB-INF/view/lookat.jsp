<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
 <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
 <link rel = "stylesheet" type = "text/css" href = "css/lookat.css">
 <link rel = "stylesheet" type = "text/css" href = "css/reset.css">
 <script  src="js/jquery.bxslider.min.js"></script>
<script src="js/bx.js"></script>
<script src="js/aja.js?ver=2"></script>
<script type="text/javascript">
/* $(document).ready(function(){
	$('#select').change(function(){
		alert($('#select option:selected').val());
	});
}); */

</script>
</head>	
<body>
<div id="main">
	<div id="content">
		<!-- 랭킹별 사진  -->
		<c:choose>
			<c:when test="${fn:length(aList)>'0'}">
			<div id="rank1">
				<li><a href="pubview.do?p_num=${aList[0].p_num}"><img src="\projectpub\temp//${aList[0].p_mupload}" style="width:1098px; height:598px; " alt="메인" /></a></li>
			</div>
			<div id="rankrest">
			<ul id="slide_banner">
			<c:forEach var="i" begin="1" end="${fn:length(aList)-1}">
				<li><a href="pubview.do?p_num=${aList[i].p_num}"><img src="\projectpub\temp//${aList[i].p_mupload}" style="width:198px; height:198px; " alt="사진${i}" /></a></li>
			</c:forEach>
			</ul>
		</div>
			</c:when>
			
			<c:otherwise>
			<div id="rank1">
			<a>${fn:length(aList)}</a>
			</div>
			<div id="rankrest">
			<ul id="slide_banner">
			</ul>
			</div>
			</c:otherwise>
		</c:choose>
		
		<!-- 검색 -->
		<div id="search">
			<div id = "search-box">
				<input id="search-con" name="search" type="text">
				<input type="submit" value="검색" id="btn">
			</div>
			<select name="search" id="select">
				<option value="">지역</option>
				<option value="서울">서울</option>
				<option value="인천">인천</option>
				<option value="부산">부산</option>
				<option value="평양">평양</option>
            </select>
		</div>
		
		<!-- 전체 펍 나타내기 -->
		<div id="rec">
			<div id="rec-con">
			<table id="table">
				<c:forEach var="pub" items="${aList2}">
					<div id="test">
						<a href="pubview.do?p_num=${pub.p_num}"><img src="\projectpub\temp//${pub.p_mupload}" style="width:212px; height:274px;" alt="사진1" /></a>
						
						<a style="width:212px; height:40px;">Pub집 이름 : ${pub.p_title}</a>
						<a style="width:212px; height:40px;">Pub집 주소 : ${pub.p_address}</a>
						<a style="width:212px; height:40px;">최대인원 : ${pub.p_maxpeople}</a>
						<c:forEach var="sss" items="${diao}">
							<c:if test="${pub.p_num==sss.p_num}">
								<div class="${pub.p_num}" style="width:150px;"></div><a>${sss.s_stars}점</a>
									<script>
										alert(${sss.p_num});
										star(${sss.p_num},${pub.p_num});
									</script>
							</c:if>
						</c:forEach>
					</div>
				</c:forEach>
			</table>	
			</div>
		
			<div id="rec-num">
				
				<c:forEach var="i" begin="${pv.startPage}" end="${pv.endPage}">
					<a class="currentPage"><c:out value="${i}" /></a>
				</c:forEach>
				
			</div>
		</div>
 	</div>
	
	

</div>
</body>
</html>