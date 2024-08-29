package com.nombreCompania.appfacturas.model;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Factura {
    private int folio;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private ItemFactura[] items;



    private int indiceItems = 0;
    private static final int MAX_ITEMS = 10;
    private static int ultimoFolio = 0;

    // Constructor
    public Factura(String descripcion, Cliente cliente) {
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.fecha = new Date(); // Fecha actual
        this.items = new ItemFactura[MAX_ITEMS]; // Inicializa el arreglo de ítems con el tamaño máximo permitido

        // Asigna un folio único incrementando el último folio
        ultimoFolio++;
        this.folio = ultimoFolio;
    }

    // Método para añadir ítems a la factura
    public void addItemFactura(ItemFactura item) {
        if (indiceItems < MAX_ITEMS) {
            items[indiceItems] = item;
            indiceItems++;
        } else {
            System.out.println("No se pueden agregar más ítems. Se alcanzó el máximo permitido.");
        }
    }

    /**
     * Calcula el importe total de la factura sumando el importe de cada ítem en la lista.
     *
     * @return el importe total de la factura, como un valor de tipo {@code float}.
     * Si la lista de ítems está vacía o todos los ítems son {@code null}, el valor retornado será 0.0.
     */
    public float calcularTotal() {
        float total = 0.0f; //0.0f indica que el número es un valor floa
        for (ItemFactura item : items) {
            if (item != null) {
                total += item.calcularImporte();
            }
        }
        return total;
    }

    // Método para generar el detalle de la factura
    public String generarDetalle() {
        StringBuilder sb = new StringBuilder("Factura Nº: ");
        sb.append(folio)
                .append("\nCliente: ")
                .append(this.cliente.getNombre())
                .append("\t NIF: ")
                .append(cliente.getNif())
                .append("\nDescripción: ")
                .append(this.descripcion)
                .append("\n");

        SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMMM, yyyy");
        sb.append("Fecha Emisión: ")
                .append(df.format(this.fecha))
                .append("\n")
                .append("\n#\tNombre\t$\tCant.\tTotal\n");

        for (int i = 0; i < indiceItems; i++) {
            ItemFactura item = items[i];
            if (item != null) {
                sb.append(i + 1) // Número del ítem
                        .append("\t")
                        .append(item)
                        .append("\n");
            }
        }
        sb.append("\nGran Total: ")
                .append(calcularTotal());
        return sb.toString();
    }

    @Override
    public String toString() {
        return generarDetalle();
    }
}