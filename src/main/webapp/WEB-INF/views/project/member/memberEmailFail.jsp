<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!-- Designined by CodingLab - youtube.com/codinglabyt -->
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <title> 회원가입 폼 </title>
    <link rel="stylesheet" href="/login/signup.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<div class="container">
    <div class="title">Sign Up</div>
    <div class="content">
        <form action="/memberadd" method="post">
            <div class="user-details">
                <div class="input-box">
                    <span class="details" style="color: red">이메일(이메일이 이미 존재합니다!)</span>
                    <input type="text" name="email" id="email" placeholder="이메일 주소를 입력하세요" required>
                </div>
                <div class="input-box">
                    <span class="details">이름</span>
                    <input type="text" name="name" id="name" placeholder="이름을 입력하세요" required>
                </div>
                <div class="input-box">
                    <span class="details">비밀번호</span>
                    <input type="password" name="password" id="password" placeholder="비밀번호를 입력하세요" required>
                </div>
                <div class="input-box">
                    <span class="details">비밀번호 확인</span>
                    <input type="password" name="passwordChk" id="passwordChk" placeholder="비밀번호를 확인해주세요" required>
                </div>
            </div>
            <div class="button">
                <input type="submit" value="가입하기">
            </div>
        </form>
    </div>
</div>
</body>
</html>