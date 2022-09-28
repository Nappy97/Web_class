<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String cookieName1 = "num1";
    Cookie cookie1 = new Cookie(cookieName1, "");   // 이름-값 쌍으로 Cookie  생성
    cookie1.setMaxAge(0);   // 쿠키 파기(expiry) 시간 설정 (단위: 초)
    response.addCookie(cookie1);   // response 에 Cookie 탑재
%>

<script>
    alert("<%= cookieName1 %>쿠키 삭제");
    location.href = "cookieList.jsp";
</script>