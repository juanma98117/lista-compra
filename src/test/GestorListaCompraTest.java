package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.GestorListaCompra;

class GestorListaCompraTest {

    @BeforeEach
    void limpiarLista() {
        GestorListaCompra.vaciarLista();
    }

    @Test
    void testAddProducto() {
        assertTrue(GestorListaCompra.addProducto("Leche"));
    }

    @Test
    void testEliminarProducto() {
        GestorListaCompra.addProducto("Pan");
        assertTrue(GestorListaCompra.eliminarProducto("Pan"));
        assertFalse(GestorListaCompra.eliminarProducto("Pan"));
    }

    @Test
    void testBuscarProducto() {
        GestorListaCompra.addProducto("Huevos");
        assertNotEquals(-1, GestorListaCompra.buscarProducto("Huevos"));
        assertEquals(-1, GestorListaCompra.buscarProducto("Leche"));
    }

    @Test
    void testObtenerLista() {
        GestorListaCompra.addProducto("Arroz");
        String[] lista = GestorListaCompra.obtenerLista();
        assertEquals(1, lista.length);
        assertEquals("Arroz", lista[0]);
    }

    @Test
    void testVaciarLista() {
        GestorListaCompra.addProducto("Azúcar");
        GestorListaCompra.vaciarLista();
        assertEquals(0, GestorListaCompra.obtenerLista().length);
    }
}
