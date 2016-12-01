<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/manager.css">
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.css">
<script src="http://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="//cdn.jsdelivr.net/morris.js/0.5.1/morris.min.js"></script>
<script src="js/aja.js?ver=1"></script>
</head>
<body>
<c:if test="${sessionScope.userchk=='C' || sessionScope.userchk=='S'}">
<script>
 alert('권한이 없습니다.');
 location.href="mypage.do";
 </script>
</c:if>

		<div id="content">	

			<div id="view">
			
				<div id="ex">
					
					<div id="tt" style="width:1100px; height:50px;">
						<a href="/projectpubs" style="margin-left:475px;">The Pub</a><a style="margin-left:200px;">관리자 페이지</a>
					</div>
				
					<div id="cal" style="width: 1000px; height:250px; float:left;"></div>
    					<script>
    						var day_data	 = [
    				  			{"period": "2016-01", "전체회원": "${to[0]}", "가입자": "${cal[0]}", "펍등록수":40},
    				  			{"period": "2016-02", "전체회원": "${to[1]}", "가입자": "${cal[1]}", "펍등록수":40},
    							  {"period": "2016-03", "전체회원": "${to[2]}", "가입자": "${cal[2]}", "펍등록수":40},
    							  {"period": "2016-04", "전체회원": "${to[3]}", "가입자": "${cal[3]}", "펍등록수":40},
    							  {"period": "2016-05", "전체회원": "${to[4]}", "가입자": "${cal[4]}", "펍등록수":40},
    							  {"period": "2016-06", "전체회원": "${to[5]}", "가입자": "${cal[5]}", "펍등록수":40},
    							  {"period": "2016-07", "전체회원": "${to[6]}", "가입자": "${cal[6]}", "펍등록수":40},
    							  {"period": "2016-08", "전체회원": "${to[7]}", "가입자": "${cal[7]}", "펍등록수":40},
    							  {"period": "2016-09", "전체회원": "${to[8]}", "가입자": "${cal[8]}", "펍등록수":40},
    							  {"period": "2016-10", "전체회원": "${to[9]}", "가입자": "${cal[9]}", "펍등록수":40},
    							  {"period": "2016-11", "전체회원": "${to[10]}", "가입자": "${cal[10]}", "펍등록수":40},
    							  {"period": "2016-12", "전체회원": "${to[11]}", "가입자": "${cal[11]}", "펍등록수":40}
    						];
    						Morris.Line({
    					 		element: 'cal',
    					  		data: day_data,
    							xkey: 'period',
    							ykeys: ['전체회원', '가입자','펍등록수'],
    							labels: ['전체회원', '가입자','펍등록수'],
    						});
    					</script>
					
					<div id="donut_example" style="width: 366px; height: 200px; float:left">
						<script>
   							Morris.Donut({
    							element: 'donut_example',     //그래프가 들어갈 위치의 ID를 적어주세요
    							data: [                                     //그래프에 들어갈 data를 적어주세요
    							{label: '남성', value: "${m}" },
    							{label: '여성', value: "${f}" }
    							],
    							colors: ["green", "black"], //그래프 color를 지정해줍니다.
    							formatter: function (y) { return y}  //y값 뒤에 %를 추가해줍니다.
    						});
    					</script>
    				</div>		

					<div id="donut_example2" style="width: 366px; height: 200px; float:left">
						<script>
    						Morris.Donut({
    							element: 'donut_example2',     //그래프가 들어갈 위치의 ID를 적어주세요
    								data: [                                     //그래프에 들어갈 data를 적어주세요
    								{label: '소비자', value: "${con}" },
    								{label: '판매자', value: "${sup}" },
    								{label: 'pub수', value: "${pubcount}" }
    							],
    							colors: ["green", "black", "blue"], //그래프 color를 지정해줍니다.
    							formatter: function (y) { return y}  //y값 뒤에 %를 추가해줍니다.
    						});
    					</script>
    				</div>
    			
   					<div id="donut_example3" style="width: 366px; height: 200px; float:left">
						<script>
    						Morris.Donut({
    							element: 'donut_example3',     //그래프가 들어갈 위치의 ID를 적어주세요
    							data: [                                     //그래프에 들어갈 data를 적어주세요
    								{label: '10대', value: "${birth[0]}"},
    								{label: '20대', value: "${birth[1]}"},
    								{label: '30대', value: "${birth[2]}"},
    								{label: '40대', value: "${birth[3]}"},
    								{label: '50대', value: "${birth[4]}"}
    							],
    							colors: ["green", "black", "blue","red","pupple"], //그래프 color를 지정해줍니다.
    							formatter: function (y) { return y}  //y값 뒤에 %를 추가해줍니다.
    						});
    					</script>   
   			 		</div>
				</div>

				<div id="con">
					<div id="title">
						<a>판매자 신청 현황 : ${total}</a>
					</div>
					<table style="width:100%;">
						<tr>
							<th width="20%">id</th>
							<th width="20%">이름</th>
							<th width="35%">사업자 번호</th>
							<th width="25%">상태여부</th>
						</tr>
						
						<c:forEach var="dto" items="${List}">
						<tr>
							<td width="20%">${dto.id}</td>
							<td width="20%">${dto.name}</td>
							<td width="35%">${dto.saupja_num}</td>
							<td width="25%">
								<button id="ok" type="submit" value="${dto.id}">확인</button>
								<button id="can" type="submit" value="${dto.id}">취소</button>
							</td>
						</tr>
						</c:forEach>
						
					</table>
				</div>

				<div id="sup">
					<div id="title">
						<a>Pub 신청 현황 : ${total2}</a>
					</div>
					<table style="width:100%;">
						<tr>
							<th width="20%">id</th>
							<th width="20%">이름</th>
							<th width="35%">Pub이름</th>
							<th width="25%">링크</th>
						</tr>
						<c:forEach var="dto" items="${List2}">
						<tr>
							<td width="20%">${dto.id}</td>
							<td width="20%">${dto.members.name}</td>
							<td width="35%">${dto.p_title}</td>
							<td width="25%">
							<a href="pubpre.do?id=${dto.id}" target="_blank">${dto.id}미리보기</a>
								<%-- <button id="pok" type="submit" value="${dto.id}">확인</button>
								<button id="pcan" type="submit" value="${dto.id}">취소</button> --%>
							</td>
						</tr>
						</c:forEach>
					</table>
				</div>

				<div id="cou">
				</div>

			</div>

		</div>


</body>
</html>