import com.nombreCompania.appfacturas.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Factura> facturas = new ArrayList<>();
        String continuar = "si";

        while (continuar.equalsIgnoreCase("si")) {
            // Crear cliente con los valores dados
            Cliente cliente = new Cliente("Andrés", "5555-5");

            System.out.print("Ingrese una descripción de la factura: ");
            String desc = s.nextLine();

            Factura factura = new Factura(desc, cliente);

            for (int i = 0; i < 5; i++) {
                System.out.print("Ingrese el nombre del producto nº " + (i + 1) + ": ");
                String nombreProducto = s.nextLine();

                System.out.print("Ingrese el precio del producto: ");
                double precioProducto = s.nextDouble();

                System.out.print("Ingrese la cantidad: ");
                int cantidad = s.nextInt();

                Producto producto = new Producto(nombreProducto, precioProducto);
                factura.addItemFactura(new ItemFactura(producto, cantidad));

                System.out.println();
                s.nextLine(); // Consumir la línea pendiente

            }

            // Añadir la factura a la lista de facturas
            facturas.add(factura);

            // Preguntar si desea agregar otra factura
            System.out.println("¿Deseas agregar otra factura? (si/no)");
            continuar = s.nextLine();
        }

        // Imprimir todas las facturas
        System.out.println("\nTodas las facturas:");
        for (Factura f : facturas) {
            System.out.println(f);
            System.out.println(); // Línea en blanco entre facturas
        }
        //

        // Cerrar el Scanner
        s.close();
    }
}
