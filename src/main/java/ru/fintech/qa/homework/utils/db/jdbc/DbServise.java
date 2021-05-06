package ru.fintech.qa.homework.utils.db.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbServise {
    public static int executeGetCountRow(final String sql) {
        Connection connection = new DbClient().getConnection();
        int countRow = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                countRow++;
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        }
        return countRow;
    }
    public static int executeUpdate(final String sql) {
        Connection connection = new DbClient().getConnection();
        int updateRow = 0;
        try {
            Statement statement = connection.createStatement();
            updateRow = statement.executeUpdate(sql);
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return updateRow;
    }
}
