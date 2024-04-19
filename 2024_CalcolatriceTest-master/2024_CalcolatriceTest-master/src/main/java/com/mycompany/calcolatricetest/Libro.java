/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calcolatricetest;

/**
 *
 * @author gian
 */
public class Libro 
{
    private String titolo;
    private String autore;
    private int numeroPagine;
    private static double costoPagina=0.05;
    private final double COSTO_FISSO=5.5;
    
    public Libro(String titolo, String autore, int numeroPagine)
    {
        this.titolo=titolo;
        this.autore=autore;
        this.numeroPagine=numeroPagine;
                
    }
    public Libro()
    {
        titolo="";
        autore="";
        numeroPagine=0;
    }
    
    public Libro(Libro l)
    {
        setTitolo(l.getTitolo());
        setAutore(l.getAutore());
        setNumeroPagine(l.getNumeropagine());
    }
    
    public String getTitolo()
    {
        return titolo;
    }
    public void setTitolo(String titolo)
    {
        this.titolo=titolo;
    }
    public String getAutore()
    {
        return autore;
    }
    public void setAutore(String autore)
    {
        this.autore=autore;
    }
    public int getNumeropagine()
    {
        return numeroPagine;
    }
    public void setNumeroPagine(int numeroPagine)
    {
        this.numeroPagine=numeroPagine;
    }
    
    public double prezzo()
    {
        double p;
        p=COSTO_FISSO+getNumeropagine()*costoPagina;
        return p;
    }
    
    public static void setCostoPagina(double costo)
    {
        costoPagina=costo;
    }
    
    public static double getCostoPagina()
    {
        return costoPagina;
    }
    
    public boolean equals(Object lib)
    {
        Libro l;
        l=(Libro)lib;
        return (titolo.equals(l.getTitolo())&& autore.equals(l.getAutore())&& numeroPagine==l.getNumeropagine());
    }
    
    public String toString()
    {
        String s;
        s="\nTitolo: "+getTitolo()+"\nAutore:"+getAutore()+"\nNumero pagine="+getNumeropagine()+"\n";
        return s;
    }
}
