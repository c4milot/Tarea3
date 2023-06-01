package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompradorTest {

    private Expendedor expendedorPrueba;
    private Comprador compradorTest;
    @BeforeEach
    void setUp() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
       expendedorPrueba = new Expendedor(2);
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    @DisplayName("Test compra correcta")
    public void testCompra() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Moneda1000 moneda = new Moneda1000();
        assertNotNull(compradorTest = new Comprador(moneda, Productos.COCA, expendedorPrueba));
    }
    @Test
    @DisplayName("Test dos compra correcta")
    public void testDosCompras() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Moneda1000 moneda = new Moneda1000();
        assertNotNull(compradorTest = new Comprador(moneda, Productos.COCA, expendedorPrueba));
        assertNotNull(compradorTest = new Comprador(moneda, Productos.COCA, expendedorPrueba));
    }
    @Test
    @DisplayName("Test NoHayProductoException")
    public void testTresCompras() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Moneda1000 moneda = new Moneda1000();
        Exception exception = assertThrows(NoHayProductoException.class, () -> {
            compradorTest = new Comprador(moneda, Productos.COCA, expendedorPrueba);
            compradorTest = new Comprador(moneda, Productos.COCA, expendedorPrueba);
            compradorTest = new Comprador(moneda, Productos.COCA, expendedorPrueba);
        });
    }

    @Test
    @DisplayName("Test PagoInsuficienteException")
    public void testCompraPocoDinero() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Moneda100 moneda = new Moneda100();
        Exception exception = assertThrows(PagoInsuficienteException.class, () -> {
            compradorTest = new Comprador(moneda, Productos.COCA, expendedorPrueba);
        });
    }

    @Test
    @DisplayName("Test PagoIncorrectoException")
    public void testCompraSinDinero() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Exception exception = assertThrows(PagoIncorrectoException.class, () -> {
            compradorTest = new Comprador(null, Productos.COCA, expendedorPrueba);
        });
    }
    @Test
    @DisplayName("Test vuelto")
    public void testvuelto() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Moneda1000 moneda = new Moneda1000();
        compradorTest = new Comprador(moneda, Productos.COCA, expendedorPrueba);
        assertEquals(500, compradorTest.cuantoVuelto());
        System.out.println("el vuelto es $"+compradorTest.cuantoVuelto());
    }

    @Test
    @DisplayName("Test nombreProducto")
    public void nombreProducto() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Moneda1000 moneda = new Moneda1000();
        compradorTest = new Comprador(moneda, Productos.COCA, expendedorPrueba);
        System.out.println("consumio: "+ compradorTest.queConsumio());
        assertEquals("cocacola",compradorTest.queConsumio());
    }
}