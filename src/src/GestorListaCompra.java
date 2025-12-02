package src;

import java.util.Scanner;

/**
 * Clase que permite gestionar una lista de la compra mediante operaciones
 * como añadir, eliminar, buscar, mostrar o vaciar productos.
 * 
 * La lista se almacena en un array de Strings con un máximo de 50 elementos.
 */
public class GestorListaCompra {

    /** Array donde se almacenan los productos de la lista. */
    private static String[] lista = new String[50];

    /** Número actual de productos almacenados en la lista. */
    private static int contador = 0;

    /**
     * Método principal que muestra el menú y permite al usuario interactuar
     * con la lista de la compra.
     * 
     * @param args argumentos de ejecución (no utilizados)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("=== Lista de la Compra ===");
            System.out.println("1. Añadir producto");
            System.out.println("2. Eliminar producto");
            System.out.println("3. Buscar producto");
            System.out.println("4. Mostrar lista completa");
            System.out.println("5. Vaciar lista");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpia buffer

            switch (opcion) {
                case 1 -> {
                    System.out.print("Introduce el producto a añadir: ");
                    String p = sc.nextLine();
                    if (addProducto(p)) System.out.println("Producto añadido.");
                    else System.out.println("La lista está llena.");
                }
                case 2 -> {
                    System.out.print("Introduce el producto a eliminar: ");
                    String p = sc.nextLine();
                    if (eliminarProducto(p)) System.out.println("Producto eliminado.");
                    else System.out.println("No se encontró el producto.");
                }
                case 3 -> {
                    System.out.print("Introduce el producto a buscar: ");
                    String p = sc.nextLine();
                    int pos = buscarProducto(p);
                    if (pos != -1) System.out.println("Producto encontrado en posición: " + pos);
                    else System.out.println("No se encontró el producto.");
                }
                case 4 -> {
                    String[] l = obtenerLista();
                    System.out.println("Lista completa:");
                    for (String item : l) System.out.println(item);
                }
                case 5 -> {
                    vaciarLista();
                    System.out.println("Lista vaciada.");
                }
                case 6 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 6);

        sc.close();
    }

    /**
     * Añade un producto al array si hay espacio disponible.
     *
     * @param producto producto que se desea añadir a la lista
     * @return true si el producto se añadió correctamente, false si la lista está llena
     */
    public static boolean addProducto(String producto) {
        if (contador < lista.length) {
            lista[contador++] = producto;
            return true;
        }
        return false;
    }

    /**
     * Elimina un producto de la lista, desplazando los elementos restantes.
     *
     * @param producto producto que se desea eliminar de la lista
     * @return true si el producto existía y fue eliminado, false en caso contrario
     */
    public static boolean eliminarProducto(String producto) {
        for (int i = 0; i < contador; i++) {
            if (lista[i].equalsIgnoreCase(producto)) {
                for (int j = i; j < contador - 1; j++) {
                    lista[j] = lista[j + 1];
                }
                lista[--contador] = null;
                return true;
            }
        }
        return false;
    }

    /**
     * Busca un producto en la lista y devuelve su índice.
     *
     * @param producto producto que se desea buscar
     * @return índice del producto si se encuentra, o -1 si no existe
     */
    public static int buscarProducto(String producto) {
        for (int i = 0; i < contador; i++) {
            if (lista[i].equalsIgnoreCase(producto)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Devuelve una copia exacta de todos los productos actuales de la lista.
     *
     * @return array de Strings con los productos almacenados
     */
    public static String[] obtenerLista() {
        String[] copia = new String[contador];
        System.arraycopy(lista, 0, copia, 0, contador);
        return copia;
    }

    /**
     * Vacía la lista de productos y reinicia el contador.
     */
    public static void vaciarLista() {
        for (int i = 0; i < contador; i++) {
            lista[i] = null;
        }
        contador = 0;
    }
}
