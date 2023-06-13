<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
</head>
<body>
	<c:choose>
		<c:when test="${sessionScope.id == 'admin'}">
			<script type="text/javascript">
				alert("회원 (${memberDTO.memberName})의 회원 탈퇴가 완료되었습니다.")
				location.href = "./SiksinSelect.do"
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert("탈퇴가 완료되었습니다.")
				location.href = "./SiksinSelect.do"; // 여기 로그아웃 주소로 변경하기
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>