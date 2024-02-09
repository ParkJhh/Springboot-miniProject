<%@ page import="com.kitri.mytodo.dto.MemberInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="/mytodo/todo.css"/>
    <title>Todo List</title>
</head>
<%
    MemberInfo sessionInfo = (MemberInfo) session.getAttribute("sessionId");
    if(sessionInfo != null){
%>
<body>
<header class="">
    <nav>
        <div class="d-flex justify-content-center">
            <div class="p-2"><a class="headerAtag"><%=sessionInfo.getName()%>님 환영합니다.</a></div>
            <div class="p-2"><a class="headerAtag" href="/Mytodologin/logout">로그아웃</a></div>
        </div>
    </nav>
</header>
    <h1>todo-list</h1>
        <form action="/" id="form" method="post">
            <input type="text" class="input" id="input" placeholder="Enter your todo" autocomplete="off">
            <ul class="todos" id="todos">
            </ul>
        </form>
    <small>왼쪽 클릭: 항목 완료 <br> 오른쪽 클릭: 해당 항목 삭제</small>
<script>
    let memberId = ${memberId}
</script>
<script src="/mytodo/script.js"></script>
</body>
<%} else {%>
    <body>
    <h1>잘못된 접근입니다!</h1>
    <p>주소창을 확인 후 다시 접속하시기 바랍니다.</p>
    <small><a href="/Mytodologin">로그인 페이지로</a></small>
    </body>
<%}%>
</html>