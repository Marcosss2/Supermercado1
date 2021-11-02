/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceep.Supermercado.capas;

import Producto.Producto;
import com.ceep.Supermercado.datos.Datos;
import com.ceep.Supermercado.datos.IDatos;
import com.ceep.Supermercado.excepciones.Excepcion;
import com.ceep.Supermercado.excepciones.ExcepcionE;
import com.ceep.Supermercado.excepciones.ExcepcionL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno mañana
 */
public class Capa implements ICapa{

    private final IDatos datos;
    
    
      public Capa() {
        this.datos = new Datos();
    }
    
     @Override
    public void AgregarProducto(String nombreArchivo, String nombreP, int cantidad,  double Precio, int fechaCaducidad) {
        try {
            Producto producto = new Producto(nombreP,  cantidad,  Precio,  fechaCaducidad);
            if(datos.Existe(nombreArchivo) == true){
                datos.Escribir(producto, nombreArchivo, true);
            } else {
                System.out.println("El archivo no existe");
            }
            
        } catch (ExcepcionE ex) {
            ex.printStackTrace(System.out);
        } catch (Excepcion ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void Listar(String nombreArchivo) {
        List<Producto> lista;
        try {
            lista = datos.Listar(nombreArchivo);
            lista.forEach(producto -> {
                System.out.println("Producto: " + producto.getNombreP() +" | cantidad: " + producto.getCantidad() +" | Precio: "+ producto.getPrecio() +" | gechaDeCaducidad: "+ producto.getFechaCaducidad());
            });
            
        } catch (ExcepcionL e) {
            System.out.println("Error ");
            e.printStackTrace(System.out);
        } catch (Excepcion ex) {
            Logger.getLogger(Capa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void Buscar(String nombreArchivo, String buscar) throws Excepcion {
        try {
            System.out.println(datos.Buscar(nombreArchivo, buscar));
        } catch (ExcepcionL e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void IniciarArchivo(String nombreArchivo) {
        try {
            if(datos.Existe(nombreArchivo) == false){
                datos.Crear(nombreArchivo);
            } else {
                System.out.println("El archivo ya existe");
            }
            
        } catch (Excepcion e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void Borrar(String nombreArchivo,String buscar) {
        datos.Borrar(nombreArchivo, buscar);
        System.out.println("Catalogo eliminado con exito");
    }

    @Override
    public void PrecioTotal(String nombreArchivo) {
        System.out.println("Precio total de las productos: " + datos.calcularTotalPrecio(nombreArchivo)+"€");

    }

    @Override
    public void contadorProductos(String nombreArchivo)  {
        System.out.println("Cantidad de productos: " + datos.contadorProductos(nombreArchivo));
    }

   
  
 
   
    
    
}
