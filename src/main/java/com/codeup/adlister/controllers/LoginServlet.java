package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }

        String register = request.getParameter("register");
        if (register != null && register.equals("true")) {
            response.sendRedirect("/register");
            return;
        }

        String redirect = request.getParameter("redirect");
        request.getSession().setAttribute("redirect", redirect);

        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = DaoFactory.getUsersDao().findByUsername(username);

        if (user == null) {
            response.sendRedirect("/login");
            return;
        }

        boolean validAttempt = Password.check(password, user.getPassword());

        if (validAttempt) {
            request.getSession().setAttribute("user", user);

            String redirect = (String) request.getSession().getAttribute("redirect");
            if (redirect != null && !redirect.isEmpty()) {
                response.sendRedirect(redirect);
                request.getSession().removeAttribute("redirect"); // Remove the redirect attribute from the session
            } else {
                response.sendRedirect("/profile");
            }
        } else {
            response.sendRedirect("/login?error=1");
        }
    }
}
