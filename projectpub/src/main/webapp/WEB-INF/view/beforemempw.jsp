<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<!-- <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script> -->
<!-- <link rel="stylesheet" href="css/reset.css" /> -->
<link rel="stylesheet" href="css/mypage.css?ver=2" />	
<script type="text/javascript" src="js/mine.js?ver=3"></script>
<link href="css/bootstrap.min.css" rel="stylesheet"/>
<script type="text/javascript">
/* var mdto_id="${sessionScope.mem.id}"; */
var mdto_pw="${sessionScope.mem.pw}";

</script>
</head>
<body>
	<!-- <div class="header footer"></div> -->

<!-- 	<div class="full">  -->
		<div class="full_sub">
		<div class="sidemenu">
			<!-- 공통 -->
			<div class="face_and_name">
			<c:choose>
			<c:when test="${mdto[0].face!=null}">
			<img id="face_pic" src="\projectpub\temp//${mdto[0].face}" />
			</c:when>
			<c:otherwise>
			<img id="face_pic" src="images\nopicture.jpg"/>
			</c:otherwise>
			</c:choose>
				
				<div id="member_name">
					<c:out value="${mdto[0].name}님" />
				</div>
			</div>
			<div id="update_profile" class="common_btn">회원정보 수정</div>
			<div id="mypage_message" class="common_btn">쪽지함</div>
			<c:choose>
				<c:when test="${mdto[0].userchk=='C'}">
					<!-- 구매자 -->
					<div id="join_sell" class="common_btn special_btn">판매자 신청</div>
					<div id="leave" class="common_btn">회원탈퇴</div>
				</c:when>
				<c:when test="${mdto[0].userchk=='S'}">
					<!--판매자 -->
					<c:choose>
						<c:when
							test="${sellreserv[0].p_pub_chk==null || sellreserv[0].p_pub_chk=='N' || sellreserv[0].p_pub_chk=='R'}">
							<div id="need_pub" class="common_btn special_btn">펍등록 신청</div>
						</c:when>
						<c:otherwise>
							<div id="update_pub" class="common_btn special_btn">펍 수정</div>
								<div id="reserv_list" class="common_btn special_btn">예약 리스트</div>
						</c:otherwise>
					</c:choose>
					<div id="leave" class="common_btn">회원탈퇴</div>
				</c:when>
			</c:choose>
		</div>
			<!-- End SideMenu -->

			<div class="mainmenu">

					<div class="page-header">
				<h1>
					&nbsp;비밀번호 확인
				</h1>
			</div>
			<div class="gongback">
			<form class="form-horizontal" id="pwfrm" method="POST" action="mempwchk.do">
			<div class="col-md-12">
					<div class="form-group">
					<label class="col-sm-5 control-label" for="findPassword">비밀번호</label>
					<div class="col-sm-6">
					<div class="input-group">
						<input class="form-control" id="findPassword" type="password" placeholder="비밀번호를 입력해주세요">
						</div>
					</div>
				</div>
				</div>
			  <%-- 	<input type="hidden" name="id" value="${mdto[0].id}"/> --%>
				<div class="form-group">
					<div class="col-sm-11 text-center">
						<button class="btn btn-primary" type="button" id="pwokbtn">
							확인
						</button>
						<button class="btn btn-danger" type="button" id="pwcanclebtn">
							취소
						</button>
					</div>
				</div>
			</form>
				</div>
			</div>
			<!-- End MainMenu -->
		</div>
		<!-- End Full_Sub -->
	 <!-- </div>  -->
	<!-- End Full -->

<!-- 	<div class="header footer"></div> -->
</body>
</html>