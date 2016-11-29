$(document)
		.ready(
				function() {
					// 리플 삭제
					$(document).on('click', '.reply_del', reply_DeleteLlist);

					$('.btnRes').bind('click', function() {
						alert('asdfasf');
	
						var IMP = window.IMP; // 생략가능
						IMP.init('imp68404030'); // 'iamport' 대신 부여받은 "가맹점
													// 식별코드"를
						// 사용
						IMP.request_pay({
						    pg : 'html5_inicis',
						    pay_method : 'phone',
						    merchant_uid : 'merchant_' + new Date().getTime(),
						    name : '주문명:결제테스트',
						    amount : 100,
						    buyer_email : 'iamport@siot.do',
						    buyer_name : '구매자이름',
						    buyer_tel : '010-1234-5678',
						    buyer_addr : '서울특별시 강남구 삼성동',
						    buyer_postcode : '123-456'
						}, function(rsp) {
						    if ( rsp.success ) {
						        var msg = '결제가 완료되었습니다.';
						        msg += '고유ID : ' + rsp.imp_uid;
						        msg += '상점 거래ID : ' + rsp.merchant_uid;
						        msg += '결제 금액 : ' + rsp.paid_amount;
						        msg += '카드 승인번호 : ' + rsp.apply_num;
						        $('#frm').attr('action', "pubview.do").submit();
						    } else {
						        var msg = '결제에 실패하였습니다.';
						        msg += '에러내용 : ' + rsp.error_msg;
						    }

						    alert(msg);
						});
						// 결재
						
					});
					
					// 댓글 달기
					$('#reply_commit').bind('click', function() {
						if ($('#re_content').val().length == 0) {
							alert('댓글을 입력해주세요');
						} else {
							reply_InsertLlist();
						}
					});
					// 수정
					$(document)
							.on(
									'click',
									'.reply_update',
									function() {
										if ($(this).text() == '수정') {

											$('.reply_content' + $(this).val())
													.replaceWith(
															'<input type="text" id="reply_content2" value="${reply.pr_content}"/>');
											/*
											 * $('#reply_content') .html( '<input
											 * type="text" id="reply_content2"
											 * value="${reply.pr_content}"/>');
											 */
											$(this).text('확인');

										} else if ($(this).text() == "확인") {
											// alert($(this).val());
											reply_UpdateLlist($(this).val());

										}

									})
								// 스타 인설트
					$('.star_input').mouseenter(function(){
				         star_rating();
				         $(this).mouseleave(function(){
				            // console.log(idx);
				            $('.star_input span:lt('+idx+'):even').addClass('over-left');
				            $('.star_input span:lt('+idx+'):odd').addClass('over-right');
				            $('div span').off();
				         });
				      });
					
					$('.star_input').bind('click', function(){
						pubStar_InsertLlist();
						});
				});

window.onload = function() {
	var list_zone = document.getElementById("slide_banner");
	var list_a = document.getElementsByTagName("a");
	$('list_a').click(function(e) {
		alert($(e.target).index());
	});

	for (var i = 0; i < list_a.length; i++) {
		list_a[i].onclick = function() {
			var ph = document.getElementById("photo").children[0];
			// alert(ph.nodeType + " , " + ph.nodeName);
			ph.src = this.href;
			return false; // <a>를 클릭했을 때 링크가 되지 않도록 한다.
		}
	}
}

// 별점 인설트
function pubStar_InsertLlist() {
	alert(typeof(Number($('.score').text())));
	$.ajax({
				type : 'POST',
				dataType : 'json',
				url : 'pubStarInsertList.do',
				data : 'p_num=' + param_p_num + '&s_stars='
						+ (idx/2),// Number($('.score').text()),
				success : starViewMessage,
				error : function(error) {
					alert(error);
				}
			});

}

function reply_InsertLlist() {
	$
			.ajax({
				type : 'POST',
				dataType : 'json',
				url : 'replyInsertList.do',
				data : 'p_num=' + param_p_num + '&pr_content='
						+ $('#re_content').val(),
				success : viewMessage,
				error : function(error) {
					alert(error);
				}
			});

}

function reply_UpdateLlist(e) {
	// alert(e);
	// alert($('#reply_content2').val());
	$.ajax({
		type : 'POST',
		dataType : 'json',
		url : 'replyUpdateList.do',
		data : 'p_num=' + param_p_num + '&pr_num=' + e + '&pr_content='
				+ $('#reply_content2').val(),
		success : viewMessage,
		error : function(error) {
			alert(error);
		}
	});

}

function reply_DeleteLlist() {
	// alert($(this).val());
	$.ajax({
		type : 'POST',
		dataType : 'json',
		url : 'replyDeleteList.do',
		data : 'p_num=' + param_p_num + '&pr_num=' + $(this).val(),
		success : viewMessage,
		error : function(error) {
			alert(error);
		}
	});

}

function process() {
	$('[name=content]').val($('[name=content]').val().replace(/\n/gi, '<br/>'));
	return true;
}

// 별점시작

	function star_rating() {
		$('div span').removeClass('over-left');
		$('div span').removeClass('over-right');
		$('div span').mouseenter(
				function(e) {
					var i = $(e.target).index() + 1;
					var score = (i / 2).toFixed(1);
					$('.score').text(score+'점');
					idx = i;
					$('.star_input span:lt(' + i + '):even').addClass(
							'over-left');
					$('.star_input span:lt(' + i + '):odd').addClass(
							'over-right');
				}).mouseleave(
				function(e) {
					var i = $(e.target).index() + 1;
					idx=i;
					$('.star_input span:lt(' + i + '):even')
							.removeClass('over-left');
					$('.star_input span:lt(' + i + '):odd')
							.removeClass('over-right');
				});
	}
// 별점 끝

// 별점 띄우기
function star_view(s){
	   // 추후 해당 축제 별점 수를 가져와서 나눠주는 걸로 바꿀 것
	   star2=s/2;// 별 평점
	   var star=s;
	   var star_half=(s*0.5-star).toFixed(2);
	   if(star!=0){
	   for(var i=1;i<=star;i++){
	      $('.starview').append('<img src="images/star1.png" width="30px" height="30px">');
	   }
	   if(star_half>=0.5){
	      $('.starview').append('<img src="images/star0.5.png" width="30px" height="30px">');
	   }
	   }else{
	      for(var i=1;i<=5;i++){
	         $('.starview').append('<img src="images/star0.png" width="30px" height="30px">');
	      }
	   }
	}
	

// 별점 띄우기 끝
