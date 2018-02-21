package com.database.systems.fixture.dao;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import static java.lang.System.out;

/**
 * Created by chris on 2/17/18.
 */
public class Dao {

    private static Dao dao = null;
    private Connection connection = null;

    private Dao(){
        String db = Config.DB;
        String username = Config.USER;
        String password = Config.PASSWORD;

        try {
            Class.forName(Config.DRIVER);
            connection = DriverManager.getConnection(db, username, password);
            if(connection == null){
                out.println("Connection failed :(");
                System.exit(0);
            } else {
                out.println("Connection established! :)");
            }
        } catch (ClassNotFoundException | SQLException e) {
            out.println("wtf");
            e.printStackTrace();
        }
    }

    public static Dao getInstance(){
        if (dao == null)
            return new Dao();
        else
            return dao;
    }

    public List<String> getNames() {
        List<String> names = new LinkedList<>();

        try {
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM stagione");

            while (result.next()) {
                String id = result.getString("anno");
                names.add(id + "-");
            }

            result.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return names;
    }

    public static void main(String[] args){
        Dao dao = new Dao();
        List<String> names = dao.getNames();

        names.forEach(out::println);

    }

}
