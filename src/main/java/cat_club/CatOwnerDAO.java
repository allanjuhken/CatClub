package dao;

import cat.Cat;
import catOwner.CatOwner;
import connection.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CatOwnerDAO {
    private ConnectionManager connectionManager;

    //constructor
    public CatOwnerDAO() {
        connectionManager = new ConnectionManager();
    }

    public void addCatOwner(CatOwner catOwner) {

        Connection connection = connectionManager.createConnection();

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO `cat_club`.`cat_owner`" +
                            "(`name`," + "`address`," + "`code`)" + "VALUES" + "(?," + "?," + "?);");

            preparedStatement.setString(1, catOwner.getName());
            preparedStatement.setString(2, catOwner.getAddress());
            preparedStatement.setString(3, catOwner.getCode());

            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public CatOwner getCatOwnerById(long id) {
        Connection connection = connectionManager.createConnection();

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT cat_owner.id, cat_owner.name, cat_owner.code, cat_owner.address," +
                        "cat.id as 'cat_id', cat.breed, cat.rating, cat.gender" +
                        " FROM cat_club.cat_owner, cat_club.cat WHERE cat_club.cat_owner.id = cat_club.cat.cat_owner_id AND cat_owner_id = ?;");

            preparedStatement.setLong(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                CatOwner catOwner = new CatOwner();
                catOwner.setId(rs.getLong("id"));
                catOwner.setAddress(rs.getString("address"));
                catOwner.setCode(rs.getString("code"));
                catOwner.setName(rs.getString("name"));

                List<Cat> cats = new ArrayList<>();
                Cat cat = new Cat();
                cat.setId(rs.getLong("cat_id"));
                cat.setBreed(rs.getString("breed"));
                cat.setRating(rs.getLong("rating"));
                cat.setGender(rs.getBoolean("gender"));
                cat.setCatOwner(catOwner);
                cats.add(cat);

                catOwner.setCats(cats);
                return catOwner;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<CatOwner> getAllOwners() {
        Connection connection = connectionManager.createConnection();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM cat_club.cat_owner");

            ResultSet rs = preparedStatement.executeQuery();

            List<CatOwner> catOwners = new ArrayList<>();
            while (rs.next()) {
                CatOwner catOwner = new CatOwner();
                catOwner.setId(rs.getLong("id"));
                catOwner.setAddress(rs.getString("address"));
                catOwner.setCode(rs.getString("code"));
                catOwner.setName(rs.getString("name"));
                catOwners.add(catOwner);
            }
            return catOwners;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
