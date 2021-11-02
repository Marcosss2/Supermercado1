/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ceep.Supermercado.capas;

import com.ceep.Supermercado.excepciones.Excepcion;

/**
 *
 * @author Alumno mañana
 */
public interface ICapa {
  
    void AgregarProducto(String nombreArchivo, String nombreP, int cantidad, double precio,int fechaCaducidad);
    void Listar (String nombreArchivo);
    void Buscar(String nombreArchivo, String buscar) throws Excepcion;
    void IniciarArchivo(String nombreArchivo);
    void Borrar(String nombreArchivo, String buscar);
    void PrecioTotal(String nombreArchivo);
    void contadorProductos(String nombreArchivo);
    
    
}
