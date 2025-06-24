public class Producto {
    // Declaración de variables
    private int cod;
    private String desc;
    private int precio;
    private int stock;
    private Categoria categoria;

    // Creacion de constructor
    public Producto(int cod, String desc, int precio, int stock, Categoria categoria) {
        this.cod = cod;
        this.desc = desc;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    // Creacion de metodos getter y setter
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void imprimirListado() {
        System.out.println("Código: " + cod);
        System.out.println("Descripción: " + desc);
        System.out.println("Precio: " + precio);
        System.out.println("Categoría: " + categoria.getNombre() + " (Cod: " + categoria.getCodigo() + ")");
        System.out.println("Stock:" + stock);
        System.out.println("--------------------------------------------");
    }

    public void imprimirListadoSimple() {
        System.out.println("Código: " + cod);
        System.out.println("Descripción: " + desc);
        System.out.println("--------------------------------------------");
    }
}
