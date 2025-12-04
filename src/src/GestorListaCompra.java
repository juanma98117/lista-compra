package src;

import java.util.Scanner;

/**
 * GestorListaCompra
 * 
 * Programa que permite gestionar una lista de la compra con un array de String.
 * Funcionalidades: añadir, eliminar, buscar, mostrar lista completa y vaciar lista.
 */
public class GestorListaCompra {

    private static final int MAX_PRODUCTOS = 50;
    private static String[] lista = new String[MAX_PRODUCTOS];
    private static int numProductos = 0;

    private static Scanner scan = new Scanner(System.in);

    /**
     * Añade un producto a la lista
     * @param producto Nombre del producto a añadir
     * @return true si se añadió correctamente, false si la lista está llena
     */
    public static boolean addProducto(String producto) {
        if (numProductos < MAX_PRODUCTOS) {
            lista[numProductos++] = producto;
            return true;
        }
        return false;
    }

    /**
     * Elimina un producto de la lista
     * @param producto Nombre del producto a eliminar
     * @return true si se eliminó, false si no se encontró
     */
    public static boolean eliminarProducto(String producto) {
        for (int i = 0; i < numProductos; i++) {
            if (lista[i].equalsIgnoreCase(producto)) {
                // mover los elementos hacia atrás
                for (int j = i; j < numProductos - 1; j++) {
                    lista[j] = lista[j + 1];
                }
                lista[--numProductos] = null;
                return true;
            }
        }
        return false;
    }

    /**
     * Busca un producto en la lista
     * @param producto Nombre del producto a buscar
     * @return posición del producto (0 a numProductos-1), -1 si no se encuentra
     */
    public static int buscarProducto(String producto) {
        for (int i = 0; i < numProductos; i++) {
            if (lista[i].equalsIgnoreCase(producto)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Obtiene la lista completa de productos
     * @return array de Strings con los productos añadidos
     */
    public static String[] obtenerLista() {
        String[] copia = new String[numProductos];
        System.arraycopy(lista, 0, copia, 0, numProductos);
        return copia;
    }

    /**
     * Vacía la lista de productos
     */

   /** public static void vaciarLista() {
        for (int i = 0; i < contador; i++) {
            lista[i] = null;
        }
        contador = 0;
    }
=======
    public static void vaciarLista() {
        for (int i = 0; i < numProductos; i++) {
            lista[i] = null;
        }
        numProductos = 0;
    }

    /**
     * Método principal con menú de opciones
     */
    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== Lista de la Compra ===");
            System.out.println("1. Añadir producto");
            System.out.println("2. Eliminar producto");
            System.out.println("3. Buscar producto");
            System.out.println("4. Mostrar lista completa");
            System.out.println("5. Vaciar lista");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");

            String opcion = scan.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Introduce el nombre del producto: ");
                    String prodAdd = scan.nextLine();
                    if (addProducto(prodAdd)) {
                        System.out.println("Producto añadido correctamente.");
                    } else {
                        System.out.println("Lista llena, no se puede añadir.");
                    }
                    break;
                case "2":
                    System.out.print("Introduce el nombre del producto a eliminar: ");
                    String prodDel = scan.nextLine();
                    if (eliminarProducto(prodDel)) {
                        System.out.println("Producto eliminado correctamente.");
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case "3":
                    System.out.print("Introduce el nombre del producto a buscar: ");
                    String prodBus = scan.nextLine();
                    int pos = buscarProducto(prodBus);
                    if (pos != -1) {
                        System.out.println("Producto encontrado en la posición " + pos);
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case "4":
                    String[] listaActual = obtenerLista();
                    if (listaActual.length == 0) {
                        System.out.println("La lista está vacía.");
                    } else {
                        System.out.println("Lista completa:");
                        for (String p : listaActual) {
                            System.out.println("- " + p);
                        }
                    }
                    break;
                case "5":
                    vaciarLista();
                    System.out.println("Lista vaciada correctamente.");
                    break;
                case "6":
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    break;
            }
        }

        scan.close();
    }

	private static void vaciarLista() {
		// TODO Auto-generated method stub
		
	}

}
