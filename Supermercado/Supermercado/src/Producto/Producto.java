/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Producto;


public class Producto {
 
  private String nombreP;  
  private int cantidad; 
  private double Precio;
  private int fechaCaducidad;

    public Producto() {
    }

    public Producto(String nombreP) {
        this.nombreP = nombreP;
    }

    public Producto(String nombreP, int cantidad) {
        this.nombreP = nombreP;
        this.cantidad = cantidad;
    }

    public Producto(String nombreP, int cantidad, double Precio, int fechaCaducidad) {
        this.nombreP = nombreP;
        this.cantidad = cantidad;
        this.Precio = Precio;
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getNombreP() {
        return nombreP;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return Precio;
    }

    public int getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public void setFechaCaducidad(int fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }
    
  
    
    
}
