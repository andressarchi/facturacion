import com.nombreCompania.appfacturas.model.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Andrés", "5555-5");
        cliente.setNif("5555-5");
        cliente.setNombre("Andrés");

        Scanner s = new Scanner(System.in);

        System.out.print("Ingrese una descripción de la factura: ");
        String desc = s.nextLine();

        Factura factura = new Factura(desc, cliente);

        System.out.println();

        for (int i = 0; i < 5; i++) {

            // Código del producto asignado automáticamente en el constructor de Producto
            System.out.print("Ingrese el nombre del producto nº " + (i + 1) + ": ");
            String nombreProducto = s.nextLine();

            System.out.print("Ingrese el precio del producto: ");
            double precioProducto = s.nextDouble();

            System.out.print("Ingrese la cantidad: ");
            int cantidad = s.nextInt();


            Producto producto = new Producto(nombreProducto, precioProducto);
            factura.addItemFactura(new ItemFactura(producto, cantidad));

            System.out.println();
            s.nextLine();
        }

        System.out.println(factura);
    }
}