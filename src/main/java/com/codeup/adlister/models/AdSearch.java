package com.codeup.adlister.models;

import java.util.ArrayList;
import java.util.List;

public class AdSearch {
    public List<Ad>searchAdsByTitleorDescription(List<Ad> ads,String title, String description){
        List<Ad> matchingAds = new ArrayList<>();

        for (Ad ad : ads){
            if(ad.getTitle().contains(title) || ad.getDescription().contains(description)){
                matchingAds.add(ad);
            }
        }
        return matchingAds;
    }
}
