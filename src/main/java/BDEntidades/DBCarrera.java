/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BDEntidades;

import Entidades.Carrera;
import java.sql.Connection;
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
    
}
    
