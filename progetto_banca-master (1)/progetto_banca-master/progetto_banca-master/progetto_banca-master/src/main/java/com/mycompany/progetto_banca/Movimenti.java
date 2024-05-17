/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.progetto_banca;

import eccezioni.EccezionePosizioneNonValida;

/**
 *
 * @author Acer
 */
import java.time.LocalDate;
 
import java.time.LocalDate;

public class Movimenti 
{
    private final static int NUM_MAX_MOVIMENTI=10;
    private Cliente[] movimenti;
    private int numMovimenti;
    private int prossimoId;

    public Movimenti() 
    {
        this.numMovimenti = 0;
        this.prossimoId = 1;
        movimenti=new Cliente[NUM_MAX_MOVIMENTI];
    }

    public Movimenti(Movimenti m) throws EccezionePosizioneNonValida 
    {
        movimenti=new Cliente[NUM_MAX_MOVIMENTI];
        Cliente c;
        for(int i=0;i<m.getNumMaxMovimenti();i++) 
        {
            c=m.getMovimenti(i);
            if(c!=null)
                this.setMovimenti(new Cliente(c.getNome(), c.getCognome(), c.getID(), c.getDataRegistrazione(), c.getImporto()), i);
        }
    }

    public static int getNumMaxMovimenti() 
    {
        return NUM_MAX_MOVIMENTI;
    }

    public void setMovimenti(Cliente movimento, int posizione) throws EccezionePosizioneNonValida 
    {
        if(posizione>=0 && posizione<NUM_MAX_MOVIMENTI) 
        {
            movimenti[posizione]=new Cliente(movimento.getNome(), movimento.getCognome(), movimento.getID(), movimento.getDataRegistrazione(), movimento.getImporto());
        } 
        else 
        {
            throw new EccezionePosizioneNonValida();
        }
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

    public Cliente getMovimenti(int posizione) throws EccezionePosizioneNonValida 
    {
        if(posizione>=0 && posizione<NUM_MAX_MOVIMENTI) 
        {
            Cliente c=movimenti[posizione];
            if(c!=null) 
            {
                return new Cliente(c.getNome(), c.getCognome(), c.getID(), c.getDataRegistrazione(), c.getImporto());
            }
        }
        throw new EccezionePosizioneNonValida();
    }

    public void eliminaMovimento(int posizione) throws EccezionePosizioneNonValida 
    {
        if(posizione>=0 && posizione<NUM_MAX_MOVIMENTI) 
        {
            movimenti[posizione]=null;
        } 
        else 
        {
            throw new EccezionePosizioneNonValida();
        }
    }

    public double calcolaSaldo() 
    {
        double saldo=0.0;
        for(int i=0;i<NUM_MAX_MOVIMENTI;i++) 
        {
            if(movimenti[i]!=null) 
            {
                saldo+=movimenti[i].getImporto();
            }
        }
        return saldo;
    }

    public void visualizzaSaldoCliente(Cliente cliente) 
    {
        double saldoCliente=0.0;
        for(int i=0; i<movimenti.length; i++) 
        {
            if(movimenti[i]!=null && movimenti[i].getID()==cliente.getID()) {
                saldoCliente+=movimenti[i].getImporto();
            }
        }
        System.out.println("Saldo per " + cliente.getNome() + " " + cliente.getCognome() + ": " + saldoCliente);
    }

    public void visualizzaMovimentiPerData(LocalDate data) {
        System.out.println("Movimenti per la data: " + data);
        for(int i=0; i<movimenti.length; i++)  {
            if(movimenti[i]!=null && movimenti[i].getDataRegistrazione().equals(data)) {
                System.out.println(movimenti[i].getNome() + " " + movimenti[i].getCognome() + " - Importo: " + movimenti[i].getImporto());
            }
        }
    }

    public void preleva(Cliente cliente, double importo) {
        double saldoDisponibile=calcolaSaldo();
        if(saldoDisponibile>=importo) {
            aggiungiMovimento(new Cliente(cliente.getNome(), cliente.getCognome(), cliente.getID(), LocalDate.now(), -importo));
            System.out.println("Prelievo di " + importo + " effettuato con successo.");
        } else {
            System.out.println("Saldo insufficiente per il prelievo di " + importo);
        }
    }

    public void aggiungiMovimento(Cliente movimento) {
        movimento.setID(prossimoId++);
        movimenti[numMovimenti++] = movimento;
        for(int i=0;i<NUM_MAX_MOVIMENTI;i++) {
            if(movimenti[i]==null) {
                movimenti[i]=movimento;
                break;
            }
        }
    }

    public void visualizzaMovimentiCliente(Cliente cliente) {
        System.out.println("Movimenti per il cliente: " + cliente.getNome() + " " + cliente.getCognome());
       for(int i=0; i<movimenti.length; i++) {
            if(movimenti[i]!=null && movimenti[i].getID()==cliente.getID())
                System.out.println("Data: " + movimenti[i].getDataRegistrazione() + " - Importo: " + movimenti[i].getImporto());
        }
    }

    public void bonifico(Cliente mittente, Cliente destinatario, double importo) {
        double saldoDisponibile=calcolaSaldo();
        if(saldoDisponibile>=importo) {
            aggiungiMovimento(new Cliente(mittente.getNome(), mittente.getCognome(), mittente.getID(), LocalDate.now(), -importo));
            aggiungiMovimento(new Cliente(destinatario.getNome(), destinatario.getCognome(), destinatario.getID(), LocalDate.now(), importo));
            System.out.println("Bonifico di " + importo + " da " + mittente.getNome() + " " + mittente.getCognome() +
                " a " + destinatario.getNome() + " " + destinatario.getCognome() + " effettuato con successo.");
        } else {
            System.out.println("Saldo insufficiente per il bonifico di " + importo);
        }
    }
}





