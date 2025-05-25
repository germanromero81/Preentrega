package modelo;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<ItemPedido> items;

    public Pedido() {
        this.items = new ArrayList<>();
    }

    public void agregarItem(ItemPedido item) {
        items.add(item);
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemPedido item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

    public List<ItemPedido> getItems() {
        return items;
    }
}