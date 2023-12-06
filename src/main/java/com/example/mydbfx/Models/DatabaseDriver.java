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

    public void createTableQuery(String query) {
        System.out.println(query);
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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

    public ArrayList<String> toString(ResultSet resultSet) {
        ArrayList<String> table = new ArrayList<>();
        try {
            int n = resultSet.getMetaData().getColumnCount();
            StringBuilder temp = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                temp.append(resultSet.getMetaData().getColumnName(i)).append("\t | ");
            }
            table.add(temp.toString());

            while (resultSet.next()) {
                temp = new StringBuilder();
                for (int i = 1; i <= n; i++) {
                    temp.append(resultSet.getString(i)).append("\t | ");
                }
                table.add(temp.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return table;
    }
}
