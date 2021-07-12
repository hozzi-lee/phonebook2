<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.javaex.vo.PhoneVo" %>
<%@ page import="com.javaex.dao.PhoneDao" %>

<%

PhoneDao pDao = new PhoneDao();

int id = Integer.parseInt(request.getParameter("id"));

PhoneVo pVid = pDao.getPerson(id);

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>전화번호 수정</h1>
	<p>수정화면 입니다. 아래 항목을 수정하고 "수정" 버튼을 클릭하세요.</p>

	<form action="/phonebook2/pbc" method="post">

		<input type="hidden" name="action" value="update"><br>
		이름: <input type="text" name="name" value="<%=pVid.getName() %>"> <br>
		핸드폰: <input type="text" name="hp" value="<%=pVid.getHp() %>"> <br>
		회사: <input type="text" name="cp" value="<%=pVid.getCompany() %>"> <br>
		<input type="hidden" name="id" value="<%=pVid.getPersonID() %>"> <br>

		<button type="submit">수정</button>

	</form>

</body>
</html>