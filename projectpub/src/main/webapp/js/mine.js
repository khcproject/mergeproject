$(document).ready(function() {
	// 구매자 예약 취소 버튼
	$(document).on('click', '#cuscancle_btn', delcusreserv);
	// 판매자 예약 수락 버튼
	$(document).on('click', '#sellallow_btn', ablereserv);
	// 판매자 예약 취소 버튼
	$(document).on('click', '#sellcanncle_btn', disablereserv);
	// 회원정보 수정 버튼
	$(document).on('click', '#update_profile', memuptint);
	// 회원탈퇴 버튼
	$('#leave').on('click',leaveready);
	// 판매자 신청 버튼
	$('#join_sell').on('click',joinsell);
	//PUB 등록 신청 버튼
	$('#need_pub').on('click',joinpubready);
	//판매자 : 예약리스트 버튼
	$('#reserv_list').on('click',reservalllist);
	//PUB 수정 버튼
	$('#update_pub').on('click',updatepub);
	//쪽지함 버튼
	$('#mypage_message').on('click',gotomessage);
	
	
	
	// ///////////회원정보 수정 페이지 /////////////////
	// 취소 버튼
	$('#uptcanclebtn').on('click', function() {
		history.go(-2);
	});
	// 수락 버튼
	$('#uptokbtn').on('click', memuptok);
	// 이미지파일 바로보기
	//file 양식으로 이미지를 선택(값이 변경) 되었을때 처리하는 코드
	$('#inputFace').change(function(){
		imgchange(this);
	});
	
	////////////////회원정보  PW 확인 페이지 ////////////
	// 취소 버튼
	$('#pwcanclebtn').on('click',function(){
		history.back();
	});
	// 수락 버튼
	$('#pwokbtn').on('click',pwokproc);
	
	////////////////회원탈퇴 페이지///////////////////
	// 취소 버튼
	$('#delmemcanclebtn').on('click',function(){
		history.back();
	});
	// 탈퇴 버튼
	$('#delmembtn').on('click',function(){
		var result = confirm('정말로 탈퇴하시겠습니까?');
		if(result==true){
			$('#leaveus').attr('action','leaveus.do').submit();	
		}else{
			return false;
		}
	});

	/////////////판매자 신청 페이지/////////////////////
	// 취소 버튼
	$('#nscanclebtn').on('click',function(){
		history.back();
	});
	// 신청 버튼
	$('#nsbtn').on('click',joinsellok);

	////////////PUB 등록 신청 페이지////////////////////
	// 이미지파일 바로보기
	$('#jppub_supload').change(function(){
		jpsimgchange(this);
	});
	// 취소 버튼
	$('#jpcanclebtn').on('click',function(){
		history.back();
	});
	// 신청 버튼
	$('#jpbtn').on('click',joinpubok);
	// 다중 이미지 파일 바로보기
	$('#jppub_mupload').on('change',function(){
		jpmimgchange(this);
	});
	
	//////////판매자 총 예약 리스트 페이지//////////////////
	// 수락 버튼
	$(document).on('click','#allsellallow_btn',sellreservok);
	// 취소 버튼
	$(document).on('click','#allsellcanncle_btn',sellreservno);
	
	/////////PUB 수정 페이지//////////////////
	// 이미지파일 바로보기
	$('#uppub_supload').change(function(){
		upsimgchange(this);
	});
	// 다중 이미지 파일 바로보기
	$('#uppub_mupload').change(function(){
		upmimgchange(this);
	});
	// 취소 버튼
	$('#upcanclebtn').on('click',function(){
		history.back();
	});
	// 수락 버튼
	$('#upbtn').on('click',uptpubok);
	
	
});// end document.ready/////////////

function delcusreserv() {
	$.ajax({
		type : 'POST',
		dataType : 'text',
		url : 'delcusreserv.do',
		data : 'res_num=' + $(this).val() + '&id=' + mdto_id,
		success : function() {
			location.href = 'mypage.do';
		},
		error : function(xhr, textStatus, error) {
			alert(xhr.stauts + "," + textStatus + "," + error);
		}
	});
};// end delcusreserv()////////////

