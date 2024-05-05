/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.progetto_banca;

/**
 *
 * @author Acer
 */
public class Cliente {

    private String nome;
    private String cognome;
    private int ID;
    private static double commissione=0.5;


    public Cliente(String nome, String cognome, int ID) {
        this.nome = nome;
        this.cognome = cognome;
        this.ID = ID;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public static double getCommissione() {
        return commissione;
    }

    public static void setCommissione(double commissione) {
        Cliente.commissione = commissione;
    }

    
}
