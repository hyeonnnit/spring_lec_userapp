package com.example.userapp.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// FrontController
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
    // /user.do
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 공통로직
        System.out.println("common logic");
        resp.setHeader("Content-Type","text/html; charset=utf-8");

        // 2. 분기
        String uri = req.getRequestURI();
        System.out.println(uri);
        if (uri.equals("/join-form.do")){
            req.getRequestDispatcher("/WEB-INF/user/join-form.jsp").forward(req,resp);
//            resp.sendRedirect("/WEB-INF/user/join-form.jsp");
        } else if (uri.equals("/join.do")) {
            req.getRequestDispatcher("/WEB-INF/user/join.jsp").forward(req,resp);
//            resp.sendRedirect("/WEB-INF/user/join.jsp");
        }else if (uri.equals("/main.do")) {
            req.getRequestDispatcher("/WEB-INF/board/main.jsp").forward(req,resp);
//            resp.sendRedirect("/WEB-INF/board/main.jsp");
        }else {
            resp.setStatus(404);
            resp.getWriter().println("잘못된 페이지를 요청하셨습니다.");
        }
    }
}
