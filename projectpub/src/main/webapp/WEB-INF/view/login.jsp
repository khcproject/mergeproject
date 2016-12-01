<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<link rel="stylesheet" type="text/css" href="css/reset.css" media="all" />
<link rel="stylesheet" type="text/css" href="css/cho2.css"
	media="all" />

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/login.js?ver=1" type="text/javascript"></script>

<script type="text/javascript">
	var returnUrl = "${param.returnUrl}";
	var chk1 = "";

	function idchkView(res) {
		if (res == 'false') {
			alert('사용가능한 아이디입니다.')
			$('.idchk').remove();
			$('#idchk').attr({
				"readonly" : ""
			});
			//{"readonly":"", ....}		
			chk1 = '확인';

		} else {
			$('#idchk').focus();
			$('#idchk').val('');
			alert('중복된 아이디입니다.');
		}
	}
</script>

</head>
<body>
<c:if test="${!empty param.returnUrl}">
<script>
 alert('로그인후 페이지 이동');
 </script>
</c:if>


	<div id="all">
		<div class="half" id="halfcon">
			<h1>The Pub</h1>
			<div class="tabs">
				<span class="tab signin active"><a href="#signin">로그인</a></span> <span
					class="tab signup"><a href="#signup">회원가입</a></span>
			</div>
			<div class="content">
				<div class="signin-cont cont">
					<form id="log" method="post">
						<input type="text" name="id" id="logid" class="inpt1"
							placeholder="아이디"> <input type="password" name="pw"
							id="logpw" class="inpt1" placeholder="비밀번호">
						<div class="submit-wrap">
							<input type="button" class="submit" id="logbtn" value="로그인" /> <span
								class="more passu">비밀번호 찾기!</span>
						</div>
					</form>
				</div>
				<div class="signup-cont cont">
					<form id="meminsert" method="post">
						<input type="text" name="id" class="inpt2" id="idchk"
							placeholder="아이디">
						<div id="chktool">
							<input type="button" class="idchk" value="중복확인" />
						</div>
						<input type="password" id="email" class="inpt2 pass1"
							placeholder="비밀번호"><span id="pass1" class="chkspan">비밀번호는
							숫자, 영문, 특수문자 조합으로 6~15자리를 사용해야 합니다.</span> <input type="password"
							name="pw" class="inpt2 pass2" placeholder="비밀번호 확인"> <span
							class="chkspan" id="pass2"></span> <input type="email"
							name="email" class="inpt2 email" placeholder="이메일"><span
							id="email" class="chkspan">※이메일인증을 해야 로그인이 가능합니다.</span> <input
							type="text" name="name" class="inpt2 name" placeholder="이름">
						<input type="date" name="birth" class="inpt2 birth"
							placeholder="이름"> <select id="inpt23" name="sex">
							<option value="n">성별</option>
							<option value="m">남자</option>
							<option value="f">여자</option>
						</select> <input type="text" name="phone" class="inpt2 phone"
							placeholder="핸드폰">
						<div class="submit-wrap">
							<input type="button" class="submit" id="submit1" value="등록하기" />
							<span class="more">Terms and conditions</span>
						</div>
					</form>
				</div>
				<div class="pass-cont cont">
					<form method="post" enctype="multipart/form-data">
						<input type="text" name="id" id="pwfind_Id" class="inpt1"
							placeholder="아이디"> <input type="email" name="email"
							id="pwfind_email" class="inpt1" placeholder="이메일">
						<div class="submit-wrap">
							<input type="button" class="submit" id="pwfind_btn" value="인증하기" />
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="half" id="imghalf">
			<img alt="사진1" src="images/11.jpg" style="width: 550px; height: 100%">
		</div>
	</div>


</body>
</html>