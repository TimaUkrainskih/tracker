package ru.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection connection;

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection connection) {
        this.connection = connection;
    }

    private void init() {
        try (InputStream input = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(input);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    @Override
    public Item add(Item item) {
        String sqlQuery = "insert into item(name, created_datetime) values(?,?)";
        try (PreparedStatement statement = this.connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.execute();
            try (ResultSet resultSet = statement.getResultSet()) {
                if (resultSet.next()) {
                    item.setId(resultSet.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        String sqlQuery = "update item set name = ?, created_datetime = ? where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.setInt(3, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sqlQuery = "delete from item where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        String sqlQuery = "select id, name, created_datetime from item";
        try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.execute();
            try (ResultSet resultSet = statement.getResultSet()) {
                while (resultSet.next()) {
                    items.add(
                            new Item(
                                    resultSet.getInt("id"),
                                    resultSet.getString("name"),
                                    resultSet.getTimestamp("created_datetime").toLocalDateTime()
                            )
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> items = new ArrayList<>();
        String sqlQuery = "select id, name, created_datetime from item where name = ?";
        try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setString(1, key);
            statement.execute();
            try (ResultSet resultSet = statement.getResultSet()) {
                while (resultSet.next()) {
                    items.add(
                            new Item(
                                    resultSet.getInt("id"),
                                    resultSet.getString("name"),
                                    resultSet.getTimestamp("created_datetime").toLocalDateTime()
                            )
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return items;
    }

    @Override
    public Item findById(int id) {
        String sqlQuery = "select id, name, created_datetime from item where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setInt(1, id);
            statement.execute();
            try (ResultSet resultSet = statement.getResultSet()) {
                if (resultSet.next()) {
                    return new Item(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getTimestamp("created_datetime").toLocalDateTime()
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}