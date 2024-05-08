/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.progetto_banca;

import eccezioni.EccezionePosizioneNonValida;
import java.time.LocalDate;

/**
 *
 * @author Acer
 */
public class App {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Mario", "Rossi", 1, LocalDate.now(), 1000.0);
        Cliente cliente2 = new Cliente("Luigi", "Verdi", 2, LocalDate.now(), 1500.0);
        Movimenti movimenti = new Movimenti();
        movimenti.aggiungiMovimento(cliente1);
        movimenti.aggiungiMovimento(cliente2);
        System.out.println("Movimenti totali:");
        for (int i = 0; i < movimenti.getNumMovimenti(); i++) {
            try {
                Cliente movimento = movimenti.getMovimenti(i);
                System.out.println("Cliente: " + movimento.getNome() + " " + movimento.getCognome() +
                                   " - Importo: " + movimento.getImporto());
            } catch (EccezionePosizioneNonValida e) {
                System.out.println("Errore: posizione non valida");
            }
        }
        LocalDate oggi = LocalDate.now();
        movimenti.visualizzaMovimentiPerData(oggi);
        movimenti.visualizzaMovimentiCliente(cliente1);
        double saldo = movimenti.calcolaSaldo();
        System.out.println("Saldo totale di tutti i movimenti: " + saldo);
        double importoPrelievo = 200.0;
        movimenti.preleva(cliente1, importoPrelievo);
        saldo = movimenti.calcolaSaldo();
        System.out.println("Saldo totale dopo il prelievo: " + saldo);
        System.out.println("Movimenti totali dopo il prelievo:");
        for (int i = 0; i < movimenti.getNumMovimenti(); i++) {
            try {
                Cliente movimento = movimenti.getMovimenti(i);
                System.out.println("Cliente: " + movimento.getNome() + " " + movimento.getCognome() +
                                   " - Importo: " + movimento.getImporto());
            } catch (EccezionePosizioneNonValida e) {
                System.out.println("Errore: posizione non valida");
            }
        }
        System.out.println("Saldo per ciascun cliente:");
        movimenti.visualizzaSaldoCliente(cliente1);
        movimenti.visualizzaSaldoCliente(cliente2);

        Cliente cliente3 = new Cliente("Mario", "Rossi", 1, LocalDate.now(), 1000.0);
        Cliente cliente4 = new Cliente("Luigi", "Verdi", 2, LocalDate.now(), 500.0);

        System.out.println("Saldo di Mario Rossi: " + movimenti.calcolaSaldo());

        movimenti.bonifico(cliente3, cliente4, 200.0);

        System.out.println("Saldo di Mario Rossi dopo bonifico: " + movimenti.calcolaSaldo());
        System.out.println("Saldo di Luigi Verdi dopo bonifico: " + movimenti.calcolaSaldo());
    }
}
