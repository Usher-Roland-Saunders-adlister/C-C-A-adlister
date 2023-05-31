package com.codeup.adlister.controllers;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.*;
import javax.servlet.ServletRequest;
import javax.servlet.jsp.jstl.core.Config;


import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.Users;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.dao.MySQLAdsDao;
import com.codeup.adlister.dao.Ads;
import com.codeup.adlister.models.User;


@WebServlet(name = "ShowAdServlet", value = "/showad")
public class ShowAdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the ad id from the request parameter
        long adId = Long.parseLong(request.getParameter("id"));

        // Retrieve the ad from the database using the ad id
        Ads adsDao = DaoFactory.getAdsDao();  // Replace with your actual AdsDao implementation
        Ad ad = adsDao.findById(adId);

        if (ad != null) {
            // Retrieve the user information for the ad
            Users userDao = DaoFactory.getUsersDao(); // Replace with your actual UserDao implementation
            User user = userDao.findById(ad.getUserId());

            // Set the ad and user objects as attributes in the request
            request.setAttribute("ad", ad);
            request.setAttribute("user", user);

            // Forward the request to the show ad JSP page
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ad.jsp"); // Replace with your JSP page path
            dispatcher.forward(request, response);
        } else {
            // Handle the case when the ad doesn't exist
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle POST requests if necessary
    }
}
