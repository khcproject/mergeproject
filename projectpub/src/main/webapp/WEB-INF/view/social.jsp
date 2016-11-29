<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">



<title>Carousel Template for Bootstrap</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>




<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>

<link
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css"
	rel="stylesheet" type="text/css">




<!-- Bootstrap core JavaScript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	window.jQuery
			|| document.write('<script src="js/jquery.min.js"><\/script>')
</script>
<script src="js/bootstrap.min.js"></script>

<script type="text/javascript"
	src="//apis.daum.net/maps/maps3.js?apikey=731f03a939fe898215f7cb004ab21b84&libraries=services"></script>
<script src="js/reservation.js" type="text/javascript"></script>




<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="js/ie10-viewport-bug-workaround.js"></script>

<style>
.block {
	border-color: #bdc3c7;
	background-color: #FAFAFA;
	box-shadow: 10px 10px 10px silver;
	-moz-box-shadow: 10px 10px 10px silver;
	-webkit-box-shadow: 10px 10px 10px silver;
}

.nopadding {
	padding-left: 0px;
}
</style>

</head>
<body>
	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-6 col-md-offset-3">

					<div class="panel panel-default block">
						<div class="panel-body">
							<div class="row">

								<div class="col-md-12 nopadding">
									<img src="images/profilesample.jpg"
										class="img-circle img-responsive col-md-3">
									<h4 class="col-md-5">사용자병신님</h4>
									<div class="com-md-2 com-md-offset-2 text-right">작성시간1min</div>
								</div>


								<div class="col-md-12 text-right">
									<button type="button" class="btn btn-default btn-lg">
										<span class="glyphicon glyphicon-star" aria-hidden="true"></span>글쓰기
									</button>
								</div>
							</div>
						</div>
					</div>


					<div class="panel panel-default block">
						<div class="panel-body">

							<div class="row">
								<div class="col-md-12">
									<img src="images/profilesample.jpg"
										class="img-responsive col-md-3">
									<h4 class="col-md-5">사용자병신님</h4>
									<div class="com-md-2 com-md-offset-2 text-right">작성시간1min</div>
								</div>
							</div>

							<div class="row">
								<p class="col-md-12">Lorem ipsum dolor sit amet,
									consectetuer adipiscing elit. Aenean commodo ligula eget dolor.
									Aenean massa. Cum sociis natoque penatibus et magnis dis
									parturient montes, nascetur ridiculus mus. Donec quam felis,
									ultricies nec, pellentesque eu, pretium quis, sem. Nulla
									consequat massa quis enim. Donec pede justo, fringilla vel,
									aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut,
									imperdiet a, venenatis vitae, justo. Nullam dictum felis eu
									pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus
									elementum semper nisi. Aenean vulputate eleifend tellus. Aenean
									leo ligula, porttitor eu, consequat vitae, eleifend ac, enim.
									Aliquam lorem ante, dapibus in, viverra quis, feugiat a,
									tellus. Phasellus viverra nulla ut metus varius laoreet.</p>
							</div>

							<div class="row">
								<div class="col-md-12">
									<img alt="" src="images/subpic.jpg" class="img-responsive">
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<button type="button" class="btn btn-primary">
										<span class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span>좋아요
									</button>
									<button type="button" class="btn btn-primary">
										<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>댓글달기
									</button>
								</div>
								`
							</div>
							<div class="row">
								<div class="reply col-md-12">글쓰기 영역</div>
							</div>
						</div>
					</div>
				</div>
				<!-- end of row -->

			</div>
		</div>
	</div>
	</div>
</body>
</html>
