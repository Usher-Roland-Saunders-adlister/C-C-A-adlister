package com.codeup.adlister.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.DeleteAdServlet", urlPatterns = "/deleteAd")
public class DeleteAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/deleteAd.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/deleteAd.jsp").forward(request, response);
    }
}
