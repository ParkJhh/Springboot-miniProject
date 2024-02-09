<%@ page import="com.kitri.mytodo.dto.MemberInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!-- Created By CodingNepal -->
<html lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
    <title>로그인 폼</title>
    <link rel="stylesheet" href="/login/login.css">
</head>
<body>
<%
    MemberInfo sessionInfo = (MemberInfo) session.getAttribute("sessionId");
%>
<% if(sessionInfo != null) {%>
<div class="wrapper">
    <div class="title">
        로그인 중입니다!
    </div>
    <form action=/Mytodologin/login method="post">
        <input type="text" name="email" value="<%=sessionInfo.getEmail()%>" hidden>
        <input type="text" name="password" value="<%=sessionInfo.getPassword()%>" hidden>
        <div class="field">
            <input type="submit" value="Todo 페이지로!">
        </div>
        <div class="signup-link">
            로그아웃 하시겠습니까? <a href="/Mytodologin/logout"> 로그아웃 </a>
        </div>
    </form>
</div>
<%} else {%>
<div class="wrapper">
    <div class="title">
        LOGIN FORM
    </div>
    <form action=/Mytodologin/login method="post">
        <div class="field">
            <input type="text" name="email" id="email" required>
            <label>이메일 주소</label>
        </div>
        <div class="field">
            <input type="password" name="password" id="password" required>
            <label>비밀번호</label>
        </div>
        <div class="content">
            <div class="checkbox">
                <input type="checkbox" id="remember-me">
                <label for="remember-me">이메일 주소 저장</label>
            </div>
        </div>
        <div class="field">
            <input type="submit" value="로그인">
        </div>
        <div class="signup-link">
            회원이 아니신가요? <a href="/memberadd"> 회원가입 </a>
        </div>
    </form>
</div>
<%}%>
</body>
</html>