/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aula01.main.dao;

import com.aula01.main.model.FuncionarioBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author farma
 */
public class FuncionarioDAO {
    
    public List<FuncionarioBean> listarFuncionarios() {
        List<FuncionarioBean> lista = new ArrayList();
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("select * from funcionario");
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                FuncionarioBean funcionario = new FuncionarioBean();
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setDepartamento(rs.getString("departamento"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setDataContratacao(rs.getDate("data_contratacao"));
                
                lista.add(funcionario);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return lista;
    }
    public int totalFuncionarios() {
        int total = 0;
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("select count(*) as total from funcionario");
            rs = stmt.executeQuery();
           
            if(rs.next()) {
                total = rs.getInt("total");
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return total;
    }
    public List<FuncionarioBean> tecnologia() {
        List<FuncionarioBean> listaFiltrada = new ArrayList();
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("select * from funcionario where departamento = 'Tecnologia'");
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                FuncionarioBean funcionarioFiltrado = new FuncionarioBean();
                funcionarioFiltrado.setId(rs.getInt("id"));
                funcionarioFiltrado.setNome(rs.getString("nome"));
                funcionarioFiltrado.setDepartamento(rs.getString("departamento"));
                funcionarioFiltrado.setEmail(rs.getString("email"));
                funcionarioFiltrado.setDataContratacao(rs.getDate("data_contratacao"));
                
                listaFiltrada.add(funcionarioFiltrado);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return listaFiltrada;
    }
    
}
