/**
 * 
 */
// 로그인 유효성 검사
$(function() {
	$("#login").submit(function() {
		if ($("select[name='phoneNumArea'] > option:selected").index() < 1) {
			alert("나라를 선택해 주세요.");
			$("select[name='phoneNumArea']").focus();
			return false;
		}

		if (!$("input[name='phoneNum']").val()) {
			alert("휴대폰 번호를 입력하세요");
			$("input[name='phoneNum']").focus();
			return false;
		}

		var regexp_phoneNum = /^01([0|1|6|7|8|9]?)([0-9]{3,4})([0-9]{4})$/;
		var phoneNum_check = $("input[name='phoneNum']").val();
		if (!regexp_phoneNum.test(phoneNum_check)) {
			alert("전화번호는 기호없이 입력하세요.(01012341234)");
			$("input[name='phoneNum']").focus();
			return false;
		}

		if (!$("input[name='password']").val()) {
			alert("비밀번호를 입력하세요.");
			$("input[name='password']").focus();
			return false;
		}

		var regexp_password = /^[A-Za-z0-9]{2,20}$/;
		var password_check = $("input[name='password']").val();
		if (!regexp_password.test(password_check)) {
			alert("비밀번호는 공백을 제외한 영문이나 숫자 형태의 2~20자리만 입력할 수 있습니다.");
			$("input[name='password']").focus();
			return false;
		}

	});
});

// 회원가입 유효성검사
$(function() {
	$("#join_member").submit(function() {
		if (!$("input[name='memberName']").val()) {
			alert("이름을 입력하세요.");
			$("input[name='memberName']").focus();
			return false;
		}

		if (!$("input[name='nickName']").val()) {
			alert("닉네임을 입력하세요.");
			$("input[name='nickName']").focus();
			return false;
		}
		var regexp_nickName = /^[a-zA-Z0-9가-힣]{2,30}$/;
		var nickName_check = $("input[name='nickName']").val();
		if (!regexp_nickName.test(nickName_check)) {
			alert("닉네임은 공백을 제외한 2~30자리만 입력할 수 있습니다.");
			$("input[name='nickName']").focus();
			return false;
		}
		if (!$("input[name='password']").val()) {
			alert("비밀번호를 입력하세요.");
			$("input[name='password']").focus();
			return false;
		}
		var regexp_password = /^[A-Za-z0-9]{2,20}$/;
		var password_check = $("input[name='password']").val();
		if (!regexp_password.test(password_check)) {
			alert("비밀번호는 공백을 제외한 영문이나 숫자 형태의 2~20자리만 입력할 수 있습니다.");
			$("input[name='password']").focus();
			return false;
		}


		if ($("select[name='phoneNumArea'] > option:selected").index() < 1) {
			alert("나라를 선택해 주세요.");
			$("select[name='phoneNumArea']").focus();
			return false;
		}
		if (!$("input[name='phoneNum']").val()) {
			alert("휴대폰 번호를 입력하세요");
			$("input[name='phoneNum']").focus();
			return false;
		}

		var regexp_phoneNum = /^01([0|1|6|7|8|9]?)([0-9]{3,4})([0-9]{4})$/;
		var phoneNum_check = $("input[name='phoneNum']").val();
		if (!regexp_phoneNum.test(phoneNum_check)) {
			alert("전화번호는 기호없이 입력하세요.(01012341234)");
			$("input[name='phoneNum']").focus();
			return false;
		}
		if (!$("input[name='phoneNum2']").val()) {
			alert("휴대폰 번호 인증을 완료해주세요.");
			$("input[name='phoneNum2']").focus();
			return false;
		}
		if (!$("input[id='agree1']").is(":checked")) {
			alert("[필수] 이용약관에 동의해주세요.");
			$("input[id='agree1']:eq(0)").focus();
			return false;
		}
		if (!$("input[id='agree2']").is(":checked")) {
			alert("[필수] 개인정보 수집 및 이용에 동의해주세요.");
			$("input[name='agree2']:eq(0)").focus();
			return false;
		}
		if (!$("input[id='agree3']").is(":checked")) {
			alert("[필수] 만 14세 이상여부를 확인 해주세요.");
			$("input[id='agree3']:eq(0)").focus();
			return false;
		}
	});
});

//회원수정 유효성검사
$(function() {
	$("#update_member").submit(function() {

		if (!$("input[name='nickName']").val()) {
			alert("닉네임을 입력하세요.");
			$("input[name='nickName']").focus();
			return false;
		}
		var regexp_nickName = /^[a-zA-Z0-9가-힣]{2,30}$/;
		var nickName_check = $("input[name='nickName']").val();
		if (!regexp_nickName.test(nickName_check)) {
			alert("닉네임은 공백을 제외한 2~30자리만 입력할 수 있습니다.");
			$("input[name='nickName']").focus();
			return false;
		}
		if (!$("input[name='password']").val()) {
			alert("비밀번호를 입력하세요.");
			$("input[name='password']").focus();
			return false;
		}
		var regexp_password = /^[A-Za-z0-9]{2,20}$/;
		var password_check = $("input[name='password']").val();
		if (!regexp_password.test(password_check)) {
			alert("비밀번호는 공백을 제외한 영문이나 숫자 형태의 2~20자리만 입력할 수 있습니다.");
			$("input[name='password']").focus();
			return false;
		}
		if ($("select[name='phoneNumArea'] > option:selected").index() < 1) {
			alert("나라를 선택해 주세요.");
			$("select[name='phoneNumArea']").focus();
			return false;
		}
		if (!$("input[name='phoneNum']").val()) {
			alert("휴대폰 번호를 입력하세요");
			$("input[name='phoneNum']").focus();
			return false;
		}
		var regexp_phoneNum = /^01([0|1|6|7|8|9]?)([0-9]{3,4})([0-9]{4})$/;
		var phoneNum_check = $("input[name='phoneNum']").val();
		if (!regexp_phoneNum.test(phoneNum_check)) {
			alert("전화번호는 기호없이 입력하세요.(01012341234)");
			$("input[name='phoneNum']").focus();
			return false;
		}
		if (!$("input[name='phoneNum2']").val()) {
			alert("휴대폰 번호 인증을 완료해주세요.");
			$("input[name='phoneNum2']").focus();
			return false;
		}
	});
});
