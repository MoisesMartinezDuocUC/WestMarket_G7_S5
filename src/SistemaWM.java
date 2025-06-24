import java.util.ArrayList;
import java.util.Scanner;

public class SistemaWM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Producto> productos = new ArrayList<>();
        ArrayList<Categoria> categorias = new ArrayList<>();
        categorias.add(new Categoria(1, "Bebidas"));
        categorias.add(new Categoria(2, "Congelados"));
        categorias.add(new Categoria(3, "Lacteos"));
        categorias.add(new Categoria(4, "Aseo"));

        //Menu de opciones
        int opcion;
        do {
            System.out.println("""
                --- West Market ---
                1. Registrar producto
                2. Imprimir productos 
                3. Eliminar producto
                4. Salir
                
                Seleccione una opcion:
                """);
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1: // Registrar producto
                    int cod = pedirEntero("Ingrese codigo:", sc);
                    String desc = pedirTexto("Ingrese descripcion:", sc);
                    int precio = pedirEntero("Ingrese precio:", sc);
                    int stock = pedirEntero("Ingrese stock:", sc);
                    System.out.println("Categorias");
                    for (Categoria c : categorias) {
                        System.out.println(c.getCodigo() + ". " + c.getNombre());
                    }
                    System.out.println("\nAsigne una categoria al producto:");
                    int intentosCat = 0;
                    Categoria categoriaSeleccionada = null;
                    while (intentosCat < 3) {
                        int catCodigo = pedirEntero("Ingrese el código de la categoría:", sc);
                        for (Categoria c : categorias) {
                            if (c.getCodigo() == catCodigo) {
                                categoriaSeleccionada = c;
                                break;
                            }
                        }
                        if (categoriaSeleccionada != null) break;
                        System.out.println("Categoría inválida. Intente nuevamente.");
                        intentosCat++;
                    }
                    if (categoriaSeleccionada == null) {
                        System.out.println("Ha superado el número de intentos permitidos.");
                        System.exit(0);
                    }
                    Producto newProd = new Producto(cod, desc, precio, stock, categoriaSeleccionada);
                    productos.add(newProd);
                    System.out.println("El producto ha sido ingresado");
                    break;

                case 2: //Imprimir productos
                    if (productos.isEmpty()) {
                        System.out.println("El listado de productos esta vacio");
                    } else {
                        System.out.println("--- Listado de productos ---");
                        for (Producto p : productos) {
                            p.imprimirListado();
                        }
                    }
                    break;

                case 3: //Eliminar productos por código
                    if (productos.isEmpty()) {
                        System.out.println("No hay productos para eliminar");
                    } else {
                        System.out.println("--- Productos ingresados ---");
                        for (Producto p : productos) {
                            p.imprimirListadoSimple();
                        }
                        System.out.println("Ingrese el codigo del producto que desea eliminar: ");
                        int codigo = sc.nextInt();
                        sc.nextLine();
                        boolean eliminado = false;
                        for (int i = 0; i < productos.size(); i++) {
                            if (productos.get(i).getCod() == codigo) {
                                productos.remove(i);
                                eliminado = true;
                                System.out.println("El producto ha sido eliminado");
                                break;
                            }
                        }
                        if (!eliminado) {
                            System.out.println("No se encontró un producto con ese código.");
                        }
                    }
                    break;
            }
        } while(opcion != 4);
        System.out.println("Ha salido del sistema");
    }

    public static int pedirEntero(String mensaje, Scanner sc) {
        int intentos = 0;
        while (intentos < 3) {
            System.out.println(mensaje);
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Dato inválido. Intente nuevamente.");
                intentos++;
            }
        }
        System.out.println("Ha superado el número de intentos permitidos.");
        System.exit(0);
        return -1;
    }

    public static String pedirTexto(String mensaje, Scanner sc) {
        int intentos = 0;
        while (intentos < 3) {
            System.out.println(mensaje);
            String input = sc.nextLine();
            if (!input.trim().isEmpty()) {
                return input;
            } else {
                System.out.println("Dato vacío. Intente nuevamente.");
                intentos++;
            }
        }
        System.out.println("Ha superado el número de intentos permitidos.");
        System.exit(0);
        return "";
    }
}
