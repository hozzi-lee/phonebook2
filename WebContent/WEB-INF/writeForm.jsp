<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>전화번호 등록</h1>
	<p>전화번호를 등록하려면<br> 아래 항복을 기입하고 "등록" 버튼을 클릭하세요.</p>

	<form action="/phonebook2/pbc" method="post">

		<input type="hidden" name="action" value="insert"><br>
		이름(name): <input type="text" name="name" value=""><br>
		핸드폰(hp): <input type="text" name="hp" value=""><br>
		회사(company): <input type="text" name="cp" value=""><br>

		<button type="submit">등록</button>

	</form>

	<br>

	<a href="/phonebook2/pbc?action=list">리스트 바로가기</a>

</body>
</html>