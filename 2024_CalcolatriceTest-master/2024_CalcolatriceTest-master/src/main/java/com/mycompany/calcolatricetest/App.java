/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calcolatricetest;

/**
 *
 * @author gian
 */
public class App {

    public static void main(String[] args)
    {
        Calcolatrice c1=new Calcolatrice();
        int f[];
        f=c1.fibonacci(10);
        for(int i=0;i<f.length;i++)
        {
            System.out.print(f[i]+"\t");
        }
    }
}
