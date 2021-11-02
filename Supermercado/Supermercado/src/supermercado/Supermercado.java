/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package supermercado;

import com.ceep.Supermercado.capas.Capa;
import com.ceep.Supermercado.capas.ICapa;
import com.ceep.Supermercado.excepciones.Excepcion;
import java.util.Scanner;

/**
 *
 * @author Alumno mañana
 */
public class Supermercado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Excepcion {
        // TODO code application logic here
        
      
        System.out.println("\nIntroduzca una opcion entre el 0 y 7");
       
        
        
        ICapa productos = new Capa();
        int opciones;
        
        do {
            Scanner entrada = new Scanner(System.in);
            opciones = entrada.nextInt();
            switch(opciones){
           
                
                case 0 :
                    System.out.println("FIN DEL PROGRAMA");
                   break;

               
                case 1 :
                    productos.IniciarArchivo("productos.txt");
                    productos.IniciarArchivo("productos1.txt");
                    System.out.println("\n¿Que más quieres hacer?");
                   break;

                
                case 2 :
                    productos.AgregarProducto("productos.txt", "Manzanas",12,2.50,2022);
                    productos.AgregarProducto("productos1.txt", "cereales", 1, 2, 2022);
                    productos.AgregarProducto("productos.txt", "galletas",20,1.50,2022);
                    System.out.println("\n¿Que más quieres hacer?");

                   break;

               
                case 3:
                    productos.Listar("productos.txt");
                    System.out.println("\n¿Que más quieres hacer?");

                   break;

                
                case 4:
                    productos.Buscar("productos.txt","Manzanas");
                    System.out.println("\n¿Que más quieres hacer?");
                   break;   
                
                
                case 5:
                    productos.PrecioTotal("productos.txt");
                    System.out.println("\n¿Que más quieres hacer?");
                   break;
                   
               
                case 6:
                    productos.contadorProductos("productos.txt");
                    System.out.println("\n¿Que más quieres hacer?");
                   break;
                   
                
                case 7:
                    productos.Borrar("productos.txt", "productos1.txt");
                    System.out.println("\n¿Que más quieres hacer?");
                   break;

                default : 
                        System.out.println("Valor erroneo");
            }
            
        } while (opciones != 0);
        
        
        
    }
    
    
    
    
}
