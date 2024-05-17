/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.progetto_banca;

import console_input.ConsoleInput;
import eccezioni.EccezionePosizioneNonValida;
import java.time.LocalDate;

/**
 *
 * @author Acer
 */
import java.io.IOException;
import java.time.LocalDate;
import menu.Menu;

public class App {

    private static int idCounter = 1;

    public static void main(String[] args) {
        Movimenti movimenti = new Movimenti();
        int sceltaMenu;
        ConsoleInput tastiera = new ConsoleInput();

        String vociMenu[] = new String[9];
        vociMenu[0] = "Esci";
        vociMenu[1] = "Visualizza movimenti";
        vociMenu[2] = "Aggiungi movimento";
        vociMenu[3] = "Elimina movimento";
        vociMenu[4] = "Calcola saldo";
        vociMenu[5] = "Visualizza movimenti per data";
        vociMenu[6] = "Preleva importo";
        vociMenu[7] = "Bonifico";
        vociMenu[8] = "Visualizza saldo cliente";

        Menu menu = new Menu(vociMenu);

        do {
            menu.visualizzaMenu();
            sceltaMenu = menu.sceltaMenu();
            System.out.println("Scelta: " + sceltaMenu);
            boolean inputOk = true;

            switch (sceltaMenu) {
                case 0:
                    System.out.println("Arrivederci.");
                    return;
                case 1:
                    for (int i = 1; i < Movimenti.getNumMaxMovimenti(); i++) {
                        try {
                            Cliente movimento = movimenti.getMovimenti(i);
                            if (movimento != null) {
                                System.out.println(movimento.toString());
                            }
                        } catch (EccezionePosizioneNonValida e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 2:
                    try {
                        System.out.println("\nNome --> ");
                        String nome = tastiera.readString();

                        System.out.println("\nCognome --> ");
                        String cognome = tastiera.readString();

                        System.out.println("\nImporto --> ");
                        double importo = tastiera.readDouble();

                        Cliente nuovoMovimento = new Cliente(nome, cognome, idCounter++, LocalDate.now(), importo);
                        movimenti.aggiungiMovimento(nuovoMovimento);
                        System.out.println("Movimento aggiunto con successo");
                    } catch (IOException ex) {
                        System.out.println("Errore nell'inserimento del dato di input. Inserire di nuovo");
                    } catch (NumberFormatException ex) {
                        System.out.println("Input non conforme. Inserire di nuovo");
                    }
                    break;
                case 3:
                    int posizione = 0;
                    do {
                        inputOk = true;
                        try {
                            System.out.println("\nPosizione da eliminare [1.." + (Movimenti.getNumMaxMovimenti() - 1) + "] --> ");
                            posizione = tastiera.readInt();
                        } catch (IOException ex) {
                            System.out.println("Errore nell'inserimento del dato di input. Inserire di nuovo");
                            inputOk = false;
                        } catch (NumberFormatException ex) {
                            System.out.println("Input non conforme. Inserire di nuovo");
                            inputOk = false;
                        }
                    } while (!inputOk);

                    try {
                        movimenti.eliminaMovimento(posizione);
                        System.out.println("Movimento eliminato con successo");
                    } catch (EccezionePosizioneNonValida ex) {
                        System.out.println("Posizione non valida");
                    }
                    break;
                case 4:
                    System.out.println("Saldo totale: " + movimenti.calcolaSaldo());
                    break;
                case 5:
                    try {
                        System.out.println("\nData (AAAA-MM-GG) --> ");
                        LocalDate data = LocalDate.parse(tastiera.readString());
                        movimenti.visualizzaMovimentiPerData(data);
                    } catch (IOException ex) {
                        System.out.println("Errore nell'inserimento del dato di input. Inserire di nuovo");
                    } catch (NumberFormatException ex) {
                        System.out.println("Input non conforme. Inserire di nuovo");
                    }
                    break;
                case 6:
                    try {
                        System.out.println("\nNome --> ");
                        String nomePrelievo = tastiera.readString();

                        System.out.println("\nCognome --> ");
                        String cognomePrelievo = tastiera.readString();

                        System.out.println("\nID --> ");
                        int idPrelievo = tastiera.readInt();

                        System.out.println("\nImporto da prelevare --> ");
                        double importoPrelievo = tastiera.readDouble();

                        Cliente clientePrelievo = new Cliente(nomePrelievo, cognomePrelievo, idPrelievo, LocalDate.now(), importoPrelievo);
                        movimenti.preleva(clientePrelievo, importoPrelievo);
                    } catch (IOException ex) {
                        System.out.println("Errore nell'inserimento del dato di input. Inserire di nuovo");
                    } catch (NumberFormatException ex) {
                        System.out.println("Input non conforme. Inserire di nuovo");
                    }
                    break;
                case 7:
                    try {
                        System.out.println("\nNome mittente --> ");
                        String nomeMittente = tastiera.readString();

                        System.out.println("\nCognome mittente --> ");
                        String cognomeMittente = tastiera.readString();

                        System.out.println("\nNome destinatario --> ");
                        String nomeDestinatario = tastiera.readString();

                        System.out.println("\nCognome destinatario --> ");
                        String cognomeDestinatario = tastiera.readString();

                        System.out.println("\nImporto bonifico --> ");
                        double importoBonifico = tastiera.readDouble();

                        Cliente mittente = new Cliente(nomeMittente, cognomeMittente, idCounter++, LocalDate.now(), -importoBonifico);
                        Cliente destinatario = new Cliente(nomeDestinatario, cognomeDestinatario, idCounter++, LocalDate.now(), importoBonifico);

                        movimenti.bonifico(mittente, destinatario, importoBonifico);
                    } catch (IOException ex) {
                        System.out.println("Errore nell'inserimento del dato di input. Inserire di nuovo");
                    } catch (NumberFormatException ex) {
                        System.out.println("Input non conforme. Inserire di nuovo");
                    }
                    break;
                case 8:
                    try {
                        System.out.println("\nNome --> ");
                        String nomeSaldo = tastiera.readString();

                        System.out.println("\nCognome --> ");
                        String cognomeSaldo = tastiera.readString();

                        Cliente clienteSaldo = new Cliente(nomeSaldo, cognomeSaldo, idCounter++, LocalDate.now(), 0);
                        movimenti.visualizzaSaldoCliente(clienteSaldo);
                    } catch (IOException ex) {
                        System.out.println("Errore nell'inserimento del dato di input. Inserire di nuovo");
                    } catch (NumberFormatException ex) {
                        System.out.println("Input non conforme. Inserire di nuovo");
                    }
                    break;
            }
        } while (true);
    }
}


