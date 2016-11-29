$(document).ready(function(){
		/* alert($(this).text()); */
		$('.currentPage').on('click',function(){
			$.ajax({
				type:'GET',
				dataType:'json',
				url:'lookat2.do?currentPage='+$(this).text(),
				success: viewMessage,
			});
		});
		
		$('#btn').on('click',function(){
			$.ajax({
				type:'GET',
				dataType:'json',
				url:'search.do?search='+$('#search-con').val(),
				success:viewMessage2,
			});
		});
		
		$(document).on('click','#currentPage',function(){
			$.ajax({
				type:'GET',
				dataType:'json',
				url:'search2.do?currentPage='+$(this).text(),
				success: viewMessage3,
			});
		})
		
		$('#select').change(function(){
			$.ajax({
				type:'GET',
				dataType:'json',
				url:'search.do?search='+$('#select option:selected').val(),
				success:viewMessage2,
			});
		});
		
		$(document).on('click','#ok',function(){
			location.href="managero.do?id="+$(this).val();
		});
		
		$(document).on('click','#can',function(){
			location.href="managerc.do?id="+$(this).val();
		});
		
		$(document).on('click','#pok',function(){
			location.href="managerpo.do?id="+$(this).val();
		});
		
		$(document).on('click','#pcan',function(){
			location.href="managerpc.do?id="+$(this).val();
		});
		$(document).on('click','#pubpre',function(){
			location.href="pubpre.do?id="+$(this).val();
		});
	
		
});
function viewMessage(data){
	$('#rec-con').empty();
	$('#rec-con').append('<table>')	
   		$.each(data, function(index, value) {
   			$('#rec-con').append('<div id="test"><img src="\\projectpubs\\temp//'+value.p_mupload+'"style="width:212px; height:274px; " alt="사진1" /><a>Pub집 이름 : '+value.p_title+'</a></br><a>Pub집 주소 : '+value.p_address+'</a></br><a>최대인원 : '+value.p_maxpeople+'</a></br><a>별점 : 아직</a></div>');
   		});
   	$('#rec-con').append('</table>')
};
/*$('#rec-con').append('<img src="\\projectpubs\\temp//'+value.p_mupload+'"style="width:212px; height:274px; " alt="사진1" /><a>Pub집 이름 : '+value.p_title+'</a></br><a>Pub집 주소 : '+value.p_address+'</a></br><a>최대인원 : '+value.p_maxpeople+'</a></br><a>별점 : 아직</a></div>');	
*/
function viewMessage2(data){
	var a ='';
	for (var int = data.pv.startPage; int <= data.pv.endPage; int++) {
		a=a +'<a id="currentPage">'+int+'</a>';
	}
	alert(a);
	
	$('#rec-con').empty();
	$('#rec-con').append('<table>')	;
	$.each(data.you, function(index, value) {
		$('#rec-con').append('<div id="test"><img src="\\projectpubs\\temp//'+value.p_mupload+'"style="width:212px; height:274px; " alt="사진1" /><a>Pub집 이름 : '+value.p_title+'</a></br><a>Pub집 주소 : '+value.p_address+'</a></br><a>최대인원 : '+value.p_maxpeople+'</a></br><a>별점 : 아직</a></div>');
		});
	$('#rec-con').append('</table>');

	$('#rec-num').empty();
	$('#rec-num').append(a);
	
}

function viewMessage3(data){
	alert("asdasd");
	$('#rec-con').empty();
	$('#rec-con').append('<table>')	
   		$.each(data, function(index, value) {
   			$('#rec-con').append('<div id="test"><img src="\\projectpubs\\temp//'+value.p_mupload+'"style="width:212px; height:274px; " alt="사진1" /><a>Pub집 이름 : '+value.p_title+'</a></br><a>Pub집 주소 : '+value.p_address+'</a></br><a>최대인원 : '+value.p_maxpeople+'</a></br><a>별점 : 아직</a></div>');
   		});
   	$('#rec-con').append('</table>');
}

	


