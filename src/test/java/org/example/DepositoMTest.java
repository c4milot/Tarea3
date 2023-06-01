package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepositoMTest {
    private DepositoM depositoMTest;

    @BeforeEach
    void setUp() {
        depositoMTest = new DepositoM();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("test agregar moneda")
    public void addMoneda() {
        Moneda moned = new Moneda500();
        depositoMTest.addMoneda(moned);
        assertEquals(1, depositoMTest.almM.size());
        assertEquals(moned, depositoMTest.almM.get(0));
    }

    @Test
    @DisplayName("Test sacar moneda")
    public void sacarMoneda() {
        Moneda moned = new Moneda500();
        depositoMTest.addMoneda(moned);
        Moneda monedaRetirada = depositoMTest.getMoneda();

        assertNotNull(monedaRetirada);
        assertEquals(0, depositoMTest.almM.size());
        assertEquals(moned, monedaRetirada);
    }

    @Test
    @DisplayName("Test deposito vacio")
    public void testSinMoneda() {
        Moneda monedaRetirada = depositoMTest.getMoneda();
        assertNull(monedaRetirada);
    }

}