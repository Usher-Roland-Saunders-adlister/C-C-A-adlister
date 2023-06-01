package com.codeup.adlister.controllers;
import com.codeup.adlister.dao.Ads;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.Users;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ShowAdServlet", value = "/ShowAdServlet")
public class ShowAdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long adId = Long.parseLong(request.getParameter("id"));

        //Show which user has clicked the Ad.
        request.setAttribute("clickAd", DaoFactory.getAdsDao().findById(adId));

        request.getRequestDispatcher("/WEB-INF/ads/ad.jsp").forward(request, response);


    }
}
