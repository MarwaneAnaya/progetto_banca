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
        // Creazione di alcuni clienti
        Cliente cliente1 = new Cliente("Mario", "Franzoni", 11, LocalDate.of(2024, 5, 1),100.0);
        Cliente cliente2 = new Cliente("Paolo", "Croci", 102, LocalDate.of(2024, 5, 2), 500.0);
        Cliente cliente3 = new Cliente("Angelo", "Croci", 10, LocalDate.of(2024, 5, 1), 304.1);

        // Creazione di un oggetto Movimenti e aggiunta dei clienti
        Movimenti movimenti = new Movimenti();
        try {
            movimenti.setMovimenti(cliente1, 0);
            movimenti.setMovimenti(cliente2, 1);
            movimenti.setMovimenti(cliente3, 2);
        } catch (EccezionePosizioneNonValida e) {
            System.out.println("Posizione non valida!");
        }

        // Visualizzazione dei movimenti per una data specifica
        LocalDate dataDaVisualizzare = LocalDate.of(2024, 5, 1);
        movimenti.visualizzaMovimentiPerData(dataDaVisualizzare);
    }
}
