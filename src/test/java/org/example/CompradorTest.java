package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompradorTest {
    private Comprador compradorPrueba;
    private Expendedor expendedorPrueba = new Expendedor(3,500,200);
    private Moneda monedaPrueba = new Moneda1000();
    @BeforeEach
    void setUp() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        compradorPrueba = new Comprador(monedaPrueba, 1, expendedorPrueba);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Test vuelto")
    public void testvuelto() {
        System.out.println("el vuelto es $"+compradorPrueba.cuantoVuelto());
        assertEquals(500, compradorPrueba.cuantoVuelto());
    }

    @Test
    @DisplayName("Test nombreProducto")
    public void nombreProducto() {
        System.out.println("consumio: "+ compradorPrueba.queConsumio());
        assertEquals("cocacola",compradorPrueba.queConsumio());
    }
}