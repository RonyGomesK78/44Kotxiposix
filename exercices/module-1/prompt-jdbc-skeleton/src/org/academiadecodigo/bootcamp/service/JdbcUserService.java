package org.academiadecodigo.bootcamp.service;

import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.persistence.ConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class JdbcUserService implements UserService {

    private Connection connection;
    private ConnectionManager connectionManager;

    public JdbcUserService(String url, String user, String pass) {

        connectionManager = new ConnectionManager();
        connection = connectionManager.getConnection(url, user, pass);
    }

    @Override
    public boolean authenticate(String username, String password){

        Statement auth = null;
        try {

            auth = connection.createStatement();

            String query = "SELECT * FROM user where username = '" +
                    username + "' AND password = '" + password +"';";

            ResultSet resultSet = auth.executeQuery(query);

            if (resultSet.next()) {
                return true;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    @Override
    public void add(User user) {

        if (findByName(user.getUsername()) != null){
            return;
        }

        String query = "INSERT INTO user (username, password, email, firstname, lastname, phone)" +
                "VALUES(" +
                    "'" + user.getUsername() +
                    "','" + user.getPassword() +
                    "','" + user.getEmail() +
                    "','" + user.getFirstName() +
                    "','" + user.getLastName() +
                    "','" + user.getPhone() + "');";

        try {

            Statement insert = connection.createStatement();
            insert.executeUpdate(query);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public User findByName(String username) {

        String query = "SELECT * FROM user WHERE username = '" + username + "';";
        try {

            Statement findByName = connection.createStatement();
            ResultSet resultSet = findByName.executeQuery(query);

            if (resultSet.next()) {

                return new User(
                        resultSet.getString("username"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("phone")
                );
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public List<User> findAll() {

        String query = "SELECT *FROM user;";

        try {

            Statement getAll = connection.createStatement();
            ResultSet resultSet = getAll.executeQuery(query);

            List<User> users = new LinkedList<>();
            while (resultSet.next()){

                users.add(
                        new User(
                                resultSet.getString("username"),
                                resultSet.getString("email"),
                                resultSet.getString("password"),
                                resultSet.getString("firstname"),
                                resultSet.getString("lastname"),
                                resultSet.getString("phone"))
                );
            }

            return users;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public int count() {
        return 0;
    }
}
