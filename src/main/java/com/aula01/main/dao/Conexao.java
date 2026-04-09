/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aula01.main.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author farma
 */
public class Conexao {
    private static final String url = "jdbc:mysql://localhost:3306/empresa_db";
    private static final String user = "root";
    private static final String senha = "caca010109";
    
    public static Connection conectar () {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, senha);
        } catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }
}
