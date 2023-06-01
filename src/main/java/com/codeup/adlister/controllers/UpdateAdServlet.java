package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.UpdateAdServlet", urlPatterns = "/updateAd")
public class UpdateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the adId parameter from the URL
        String adIdParameter = request.getParameter("adId");

        // Check if adId parameter is provided and valid
        if (adIdParameter == null || adIdParameter.isEmpty()) {
            System.out.println("adId is missing or empty"); // Debugging statement
            // Handle the case where adId is missing or empty
            response.sendRedirect("/ads");
            return;
        }

        try {
            long adId = Long.parseLong(adIdParameter);
            System.out.println(adId);

            // Get the ad from the database
            Ad selectedAd = DaoFactory.getAdsDao().getAd(adId);

            // Check if ad is found
            if (selectedAd == null) {
                System.out.println("Ad not found"); // Debugging statement
                // Handle the case where the ad is not found
                response.sendRedirect("/ads");
                return;
            }

            // Set the ad and adId as attributes to be accessed in the JSP
            request.setAttribute("ad", selectedAd);
            request.setAttribute("adId", adId);

            // Forward the request to the JSP for rendering
            request.getRequestDispatcher("/WEB-INF/updateAd.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            System.out.println("Invalid adId format"); // Debugging statement
            // Handle the case where adId is not a valid number
            response.sendRedirect("/ads");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get ad details from the request parameters
        String adTitle = request.getParameter("adTitle");
        String adDescription = request.getParameter("adDescription");

        long adId = Long.parseLong(request.getParameter("adId"));

        // Get the ad from the database
        Ad ad = DaoFactory.getAdsDao().getAd(adId);
        if (ad == null) {
            // Handle the case where the ad is not found
            response.sendRedirect("/ads");
            return;
        }

        // Update the ad details
        ad.setTitle(adTitle);
        ad.setDescription(adDescription);
        DaoFactory.getAdsDao().updateAd(ad);

        // Redirect to the profile page or any other appropriate page
        response.sendRedirect("/profile");
    }
}