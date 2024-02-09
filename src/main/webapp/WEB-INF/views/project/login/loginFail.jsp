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
<div class="wrapper">
    <div class="title">
        LOGIN FORM
    </div>
    <form action=/Mytodologin/login method="post">
        <div class ="field">
            <p style="color: red">이메일 혹은 비밀번호가 틀립니다!</p>
            <p style="color: red">다시 확인후 로그인하시기 바랍니다.</p>
        </div>
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
</body>
</html>