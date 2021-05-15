package com.myservlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

@WebServlet(
        description="Login Servlet Testing",
        urlPatterns={"/LoginServlet"}
)
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        Pattern userNameCheck = Pattern.compile("^[A-Z][a-z]{3,}");
        Pattern passwordCheck = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%]).{8,}");
        if(user.matches(String.valueOf(userNameCheck)) && pwd.matches(String.valueOf(passwordCheck))) {
            request.setAttribute("user",user);
            request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
        }
        else {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>Either Username or Password is Wrong</font>");
            requestDispatcher.include(request, response);
        }
    }
}
