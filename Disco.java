package modelo;

public class Disco extends Producto {
    private String artista;
    private String genero;

    public Disco(int id, String descripcion, double precio, String artista, String genero) {
        super(id, descripcion, precio);
        this.artista = artista;
        this.genero = genero;
    }

    public String getArtista() {
        return artista;
    }

    public String getGenero() {
        return genero;
    }
}