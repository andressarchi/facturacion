package com.nombreCompania.appfacturas.model;

public class ItemFactura {
    private Producto producto;
    private int cantidad;

    /*

    Constructor que inicializa un ÍtemFactura con un producto y una cantidad.*
    @param producto El producto asociado con este ítem de la factura.
    @param cantidad La cantidad de ese producto.*/
    public ItemFactura(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;}

    // Getters y Setters

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }



    /*Método para calcular el importe de un producto.
    La operación es cantidad * precio que tiene el objeto producto.*
            @return El importe calculado.*/
    public float calcularImporte() {
        return (float) (cantidad * producto.getPrecio());}

    /**

     Método para mostrar información del ítem registrado.*
     @return Una cadena que representa el ítem.*/@Override
    public String toString() {
        return producto.getNombre() + "\t" + cantidad + "\t" + calcularImporte();}
}
