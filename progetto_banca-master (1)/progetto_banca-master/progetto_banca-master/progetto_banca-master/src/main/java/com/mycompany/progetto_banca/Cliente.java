/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.progetto_banca;

/**
 *
 * @author Acer
 */
import java.time.LocalDate;
 
public class Cliente {

    private String nome;
    private String cognome;
    private int ID;
    private LocalDate dataRegistrazione;
    private static double commissione = 0.5;
    private double importo;

    public Cliente(String nome, String cognome, int ID, LocalDate dataRegistrazione, double importo) {
        this.nome = nome;
        this.cognome = cognome;
        this.ID = ID;
        this.dataRegistrazione = dataRegistrazione;
         this.importo = importo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public LocalDate getDataRegistrazione() {
        return dataRegistrazione;
    }

    public void setDataRegistrazione(LocalDate dataRegistrazione) {
        this.dataRegistrazione = dataRegistrazione;
    }

    public static double getCommissione() {
        return commissione;
    }

    public static void setCommissione(double commissione) {
        Cliente.commissione = commissione;
    }
    
    public double getImporto() {
        return importo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", cognome=" + cognome + ", ID=" + ID + ", dataRegistrazione=" + dataRegistrazione + ", importo=" + importo + '}';
    }
    
}

