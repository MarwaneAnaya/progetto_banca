/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.calcolatricetest;

import java.util.Random;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;


/**
 *
 * @author gian
 */
public class CalcolatriceTest {
    
    public CalcolatriceTest() {
    }

    /**
     * Test of somma method, of class Calcolatrice.
     */
    @Test
    public void testSomma() {
        Calcolatrice c1=new Calcolatrice();
        int atteso=8;
        int attuale;
        
        attuale=c1.somma(3, 5);
        assertEquals(atteso, attuale,"Somma fra 3 e 5");
    }

    /**
     * Test of sottrai method, of class Calcolatrice.
     */
    @Test
    public void testSottrai() {
         Calcolatrice c1=new Calcolatrice();
        int atteso=8;
        int attuale;
        
        attuale=c1.sottrai(10, 2);
        assertEquals(atteso, attuale,"Sottrazione fra 10 e 2");
    }

    /**
     * Test of dividi method, of class Calcolatrice.
     */
    @Test
    public void testDividi() {
         Calcolatrice c1=new Calcolatrice();
        int atteso=8;
        int attuale;
        
        attuale=c1.dividi(16, 2);
        assertEquals(atteso, attuale,"Divisione fra 16 e 8");
    }
    
    
     /**
     * Test of valoreAssoluto method, of class Calcolatrice.
     */
    @Test
    public void testValoreAssoluto() {
         Calcolatrice c1=new Calcolatrice();
         
        Random r=new Random();
        
         int x;
         int atteso;
         
         
         for(int i=0;i<1000;i++)
         {
             x=r.nextInt(-500, 500);
             atteso=c1.valoreAssoluto(x);
             assertTrue(atteso>=0,"Valore assoluto positivo");
         }
       
    }
    
     /**
     * Test of fibonacci method, of class Calcolatrice.
     */
    @Test
    public void testFibonacci() {
         Calcolatrice c1=new Calcolatrice();
         
        int[] atteso1={1};
        int[] atteso2={1,1};
        int[] atteso9={1,1,2,3,5,8,13,21,34};
        
        int[] attuale;
        attuale=c1.fibonacci(1);
        assertArrayEquals(atteso1, attuale);
        attuale=c1.fibonacci(2);
        assertArrayEquals(atteso2, attuale);
        attuale=c1.fibonacci(9);
        assertArrayEquals(atteso9, attuale);

    }
    
    
}
