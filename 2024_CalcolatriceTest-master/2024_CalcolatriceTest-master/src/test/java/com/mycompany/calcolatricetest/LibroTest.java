/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.calcolatricetest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author gian
 */
public class LibroTest {
    
    public LibroTest() {
    }

     /**
     * Test of getTitolo method, of class Libro.
     */
    @Test
    public void testCopiaLibro() {
        Libro l1=new Libro("I promessi sposi","Manzoni",500);
        Libro l2=new Libro(l1);
        
        assertEquals(l1,l2,"l1=l2");
    }
    
    /**
     * Test of getTitolo method, of class Libro.
     */
    @Test
    public void testGetTitolo() {
    }

    /**
     * Test of setTitolo method, of class Libro.
     */
    @Test
    public void testSetTitolo() {
    }

    /**
     * Test of getAutore method, of class Libro.
     */
    @Test
    public void testGetAutore() {
    }

    /**
     * Test of setAutore method, of class Libro.
     */
    @Test
    public void testSetAutore() {
    }

    /**
     * Test of getNumeropagine method, of class Libro.
     */
    @Test
    public void testGetNumeropagine() {
    }

    /**
     * Test of setNumeroPagine method, of class Libro.
     */
    @Test
    public void testSetNumeroPagine() {
    }

    /**
     * Test of prezzo method, of class Libro.
     */
    @Test
    public void testPrezzo() {
    }

    /**
     * Test of setCostoPagina method, of class Libro.
     */
    @Test
    public void testSetCostoPagina() {
    }

    /**
     * Test of getCostoPagina method, of class Libro.
     */
    @Test
    public void testGetCostoPagina() {
    }

    /**
     * Test of toString method, of class Libro.
     */
    @Test
    public void testToString() {
    }
    
}
