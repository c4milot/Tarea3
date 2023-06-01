package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepositoDTest {
    private DepositoD depositoDTest;

    @BeforeEach
    void setUp() {
        depositoDTest = new DepositoD();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("test agregar dulce")
    public void addDulce() {
        Dulce dulce = new Super8(1);
        depositoDTest.addDulce(dulce);
        assertEquals(1, depositoDTest.almD.size());
        assertEquals(dulce, depositoDTest.almD.get(0));
    }

    @Test
    @DisplayName("Test sacar dulce")
    public void sacarDulce() {
        Dulce dulce = new Super8(1);
        depositoDTest.addDulce(dulce);
        Dulce dulceRetirado = depositoDTest.getDulce();

        assertNotNull(dulceRetirado);
        assertEquals(0, depositoDTest.almD.size());
        assertEquals(dulce, dulceRetirado);
    }
    @Test
    @DisplayName("Test deposito vacio")
    public void testSinDulce() {
        Dulce dulceRetirado = depositoDTest.getDulce();
        assertNull(dulceRetirado);
    }
}