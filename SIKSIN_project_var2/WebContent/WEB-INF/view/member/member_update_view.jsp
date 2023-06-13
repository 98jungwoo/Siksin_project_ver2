<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
alert("${memberDTO.memberName}님의 개인 정보를 수정하였습니다.")
location.href="./SiksinSelectDetail.do?memberNum=${memberDTO.memberNum}";
</script>
</body>
</html>