function ablereserv() {
	$.ajax({
		type : 'POST',
		dataType : 'text',
		url : 'ablereserv.do',
		data : 'res_num=' + $(this).val()+'&c_num='+$('#reserv_cnum').val(),
		success : function() {
			location.href = 'mypage.do';
		},
		error : function(xhr, textStatus, error) {
			alert(xhr.stauts + "," + textStatus + "," + error);
		}
	});

};// end ablereserv()////////////

function disablereserv() {
	$.ajax({
		type : 'POST',
		dataType : 'text',
		url : 'disablereserv.do',
		data : 'res_num=' + $(this).val(),
		success : function() {
			location.href = 'mypage.do';
		},
		error : function(xhr, textStatus, error) {
			alert(xhr.stauts + "," + textStatus + "," + error);
		}
	});

};// end disablereserv()////////////


function memuptint() {
	location.href = 'memberupt.do';
};// end memuptint()/////////////

function memuptok() {

	var newPassword1 = $('#inputPassword').val();
	var newPassword2 = $('#inputPasswordCheck').val();

	// 재입력 일치 여부
	if (newPassword1 != newPassword2) {
		alert("입력한 두 개의 비밀번호가 서로  일치하지 않습니다.");
		return false;
	}

	// 길이
	if (!/^[a-zA-Z0-9!@#$%^&*()?_~]{6,15}$/.test(newPassword1)) {
		alert("비밀번호는 숫자, 영문, 특수문자 조합으로 6~15자리를 사용해야 합니다.");
		return false;
	}

	// 영문, 숫자, 특수문자 2종 이상 혼용
	var chk = 0;
	if (newPassword1.search(/[0-9]/g) != -1)
		chk++;
	if (newPassword1.search(/[a-z]/ig) != -1)
		chk++;
	if (newPassword1.search(/[!@#$%^&*()?_~]/g) != -1)
		chk++;
	if (chk < 2) {
		alert("비밀번호는 숫자, 영문, 특수문자를 두가지이상 혼용하여야 합니다.");
		return false;
	}

	// 동일한 문자/숫자 4이상, 연속된 문자
	if (/(\w)\1\1\1/.test(newPassword1) || isContinuedValue(newPassword1)) {
		alert("비밀번호에 4자 이상의 연속 또는 반복 문자 및 숫자를 사용하실 수 없습니다.");
		return false;
	}

	// 아이디 포함 여부
	if (newPassword1.search(mdto_id) > -1) {
		alert("ID가 포함된 비밀번호는 사용하실 수 없습니다.");
		return false;
	}

	// 기존 비밀번호와 새 비밀번호 일치 여부
	if (mdto_pw == newPassword2) {
		alert("기존 비밀본호와 새 비밀번호가 일치합니다.");
		return false;
	}

	$('#frm').attr('action', 'memberupdate.do').submit();
}// end memuptok()//////////

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


function imgchange(input) {
	var ext = $(input).val().split('.').pop().toLowerCase(); // 확장자

	// 배열에 추출한 확장자가 존재하는지 체크
		if ($.inArray(ext, [ 'gif', 'png', 'jpg', 'jpeg' ]) == -1) {
		alert('이미지 파일이 아닙니다! (gif, png, jpg, jpeg 만 업로드 가능)');
		$('#inputFace').val('');
		return false;
	} 
		
		 if (input.files && input.files[0]) {
		        var reader = new FileReader(); //파일을 읽기 위한 FileReader객체 생성
		        reader.onload = function (e) {
		        //파일 읽어들이기를 성공했을때 호출되는 이벤트 핸들러
		            $('#face_show').attr('src', e.target.result);
		            //이미지 Tag의 SRC속성에 읽어들인 File내용을 지정
		            //(아래 코드에서 읽어들인 dataURL형식)
		        }                   
		        reader.readAsDataURL(input.files[0]);
		        //File내용을 읽어 dataURL형식의 문자열로 저장
		    }
		
};//end imgchange()/////////////

function pwokproc(){
	var passchk = $('#findPassword').val();

	if(mdto_pw == passchk){
		$('#pwfrm').submit();
	}else{
		alert("패스워드가 일치 하지 않습니다. 다시 입력해주세요.");
		$('#findPassword').val('');
		return false;
	}
	
};//end pwokproc()//////////


function leaveready(){
	location.href = 'leaveready.do';

};//end leaveready()////////////

function joinsell(){
	if(mdto_allow_chk=='R'){
		alert("현재 신청중입니다.");
		return false;
	}
	location.href = 'joinseller.do';
};//end joinsell()////////////

function joinsellok(){
	if($('#nsSaupja_num').val()==''){
		alert("사업자 번호를 입력을 해주세요");
		return false;
	}
	
	if($('#rb1').is(":checked")==false){
		alert("약관에 동의해주십시오.")
		return false;
	};
	
	$('#nsfrm').attr('action','joinseller.do').submit();
};//end joinsellok()////////////

function joinpubready(){
	if(pub_chk=='R'){
		alert("현재 신청중입니다.");
		return false;
	}
	location.href = 'joinpub.do';
};//end joinpubready()///////////


function jpsimgchange(input) {
	var ext = $(input).val().split('.').pop().toLowerCase(); // 확장자

	// 배열에 추출한 확장자가 존재하는지 체크
		if ($.inArray(ext, [ 'gif', 'png', 'jpg', 'jpeg' ]) == -1) {
		alert('이미지 파일이 아닙니다! (gif, png, jpg, jpeg 만 업로드 가능)');
		$('#jppub_supload').val('');
		return false;
	} 
		
		 if (input.files && input.files[0]) {
		        var reader = new FileReader(); //파일을 읽기 위한 FileReader객체 생성
		        reader.onload = function (e) {
		        //파일 읽어들이기를 성공했을때 호출되는 이벤트 핸들러
		            $('#jpsubface_show').attr('src', e.target.result);
		            //이미지 Tag의 SRC속성에 읽어들인 File내용을 지정
		            //(아래 코드에서 읽어들인 dataURL형식)
		        }                   
		        reader.readAsDataURL(input.files[0]);
		        //File내용을 읽어 dataURL형식의 문자열로 저장
		    }
		
};//end imgchange()/////////////

function showKeyCode(event) {
	event = event || window.event;
	var keyID = (event.which) ? event.which : event.keyCode;
	if( ( keyID >=48 && keyID <= 57 ) || ( keyID >=96 && keyID <= 105 ) )
	{
		return;
	}
	else
	{
		return false;
	}
};//end showKeyCode()///////



function sample6_execDaumPostcode() {
	new daum.Postcode(
			{
				oncomplete : function(data) {
					// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

					// 각 주소의 노출 규칙에 따라 주소를 조합한다.
					// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
					var fullAddr = ''; // 최종 주소 변수
					var extraAddr = ''; // 조합형 주소 변수

					// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
					if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
						fullAddr = data.roadAddress;

					} else { // 사용자가 지번 주소를 선택했을 경우(J)
						fullAddr = data.jibunAddress;
					}

					// 사용자가 선택한 주소가 도로명 타입일때 조합한다.
					if (data.userSelectedType === 'R') {
						//법정동명이 있을 경우 추가한다.
						if (data.bname !== '') {
							extraAddr += data.bname;
						}
						// 건물명이 있을 경우 추가한다.
						if (data.buildingName !== '') {
							extraAddr += (extraAddr !== '' ? ', '
									+ data.buildingName : data.buildingName);
						}
						// 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
						fullAddr += (extraAddr !== '' ? ' (' + extraAddr
								+ ')' : '');
					}

					// 우편번호와 주소 정보를 해당 필드에 넣는다.
					document.getElementById('sample6_postcode').value = data.zonecode; //5자리 새우편번호 사용
					document.getElementById('sample6_address').value = fullAddr;

				}
			}).open();
};//end sample6_execDaumPostcode()////////////


function process() {
		$('[name=p_contents]').val(
				$('[name=p_contents]').val().replace(/\n/gi, '<br/>'));
		return true;
	};//end process()///////////////


function joinpubok(){
	alert("PUB 등록이 신청 되었습니다.")
	if($('#jppub_mupload')[0].files.length == 0){
		$('#jppub_mupload').removeAttr('name');
		$('#jpfrm').attr('action','joinpub.do').submit();
		$('#jppub_mupload').attr('name','filename');
	}else{
		$('#jpfrm').attr('action','joinpub.do').submit();	
	}
	
};//end joinpubok()///////////

function reservalllist(){
	location.href = 'sellreservlist.do';
};//end reservalllist()/////////////

function sellreservok(){
	$.ajax({
		type : 'POST',
		dataType : 'text',
		url : 'ablereserv.do',
		data : 'res_num=' + $(this).val()+'&c_num='+$('#reserv_cnum').val(),
		success : function() {
			location.href = 'sellreservlist.do?currentPage='+currentPage;
		},
		error : function(xhr, textStatus, error) {
			alert(xhr.stauts + "," + textStatus + "," + error);
		}
	});
};//end sellreservok()///////////////////

function sellreservno(){
	$.ajax({
		type : 'POST',
		dataType : 'text',
		url : 'disablereserv.do',
		data : 'res_num=' + $(this).val(),
		success : function() {
			location.href = 'sellreservlist.do?currentPage='+currentPage;
		},
		error : function(xhr, textStatus, error) {
			alert(xhr.stauts + "," + textStatus + "," + error);
		}
	});
};//end sellreservno()///////////

function gotomessage(){
	
		var popUrl = 'gotomessage.do';	
		var popOption = "width=780, height=500, resizable=no, scrollbars=no, top=200, left=600, status=no;";    
			window.open(popUrl,"",popOption);
	
};//end gotomessage()///////////


function jpmimgchange(input){
	
	var file = input.files;

	if (file.length == 0) {
		$('#jpmainpic').empty();
		return false;
	} else {
		$('#jpmainpic').empty();
	}

	for (var i = 0; i < file.length; i++) {
		if (!/\.(jpe?g|png|gif|jpg)$/i.test(file[i].name)) {
			alert("이미지 파일을 넣어주세요.");
			$(input).val("");
			return false;
		}
		var reader = new FileReader();
		reader.onload = function(event) {
			var img = new Image();
			img.src = event.target.result;
				img.width = 200;
				img.height = 150;
			$('#jpmainpic').append(img);
		};
		reader.readAsDataURL(file[i]);
	}

	return false;
};//end jpmimgchange()///////////

function updatepub(){
	location.href = 'updatepub.do';
};//end updatepub()////////

function upsimgchange(input){
	
	var ext = $(input).val().split('.').pop().toLowerCase(); // 확장자

	// 배열에 추출한 확장자가 존재하는지 체크
		if ($.inArray(ext, [ 'gif', 'png', 'jpg', 'jpeg' ]) == -1) {
		alert('이미지 파일이 아닙니다! (gif, png, jpg, jpeg 만 업로드 가능)');
		$('#uppub_supload').val('');
		return false;
	} 
		
		 if (input.files && input.files[0]) {
		        var reader = new FileReader(); //파일을 읽기 위한 FileReader객체 생성
		        reader.onload = function (e) {
		        //파일 읽어들이기를 성공했을때 호출되는 이벤트 핸들러
		            $('#upsubface_show').attr('src', e.target.result);
		            //이미지 Tag의 SRC속성에 읽어들인 File내용을 지정
		            //(아래 코드에서 읽어들인 dataURL형식)
		        }                   
		        reader.readAsDataURL(input.files[0]);
		        //File내용을 읽어 dataURL형식의 문자열로 저장
		    }
	
};//end upsimgchange()///////////

function upmimgchange(input){
	
	var file = input.files;

	if (file.length == 0) {
		$('#upmainpic').empty();
		return false;
	} else {
		$('#upmainpic').empty();
	}

	for (var i = 0; i < file.length; i++) {
		if (!/\.(jpe?g|png|gif|jpg)$/i.test(file[i].name)) {
			alert("이미지 파일을 넣어주세요.");
			$(input).val("");
			return false;
		}
		var reader = new FileReader();
		reader.onload = function(event) {
			var img = new Image();
			img.src = event.target.result;
				img.width = 200;
				img.height = 150;
			$('#upmainpic').append(img);
		};
		reader.readAsDataURL(file[i]);
	}

	return false;
	
};//end upmimgchange()////////////

function uptpubok(){
	alert("PUB 정보가 수정되었습니다.")
	if($('#uppub_mupload')[0].files.length == 0){
		$('#uppub_mupload').removeAttr('name');
		$('#upfrm').attr('action','updatepub.do').submit();
		$('#uppub_mupload').attr('name','filename');
	}else{
		$('#upfrm').attr('action','updatepub.do').submit();	
	}
};//end uptpubok()/////////////////
