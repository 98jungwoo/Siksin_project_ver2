
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<!--여기 게시판
	Aesthetic by gettemplates.co
	Twitter: http://twitter.com/gettemplateco
	URL: http://gettemplates.co
-->
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>SIKSIN &mdash;member_update</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Free HTML5 Website Template by GetTemplates.co" />
<meta name="keywords"
	content="free website templates, free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive" />
<meta name="author" content="GetTemplates.co" />


<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Kaushan+Script" rel="stylesheet">

<!-- Animate.css -->
<link rel="stylesheet" href="css/animate.css">
<!-- Icomoon Icon Fonts-->
<link rel="stylesheet" href="css/icomoon.css">
<!-- Themify Icons-->
<link rel="stylesheet" href="css/themify-icons.css">
<!-- Bootstrap  -->
<link rel="stylesheet" href="css/bootstrap.css">
<!-- Magnific Popup -->
<link rel="stylesheet" href="css/magnific-popup.css">
<!-- Bootstrap DateTimePicker -->
<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css">
<!-- Owl Carousel  -->
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">
<!-- Theme style  -->
<link rel="stylesheet" href="css/style.css">
<!-- Modernizr JS -->
<script src="js/modernizr-2.6.2.min.js"></script>
<!-- FOR IE9 below -->
<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->


<script src="./js/jquery-3.5.1.js" type="text/javascript"></script>
<script src="../js/validity.js" type="text/javascript"></script>
<script type="text/javascript">
	function memberDelete() {
		if (confirm("${memberDTO.memberName}님 회원을 탈퇴 하시겠습니까?")) {
			location.href = "./SiksinDelete.do?memberNum=${memberDTO.memberNum}"
		}
	}
	function memberUpdate() {
		if (confirm("${memberDTO.memberName}님 회원정보를 수정 하시겠습니까?")) {
			location.href = "./SiksinUpdate.do?memberNum=${memberDTO.memberNum}"
		}
	}
