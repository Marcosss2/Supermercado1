/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceep.Supermercado.datos;

import Producto.Producto;
import com.ceep.Supermercado.excepciones.Excepcion;
import java.util.List;

/**
 *
 * @author Alumno mañana
 */
public interface IDatos {
   
   boolean Existe(String nombreArchivo) throws Excepcion;
    List<Producto> Listar(String nombreArchivo) throws Excepcion;
    void Escribir(Producto producto, String nombreArchivo, boolean anexar) throws Excepcion;
    String Buscar(String nombreArchivo, String Buscar) throws Excepcion;
    void Crear(String nombreArchivo) throws Excepcion;
    void Borrar(String nombreArchivo,String buscar);   
    double calcularTotalPrecio(String nombreArchivo);
    int contadorProductos(String nombreArchivo);
    
}
