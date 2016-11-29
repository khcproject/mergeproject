<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<!-- <link rel="stylesheet" href="css/reset.css" /> -->
<link rel="stylesheet" href="css/mypage.css?ver=2" />
<script type="text/javascript" src="js/mine.js?ver=2"></script>
<script type="text/javascript">
	var mdto_id = "${mdto[0].id}";
	var mdto_allow_chk = "${mdto[0].allow_chk}";
	var pub_chk = "${sellreserv[0].p_pub_chk}";
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
			</c:choose>
		</div>
		<!-- End SideMenu -->

		<div class="mainmenu">
			<div id="profile_pic">
				<img id="big_face_pic" src="\projectpub\temp//${mdto[0].face}" />
			</div>
			<div id="profile_intro">
				<div id="profile_h">프로필</div>
				<div class="profile_text">
					ID :
					<c:out value="${mdto[0].id}" />
				</div>
				<div class="profile_text">
					이름 :
					<c:out value="${mdto[0].name}" />
				</div>
				<c:choose>
					<c:when test="${mdto[0].sex=='m'}">
						<div class="profile_text">성별 : 남</div>
					</c:when>
					<c:otherwise>
						<div class="profile_text">성별 : 여</div>
					</c:otherwise>
				</c:choose>
				<div class="profile_text">
					연락처 :
					<c:out value="${mdto[0].phone}" />
				</div>
				<div class="profile_text">
					E-mail :
					<c:out value="${mdto[0].email}" />
				</div>
				<c:choose>
					<c:when test="${mdto[0].userchk=='C'}">
						<!-- 구매자 -->
						<div class="profile_text">회원 등급 : 구매자</div>
					</c:when>
					<c:when test="${mdto[0].userchk=='S'}">
						<!--판매자 -->
						<div class="profile_text">회원 등급 : 판매자</div>
					</c:when>
					<c:otherwise>
						<!-- 관리자 -->
						<div class="profile_text">회원 등급 : 관리자</div>
					</c:otherwise>
				</c:choose>
				<div class="profile_text">
					마지막 로그인 :
					<c:out value="${mdto[0].login_time}" />
				</div>
			</div>
			<!-- End Profile_Intro -->
			<div id="main_hr"></div>
			<div class="main_bot">
				<c:choose>
					<c:when test="${mdto[0].userchk=='C'}">
						<div class="main_bot_comm">
							<div id="first_head" class="main_bot_head">PUB 예약 현황</div>
							<div id="reservation_proc">

								<div id="span_comm">
									<span id="cusrerv">PUB 이름</span> <span id="cusrerv">예약
										날짜</span> <span id="cusrerv">예약 시간</span> <span id="cusrerv">예약
										인원</span> <span id="cusrerv">처리상태</span>
								</div>
								<div id="span_comm">
									<c:choose>
										<c:when test="${cusreserv[0].reservation[0].res_num!=null}">
											<c:forEach items="${cusreserv}" var="cus">
												<c:forEach items="${cus.reservation}" var="res">
													<span id="cusrerv"><c:out value="${res.pub.p_title}" /></span>
													<span id="cusrerv"><c:out value="${res.res_date}" /></span>
													<span id="cusrerv"><c:out value="${res.res_time}" /></span>
													<span id="cusrerv"><c:out value="${res.res_people}" /></span>
													<c:choose>
														<c:when test="${res.res_sellcheck=='N'}">
															<span id="cusrerv">대기중
																<button id="cuscancle_btn" value="${res.res_num}">취소</button>
															</span>
														</c:when>
														<c:when test="${res.res_sellcheck=='C'}">
															<span id="cusrerv">예약불가
																<button id="cuscancle_btn" value="${res.res_num}">취소</button>
															</span>
														</c:when>
														<c:otherwise>
															<span id="cusrerv">예약성공
																<button id="cuscancle_btn" value="${res.res_num}">취소</button>
															</span>
														</c:otherwise>
													</c:choose>
												</c:forEach>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<span id="nocoupon">예약한 PUB이 없습니다.</span>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</div>
						<div class="main_bot_comm">
							<div id="second_head" class="main_bot_head">쿠폰</div>
							<div id="cuscoupon_proc">

								<div id="span_comm">
									<span id="commcoupon">쿠폰 이름</span> <span id="commcoupon">남은기간</span>
									<span id="commcoupon">사용 여부</span><span id="commcoupon">사용처</span>

								</div>
								<div id="span_comm">
									<c:choose>
										<c:when test="${mdto[0].coupon[0].c_num!=null}">
											<c:forEach items="${mdto}" var="md">
												<c:forEach items="${md.coupon}" var="cou">
													<span id="commcoupon"><c:out value="${cou.c_coupon}" /></span>
													<span id="commcoupon">~ <c:out value="${cou.c_date}" /></span>
													<c:if test="${cou.c_use=='N'}">
														<span id="commcoupon">미사용</span>
														<span id="commcoupon">없음</span>
													</c:if>
													<c:if test="${cou.c_use=='Y'}">
														<span id="commcoupon">사용됨</span>
														<span id="commcoupon"><c:out
																value="${cou.reservation.pub.p_title}" /></span>
													</c:if>
												</c:forEach>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<span id="nocoupon">사용가능한 쿠폰이 없습니다.</span>
										</c:otherwise>
									</c:choose>

								</div>
							</div>
						</div>
					</c:when>


					<c:when test="${mdto[0].userchk=='S'}">
						<div class="main_bot_comm">
							<div id="first_head" class="main_bot_head">예약 현황</div>
							<div id="reservation_proc">

								<div id="span_comm">
									<span id="sellreserv">신청인</span> <span id="sellreserv">예약 날짜</span> <span
										id="sellreserv">예약 시간</span> <span id="sellreserv">예약 인원</span><span
										id="sellreserv">쿠폰 유무</span> <span id="sellreserv">수락여부</span>
								</div>
								<div id="span_comm">
									<c:choose>
										<c:when
											test="${sellreserv[0].p_pub_chk=='N' || sellreserv[0].p_pub_chk==null}">
											<span id="nocoupon">PUB 등록을 해주십시오</span>
										</c:when>
										<c:when
											test="${sellreserv[0].p_pub_chk=='Y' && sellreserv[0].reservation[0].res_num!=null}">
											<c:forEach items="${sellreserv}" var="sell">
												<c:forEach items="${sell.reservation}" var="sellres">
												<c:if test="${sellres.res_sellcheck=='N'}">
														<span id="sellreserv"><c:out
																value="${sellres.members.name}" /></span>
														<span id="sellreserv"><c:out
																value="${sellres.res_date}" /></span>
														<span id="sellreserv"><c:out
																value="${sellres.res_time}" /></span>
														<span id="sellreserv"><c:out
																value="${sellres.res_people}" /></span>
														<c:choose>
															<c:when test="${sellres.c_num!=0}">
																<span id="sellreserv"><c:out
																		value="${sellres.coupon.c_contents}" /></span>
															</c:when>
															<c:otherwise>
																<span id="sellreserv">미사용</span>
															</c:otherwise>
														</c:choose>
														<span id="sellreserv"> <input type="hidden"
															value="${sellres.c_num}" id="reserv_cnum">
															<button id="sellallow_btn" value="${sellres.res_num}">수락</button>
															<button id="sellcanncle_btn" value="${sellres.res_num}">거부</button>
														</span>
														</c:if>
												</c:forEach>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<span id="nocoupon">예약이 없습니다</span>
										</c:otherwise>
									</c:choose>

								</div>
							</div>
						</div>
						<div class="main_bot_comm">
							<div id="second_head" class="main_bot_head">쿠폰</div>
							<div id="cuscoupon_proc">

									<div id="span_comm">
									<span id="commcoupon">쿠폰 이름</span> <span id="commcoupon">남은기간</span>
									<span id="commcoupon">사용 여부</span><span id="commcoupon">사용처</span>

								</div>
								<div id="span_comm">

									<c:choose>
										<c:when test="${mdto[0].coupon[0].c_num!=null}">
											<c:forEach items="${mdto}" var="md">
												<c:forEach items="${md.coupon}" var="cou">
													<span id="commcoupon"><c:out value="${cou.c_coupon}" /></span>
													<span id="commcoupon">~ <c:out value="${cou.c_date}" /></span>
													<c:if test="${cou.c_use=='N'}">
														<span id="commcoupon">미사용</span>
														<span id="commcoupon">없음</span>
													</c:if>
													<c:if test="${cou.c_use=='Y'}">
														<span id="commcoupon">사용됨</span>
														<span id="commcoupon"><c:out
																value="${cou.reservation.pub.p_title}" /></span>
													</c:if>
												</c:forEach>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<span id="nocoupon">사용가능한 쿠폰이 없습니다.</span>
										</c:otherwise>
									</c:choose>

								</div>
							</div>
						</div>
					</c:when>
				</c:choose>

			</div>
			<!-- End main_bot -->
		</div>
		<!-- End MainMenu -->
	</div>
	<!-- End Full_Sub -->
	<!-- </div>  -->
	<!-- End Full -->

	<!-- 	<div class="header footer"></div> -->
</body>
</html>