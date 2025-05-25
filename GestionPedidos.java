package servicio;

import modelo.*;
import excepciones.ProductoNoEncontradoException;

import java.util.Scanner;

public class GestionPedidos {
    private GestionProductos gestionProductos;

    public GestionPedidos(GestionProductos gestionProductos) {
        this.gestionProductos = gestionProductos;
    }

    public Pedido crearPedidoDesdeConsola() {
        Scanner scanner = new Scanner(System.in);
        Pedido pedido = new Pedido();

        String continuar;
        do {
            try {
                System.out.print("Ingrese ID del producto: ");
                int id = Integer.parseInt(scanner.nextLine());
                Producto producto = gestionProductos.buscarProductoPorId(id);

                System.out.print("Ingrese cantidad: ");
                int cantidad = Integer.parseInt(scanner.nextLine());

                pedido.agregarItem(new ItemPedido(producto, cantidad));
                System.out.println("Producto agregado.");

            } catch (ProductoNoEncontradoException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Intente de nuevo.");
            }

            System.out.print("¿Desea agregar otro producto? (s/n): ");
            continuar = scanner.nextLine().trim().toLowerCase();

        } while (continuar.equals("s"));

        return pedido;
    }
}