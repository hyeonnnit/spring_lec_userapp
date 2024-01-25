
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    response.setHeader("Content-Type","text/html; charset=utf-8");
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String email = request.getParameter("email");
    System.out.println("username "+username);
    System.out.println("password " + password);
    System.out.println("email " + email);
    if (username.length()<3 || username.length()>10){
        response.getWriter().println("<h1>username 글자수가 3~10 사이어야 합니다.");
        return;
    }
    response.setStatus(302);
    response.setHeader("Location","/board/main.jsp");
    response.setHeader("clock","/12pm");
%>