package disqueria;

import modelo.*;
import servicio.*;
import excepciones.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestionProductos gestionProductos = new GestionProductos();
        GestionPedidos gestionPedidos = new GestionPedidos(gestionProductos);

        gestionProductos.agregarProducto(new Disco(1, "Thriller", 20.0, "Michael Jackson", "Pop"));
        gestionProductos.agregarProducto(new Disco(2, "Invicible Shield", 18.5, "Judas Priest", "Heavy Metal"));
        gestionProductos.agregarProducto(new Disco(3, "Dopadromo", 22.0, "Babasonicos", "Alternative Rock"));
        o
        boolean salir = false;

        while (!salir) {
            System.out.println("\n==== Disquería Online ====");
            System.out.println("1. Ver productos");
            System.out.println("2. Crear pedido");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("\nCatálogo de productos:");
                    for (Producto p : gestionProductos.listarProductos()) {
                        System.out.println(p.getId() + ": " + p.getDescripcion() + " - $" + p.getPrecio());
                    }
                    break;
                case "2":
                    Pedido pedido = gestionPedidos.crearPedidoDesdeConsola();
                    System.out.println("\nResumen del pedido:");
                    for (ItemPedido item : pedido.getItems()) {
                        System.out.println(item.getCantidad() + " x " + item.getProducto().getDescripcion() +
                                " = $" + item.getSubtotal());
                    }
                    System.out.println("TOTAL: $" + pedido.calcularTotal());
                    break;
                case "3":
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }

        System.out.println("Gracias por usar la disquería online.");
    }
}