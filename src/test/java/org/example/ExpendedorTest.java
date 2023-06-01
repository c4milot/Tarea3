package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpendedorTest {
    private Expendedor expendedorPrueba;
    private Moneda mon;

    @BeforeEach
    void setUp() {
        expendedorPrueba = new Expendedor(3);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Test compra una Bebida")
    public void testCompraUnaBebida() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        mon = new Moneda1000();
        assertNotNull(expendedorPrueba.comprarProducto(mon, Productos.COCA));
    }
    @Test
    @DisplayName("Test compra tres Bebida")
    public void testCompraTresBebida() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        mon = new Moneda1000();
        assertNotNull(expendedorPrueba.comprarProducto(mon, Productos.COCA));
        assertNotNull(expendedorPrueba.comprarProducto(mon, Productos.COCA));
        assertNotNull(expendedorPrueba.comprarProducto(mon, Productos.COCA));
    }
    @Test
    @DisplayName("Test NoHayProductoException")
    public void testCompraCuatroBebida() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        mon = new Moneda1000();
        Exception exception = assertThrows(NoHayProductoException.class, () -> {
            expendedorPrueba.comprarProducto(mon, Productos.COCA);
            expendedorPrueba.comprarProducto(mon, Productos.COCA);
            expendedorPrueba.comprarProducto(mon, Productos.COCA);
            expendedorPrueba.comprarProducto(mon, Productos.COCA);
        });
    }
    @Test
    @DisplayName("Test PagoInsuficienteException")
    public void testCompraPocoDinero() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        mon = new Moneda100();
        Exception exception = assertThrows(PagoInsuficienteException.class, () -> {
            expendedorPrueba.comprarProducto(mon, Productos.COCA);
        });
    }
    @Test
    @DisplayName("Test PagoIncorrectoException")
    public void testCompraSinDinero() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Exception exception = assertThrows(PagoIncorrectoException.class, () -> {
            expendedorPrueba.comprarProducto(null, Productos.COCA);
        });
    }
    @Test
    void getVuelto() {
    }
}