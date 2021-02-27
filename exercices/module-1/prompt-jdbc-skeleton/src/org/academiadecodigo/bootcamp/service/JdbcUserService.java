package org.academiadecodigo.bootcamp.service;

import com.sun.codemodel.internal.JStatement;
import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.persistence.ConnectionManager;
import org.academiadecodigo.bootcamp.utils.Security;

import java.sql.*;
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

        boolean valid = false;
        try {

            String query = "SELECT * FROM user WHERE username = ? " +
                    "AND password = ?";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(2, Security.getHash(password));
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                valid = true;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }

        return valid;
    }

    @Override
    public void add(User user) {

        if (findByName(user.getUsername()) != null){
            return;
        }

        String query = "INSERT INTO user (username, password, email, firstname, lastname, phone) " +
                "VALUES(?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement insert = connection.prepareStatement(query);

            insert.setString(1, user.getUsername());
            insert.setString(2, user.getPassword());
            insert.setString(3, user.getEmail());
            insert.setString(4, user.getFirstName());
            insert.setString(5, user.getLastName());
            insert.setString(6, user.getPhone());

            insert.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public User findByName(String username) {

        String query = "SELECT * FROM user WHERE username = ?";
        try {

            PreparedStatement findByName = connection.prepareStatement(query);
            findByName.setString(1, username);

            ResultSet resultSet = findByName.executeQuery();

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

        List<User> users= null;
        String query = "SELECT *FROM user";

        try {

            PreparedStatement getAll = connection.prepareStatement(query);
            ResultSet resultSet = getAll.executeQuery();

            users = new LinkedList<>();
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

        return users;
    }

    @Override
    public int count() {

        int result = 0;
        String query = "SELECT COUNT(*) FROM user";

        try {

            PreparedStatement count = connection.prepareStatement(query);
            ResultSet resultSet = count.executeQuery();

            if(resultSet.next()){
                result = resultSet.getInt("id");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }
}
