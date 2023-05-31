package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ResultsServlet", urlPatterns = "/ResultsServlet")
public class ResultsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userSearch = request.getParameter("user-search");
        request.setAttribute("userSearch", userSearch);
        System.out.println(DaoFactory.getAdsDao().AdSearch(userSearch).toString());

        request.setAttribute("searchResults", DaoFactory.getAdsDao().AdSearch(userSearch));
//        System.out.println(WhatIsSearched);

        request.getRequestDispatcher("/WEB-INF/ads/search-results.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
