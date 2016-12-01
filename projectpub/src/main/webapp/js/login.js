$(document)
		.ready(
				function() {
					// 로그인, 회원가입, 비밀번호 찾기 보여주는 뷰
					$('.tabs .tab').click(function() {
						if ($(this).hasClass('signin')) {
							// alert('signin');
							// $('.tabs .tab').removeClass('active');
							// $(this).addClass('active');
							$('.cont').hide();
							$('.signin-cont').show();
						}
						if ($(this).hasClass('signup')) {
							// alert('signup');
							// $('.tabs .tab').removeClass('active');
							// $(this).addClass('active');
							$('.cont').hide();
							$('.signup-cont').show();
						}
					});
					$('.passu').click(function() {
						// alert('맞냐?');
						$('.cont').hide();
						$('.pass-cont').show();
					});
					// 회원등록
					$('#submit1')
							.bind(
									'click',
									function() {
										// alert($('.birth').val());
										if (chk1 == '확인') {
											if ($('.pass1').val().length != 0) {

												if ($('.pass2').val().length != 0) {
													if ($('.pass1').val() == $(
															'.pass2').val()) {
														var newPassword1 = $(
																'.pass1').val();
														var chk3 = 0;

														// 영문, 숫자, 특수문자 2종 이상 혼용
														if (newPassword1
																.search(/[0-9]/g) != -1)
															chk3++;
														if (newPassword1
																.search(/[a-z]/ig) != -1)
															chk3++;
														if (newPassword1
																.search(/[!@#$%^&*()?_~]/g) != -1)
															chk3++;

														if (!/^[a-zA-Z0-9!@#$%^&*()?_~]{6,15}$/
																.test(newPassword1)) {
															$('.pass1').focus();
															$('.pass1').val('');
															$('.pass2').val('');
															alert('비밀번호를 다시 입력하세요.')
															return false;
														} else if (newPassword1
																.search($(
																		'#idchk')
																		.val()) > -1) {
															$('.pass1').focus();
															$('.pass1').val('');
															$('.pass2').val('');
															alert('비밀번호를 다시 입력하세요.')
															return false;

														} else if (chk3 < 2) {
															$('.pass1').focus();
															$('.pass1').val('');
															$('.pass2').val('');
															alert('비밀번호를 다시 입력하세요.')
															return false;

														} else if (/(\w)\1\1\1/
																.test(newPassword1)
																|| isContinuedValue(newPassword1)) {
															$('.pass1').focus();
															$('.pass1').val('');
															$('.pass2').val('');
															alert('비밀번호를 다시 입력하세요.');
															return false;

														} else {

															if ($('.email')
																	.val().length != 0) {
																if ($('.name')
																		.val().length != 0) {
																	if ($(
																			'.birth')
																			.val().length != 0) {

																		if (!($(
																				'#inpt23')
																				.val() == 'n')) {
																			if ($(
																					'.phone')
																					.val().length != 0) {
																				$(
																						'#meminsert')
																						.attr(
																								'action',
																								"memInsert.do")
																						.submit();
																			} else {
																				alert('핸드폰번호를 입력하세요.!!')
																				$(
																						'.phone')
																						.focus();
																				return false;
																			}
																		} else {
																			alert('성별을 선택하세요.!!')
																			$(
																					'#inpt23')
																					.focus();
																			return false;
																		}

																	} else {
																		alert('생년월일을 선택하세요.');
																		$(
																				'.birth')
																				.focus();
																		return false;
																	}
																} else {
																	alert('이름을 입력하세요.!!')
																	$('.name')
																			.focus();
																	return false;
																}
															} else {
																alert('이메일을 입력하세요.!!')
																$('.email')
																		.focus();

																return false;
															}
														}
													} else {
														alert('비밀번호가 일치하지 않습니다.!!')
														$('.pass2').focus();

														return false;

													}
												} else {
													alert('비밀번호 확인을 입력하세요.!!')
													$('.pass2').focus();
													return false;
												}

											} else {
												alert('비밀번호를 입력하세요.!!')
												$('.pass1').focus();
												return false;
											}
										} else {
											alert('아이디 중복확인을 해주세요.!!')
											$('.idchk').focus();
											return false;
										}
									});

					$('.idchk').bind('click', function() {
						var newId = $('#idchk').val();
						if (/^[a-zA-Z][a-zA-Z0-9_]{7,14}$/g.test(newId)) {
							idchk();
						} else {
							alert('아이디는 영문자로 시작하는 8~15자 영문자 또는 숫자이어야 합니다.')
						}

					});
					$(".pass2").keyup(function() {
						if ($('.pass2').val().length == 0) {
							$('#pass2').text('');
						} else if ($('.pass1').val() != $('.pass2').val()) {
							$('#pass2').text('');
							$('#pass2').html('비밀번호가 일치하지 않습니다.');
							$("#pass2").css("color", "red");
						} else {
							$('#pass2').text('');
							$('#pass2').html('비밀번호가 일치합니다.');
							$("#pass2").css("color", "green");
						}
					});

					$(".pass1")
							.keyup(
									function() {
										var newPassword1 = $('.pass1').val();
										var chk2 = 0;

										// 영문, 숫자, 특수문자 2종 이상 혼용
										if (newPassword1.search(/[0-9]/g) != -1)
											chk2++;
										if (newPassword1.search(/[a-z]/ig) != -1)
											chk2++;
										if (newPassword1
												.search(/[!@#$%^&*()?_~]/g) != -1)
											chk2++;

										// 길이
										if (!/^[a-zA-Z0-9!@#$%^&*()?_~]{6,15}$/
												.test(newPassword1)) {
											$('#pass1')
													.html(
															"비밀번호는 숫자, 영문, 특수문자 조합으로 6~15자리를 사용해야 합니다.");
											$("#pass1").css("color", "red");

										} else if (newPassword1.search($(
												'#idchk').val()) > -1) {
											$('#pass1')
													.html(
															"ID가 포함된 비밀번호는 사용하실 수 없습니다.");
											$("#pass1").css("color", "red");

										} else if (chk2 < 2) {
											$('#pass1')
													.html(
															"비밀번호는 숫자, 영문, 특수문자를 두가지이상 혼용하여야 합니다.");
											$("#pass1").css("color", "red");

										} else if (/(\w)\1\1\1/
												.test(newPassword1)
												|| isContinuedValue(newPassword1)) {
											$('#pass1')
													.html(
															"비밀번호에 4자 이상의 연속 또는 반복 문자 및 숫자를 사용하실 수 없습니다.");
											$("#pass1").css("color", "red");

										} else {
											$('#pass1').html('사용가능한 비밀번호 입니다.');
											$("#pass1").css("color", "green");
										}

									});

					// 로그인버튼
					$("#logbtn").bind('click', function() {
						// alert($('#logid').val());
						// alert($('#logpw').val());
						loginMethod();
					});

					// 비밀번호 찾기 인증버튼
					$("#pwfind_btn").bind('click', function() {
						// alert($('#pwfind_Id').val());
						// alert($('#pwfind_email').val());
						pwFindMethod();
					});

				});

function isContinuedValue(value) {
	console.log("value = " + value);
	var intCnt1 = 0;
	var intCnt2 = 0;
	var temp0 = "";
	var temp1 = "";
	var temp2 = "";
	var temp3 = "";

	for (var i = 0; i < value.length - 3; i++) {
		temp0 = value.charAt(i);
		temp1 = value.charAt(i + 1);
		temp2 = value.charAt(i + 2);
		temp3 = value.charAt(i + 3);

		if (temp0.charCodeAt(0) - temp1.charCodeAt(0) == 1
				&& temp1.charCodeAt(0) - temp2.charCodeAt(0) == 1
				&& temp2.charCodeAt(0) - temp3.charCodeAt(0) == 1) {
			intCnt1 = intCnt1 + 1;
		}

		if (temp0.charCodeAt(0) - temp1.charCodeAt(0) == -1
				&& temp1.charCodeAt(0) - temp2.charCodeAt(0) == -1
				&& temp2.charCodeAt(0) - temp3.charCodeAt(0) == -1) {
			intCnt2 = intCnt2 + 1;
		}
	}

	return (intCnt1 > 0 || intCnt2 > 0);
}// end isContinuedValue()//////

// ///////////////////////////////////
function idchk() {

	$.ajax({
		type : 'POST',
		dataType : 'text',
		url : 'idchk.do',
		data : 'id=' + $('#idchk').val(),
		success : idchkView,
		error : function(error) {
			alert(error);
		}
	});

}

function loginMethod() {
	$.ajax({
		type : 'POST',
		dataType : 'json',
		url : 'login.do',
		data : 'id=' + $('#logid').val() + '&pw=' + $('#logpw').val()+'&returnUrl='+returnUrl,
		success : function(data) {
			if (data.chk == null) {
				window.location.href = data.href;
			} else {
				alert(data.chk);
				return false;
			}
		},
		error : function(error) {
			alert(error);
		}
	});

}

function pwFindMethod() {
	// alert($('#pwfind_Id').val());
	// alert($('#pwfind_email').val());
	$.ajax({
		type : 'POST',
		dataType : 'json',
		url : 'pwfind.do',
		data : 'id=' + $('#pwfind_Id').val() + '&email='
				+ $('#pwfind_email').val(),
		success : function(data) {
			alert('왔섭?');
			if (data.no == null) {
				alert(data.ok)
				window.location.href = data.href;
			} else {
				alert(data.no);
				return false;
			}
		},
		error : function(error) {
			alert(error);
		}
	});

}
