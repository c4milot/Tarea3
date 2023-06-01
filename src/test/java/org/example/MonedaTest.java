package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonedaTest {
    private Moneda100 moneda100;
    private Moneda500 moneda500;
    private Moneda1000 moneda1000;
    private Moneda1500 moneda1500;

    @BeforeEach
    void setUp() {
        moneda100 = new Moneda100();
        moneda500 = new Moneda500();
        moneda1000 = new Moneda1000();
        moneda1500 = new Moneda1500();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Test serie")
    public void getSerie() {
        assertNotNull(moneda100);
        assertNotNull(moneda500);
        assertNotNull(moneda1000);
        assertNotNull(moneda1500);
    }

    @Test
    @DisplayName("Test valor")
    public void getValor() {
        assertEquals(100, moneda100.getValor());
        assertEquals(500, moneda500.getValor());
        assertEquals(1000, moneda1000.getValor());
        assertEquals(1500, moneda1500.getValor());
    }

}