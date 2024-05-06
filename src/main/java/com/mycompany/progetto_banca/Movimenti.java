/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.progetto_banca;

/**
 *
 * @author Acer
 */
public class Movimenti {
    private final static int NUM_MAX_MOVIMENTI=10;
    private Cliente[] movimenti; 
    
    public Movimenti()
    {
        movimenti=new Cliente[NUM_MAX_MOVIMENTI];
    }
    public Movimenti(Movimenti m)
    {
        movimenti=new Cliente[NUM_MAX_MOVIMENTI];
         Cliente c;
         for(int i=0; i<m.getNumMaxMovimenti();i++)
         {
                 c=m.getMovimenti(i);
                 if (c!=null)        
                     this.setMovimenti(c, i);
         }
    }
    public static int getNumMaxMovimenti() {
        return NUM_MAX_MOVIMENTI;
    }

    public void setMovimenti(Cliente movimento, int posizione) {
        movimenti[posizione]=new Cliente(movimento);
    }
    
    public int getNumMovimenti()
    {
        int contatore=0;
        for(int i=0;i<NUM_MAX_MOVIMENTI;i++)
        {
            if(movimenti[i]!=null)
                contatore++;
        }
        return contatore;
    }
    public Cliente getMovimenti(int posizione){
        Cliente c;
        c=movimenti[posizione];
            return new Cliente(c);
    }
}

    
