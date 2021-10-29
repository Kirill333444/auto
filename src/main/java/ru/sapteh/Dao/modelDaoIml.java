package ru.sapteh.Dao;

import ru.sapteh.model.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class modelDaoIml implements Dao<model, Integer> {

    private final Connection connection;

    public modelDaoIml(Connection connection) {
        this.connection = connection;
    }


    @Override
    public model findById(Integer id) {
        String query = "SELECT * FROM auto1.moodel WHERE id=?";
        model model = null;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                model = new model(
                        resultSet.getInt("id"),
                        resultSet.getString("mark"),
                        resultSet.getString("body_type"),
                        resultSet.getString("gasoline")

                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return model;
    }

    @Override
    public List<model> findAll() {
        List<model> model = new ArrayList<>();
        String query = "SELECT * FROM auto1.moodel";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                model.add(
                        new model(
                                resultSet.getInt("id"),
                                resultSet.getString("mark"),
                                resultSet.getString("body_type"),
                                resultSet.getString("gasoline")
                        )
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return model;
    }

    @Override
    public void save(model model) {
        String save = "INSERT INTO auto1.moodel (mark,body_type,gasoline) VALUES (?, ?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(save);
            statement.setString(1, model.getMark());
            statement.setString(2, model.getBody_type());
            statement.setString(3, model.getType_gasoline());
            int result = statement.executeUpdate();
            System.out.println(result == 1 ? "Save success" : "Save failed");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(model model) {
        String update = "UPDATE auto1.moodel SET mark=?, body_type=?,gasoline=?  WHERE id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(update);
            statement.setString(1, model.getMark());
            statement.setString(2, model.getBody_type());
            statement.setString(3, model.getType_gasoline());
            statement.setInt(4, model.getId());
            int result = statement.executeUpdate();
            System.out.println(result == 1 ? "Update success" : "Update failed");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteById(Integer id) {
        String delete = "DELETE FROM auto1.moodel WHERE id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(delete);
            statement.setInt(1, id);
            int result = statement.executeUpdate();
            System.out.println(result == 1 ? "Delete success" : "Delete failed");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}