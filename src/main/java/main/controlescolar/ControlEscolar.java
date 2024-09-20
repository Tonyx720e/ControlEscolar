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
            DBCarrera miConexion = new DBCarrera(connection);
            miConexion.setConnection(connection);
                   
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
                    
                    DBCarrera.insert(carrera); // Llamar al método insert correctamente
                    break;
                case 2:
                    System.out.println("ingrese numero  id de carrera");
                    int id = sc.nextByte();
                    sc.nextLine(); // Limpiar el buffer
                    System.out.println("Ingrese nombre");
                    String nombre2 = sc.nextLine();
                    Carrera idC = new Carrera();
                    idC.setNombre(nombre2);
                    idC.setId(id);
                    DBCarrera.update(idC);
                    break;
                case 3:
                   System.out.println("Ingresa el id de la carrera");
                   id = sc.nextInt(); // Cambié a nextInt() para evitar problemas con nextByte()
                   sc.nextLine(); // Limpiar el buffer
                   Carrera verC = new Carrera();
                   verC.setId(id); // Asignar el ID a verC
                   DBCarrera.ver(verC);
                   break;
                case 4:
                    System.out.println("Ingresa id para borrar");
                    id = sc.nextInt();
                    sc.nextLine(); // Limpiar el buffer
                    Carrera deleteC = new Carrera();
                    deleteC.setId(id); // Asignar el ID a verC
                    DBCarrera.deleteC(deleteC);
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
        }while(op !=5);
        //String nombre = sc.nextLine();
        
        
        System.out.println("Conexion cerrada");
    }
}
