package com.example.mydbfx.Models;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseDriver {
    private Connection con;
    private int empId;

    DatabaseDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/after5", "root", "Lawdalashun1024");
            System.out.println("[+] Connected to MySql Database [+]");
        } catch (Exception e) {
            System.out.println("[+] Error Connecting to the MySql Database [+]");
            e.printStackTrace();
        }
    }

    public void setEmpId(int id) {
        this.empId = id;
    }

    public int getEmpId() {
        return this.empId;
    }

    public void runDMLQuery(String query) throws SQLException {
        System.out.println(query);
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            int rowAffected = preparedStatement.executeUpdate();
            System.out.println(rowAffected + " ROWS Affected");
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public ResultSet runQuery(String query) {
        try {
            System.out.println(query);
            Statement statement = con.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<String[]> toString(ResultSet resultSet) {
        ArrayList<String[]> table = new ArrayList<>();
        if(resultSet == null) return table;
        try {
            int n = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {
                String[] data = new String[n];
                for (int i = 1; i <= n; i++) {
                    data[i-1] = resultSet.getString(i).trim();
                }
                table.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return table;
    }
}
