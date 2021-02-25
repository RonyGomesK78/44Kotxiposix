package org.academiadecodigo.bootcamp.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private Connection connection = null;

    public Connection getConnection(String dbUrl, String user, String pass) {

        try {

            if (connection == null) {
                connection = DriverManager.getConnection(dbUrl, user, pass);
            }
        } catch (SQLException e){
            System.out.println("Failure to connect to database : " + e.getMessage());
        }

        return connection;
    }

    public void close(){

        try {

            if (connection != null){
                connection.close();
            }
        }catch (SQLException e){
            System.out.println("Failure to close dabase connections : " + e.getMessage());
        }
    }
}
