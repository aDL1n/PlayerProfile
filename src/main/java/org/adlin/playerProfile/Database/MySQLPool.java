package org.adlin.playerProfile.Database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.adlin.playerProfile.Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLPool {
    private final Main plugin;
    private HikariDataSource dataSource;
    private String hostname;
    private String port;
    private String database;
    private String username;
    private String password;
    private int minimumIdlePools;
    private int maximumPools;
    private long connectionTimeout;

    public MySQLPool(Main plugin){
        this.plugin = plugin;
        init();
        setupPool();
        createTable();
    }


    private void init(){
        hostname = "localhost";
        port = "3306";
        database = "new_schema";
        username = "root";
        password = "0000";
        connectionTimeout = 3000;
        minimumIdlePools = 1;
        maximumPools = 100;
    }

    private void setupPool(){
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://" + hostname + ":" + port + "/" + database);
        config.setDriverClassName("com.mysql.jdbc.Driver");
        config.setUsername(username);
        config.setPassword(password);
        config.setMinimumIdle(minimumIdlePools);
        config.setMaximumPoolSize(maximumPools);
        config.setConnectionTimeout(connectionTimeout);
        dataSource = new HikariDataSource(config);
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void closePool(){
        if (dataSource != null && !dataSource.isClosed()){
            dataSource.close();
        }
    }

    public void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        if (connection != null) try { connection.close(); } catch (SQLException exception) { plugin.getConsole().sendMessage(exception.toString()); }
        if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException exception) { plugin.getConsole().sendMessage(exception.toString()); }
        if (resultSet != null) try { resultSet.close(); } catch (SQLException exception) { plugin.getConsole().sendMessage(exception.toString()); }
    }

    public void createTable() {
        PreparedStatement preparedStatement = null;
        Connection connection = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS player_profile(player_name VARCHAR(255) PRIMARY KEY, uuid VARCHAR(36) NOT NULL UNIQUE, kills INT DEFAULT 0, deaths INT DEFAULT 0, play_time INT DEFAULT 0, first_login TIMESTAMP DEFAULT CURRENT_TIMESTAMP, last_login TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP)");
            preparedStatement.executeUpdate();
        } catch (SQLException exception){
            plugin.getConsole().sendMessage(exception.toString());
        } finally {
            close(connection, preparedStatement, null);
        }
    }

     public void createPlayerProfile(String playerName) throws SQLException {
         String query = "INSERT INTO player_profiles (player_nam) VALUES (?)";
         try (Connection connection = getConnection();
              PreparedStatement statement = connection.prepareStatement(query)) {
             statement.setString(1, playerName);
             statement.executeUpdate();
         }
     }
}