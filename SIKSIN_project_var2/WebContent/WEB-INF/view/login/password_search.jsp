
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
							<h3 class="fieldset_h3">비밀번호 찾기</h3>
							<form action="./PasswordSearch.do" method="post" enctype="application/x-www-form-urlencoded">
								<hr>

								<label class="member_label" for="phoneNumArea">휴대폰 인증<em>*</em>
								</label>
								<div class="row form-group">
									<div class="col-md-4">
										<select name="phoneNumArea" id="phoneNumArea" class="form-control">
											<option>나라를 선택하세요.</option>
											<option value="82">대한민국(한국)</option>
											<option value="1">미국</option>
											<option value="81">일본</option>
											<option value="44">영국</option>
											<option value="86">중국</option>
											<option value="233">가나</option>
											<option value="241">가봉</option>
											<option value="592">가이아나</option>
											<option value="220">감비아</option>
											<option value="590">과들루프</option>
											<option value="502">과테말라</option>
											<option value="1671">괌</option>
											<option value="1473">그레나다</option>
											<option value="995">그루지아</option>
											<option value="30">그리스</option>
											<option value="299">그린란드</option>
											<option value="224">기니아</option>
											<option value="245">기니아</option>
											<option value="594">기아나</option>
											<option value="264">나미비아</option>
											<option value="674">나우루</option>
											<option value="234">나이지리아</option>
											<option value="27">남아프리카공화국</option>
											<option value="31">네덜란드</option>
											<option value="1869">네비스</option>
											<option value="977">네팔</option>
											<option value="47">노르웨이</option>
											<option value="64">뉴질랜드</option>
											<option value="687">뉴칼레도니아</option>
											<option value="227">니제르</option>
											<option value="505">니카라과</option>
											<option value="82">대한민국(한국)</option>
											<option value="45">덴마크</option>
											<option value="1809">도미니카공화국</option>
											<option value="49">독일</option>
											<option value="670">동티모르</option>
											<option value="856">라오스</option>
											<option value="231">라이베리아</option>
											<option value="371">라트비아</option>
											<option value="7">러시아</option>
											<option value="961">레바논</option>
											<option value="266">레소토</option>
											<option value="262">레위니옹</option>
											<option value="40">루마니아</option>
											<option value="352">룩셈부르크</option>
											<option value="250">르완다</option>
											<option value="218">리비아</option>
											<option value="370">리투아니아</option>
											<option value="423">리히텐슈타인</option>
											<option value="261">마다가스카르</option>
											<option value="596">마르티니크</option>
											<option value="692">마셜</option>
											<option value="269">마요트</option>
											<option value="853">마카오</option>
											<option value="389">마케도니아</option>
											<option value="265">말라위</option>
											<option value="60">말레이시아</option>
											<option value="223">말리</option>
											<option value="52">멕시코</option>
											<option value="377">모나코</option>
											<option value="212">모로코</option>
											<option value="230">모리셔스</option>
											<option value="222">모리타니아</option>
											<option value="258">모잠비크</option>
											<option value="1664">몬세랏</option>
											<option value="373">몰도바</option>
											<option value="960">몰디브</option>
											<option value="356">몰타</option>
											<option value="976">몽골</option>
											<option value="1">미국/캐나다</option>
											<option value="95">미얀마</option>
											<option value="691">미크로네시아</option>
											<option value="678">바누아투</option>
											<option value="973">바레인</option>
											<option value="1246">바베이도스</option>
											<option value="1242">바하마</option>
											<option value="880">방글라데시</option>
											<option value="1441">버뮤다</option>
											<option value="1284">버진아일랜드</option>
											<option value="58">베네수엘라</option>
											<option value="229">베닌</option>
											<option value="84">베트남</option>
											<option value="32">벨기에</option>
											<option value="375">벨라루스</option>
											<option value="501">벨리즈</option>
											<option value="387">보스니아헤르체고비나</option>
											<option value="267">보츠와나</option>
											<option value="591">볼리비아</option>
											<option value="257">부룬디</option>
											<option value="226">부르키나파소</option>
											<option value="975">부탄</option>
											<option value="359">불가리아</option>
											<option value="55">브라질</option>
											<option value="673">브루나이</option>
											<option value="685">사모아</option>
											<option value="966">사우디아라비아</option>
											<option value="1670">사이판</option>
											<option value="378">산마리노</option>
											<option value="239">상투메프린시페</option>
											<option value="221">세네갈</option>
											<option value="381">세르비아</option>
											<option value="248">세이셸</option>
											<option value="1758">세인트루시아</option>
											<option value="1784">세인트빈센트</option>
											<option value="252">소말리아</option>
											<option value="677">솔로몬제도</option>
											<option value="249">수단</option>
											<option value="597">수리남</option>
											<option value="94">스리랑카</option>
											<option value="268">스와질란드</option>
											<option value="46">스웨덴</option>
											<option value="41">스위스</option>
											<option value="34">스페인</option>
											<option value="421">슬로바키아</option>
											<option value="386">슬로베니아</option>
											<option value="963">시리아</option>
											<option value="232">시에라리온</option>
											<option value="65">싱가포르</option>
											<option value="971">아랍에미리트</option>
											<option value="297">아루바</option>
											<option value="374">아르메니아</option>
											<option value="54">아르헨티나</option>
											<option value="354">아이슬란드</option>
											<option value="509">아이티</option>
											<option value="353">아일랜드</option>
											<option value="994">아제르바이잔</option>
											<option value="93">아프가니스탄</option>
											<option value="376">안도라</option>
											<option value="1907">알래스카</option>
											<option value="355">알바니아</option>
											<option value="213">알제리아</option>
											<option value="244">앙골라</option>
											<option value="291">에리트레아</option>
											<option value="372">에스토니아</option>
											<option value="593">에콰도르</option>
											<option value="251">에티오피아</option>
											<option value="503">엘살바도르</option>
											<option value="44">영국</option>
											<option value="967">예멘</option>
											<option value="968">오만</option>
											<option value="61">오스트레일리아</option>
											<option value="43">오스트리아</option>
											<option value="504">온두라스</option>
											<option value="962">요르단</option>
											<option value="256">우간다</option>
											<option value="598">우루과이</option>
											<option value="998">우즈베키스탄</option>
											<option value="380">우크라이나</option>
											<option value="964">이라크</option>
											<option value="98">이란</option>
											<option value="972">이스라엘</option>
											<option value="20">이집트</option>
											<option value="39">이탈리아</option>
											<option value="91">인도</option>
											<option value="62">인도네시아</option>
											<option value="81">일본</option>
											<option value="1876">자메이카</option>
											<option value="253">자부티</option>
											<option value="260">잠비아</option>
											<option value="240">적도기니</option>
											<option value="86">중국</option>
											<option value="236">중앙아프리카공화국</option>
											<option value="350">지브롤터</option>
											<option value="263">짐바브웨</option>
											<option value="235">차드</option>
											<option value="420">체코</option>
											<option value="56">칠레</option>
											<option value="237">카메룬</option>
											<option value="238">카보베르데</option>
											<option value="974">카타르</option>
											<option value="855">캄보디아</option>
											<option value="254">케냐</option>
											<option value="1345">케이맨 제도</option>
											<option value="506">코스타리카</option>
											<option value="225">코트디아부르</option>
											<option value="57">콜롬비아</option>
											<option value="242">콩고</option>
											<option value="243">콩고민주공화국</option>
											<option value="53">쿠바</option>
											<option value="965">쿠웨이트</option>
											<option value="385">크로아티아</option>
											<option value="996">키르기스스탄</option>
											<option value="686">키리바시</option>
											<option value="357">키프로스</option>
											<option value="66">타이</option>
											<option value="886">타이완</option>
											<option value="992">타지키스탄</option>
											<option value="255">탄자니아</option>
											<option value="90">터키</option>
											<option value="228">토고</option>
											<option value="676">통가</option>
											<option value="993">투르크메니스탄</option>
											<option value="688">투발루</option>
											<option value="216">튀니지</option>
											<option value="1868">트리니다드/토바고</option>
											<option value="507">파나마</option>
											<option value="595">파라과이</option>
											<option value="92">파키스탄</option>
											<option value="675">파푸아뉴기니</option>
											<option value="680">팔라우</option>
											<option value="970">팔레스타인</option>
											<option value="298">페로스제도</option>
											<option value="51">페루</option>
											<option value="351">포르투갈</option>
											<option value="48">폴란드</option>
											<option value="689">폴리네시아</option>
											<option value="1939">푸에르토리코</option>
											<option value="1787">푸에르토리코</option>
											<option value="33">프랑스</option>
											<option value="679">피지</option>
											<option value="358">핀란드</option>
											<option value="63">필리핀</option>
											<option value="1808">하와이</option>
											<option value="36">헝가리</option>
											<option value="852">홍콩</option>
										</select>
									</div>
									<div class="col-md-6">
										<input type="text" name="phoneNum" id="phoneNum" class="form-control"
											placeholder="휴대폰 번호를 입력해주세요.">
									</div>
									<input class="button11" type="button" onclick="alert('인증번호를 발송하였습니다.')" value="인증번호 발송">

								</div>




								<div class="row form-group">
									<div class="col-md-4">
										<label class="sr-only" for="phoneNum2">인증번호</label> <input type="text" size="20"
											name="phoneNum2" id="phoneNum2" class="form-control" placeholder="인증번호를 입력해주세요">
									</div>
									<input class="button11" type="button" value="확인" onclick="alert('인증이 완료되었습니다.')">
								</div>

								<input type="submit" id="register" class="btn btn-info btn-block" value="비밀번호 찾기">
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

	</div>

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
