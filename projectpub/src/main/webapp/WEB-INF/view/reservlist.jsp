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
<link href="css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript">
	/* var mdto_id = "${mdto[0].id}"; */
	var currentPage = "${pv.currentPage}";
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

			<div class="page-header">
				<h1>&nbsp;예약리스트</h1>
			</div>

			<div class="table-reservation">

				<table class="table">
					<thead>
						<tr>
							<th class="text-center">신청인</th>
							<th class="text-center">예약 날짜</th>
							<th class="text-center">예약 시간</th>
							<th class="text-center">예약 인원</th>
							<th class="text-center">할인 쿠폰</th>
							<th class="text-center">수락 여부</th>
						</tr>
					</thead>
					<tbody>
						
							<c:choose>
								<c:when test="${sellreserv[0].reservation[0].res_num!=null}">
									<c:forEach items="${sellreserv}" var="sell">
										<c:forEach items="${sell.reservation}" var="sellres">
										<tr>
											<td class="text-center"><c:out
													value="${sellres.members.name}" /></td>
											<td class="text-center"><c:out
													value="${sellres.res_date}" /></td>
											<td class="text-center"><c:out
													value="${sellres.res_time}" /></td>
											<td class="text-center"><c:out
													value="${sellres.res_people}" /></td>
											<c:choose>
												<c:when test="${sellres.c_num!=0}">
													<td class="text-center"><c:out
															value="${sellres.coupon.c_contents}" /></td>
												</c:when>
												<c:otherwise>
													<td class="text-center">미사용</td>
												</c:otherwise>
											</c:choose>
											<c:choose>
												<c:when test="${sellres.res_sellcheck=='Y'}">
													<td class="text-center">예약중</td>
												</c:when>
												<c:when test="${sellres.res_sellcheck=='C'}">
													<td class="text-center">예약취소</td>
												</c:when>
												<c:otherwise>
													<td class="text-center"><input type="hidden"
														value="${sellres.c_num}" id="reserv_cnum">
														<button id="allsellallow_btn" value="${sellres.res_num}">수락</button>
														<button id="allsellcanncle_btn" value="${sellres.res_num}">거부</button>
													</td>
												</c:otherwise>
											</c:choose>
											</tr>
										</c:forEach>
									</c:forEach>
								</c:when>
								<c:otherwise>
								<tr>
								<td class="text-center" colspan="6">예약이 없습니다.</td>
								</tr>
								</c:otherwise>
							</c:choose>
						
					</tbody>
				</table>
				<hr/>

	<div class="col-md-2 col-md-offset-5">
	 
				<!-- 이전  -->
				<c:if test="${pv.startPage>1}">
					<c:url var="prePage" value="sellreservlist.do">
						<c:param name="currentPage" value="${pv.startPage-pv.blockPage}" />
						<c:param name="id" value="${mdto[0].id}" />
					</c:url>
					<a href="${prePage}"><c:out value="이전" /></a>
				</c:if>

				<!-- 페이지 출력 시작 -->
				<c:forEach var="i" begin="${pv.startPage}" end="${pv.endPage}">
					<c:url var="currPage" value="sellreservlist.do">
						<c:param name="currentPage" value="${i}" />
						<c:param name="id" value="${mdto[0].id}" />
					</c:url>
					<a href="${currPage}"><c:out value="${i}" /></a>
				</c:forEach>
				<!-- 페이지 출력 끝 -->

				<!-- 다음 -->
				<c:if test="${pv.totalPage>pv.endPage}">
					<c:url var="nextPage" value="sellreservlist.do">
						<c:param name="currentPage" value="${pv.startPage+pv.blockPage}" />
						<c:param name="id" value="${mdto[0].id}" />
					</c:url>
					<a href="${nextPage}"><c:out value="다음" /></a>
				</c:if>
				
				</div>
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