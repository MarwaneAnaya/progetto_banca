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

public class Movimenti {
    private final static int NUM_MAX_MOVIMENTI = 10;
    private Cliente[] movimenti;

    public Movimenti() {
        movimenti = new Cliente[NUM_MAX_MOVIMENTI];
    }

    public Movimenti(Movimenti m) throws EccezionePosizioneNonValida {
        movimenti = new Cliente[NUM_MAX_MOVIMENTI];
        Cliente c;
        for (int i = 0; i < m.getNumMaxMovimenti(); i++) {
            c = m.getMovimenti(i);
            if (c != null)
                this.setMovimenti(new Cliente(c.getNome(), c.getCognome(), c.getID(), c.getDataRegistrazione(), c.getImporto()), i);
        }
    }

    public static int getNumMaxMovimenti() {
        return NUM_MAX_MOVIMENTI;
    }

    public void setMovimenti(Cliente movimento, int posizione) throws EccezionePosizioneNonValida {
        if (posizione >= 0 && posizione < NUM_MAX_MOVIMENTI) {
            movimenti[posizione] = new Cliente(movimento.getNome(), movimento.getCognome(), movimento.getID(), movimento.getDataRegistrazione(), movimento.getImporto());
        } else {
            throw new EccezionePosizioneNonValida();
        }
    }

    public int getNumMovimenti() {
        int contatore = 0;
        for (int i = 0; i < NUM_MAX_MOVIMENTI; i++) {
            if (movimenti[i] != null)
                contatore++;
        }
        return contatore;
    }

    public Cliente getMovimenti(int posizione) throws EccezionePosizioneNonValida {
        if (posizione >= 0 && posizione < NUM_MAX_MOVIMENTI) {
            Cliente c = movimenti[posizione];
            if (c != null) {
                return new Cliente(c.getNome(), c.getCognome(), c.getID(), c.getDataRegistrazione(), c.getImporto());
            }
        }
        throw new EccezionePosizioneNonValida();
    }
    public void eliminaMovimento(int posizione) throws EccezionePosizioneNonValida {
    if (posizione >= 0 && posizione < NUM_MAX_MOVIMENTI) {
        movimenti[posizione] = null;
    } else {
        throw new EccezionePosizioneNonValida();
        }
    }
    public double calcolaSaldo() {
        double saldo = 0.0;
        for (int i = 0; i < NUM_MAX_MOVIMENTI; i++) {
            if (movimenti[i] != null) {
                saldo += movimenti[i].getImporto();
            }
        }
        return saldo;
    }
    public void visualizzaMovimentiPerData(LocalDate data) {
        System.out.println("Movimenti per la data: " + data);
        for (Cliente cliente : movimenti) {
            if (cliente != null && cliente.getDataRegistrazione().equals(data)) {
                System.out.println(cliente.getNome() + " " + cliente.getCognome() + " - Importo: " + cliente.getImporto());
            }
        }
    }

}



