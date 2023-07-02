/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MotorbikeStore.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class DBConnection {

    private static DBConnection instance = null;
//    private String url = "jdbc:mysql://localhost:3306/web_sale_morcycles_ver2";
//    private String user = "root";
//    private String passWord = "Hdt6102@";
    private String url = "jdbc:mysql://34.87.2.131:3306/motorbikestoreonlinedb";
	private String user ="root";
	private String passWord ="Hdt123@";

    protected DBConnection() {
        // private constructor to prevent direct instantiation
    }

    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");            
            return DriverManager.getConnection(url, user, passWord);
        } catch (ClassNotFoundException | SQLException e) {

            return null;
        }

    }

}
