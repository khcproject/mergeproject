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
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript">
	/* var mdto_id = "${mdto[0].id}"; */
// 	var abc = $('#jppub_mupload').files.length;
</script>
</head>
<body>
<c:if test="${sessionScope.userchk=='C'}">
<script>
 alert('판매자가 아닙니다.');
 location.href="mypage.do";
 </script>
</c:if>

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
			</c:choose>
		</div>
		<!-- End SideMenu -->

		<div class="jpmainmenu">

			<div class="page-header">
				<h1>&nbsp;PUB 등록 양식</h1>
			</div>
			<form class="form-horizontal" id="jpfrm" method="POST" enctype="multipart/form-data" onsubmit="return process()">
				<div class="form-group">
					<label class="col-sm-3 control-label" for="jpID">ID</label>
					<div class="col-sm-6">
						<input class="form-control" id="jpID" type="text" name="id"
							readonly="readonly" value="${mdto[0].id}">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label" for="jpName">신청인</label>
					<div class="col-sm-6">
						<input class="form-control" id="jpName" type="text"
							readonly="readonly" value="${mdto[0].name}">
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-3 control-label" for="jpSaupja_num">사업자
						번호</label>
					<div class="col-sm-6">
						<input class="form-control" id="jpSaupja_num" type="text"
							readonly="readonly" value="${mdto[0].saupja_num}">
						<p class="help-block">등록하신 사업자 번호 입니다.</p>
					</div>
				</div>



				<div class="form-group">
					<label class="col-sm-3 control-label" for="jppub_name">PUB
						이름</label>
					<div class="col-sm-6">
						<input class="form-control" id="jppub_name" type="text"
							name="p_title">
						<p class="help-block">PUB 이름을 등록해주세요.</p>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label" for="jppub_contents">PUB 소개글
						</label>
					<div class="col-sm-6">
						<textarea rows="10" cols="62" name="p_contents" id="jppub_contents"></textarea>
					<p class="help-block">PUB 소개글을 작성해주세요.</p>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-3 control-label" for="sample6_postcode">PUB
						address</label>
					<div class="col-sm-6">
						<input type="text" id="sample6_postcode" placeholder="우편번호" name="p_addr_post" readonly="readonly">
						<input type="button" onclick="sample6_execDaumPostcode()"
							value="우편번호 찾기"><br> <input class="form-control" type="text"
							id="sample6_address" placeholder="주소" name="p_address" readonly="readonly">
					</div>
				</div>


					<div class="form-group">
					<label class="col-sm-3 control-label" for="jppub_maxpeople">최대 예약 인원수
						</label>
					<div class="col-sm-6">
						<input class="form-control" id="jppub_maxpeople" type="text"
							name="p_maxpeople"onkeydown="return showKeyCode(event)"><span>명</span>
						<p class="help-block">예약 가능한 최대 인원수를 적어주세요.(숫자만기재)</p>
					</div>
				</div>

			<div class="form-group">
					<label class="col-sm-3 control-label" for="jppub_mupload">Pub 소개사진
						</label>
					<div class="col-sm-6">
					<div id="jpmainpic"></div>
						<input class="form-control" id="jppub_mupload" type="file"
							name="filename" multiple="multiple">
						<p class="help-block">Pub 소개에 관련한 사진들을 등록해주세요.(최대4장)</p>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-3 control-label" for="jppub_supload">메뉴 사진
						</label>
					<div class="col-sm-6">
						<div id="jpsubface_div"><img id="jpsubface_show" width="298px" height="147px"/></div>
						<input class="form-control" id="jppub_supload" type="file"
							name="subfilename">
						<p class="help-block">Pub menu 사진을 올려주세요.</p>
					</div>
				</div>
				<input type="hidden" name="p_pub_chk" value="R" />
				<div class="form-group">
					<div class="col-sm-12 text-center">
						<button class="btn btn-primary" type="button" id="jpbtn">
							신청하기</button>
						<button class="btn btn-danger" type="button" id="jpcanclebtn">
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