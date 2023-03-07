/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Avell
 */
public class ConnectionFactory {
    
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/todoApp";
    public static final String USER = "root";
    public static final String PASS = "";
    
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception erro) {
            throw new RuntimeException("Erro na conexão com o banco de dados ", erro);
        }
    }
    
    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) connection.close();
        } catch (Exception erro) {
            throw new RuntimeException("Erro ao fechar conexão com o banco de dados ", erro);
        }
    }
    
}