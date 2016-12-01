<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>	
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<meta name="description" content="">
<meta name="author" content="">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>

<!-- 초기화 리셋 -->
<link rel="stylesheet" type="text/css" href="css/reset.css" media="all" />

<!-- icon -->
<link rel="icon" href="../../favicon.ico">
<!-- Bootstrap -->
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap theme CSS -->
<link href="css/bootstrap-theme.min.css" rel="stylesheet">

<!-- jquery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Bootstrap script -->
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">


</script>

</head>
<style>
* {
	margin: 0px;
}
/* 이새끼가 wrap이라고 생각하면 된다.*/
section {
	background-color: white;
	width: 100%;
}

html {
	position: relative;
	min-height: 100%;
}

body {
	margin-bottom: 60px;
}

.footer {
	position: absolute ;
	bottom: 0px;
	width: 100%;
	/* Set the fixed height of the footer here */
	height: 100px;
	background-color: black;
}
</style>
<body>
	<header>
		<div>
			<tiles:insertAttribute name="header" />
		</div>
	</header>




	<section>
		<div>
			<tiles:insertAttribute name="body" />
		</div>
	</section>


	<footer>
		<div>
			<tiles:insertAttribute name="footer" />
		</div>
	</footer>
	

</body>
</html>