package westmarket;

public class Productos {
    private int codigo;
    private String descripcion;
    private int precio;
    private int cantidad;
    private Categoria categoria;

    public Productos(int codigo, String descripcion, int precio, int cantidad, Categoria categoria) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void imprimirListado() {
        System.out.println("--- Listado de productos ---");
        System.out.println("Código: " + codigo);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Precio: " + precio);
        System.out.println("Categoría: " + categoria.getNombre() + " (Cod: " + categoria.getCodigo() + ")");
        System.out.println("Stock: " + cantidad);
        System.out.println("---------------------------------");
    }

    public void imprimirListadoSimple() {
        System.out.println("Código: " + codigo + " | Descripción: " + descripcion);
    }
}
