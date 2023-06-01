package com.codeup.adlister.controllers;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "UpdateAdServlet", urlPatterns = "/updateAd")
public class UpdateAdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String deleteAd = request.getParameter("deleteBtn");
        System.out.println(deleteAd);
        if (deleteAd != null) {
            DaoFactory.getAdsDao().deleteAd(Long.valueOf(deleteAd));
            response.sendRedirect("/ads");
        } else {
            String updateAd = request.getParameter("updateBtn");
            Ad ad = DaoFactory.getAdsDao().selectAdById(Long.valueOf(updateAd));
            request.setAttribute("ad",ad);
            System.out.println(updateAd);
            request.getRequestDispatcher("/WEB-INF/updateAd.jsp").forward(request, response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get ad details from the request parameters
        String adTitle = request.getParameter("title");
        String adDescription = request.getParameter("description");
        long adId = Long.parseLong(request.getParameter("id"));

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


        response.sendRedirect("/ads");
    }
}