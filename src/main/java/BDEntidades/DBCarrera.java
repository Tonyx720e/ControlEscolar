/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BDEntidades;

import Entidades.Carrera;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author tonym
 */
public class DBCarrera {
    
    public static void insert(Connection conn, Carrera carrera) throws SQLException{
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
         //SELECT
            String sql;
            sql = "SELECT * FROM carrera";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString("carrera"));
            }
            // INSERT
            String sqlInsert = "INSERT INTO carrera (carrera) VALUES ('" + carrera.getNombre() + "')";
            st.executeUpdate(sqlInsert);
            System.out.println("Registro insertado");

            //SELECT
            rs = st.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString("carrera"));
            }
            //Update
            
    
    }
    
    public static void update(Connection conn, Carrera idC) throws SQLException{
    
        //SELECT
            String sql;
            sql = "SELECT * FROM carrera";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString("carrera"));
            }
        //Update Carrera
        String sqlUpdate;
        sqlUpdate = "UPDATE carrera SET carrera = ('" + idC.getNombre() + "') WHERE id = ('" + idC.getId() + "')";
        st.executeUpdate(sqlUpdate);
        System.out.println("Registro Actualizado");
    }
     public static void ver(Connection conn, Carrera verC) throws SQLException{
    
        //SELECT
            String sql;
            sql = "SELECT * FROM carrera";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString("carrera"));
            }
        // Ver Carrera
            String sqlVer = "SELECT c.carrera FROM carrera c WHERE id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sqlVer)) {
            pstmt.setInt(1, verC.getId());
            try (ResultSet rs2 = pstmt.executeQuery()) {
            if (rs2.next()) {
                System.out.println("la carrera consultada es: " + rs2.getString("carrera"));
            } else {
                System.out.println("Carrera no encontrada.");
            }
        }
    }
  }
    // Delete
     public static void deleteC(Connection conn, Carrera deleteC) throws SQLException{
         Statement st = null;
         ResultSet rs = null;
        //SELECT
        try {
        // SELECT
        String sql = "SELECT * FROM carrera";
        st = conn.createStatement();
        rs = st.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString("carrera"));
        }

        // Borrar registro
        String sqlDelete = "DELETE FROM CARRERA WHERE ID ="  + deleteC.getId() ;
        
        st.executeUpdate(sqlDelete);
        System.out.println("Registro borrado");

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (conn != null) conn.close();
            System.out.println("Conexión cerrada");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
  }
}

            
  
     

    
