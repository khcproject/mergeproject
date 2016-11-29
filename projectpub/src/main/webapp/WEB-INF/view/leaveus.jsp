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
<script type="text/javascript" src="js/mine.js?ver=2"></script>
<link href="css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript">
	var mdto_id = "${mdto[0].id}";
</script>
</head>
<body>
	<!-- <div class="header footer"></div> -->

	<!-- 	<div class="full">  -->
	<div class="full_sub">
	<div class="sidemenu">
			<!-- 공통 -->
			<div class="face_and_name">
				<img id="face_pic" src="\projectpub\temp//${mdto[0].face}" />
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
							test="${sellreserv[0].p_pub_chk==null || sellreserv[0].p_pub_chk=='N'}">
							<div id="need_pub" class="common_btn special_btn">펍등록 신청</div>
						</c:when>
						<c:otherwise>
							<div id="update_pub" class="common_btn special_btn">펍 수정</div>
								<div id="reserv_list" class="common_btn special_btn">예약 리스트</div>
						</c:otherwise>
					</c:choose>
					<div id="leave" class="common_btn">회원탈퇴</div>
				</c:when>
				<c:otherwise>
					<!-- 관리자 -->
					<div id="ok_sell" class="common_btn special_btn">판매자 신청현황</div>
					<div id="ok_pub" class="common_btn special_btn">펍등록 신청현황</div>
				</c:otherwise>
			</c:choose>
		</div>
		<!-- End SideMenu -->

		<div class="mainmenu">

			<div class="page-header">
				<h1>&nbsp;회원정보</h1>
			</div>
			<form class="form-horizontal" id="leaveus" method="GET">
				<div class="form-group">
					<label class="col-sm-3 control-label" for="delId">ID</label>
					<div class="col-sm-6">
						<input class="form-control" id="delId" type="text" name="id"
							readonly="readonly" value="${mdto[0].id}">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label" for="delName">이름</label>
					<div class="col-sm-6">
						<input class="form-control" id="delName" type="text"
							readonly="readonly" value="${mdto[0].name}">
					</div>
				</div>
				<c:choose>
					<c:when test="${mdto[0].sex=='m'}">
						<div class="form-group">
							<label class="col-sm-3 control-label" for="delSex">성별</label>
							<div class="col-sm-6">
								<div class="input-group">
									<input class="form-control" id="delSex" type="text"
										readonly="readonly" value="남자">
								</div>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<div class="form-group">
							<label class="col-sm-3 control-label" for="delSex">성별</label>
							<div class="col-sm-6">
								<div class="input-group">
									<input class="form-control" id="delSex" type="text"
										readonly="readonly" value="여자">
								</div>
							</div>
						</div>

					</c:otherwise>
				</c:choose>

				<div class="form-group">
					<label class="col-sm-3 control-label" for="delNumber">휴대폰번호</label>
					<div class="col-sm-6">
						<div class="input-group">
							<input type="tel" class="form-control" id="delNumber"
								readonly="readonly" value="${mdto[0].phone}" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label" for="delEmail">E-Mail</label>
					<div class="col-sm-6">
						<input class="form-control" id="delEmail" type="text"
							readonly="readonly" value="${mdto[0].email}">
					</div>
				</div>
				<c:if test="${sellreserv[0].p_title!=null}">
					<div class="form-group">
						<label class="col-sm-3 control-label" for="delPub">Pub 이름</label>
								<div class="col-sm-6">
									<input class="form-control" id="delPub" type="text"
										readonly="readonly" value="${sellreserv[0].p_title}">
							</div>
					</div>
				</c:if>
				<div class="form-group">
					<div class="col-sm-12 text-center">
						<button class="btn btn-primary" type="button" id="delmembtn">
							탈퇴하기</button>
						<button class="btn btn-danger" type="button" id="delmemcanclebtn">
							취소</button>
					</div>
				</div>
			</form>

		</div>
		<!-- End MainMenu -->
	</div>
	<!-- End Full_Sub -->
	<!-- </div>  -->
	<!-- End Full -->

	<!-- 	<div class="header footer"></div> -->
</body>
</html>