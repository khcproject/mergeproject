$(document).ready(function() {
	// 받은 쪽지함 버튼
	$('#response_message').on('click', function() {
		location.href = 'gotomessage.do?id=' + memid;
	});

	// 보낸 쪽지함 버튼
	$('#send_message').on('click', function() {
		location.href = 'sendmessage.do?id=' + memid;
	});

	// 쪽지 보내기 버튼
	$('#write_message').on('click', function() {
		location.href = 'writemessage.do?id=' + memid;
	});

	
	$('#write_btn').on('click',function(){
		location.href = 'writemessage.do?id=' + memid;
	});
	
	
	// 쪽지함 전체 체크
	$('.allchk').on('click', function() {
		$('.chk').prop('checked', this.checked);
	});

	// 받은 쪽지함 : 삭제 버튼
	$('#delete_btn').on('click', function() {
		var arr = new Array();
		$('.chk:checked').each(function(index, value) {
			arr[index] = $(value).val();
		});

		$.ajax({
			type : 'get',
			url : 'delmsg.do?data=' + arr,
			success : function(res) {
				location.href = 'gotomessage.do?id=' + memid;
			}
		});

	});

	// 받은 쪽지함 : 검색 버튼
	$('#search_btn').on('click', function() {
		if ($('#searchworld').val() == '') {
			alert("검색어를 입력해주세요");
			return false;
		}

		$('#mesgfrm').submit();
	});

	// 받은 쪽지함 뷰 : 리스트 버튼
	$('#gotomsg_btn').on('click', function() {
		location.href = 'gotomessage.do?id=' + memid;
	});
	// 받은 쪽지함 뷰 : 삭제 버튼
	$('#delmesg_btn').on('click', function() {
		var result = confirm('정말로 삭제 하시겠습니까?');
		if (result == true) {
			$('#viewfrm').attr('action', 'viewmsg.do').submit();
		} else {
			return false;
		}
	});

	// 보낸 쪽지함 뷰 : 리스트 버튼
	$('#sendgotomsg_btn').on('click', function() {
		location.href = 'sendmessage.do?id=' + memid;
	});

	// 보낸 쪽지함 뷰 : 삭제 버튼
	$('#senddelmesg_btn').on('click', function() {
		var result = confirm('정말로 삭제 하시겠습니까?');
		if (result == true) {
			$('#viewfrm').attr('action', 'sendviewmsg.do').submit();
		} else {
			return false;
		}
	});

	// 받은 쪽지함 뷰 : 답장쓰기 버튼
	$('#rewrite_btn').on('click', function() {
		$('#viewfrm').attr({
			action : 'reviewmsg.do',
			method : 'get'
		}).submit();
	});

	// 보낸 쪽지함 : 삭제 버튼
	$('#senddelete_btn').on('click', function() {
		var arr = new Array();
		$('.chk:checked').each(function(index, value) {
			arr[index] = $(value).val();
		});

		$.ajax({
			type : 'get',
			url : 'senddelmsg.do?data=' + arr,
			success : function(res) {
				location.href = 'sendmessage.do?id=' + memid;
			}
		});

	});

	// 보낸 쪽지함 : 검색버튼
	$('#sendsearch_btn').on('click', function() {
		if ($('#searchworld').val() == '') {
			alert("검색어를 입력해주세요");
			return false;
		}

		$('#sendmesgfrm').submit();
	});

	// 쪽지 쓰기 : 취소 버튼
	$('#writecancle_btn').on('click', function() {
		history.back();
	});
	// 쪽지 쓰기 : 전송 버튼
	$('#writeok_btn').on('click', function() {
		$('#writefrm').attr('action', 'writemessage.do').submit();
	});

});// end document.ready/////////////

