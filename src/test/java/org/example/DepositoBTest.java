package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepositoBTest {
    private DepositoB depositoBTest;

    @BeforeEach
    void setUp() {
        depositoBTest = new DepositoB();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("test agregar bebida")
    public void addBebida() {
        Bebida bebida = new CocaCola(1);
        depositoBTest.addBebida(bebida);
        assertEquals(1, depositoBTest.almB.size());
        assertEquals(bebida, depositoBTest.almB.get(0));
    }

    @Test
    @DisplayName("Test sacar bebida")
    public void sacarBebida() {
        Bebida bebida = new CocaCola(1);
        depositoBTest.addBebida(bebida);
        Bebida bebidaRetirada = depositoBTest.getBebida();

        assertNotNull(bebidaRetirada);
        assertEquals(0, depositoBTest.almB.size());
        assertEquals(bebida, bebidaRetirada);
    }

    @Test
    @DisplayName("Test deposito vacio")
    public void testSinBebida() {
        Bebida bebidaRetirada = depositoBTest.getBebida();
        assertNull(bebidaRetirada);
    }
}