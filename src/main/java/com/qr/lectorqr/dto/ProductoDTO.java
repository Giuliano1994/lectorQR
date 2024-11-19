package com.qr.lectorqr.dto;

public class ProductoDTO {
    private String nombre;
    private String descripcion;
    private Double precioUnitario;
    private Double precioMayorista;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getPrecioMayorista() {
        return precioMayorista;
    }

    public void setPrecioMayorista(Double precioMayorista) {
        this.precioMayorista = precioMayorista;
    }

}
