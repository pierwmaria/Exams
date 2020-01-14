package com.company;

import java.util.*;

public class Tessera {

    private String titolare;
    private int punti, acquisti, id;

    private static final int maxNumTessere = UsaTessera.maxNumTessere;
    private static int contatore = 0;
    private static String[] listaTitolari = new String[maxNumTessere];

    public static int getNumeroTessereEmesse() {
        return contatore;
    }

    public static String getNomeTitolare(int id) throws TesseraNotFound {
        if (id < 0 || id >= contatore) throw new TesseraNotFound("Id non valido");
        return listaTitolari[id];
    }

    // Costruttore

    public Tessera() throws MaxTessereReached {
        if (contatore >= maxNumTessere)
            throw new MaxTessereReached("Raggiunto il massimo numero di tessere: " + maxNumTessere);
        this.id = contatore;
        this.titolare = "";
        this.punti = 0;
        this.acquisti = 0;
        listaTitolari[contatore] = this.titolare;
        contatore++;
    }

    public Tessera(String titolare) throws MaxTessereReached {
        if (contatore >= maxNumTessere)
            throw new MaxTessereReached("Raggiunto il massimo numero di tessere: " + maxNumTessere);
        this.id = contatore;
        this.titolare = titolare;
        this.punti = 0;
        this.acquisti = 0;
        listaTitolari[contatore] = this.titolare;
        contatore++;
    }

    public void setTitolare(String titolare) {
        this.titolare = titolare;
        listaTitolari[this.id] = titolare;
    }

    public int getPunti() {
        return punti;
    }

    public int getId() {
        return id;
    }

    public void increasePunti(int punti) {
        this.punti += punti;
    }

    public void increasePuntiIO() throws TesseraLogicError {
        Scanner sc = new Scanner(System.in);
        System.out.println("Di quanti punti vuoi aumentare?");
        int valore = sc.nextInt();
        this.increasePunti(valore);
    }

    public void setPunti(int punti) {
        this.punti = punti;
    }

    public String getTitolare() {
        return titolare;
    }

    //Perchè gli devo dare il nome di una tessera per eseguire il metodo? PROBLEMA

    public void getTitolareTesseraIO() throws TesseraLogicError {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserisci l'indice della tessera di cui vuoi sapere il titolare");
        int indice = sc.nextInt();
        if (indice < 0 || indice >= maxNumTessere) throw new TesseraLogicError("Indice dato non valido");
        if (this.listaTitolari[indice] != null) {
            System.out.println("Il titolare della tessera richiesta è" + this.listaTitolari[indice]);
        } else {
            System.out.println("Hai richiesto una tessera vuota");
        }
        // return this.listaTitolari[indice];
    }

    public void buySomething(int punti) {
        this.increaseAcquisti();
        this.punti += punti;
    }

    public void resetPuntiAndAcquisti() {
        this.punti = 0;
        this.acquisti = 0;
    }

    public void spendPunti(int punti) throws NotEnoughPoints {
        if (this.checkEnoughPunti(punti)) {
            this.punti -= punti;
            this.increaseAcquisti();
        } else throw new NotEnoughPoints("Punti insufficienti per titolare " + this.titolare);
    }

    private boolean checkEnoughPunti(int punti) {
        return this.punti >= punti;
    }

    private void increaseAcquisti() {
        this.acquisti++;
    }

    public int getAcquisti() {
        return this.acquisti;
    }

    public String toString() {
        return "ID: " + this.id + ", Titolare: " + this.titolare + ", Punti: " + this.punti + ", Acquisti: " + this.acquisti;
    }

}
