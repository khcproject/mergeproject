<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Fixed Top Navbar Example for Bootstrap</title>

<!-- Custom styles for this template -->
<link href="css/dashboard.css" rel="stylesheet">
<script type="text/javascript">

</script>


</head>

<body>

	<!-- Fixed navbar -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">

			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="mainview.do">The Pub</a>
			</div>

			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-left">
					<li><a href="notice.do">공지사항</a></li>
					<li><a href="lookat.do">PUB 소개/예약</a></li>
					<li><a href="event.do">이벤트</a></li>
					<li><a href="social.do">자유게시판</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
				<c:choose>
				<c:when test="${mem!=null}">
				<li><a href="mypage.do?id=cus">마이페이지</a></li>
				<li><a href="logout.do">로그아웃</a></li>
				</c:when>
				<c:otherwise>
				<li><a href="login.do">로그인</a>
				</c:otherwise>
				</c:choose>
				
				</ul>
				<form class="navbar-form navbar-right">
					<input type="text" class="form-control" placeholder="Search...">
				</form>
			</div>
		</div>
	</nav>

</body>
</html>
