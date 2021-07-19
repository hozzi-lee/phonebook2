<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- JAVA -->
<%--
<%@ page import="com.javaex.vo.PhoneVo"%>
<%@ page import="java.util.List"%>

<%
// request Attribute는 Object여서 자료형변환 필요
// request 안에 있는 데이터 사용 --> pList
List<PhoneVo> pList = (List<PhoneVo>) request.getAttribute("pList");

/* 자료형 변환 설명 --> request.Attribute는 Object형
String name = (String)request.getAttribute("name");
int age = (int)request.getAttribute("age");

System.out.println(name);
System.out.println(age); */

// System.out.println("======= jsp =======");
// System.out.println(pList);
%>
--%>

<!-- JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>전화번호 리스트</h1>
	<p>입력한 정보 내역입니다.</p>

	<c:forEach items="${ requestScope.pList }" var="p" varStatus="status">

	<table border="1">
		<tr>
			<td>이름</td>
			<td>${ p.name }</td>
		</tr>
		<tr>
			<td>핸드폰</td>
			<td>${ p.hp }</td>
		</tr>
		<tr>
			<td>회사</td>
			<td>${ p.company }</td>
		</tr>
		<tr>
			<td><a href="/phonebook2/pbc?action=uForm&id=${ p.personID }">[수정폼]</a></td>
			<td><a href="/phonebook2/pbc?action=delete&id=${ p.personID }">[삭제]</a></td>
		</tr>
	</table>

	<br>

	</c:forEach>

	<a href="/phonebook2/pbc?action=wForm">추가번호 등록</a>

</body>
</html>