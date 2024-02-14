<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 정보 리스트</title>
</head>
<body>

<h2>회원 정보 리스트</h2>

<p>이름: <%= request.getAttribute("name") %></p>
<p>아이디: <%= request.getAttribute("id") %></p>
<p>비밀번호: <%= request.getAttribute("password") %></p>
<p>나이: <%= request.getAttribute("age") %></p>
<p>성별: <%= request.getAttribute("gender") %></p>

<p>취미:
    <%
        String[] hobbies = (String[]) request.getAttribute("hobbies");
        if (hobbies != null) {
            for (String hobby : hobbies) {
    %>
    <%= hobby %>&nbsp;
    <%
            }
        }
    %>
</p>

<p>가고 싶은 여행지: <%= request.getAttribute("travel") %></p>
<p>자기소개: <%= request.getAttribute("content") %></p>

</body>
</html>
