package pl.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcMain {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        final String driver = "com.mysql.cj.jdbc.Driver";
        Class.forName(driver);

        final String dbPath = "jdbc:mysql://localhost:3306/world?serverTimezone=UTC&useSSL=false";
        Connection conn = DriverManager.getConnection(dbPath, "root", "admin");

        Statement statement = conn.createStatement();
        final String sqlQuery = "SELECT Name, Population FROM city";
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        String cityName = null;
        int cityPopulation = 0;
        while(resultSet.next()) {
            cityName = resultSet.getString("Name");
            cityPopulation = resultSet.getInt("Population");
            System.out.println(cityName + " " + cityPopulation);
        }

        if(conn != null) {
            conn.close();
        }

    }
}