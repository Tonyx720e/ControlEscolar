/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main.controlescolar;

/**
 *
 * @author tonym
 */
import BDEntidades.BDConection;
import BDEntidades.DBCarrera;
import Entidades.Carrera;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ControlEscolar {
    
    public static void main(String[] args) throws SQLException {
        // APLICACION CONEXION
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = BDConection.getConnection();
            if (connection != null) {
                statement = connection.createStatement();
                resultSet = statement.executeQuery("SELECT * FROM carrera");

                while (resultSet.next()) {
                    System.out.println("ID: " + resultSet.getInt("id"));
                    System.out.println("Nombre: " + resultSet.getString("carrera"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    
        
        Scanner sc = new Scanner(System.in);
        int op = 0;
        
        do{
            System.out.println("Ingrese la opcion");
            System.out.println("1- Añadir carrera");
            System.out.println("2- Actualizar carrera");
            System.out.println("3- Ver carrera");
            System.out.println("4- Borrar carrera");
            System.out.println("5- Salir");
            op = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer
            switch (op){
                case 1:
                    System.out.println("Ingrese nombre de la carrera");
                    String nombre = sc.nextLine();
                    Carrera carrera = new Carrera();
                    carrera.setNombre(nombre);
                    
                    DBCarrera.insert(connection, carrera); // Llamar al método insert correctamente
                    break;
                case 2:
                    //Update BD
                    break;
                case 3:
                    //ver carrera
                    break;
                case 4:
                    // borrar carrera
                break;
                
                case 5:
                    
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                BDConection.closeConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        
                 break;
            }
        }while(op !=4);
        //String nombre = sc.nextLine();
        
        
        System.out.println("Hello World!");
    }
}
