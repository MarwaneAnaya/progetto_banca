/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calcolatricetest;

/**
 *
 * @author gian
 */
public class Calcolatrice 
{
    public int somma(int x, int y)
    {
        return x+y;
    }
    
    public int sottrai(int x, int y)
    {
        return x-y;
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    public int dividi(int x, int y)
    {
        return x/y;
    }
    
    public int valoreAssoluto(int x)
    {
        if (x<0)
            x=-x;
        return x;
    }
    
    public int[] fibonacci(int n)
    {
        int[] f=new int[n];
        int n_1=1;
        int n_2=1;
        if (n==1)
            f[0]=1;
        else if(n>=2)
        {
            f[0]=n_2;
            f[1]=n_1;
            for(int i=2;i<n;i++)
            {
                f[i]=n_1+n_2;
                n_1=f[i];
                n_2=f[i-1];
            }
        }
        return f;
    }
}
