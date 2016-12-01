<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/cho.css?var=6"
	media="all" />
<link rel="stylesheet" type="text/css" href="css/reset.css" media="all" />

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript"
	src="https://service.iamport.kr/js/iamport.payment-1.1.2.js"></script>

<!-- 이 페이지 js태그 -->

<!-- <script type="text/javascript"
	src="//apis.daum.net/maps/maps3.js?apikey=5f36d925c282340ed90e3c7831cfc05&libraries=services"></script>
 -->
<script type="text/javascript"
	src="//apis.daum.net/maps/maps3.js?apikey=f9da77cfa3f6b638335a41d5c1941a32&libraries=services"></script>
<script src="js/reservation.js" type="text/javascript"></script>


<script type="text/javascript">
	var param_p_num = "${param.p_num}";
	var idx = 0;
	var session_id = "${sessionScope.mem.id}";
	var staravg = "${rdto[0].star.s_stars}";
	var logchk = "${sessionScope.chk}"

	function viewMessage(res) {
		$('#reply_12').empty();
		$
				.each(
						res,
						function(index, value) {
							$('#reply_12')
									.append(
											'<div id="reply_border"><span id="reply_id">'
													+ value.id
													+ '</span> <span class="reply_content'+value.pr_num+'" id="reply_content">'
													+ value.pr_content
													+ '</span><button class="reply_like" value="'+value.pr_num+'">'
													+ value.pr_like
													+ '</button> <button class="reply_update" value="'+value.pr_num+'" name="'+value.pr_num+'">수정</button><button class="reply_del" value="'+value.pr_num+'" name="'+value.pr_num+'">삭제</button>');

						});
		$('#re_content').val('');
	}

	//별점 띄워주는 제이쿼리
	function starViewMessage(res) {
		$('#star_all').empty();
		$('#star_all').append(
				'<div class="starview"></div><p>' + res.s_stars + '점</p>');
		var star = res.s_stars;
		star_view(star);

	}
	function star(res) {

	}
</script>

