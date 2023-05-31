package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.UpdateAdServlet", urlPatterns = "/updateAd")
public class UpdateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/updateAd.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Ad selectedAd = (Ad) request.getSession().getAttribute("ad");

        String adTitle = request.getParameter("adTitle");
        String adDescription = request.getParameter("adDescription");

        // validate input
        boolean inputHasErrors = adTitle.isEmpty() || adDescription.isEmpty();

        if (inputHasErrors) {
            response.sendRedirect("/updateAd");
            return;
        }

        // update ad
        DaoFactory.getAdsDao().updateAd(new Ad (selectedAd.getUserId(), adTitle, adDescription));
        response.sendRedirect("/ads");
    }
}

