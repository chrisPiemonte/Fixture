package com.database.systems.fixture.dao;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import static java.lang.System.out;

/**
 * Created by chris on 2/17/18.
 */
public class DaoOracle {

    private static DaoOracle dao = null;
    private Connection connection = null;

    private DaoOracle(){
        String db = ConfigOracle.DB;
        String username = ConfigOracle.USER;
        String password = ConfigOracle.PASSWORD;

        try {
            Class.forName(ConfigOracle.DRIVER);
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

    public static DaoOracle getInstance(){
        if (dao == null)
            return new DaoOracle();
        else
            return dao;
    }

    public List<String> getNames() {
        List<String> names = new LinkedList<>();

        try {
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM Partecipants");

            while (result.next()) {
                String id = result.getString("surname");
                String nome = result.getString("name");
                names.add(id + "-" + nome);
            }

            result.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return names;
    }

    public static void main(String[] args){
        DaoOracle dao = new DaoOracle();
        List<String> names = dao.getNames();

        names.forEach(out::println);

    }

}
