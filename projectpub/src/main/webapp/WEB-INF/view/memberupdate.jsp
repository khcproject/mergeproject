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
<script type="text/javascript" src="js/mine.js?ver=1"></script>
<link href="css/bootstrap.min.css" rel="stylesheet"/>
<script type="text/javascript">
var mdto_id="${mdto[0].id}";	
var mdto_pw="${mdto[0].pw}";

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
				<h1>
					&nbsp;회원정보
				</h1>
			</div>
			<form class="form-horizontal" id="frm" method="POST" enctype="multipart/form-data">
				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputId">ID</label>
					<div class="col-sm-6">
						<input class="form-control" id="inputId" type="text" name="id" readonly="readonly" value="${mdto[0].id}">
						<p class="help-block">ID는 변경이 불가능합니다.</p>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputPassword">비밀번호</label>
					<div class="col-sm-6">
						<input class="form-control" id="inputPassword" type="password" name="pw">
						<p class="help-block">숫자, 특수문자 포함 6자 이상 15자 이하</p>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputPasswordCheck">비밀번호
						확인</label>
					<div class="col-sm-6">
						<input class="form-control" id="inputPasswordCheck"
							type="password" placeholder="비밀번호 확인">
						<p class="help-block">비밀번호를 한번 더 입력해주세요.</p>
					</div>	
				</div>	
				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputName">이름</label>
					<div class="col-sm-6">
					<div class="input-group">
						<input class="form-control" id="inputName" type="tel" name="name" readonly="readonly" value="${mdto[0].name}">
						</div>
							<p class="help-block">이름은 변경이 불가능합니다.</p>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputNumber">휴대폰번호</label>
					<div class="col-sm-6">
						<div class="input-group">
							<input type="tel" class="form-control" id="inputNumber" name="phone" value="${mdto[0].phone}"/> 
						</div>
					</div>
				</div>
				<div class="form-group">		
					<label class="col-sm-3 control-label" for="inputEmail">E-Mail</label>
					<div class="col-sm-6">
							<input class="form-control" id="inputEmail" type="text" name="email" value="${mdto[0].email}"> 
					</div>
				</div>
				
					<div class="form-group">		
					<label class="col-sm-3 control-label" for="inputFace">프로필 사진</label>
					<div class="col-sm-6">
					<div class="input-group"><div id="face_div"><img id="face_show" src="\projectpub\temp//${mdto[0].face}" width="298px" height="147px"/></div>
							<input class="form-control" id="inputFace" type="file" name="filename">
							</div> 
					</div>
				</div>
			 	<input type="hidden" name="email_agree" value="${mdto[0].email_agree}"/>
				<input type="hidden" name="sex" value="${mdto[0].sex}"/>
				<input type="hidden" name="birth" value="${mdto[0].birth}"/>
				<input type="hidden" name="userchk" value="${mdto[0].userchk}"/>
				<input type="hidden" name="allow_chk" value="${mdto[0].allow_chk}"/>
				<input type="hidden" name="login_time" value="${mdto[0].login_time}"/> 
				<input type="hidden" name="saupja_num" value="${mdto[0].saupja_num}"/>
				<div class="form-group">
					<div class="col-sm-12 text-center">
						<button class="btn btn-primary" type="button" id="uptokbtn">
							수정
						</button>
						<button class="btn btn-danger" type="button" id="uptcanclebtn">
							취소
						</button>
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