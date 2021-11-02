/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceep.Supermercado.datos;

import Producto.Producto;
import com.ceep.Supermercado.excepciones.Excepcion;
import com.ceep.Supermercado.excepciones.ExcepcionE;
import com.ceep.Supermercado.excepciones.ExcepcionL;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.stream.FileCacheImageOutputStream;

import com.ceep.Supermercado.datos.IDatos;

import com.ceep.Supermercado.datos.IDatos;

/**
 *
 * @author Alumno mañana
 */
public class Datos  implements IDatos{

    static double total = 0.0;
    static int maxCant = 0;
    
    @Override
    public boolean Existe(String nombreArchivo) throws Excepcion {
      
        File archivo = new File(nombreArchivo);      
        return archivo.exists();
    }

    @Override
    public List<Producto> Listar(String nombreArchivo) throws Excepcion {
      
          File archivo = new File(nombreArchivo);
        List<Producto> lista = new ArrayList<Producto>();
        
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            
            var lectura = entrada.readLine();
            
            while (lectura != null) {
                String[] product = lectura.split(";");
                Producto producto = new Producto(product[0], Integer.parseInt(product[1]), Double.parseDouble(product[2]) ,  Integer.parseInt(product[3]));
                lista.add(producto);
                lectura = entrada.readLine();
            }
            entrada.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace(System.out);
                throw new ExcepcionE("Error de lectura listando las productos");
            } catch (IOException e) {
            e.printStackTrace(System.out);
        }

        return lista;
        
        
        
       
       
    }

    @Override
    public void Escribir(Producto producto, String nombreArchivo, boolean anexar) throws Excepcion {
                  File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            salida.println(producto.getNombreP()+";" + producto.getCantidad()+";" + producto.getPrecio() +";" + producto.getFechaCaducidad());
            salida.close();
            System.out.println("Modificado el contenido con exito\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
            System.out.println("El archivo no existe");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
        
        
    

    @Override
    public String Buscar(String nombreArchivo, String Buscar) throws Excepcion {
         
        File archivo = new File(nombreArchivo);
        String mensaje = "";
        int linea = 0;
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine();
            
            while (lectura != null) {
                String[] product = lectura.split(";");
                linea = linea + 1;
                if(product[0].equalsIgnoreCase(Buscar)){
                    mensaje = "Nombre del archivo : " + nombreArchivo + "\n" + "Producto : " + lectura + "\n" + "Linea : " + linea;
                    break;
                }
                
                lectura = entrada.readLine();
            }
            
            if(lectura == null) {
                System.out.println("el producto no esta en stock");
            }
            
            entrada.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace(System.out);
                System.out.println("Error al leerlo");
            } catch (IOException e) {
            e.printStackTrace(System.out);
            System.out.println("No se ha encontrado el archivo");
        }
        
        return mensaje;
    }

    @Override
    public void Crear(String nombreArchivo) throws Excepcion {
       
        File archivo = new File(nombreArchivo);
        
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("Se ha creado con exito el archivo");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
            throw new ExcepcionE("No se ha podido crear el archivo");
        }
    }

    @Override
    public void Borrar(String nombreArchivo,String buscar) {
        
         File archivo = new File(nombreArchivo);
        
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine();
            
            //Creamos el archivo
            PrintWriter salida = new PrintWriter(archivo);
            System.out.println("Se ha creado con exito el archivo");
            
            while (lectura != null) {
                String[] product = lectura.split(";");
                
                if(product[0].equalsIgnoreCase(buscar)){
                    lectura = entrada.readLine();
                    continue;
                }
                
                //Escribimos las lineas que no queremos eliminar
                salida = new PrintWriter(new FileWriter(archivo, true));
                salida.println(lectura);
                salida.close();
                
                //Pasamos a la siguiente linea
                lectura = entrada.readLine();
            }
            
            if(lectura == null) {
                if(archivo.exists() == true){
                    archivo.delete();
                    System.out.println("El archivo a sido eliminado");
                } else {
                    System.out.println("El archivo que quieres eliminar no existe");
                }
                System.out.println("Se han eliminado las lineas");
            }
            
            entrada.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace(System.out);
                System.out.println("Error al leerlo");
            } catch (IOException e) {
            e.printStackTrace(System.out);
            System.out.println("No se ha encontrado el archivo");
        }
        
        
    }

    @Override
    public double calcularTotalPrecio(String nombreArchivo) {
      File archivo = new File(nombreArchivo);
        
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            
            var lectura = entrada.readLine();
            while (lectura != null) {
                String[] product = lectura.split(";");
                total = total + Double.parseDouble(product[2]);
                lectura = entrada.readLine();
            }
            entrada.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace(System.out);
          try {
              throw new ExcepcionE("Error de lectura listando los productos");
          } catch (ExcepcionE ex) {
              Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
          }
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        return total;
   
    
    }

    @Override
    public int contadorProductos(String nombreArchivo) {
       
         int cantidad = 0;
        File archivo = new File(nombreArchivo);
        
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            
            var lectura = entrada.readLine();
            while (lectura != null) {
                String[] product = lectura.split(";");
                maxCant = maxCant + Integer.parseInt(product[3]);
                lectura = entrada.readLine();
            }
            entrada.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace(System.out);
             try {
                 throw new ExcepcionE("Error de lectura listando las productos");
             } catch (ExcepcionE ex) {
                 Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
             }
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        return maxCant;
        
        
    }
 
    
    
}
