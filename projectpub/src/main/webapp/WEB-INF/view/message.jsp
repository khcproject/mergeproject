<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<link rel="stylesheet" href="css/reset.css" />
<link rel="stylesheet" href="css/message.css?ver=2" />
<script type="text/javascript" src="js/message.js?ver=2"></script>
<link href="css/bootstrap.min.css" rel="stylesheet" />
<!-- <script type="text/javascript">
	var memid = "${memid}";
</script> -->
</head>
<body>
	<!-- <div class="header footer"></div> -->

	<!-- 	<div class="full">  -->
	<div class="full">
		<div class="sidemenu">

			<div class="page-header">
				<h2>&nbsp;&nbsp;&nbsp;쪽지함</h2>
			</div>
			<div id="write_message" class="common_btn">쪽지 보내기</div>
			<div id="response_message" class="common_btn">받은 쪽지함</div>
			<div id="send_message" class="common_btn">보낸 쪽지함</div>
		</div>
		<!-- End SideMenu -->

		<div class="mainmenu">

			<div class="head_ment">
				<span>${sessionScope.mem.id}님의 받은 쪽지함입니다.(읽지 않은 쪽지:?통)</span>
			</div>

			<div class="head_button">

				<button id="delete_btn">삭제</button>
				<button id="write_btn">쪽지 보내기</button>

			</div>
			<div class="table-message">

				<table class="table">
					<thead>
						<tr>
						</tr>
						<tr>
							<th width="60px" class="text-center"><input type="checkbox" class="allchk"  /></th>
							<th width="270px" class="text-center">제목</th>
							<th width="110px" class="text-center">보낸 이</th>
							<th width="190px" class="text-center">날짜</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${respMsg[0].t_num!=null}">
								<c:forEach items="${respMsg}" var="rm">
									<tr>
										<td width="60px" class="text-center"><input
											type="checkbox" class="chk" value="${rm.t_num}"/></td>
											<c:url var="viewPage" value="viewmsg.do">
											<c:param name="t_num" value="${rm.t_num}"/>
										<%-- 	<c:param name="id" value="${memid}"/> --%>
											</c:url>
										<td width="270px" class="text-center"><a href="${viewPage}">${rm.t_title}</a></td>
										<td width="110px" class="text-center">${rm.id}</td>
										<td width="190px" class="text-center">${fn:substringAfter(rm.t_date,"-")}</td>
									</tr>							

								</c:forEach>
								

							</c:when>
							<c:otherwise>
								<tr>
								<td></td>
									<td width="620px" class="text-center">받은 쪽지가 없습니다.</td>
								</tr>

							</c:otherwise>
						</c:choose>

					</tbody>
				</table>
				<hr />

				<div class="page_line">
				
				<c:choose>
				<c:when test="${pv!=null}">
				
				<!-- 이전  -->
					<c:if test="${pv.startPage>1}">
						<c:url var="prePage" value="gotomessage.do">
							<c:param name="currentPage" value="${pv.startPage-pv.blockPage}" />
							<c:param name="id" value="${memid}" />
						</c:url>
						<a href="${prePage}"><c:out value="이전" /></a>
					</c:if>

					<!-- 페이지 출력 시작 -->
					<c:forEach var="i" begin="${pv.startPage}" end="${pv.endPage}">
						<c:url var="currPage" value="gotomessage.do">
							<c:param name="currentPage" value="${i}" />
							<c:param name="id" value="${memid}" />
						</c:url>
						<a href="${currPage}"><c:out value="${i}" /></a>
					</c:forEach>
					<!-- 페이지 출력 끝 -->

					<!-- 다음 -->
					<c:if test="${pv.totalPage>pv.endPage}">
						<c:url var="nextPage" value="gotomessage.do">
							<c:param name="currentPage" value="${pv.startPage+pv.blockPage}" />
							<c:param name="id" value="${memid}" />
						</c:url>
						<a href="${nextPage}"><c:out value="다음" /></a>
					</c:if>
				</c:when>
				
				<c:otherwise>
				
				
					<!-- 이전  -->
					<c:if test="${spv.startPage>1}">
						<c:url var="prePage" value="searchmsg.do">
							<c:param name="currentPage" value="${spv.startPage-spv.blockPage}" />
							<c:param name="id" value="${memid}" />
							<c:param name="searchop" value="${searchop}"/>
							<c:param name="searchworld" value="${searchworld}"/>
							
						</c:url>
						<a href="${prePage}"><c:out value="이전" /></a>
					</c:if>

					<!-- 페이지 출력 시작 -->
					<c:forEach var="i" begin="${spv.startPage}" end="${spv.endPage}">
						<c:url var="currPage" value="searchmsg.do">
							<c:param name="currentPage" value="${i}" />
							<c:param name="id" value="${memid}" />
							<c:param name="searchop" value="${searchop}"/>
							<c:param name="searchworld" value="${searchworld}"/>
						</c:url>
						<a href="${currPage}"><c:out value="${i}" /></a>
					</c:forEach>
					<!-- 페이지 출력 끝 -->

					<!-- 다음 -->
					<c:if test="${spv.totalPage>spv.endPage}">
						<c:url var="nextPage" value="searchmsg.do">
							<c:param name="currentPage" value="${spv.startPage+spv.blockPage}" />
							<c:param name="id" value="${memid}" />
							<c:param name="searchop" value="${searchop}"/>
							<c:param name="searchworld" value="${searchworld}"/>
						</c:url>
						<a href="${nextPage}"><c:out value="다음" /></a>
					</c:if>
				
				</c:otherwise>
				</c:choose>


					
				</div>



				<div class="search_div">
					<form id="mesgfrm" method="get" action="searchmsg.do">
						<select id="searchop" name="searchop">
							<option value="subject">제목</option>
							<option value="contents">내용</option>
							<option value="subandcon">제목+내용</option>
							<option value="searchid">ID</option>
						</select> <input type="text" id="searchworld" name="searchworld" /> <input
							type="button" id="search_btn" value="검색" />
							<input type="hidden" name="id" value="${memid}">

					</form>
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