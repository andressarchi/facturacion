package com.nombreCompania.appfacturas.model;

public class Producto {
    private String codigo;
    private String nombre;
    private double precio;

    /**
     * El último código asignado a un producto.
     * Este campo se usa para generar nuevos códigos únicos para cada instancia de {@code Producto}.
     */
    private static int ultimoCodigo = 0;

    /**
     * Constructor que asigna automáticamente un código único al producto
     * incrementando {@code ultimoCodigo}.
     */
    public Producto(String nombre, double precio) {
        ultimoCodigo++;
        this.codigo = "P" + String.format("%05d", ultimoCodigo);
        this.nombre = nombre;
        this.precio = precio;
    }

    // Siguen los getters y setters

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Devuelve una representación en cadena del producto.
     * <p>
     * La representación incluye el código, nombre y precio del producto, separados por tabulaciones.
     * </p>
     *
     * @return Una cadena que representa el producto.
     */
    @Override
    public String toString() {
        return getCodigo() + "\t" + getNombre() + "\t" + getPrecio();
    }
}