</head>
<body>
	<div id="all">
		<div id="bxpic">
			<div id="main_slide">
				<p id="photo">
					<img src="\projectpub\temp//${pubimg[0]}"
						style="width: 520px; height: 300px;" alt="사진1" />
				</p>
			</div>
			<ul id="slide_banner">
				<c:forEach items="${pubimg}" var="img">
					<li class="slide1"><a class="slide_sub"
						href="\projectpub\temp//${img}"><img
							src="\projectpub\temp//${img }" alt="사진"
							style="width: 120px; height: 80px" /></a></li>
				</c:forEach>

			</ul>
		</div>
		<div id="reservtion">
			<p id="res_title">예약안내,</p>
			<div class="res_body">

				<form id="frm" method="POST">
					<table>
						<tr>
							<td width="20%" align="center">날짜</td>
							<td><input id="reser_date" type="date" name="res_date"
								size="10" maxlength="20" /></td>
						</tr>

						<tr>
							<td width="20%" align="center">시간</td>
							<td><select id="reser_time" name="res_time">
									<option value="n">선택하세요</option>
									<option value="18:00">18:00</option>
									<option value="19:00">19:00</option>
									<option value="20:00">20:00</option>
									<option value="21:00">21:00</option>
									<option value="22:00">22:00</option>

							</select></td>
						</tr>
						<tr>
							<td width="20%" align="center">인원수</td>
							<td><select name="res_people" id="res_people">
									<c:forEach var="data" varStatus="status" begin="1"
										end="${rdto[0].p_maxpeople}" step="1">
										<option value="${data }">${data }</option>
									</c:forEach>
							</select></td>
						</tr>


						<tr>
							<td width="20%" align="center">사용할 쿠폰 :</td>
							<td><select name="c_num">
									<option value="없음">쿠폰 선택</option>
									<c:forEach items="${coupon }" var="co">
										<option value="${co.c_num}">${co.c_contents}</option>
									</c:forEach>
							</select></td>
						</tr>
					</table>
					<input type="hidden" name="p_num" value="${rdto[0].p_num}" /> <input
						type="button" class="btnRes" value="예약하기" /> <input type="hidden"
						name="id" value="${sessionScope.mem.id}" />

				</form>

			</div>

		</div>
		<div id="content">
			<!-- 별점 시작 -->
			<c:choose>
				<c:when test="${sessionScope.mem!=null}">
					<c:choose>
						<c:when test="${ss==null}">
							<div id="star_all">
								<div class="star_input">
									<span class="star"></span> <span class="star"></span> <span
										class="star"></span> <span class="star"></span> <span
										class="star"></span> <span class="star"></span> <span
										class="star"></span> <span class="star"></span> <span
										class="star"></span> <span class="star"></span>
								</div>
								<div>
									<span class="score"></span>
								</div>
							</div>
						</c:when>
						<c:otherwise>
							<!-- 별점 평균 및 띄워주기 -->
							<div id="starview"></div>
							<p>${rdto[0].star.s_stars}점</p>
						</c:otherwise>
					</c:choose>
				</c:when>
				<c:otherwise>
					<!-- 별점 평균 및 띄워주기 -->
					<div id="starview"></div>
					<p>${rdto[0].star.s_stars}점</p>
				</c:otherwise>
			</c:choose>


			<!-- 별점 끝-->
			<br>
			<p>설명충 : ${rdto[0].p_contents}</p>
			<p>예약최대인원 : ${rdto[0].p_maxpeople}</p>
			<p>주소 : ${rdto[0].p_address}</p>
		</div>

		<!-- 다음API 주소 입력시 장소 표시 및 마크까지 js로 넘기면 안됩니다.ㅠㅠㅠ-->
		<div id="map_wrap">

			<div id="map" style="width: 100%; height: 350px;"></div>

			<script>
				var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
				mapOption = {
					center : new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
					level : 3
				// 지도의 확대 레벨
				};

				// 지도를 생성합니다    
				var map = new daum.maps.Map(mapContainer, mapOption);

				// 주소-좌표 변환 객체를 생성합니다
				var geocoder = new daum.maps.services.Geocoder();

				// 주소로 좌표를 검색합니다
				geocoder
						.addr2coord(
								'${rdto[0].p_address}',
								function(status, result) {

									// 정상적으로 검색이 완료됐으면 
									if (status === daum.maps.services.Status.OK) {

										var coords = new daum.maps.LatLng(
												result.addr[0].lat,
												result.addr[0].lng);

										// 결과값으로 받은 위치를 마커로 표시합니다
										var marker = new daum.maps.Marker({
											map : map,
											position : coords
										});

										// 인포윈도우로 장소에 대한 설명을 표시합니다
										var infowindow = new daum.maps.InfoWindow(
												{
													content : '<div style="width:150px;text-align:center;padding:6px 0;">${rdto[0].p_title}</div>'
												});
										infowindow.open(map, marker);

										// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
										map.setCenter(coords);
									}
								});
			</script>
		</div>
		<div id="comment">
			<div id="scomment">
				<p style="font-size: 18pt;">댓글</p>
				<form id="reply_form" action="view.do" method="post"
					enctype="application/x-www-form-urlencoded">
					<p id="comment_id" style="font-size: 15pt;">아이디</p>
					<input type="text" name="pr_content" id="re_content" /> <input
						id="reply_commit" type="button" value="댓글달기" /> <input
						type="hidden" name="p_num" value="${param.p_num}" />
				</form>
				<div id="reply_12">
					<c:forEach items="${rdto[0].reply}" var="reply">
						<div id="reply_border">
							<span id="reply_id">${reply.id }</span> <span
								class="reply_content${reply.pr_num}" id="reply_content">${reply.pr_content }</span>
							<button class="reply_like" value="${reply.pr_num}">${reply.pr_like}</button>
							<button class="reply_update" value="${reply.pr_num}"
								name="pr_num">수정</button>
							<button class="reply_del" value="${reply.pr_num}" name="pr_num">삭제</button>

						</div>

					</c:forEach>

				</div>

			</div>
		</div>
	</div>



</body>
</html>