</script>
</head>
<body>

	<div class="gtco-loader"></div>

	<div id="page">

				<!-- <div class="page-inner"> -->
		<nav class="gtco-nav" role="navigation">
			<div class="gtco-container">

				<div class="row">
					<div class="col-sm-4 col-xs-12">
						<div id="gtco-logo">
							<a href="./index.jsp">SIKSIN <em>.</em></a><br>
						</div>
					</div>
					<div class="col-xs-8 text-right menu-1">
						<ul>
							<c:choose>
								<c:when test="${empty sessionScope.phoneNum}">
									<li class="btn-cta"><a onclick="location.href='./LoginView.do'"><span>Login</span></a>
								</c:when>
								<c:otherwise>
									<li class="btn-cta">
									<li class="has-dropdown"><a href="./SiksinSelect.do">회원관리</a>  <a
											href="./SiksinSelectDetail.do?memberName=${sessionScope.memberName}">${sessionScope.memberName} 
												님</a>
									<li class="btn-cta"><a onclick="location.href='./Logout.do'"><span>Logout</span></a>
								</c:otherwise>
							</c:choose>
						</ul>
					</div>
				</div>
			</div>
		</nav>

		<header id="gtco-header" class="gtco-cover gtco-cover-sm" role="banner"
			style="background-image: url(images/img_bg_1.jpg)" data-stellar-background-ratio="0.5">
			<div class="overlay"></div>
			<div class="gtco-container">
				<div class="row">
					<div class="col-md-12 col-md-offset-0 text-center">


						<div class="row row-mt-15em">
							<div class="col-md-12 mt-text animate-box" data-animate-effect="fadeInUp">
								<span class="intro-text-small"> <a href="#" target="_blank">대한민국 No.1 맛집 서비스
										SIKSIN.</a></span>
								<h1 class="cursive-font">SIKSIN.</h1>
							</div>
						</div>
					</div>
				</div>
			</div>
		</header>


		<div class="gtco-section" id="join_member" name="join_member">
			<div class="gtco-container">
				<div class="row" id="member#ffffff">
					<div class="col-md-12">
						<fieldset name="member" class="member">

							<h3 class="fieldset_h3">비밀번호 찾기 결과</h3>
							<br> <br>
							<form action="./PasswordSearch.do" method="post" enctype="application/x-www-form-urlencoded">
								<section id="actions" class="py-4 mb-4 bg-light">
									<div class="container">
										<div class="row"></div>
									</div>
								</section>
								<section id="login">
									<div class="container">
										<div class="row">
											<div class="col-9 mx-auto">
												<div class="card">
													<div class="card-body">
														<div class="row  pt-3 pb-1 justify-content-center">
															<div class="col col-sm-8 text_strong text-center">검색한 비밀번호의 정보입니다.</div>
														</div>
														<div class="row pb-1 justify-content-center">
															<div class="col-10 col-sm-8">
																<hr class="list_hr">
															</div>
														</div>

														<c:choose>
															<c:when test="${!empty password}">
																<div class="col col-sm-8 text_strong text-center">
																	<p class="text-success">
																		찾으시는 비밀번호는 <b class="text-info">${password}</b> 입니다.
																	</p>

																</div>
															</c:when>
															<c:otherwise>
																<div class="col col-sm-8 text_strong text-center">
																	<p class="text-danger">찾으시는 비밀번호가 존재하지 않습니다.</p>

																</div>
															</c:otherwise>
														</c:choose>
														<div class="row pb-1 justify-content-center">
															<div class="col-10 col-sm-8">
																<hr class="base_hr">
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</section>
							</form>
						</fieldset>
					</div>
				</div>
			</div>
		</div>








		<footer id="gtco-footer" role="contentinfo" style="background-image: url(images/img_bg_1.jpg)"
			data-stellar-background-ratio="0.5">
			<div class="overlay"></div>
			<div class="gtco-container">
				<div class="row row-pb-md">




					<div class="col-md-12 text-center">
						<div class="gtco-widget">
							<h3>Get In Touch</h3>
							<ul class="gtco-quick-contact">
								<li><a href="#"><i class="icon-phone"></i> 1577-3957</a></li>
								<li><a href="#"><i class="icon-mail2"></i>info@siksinhot.com</a></li>
								<li><a href="#"><i class="icon-chat"></i> Live Chat</a></li>
							</ul>
						</div>
						<div class="gtco-widget">
							<h3>Get Social</h3>
							<ul class="gtco-social-icons">
								<li><a href="#"><i class="icon-twitter"></i></a></li>
								<li><a href="#"><i class="icon-facebook"></i></a></li>
								<li><a href="#"><i class="icon-linkedin"></i></a></li>
								<li><a href="#"><i class="icon-dribbble"></i></a></li>
							</ul>
						</div>
						<div>
							<p>
								<strong data-reactid="1330">식신(주)</strong><em data-reactid="1331"></em>
								<!-- react-text: 1332 -->
								대표자
								<!-- /react-text -->
								<!-- react-text: 1333 -->
								&nbsp;
								<!-- /react-text -->
								<strong data-reactid="1334">안병익</strong><em data-reactid="1335"></em>
								<!-- react-text: 1336 -->
								서울특별시 강남구 테헤란로8길 16, 9층 (지희빌딩)
								<!-- /react-text -->
								<br data-reactid="1337">
								<!-- react-text: 1338 -->
								사업자등록번호
								<!-- /react-text -->
								<!-- react-text: 1339 -->
								&nbsp;
								<!-- /react-text -->
								<strong data-reactid="1340">214-88-59748&nbsp;</strong><em data-reactid="1341"></em>
								<!-- react-text: 1342 -->
								|&nbsp;TEL&nbsp;
								<!-- /react-text -->
								<strong data-reactid="1343"><a href="tel:1577-3957" data-reactid="1344">1577-3957&nbsp;</a></strong><em
									data-reactid="1345"></em>
								<!-- react-text: 1346 -->
								|&nbsp;FAX&nbsp;
								<!-- /react-text -->
								<strong data-reactid="1347">02.533.1909&nbsp;</strong><em data-reactid="1348"></em>
								<!-- react-text: 1349 -->
								|&nbsp;EMAIL&nbsp;
								<!-- /react-text -->
								<a href="mailto:info@siksinhot.com" data-reactid="1350"><strong data-reactid="1351">info@siksinhot.com</strong></a><br
									data-reactid="1352">
								<!-- react-text: 1353 -->
								Copyright (c) SIKSIN. All Rights Reserved.
								<!-- /react-text -->
							</p>
						</div>
					</div>

					<div class="col-md-12 text-center copyright">
						Shared by <i class="fa fa-love"></i><a href="https://bootstrapthemes.co">BootstrapThemes</a>
					</div>

				</div>



			</div>
		</footer>
		<!-- </div> -->



		<div class="gototop js-top">
			<a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
		</div>

		<!-- jQuery -->
		<script src="js/jquery.min.js">
			
		</script>
		<!-- jQuery Easing -->
		<script src="js/jquery.easing.1.3.js"></script>
		<!-- Bootstrap -->
		<script src="js/bootstrap.min.js"></script>
		<!-- Waypoints -->
		<script src="js/jquery.waypoints.min.js"></script>
		<!-- Carousel -->
		<script src="js/owl.carousel.min.js"></script>
		<!-- countTo -->
		<script src="js/jquery.countTo.js"></script>

		<!-- Stellar Parallax -->
		<script src="js/jquery.stellar.min.js"></script>

		<!-- Magnific Popup -->
		<script src="js/jquery.magnific-popup.min.js"></script>
		<script src="js/magnific-popup-options.js"></script>

		<script src="js/moment.min.js"></script>
		<script src="js/bootstrap-datetimepicker.min.js"></script>


		<!-- Main -->
		<script src="js/main.js"></script>
</body>
</html>
