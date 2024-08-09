package com.parida.sagar;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExecutor {

    public static void main(String[] args) {
        DatabaseConnectionManager connectionManager = new DatabaseConnectionManager(
                "postgres", "password123"
        );

        try {
            Connection connection = connectionManager.getConnection();
            CustomerDAO customerDAO = new CustomerDAO(connection);
            OrderDAO orderDAO = new OrderDAO(connection);
            Order order = orderDAO.findById(1000);
            System.out.println(order);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
