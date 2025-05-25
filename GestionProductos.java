package servicio;

import modelo.Producto;
import excepciones.ProductoNoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class GestionProductos {
    private List<Producto> productos;

    public GestionProductos() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public List<Producto> listarProductos() {
        return productos;
    }

    public Producto buscarProductoPorId(int id) throws ProductoNoEncontradoException {
        return productos.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ProductoNoEncontradoException("Producto con ID " + id + " no encontrado"));
    }
}