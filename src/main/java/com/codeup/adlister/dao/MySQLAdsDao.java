package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(user_id, title, description) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId()); // Update this line to use ad.getUserId()
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    @Override
    public List<Ad> findByUserId(long id) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads WHERE user_id = ?");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving ads by user ID.", e);
        }
    }

    public List<Ad> AdSearch(String userSearch) {
//        System.out.println(userSearch);

        List<Ad> matchingAds;

        try {
            String findAds = "SELECT * FROM ads WHERE title LIKE ? OR description LIKE ?";
            PreparedStatement stmt = connection.prepareStatement(findAds);
            stmt.setString(1, "%" +userSearch+ "%");
            stmt.setString(2, "%" +userSearch+ "%");

            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
//                System.out.println(matchingAds);



        } catch (Exception e) {
            throw new RuntimeException("Error finding user");
        }


    }




    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getString("title"),
                rs.getString("description")
        );
    }


    @Override
    public Ad getAd(long adId) {
        try {
                     String query = "SELECT * FROM ads WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, adId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                long id = rs.getLong("id");
                long userId = rs.getLong("user_id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                return new Ad(id, userId, title, description);
            }

            // If no ad is found, return null
            return null;
        } catch (SQLException e) {
            // Handle any potential exceptions
            e.printStackTrace();
            return null;
        }
    }



    @Override
    public void updateAd(Ad ad) {
        try {
            String query = "UPDATE ads SET user_id =?, title =?, description =? WHERE id =?";

            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.setLong(4, ad.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating an ad.", e);
        }

    }
// make a query to grab 1 AD by id
    @Override
    public void deleteAd(Ad selectedAd) {
        try {
            String query = "DELETE FROM ads WHERE id =?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, selectedAd.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting an ad.", e);
        }

    }



    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }

    @Override
    public Ad findById(long id) {
        try {
            String query = "SELECT * FROM ads WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Ad ad = new Ad(
                        rs.getLong("id"),
                        rs.getString("title"),
                        rs.getString("description")

                );

                return ad;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }
}
