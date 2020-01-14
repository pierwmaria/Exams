package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TesseraList {

    private int maxSize, currentSize;
    private List<Tessera> listaTessere;

    public TesseraList(int maxSize) throws MaxTessereReached {
        this.maxSize = maxSize;
        this.currentSize = 0;
        this.listaTessere = new ArrayList<>(this.maxSize);
        for (int i = 0; i < this.maxSize; i++) {
            this.listaTessere.add(i, null);
        }
    }

    public int getCurrentSize() {
        return this.currentSize;
    }

    public void addTesseraToList(Tessera t, int indice) throws TesseraLogicError {
        if (indice < 0 || indice >= this.maxSize) throw new TesseraLogicError("Indice non valido");
        this.listaTessere.add(indice, t);
        this.currentSize++;
    }

    public void addTesseraToListIO() throws TesseraLogicError, IOException, MaxTessereReached {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserire titolare della tessera in TesseraList:");
        String titolare = sc.nextLine();
        System.out.println("Inserire indice:");
        int indice = sc.nextInt();
        if (indice < 0 || indice >= this.maxSize) throw new TesseraLogicError("Indice dato non valido");
        Tessera t = new Tessera(titolare);
        this.listaTessere.add(indice, t);
        System.out.println("Ho inserito la tessera " + t.toString());
        this.currentSize++;
    }

    //Tessera dato indice inserito dall'utente

    public Tessera getTesseraFromList(int indice) throws TesseraLogicError {
        if (indice < 0 || indice >= this.maxSize) throw new TesseraLogicError("Indice non valido");
        return this.listaTessere.get(indice);
    }

    public Tessera getTesseraFromListIO() throws TesseraLogicError {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserisci l'indice della tessera che vuoi avere");
        int indice = sc.nextInt();
        if (indice < 0 || indice >= maxSize) throw new TesseraLogicError("Indice dato non valido");
        if (this.listaTessere.get(indice) != null) {
            System.out.println("Hai richiesto la tessera " + this.listaTessere.get(indice).toString());
        } else {
            System.out.println("Hai richiesto una tessera vuota");
        }
        return this.listaTessere.get(indice);
    }

    public List<Tessera> getListaTessere() {
        List<Tessera> resultList = new ArrayList<>();
        for (Tessera t : this.listaTessere) {
            if (t != null) {
                resultList.add(t);
            }
        }
        return resultList;
    }

    // strategia first come first served (FCFS)
    public void addAllTesseraList(List<Tessera> listaTessere) throws MaxTessereReached {
        int j = 0;
        if (this.currentSize + listaTessere.size() >= this.maxSize)
            throw new MaxTessereReached("Collezione di Tessere troppo grande");
        for (int i = 0; i < this.maxSize && j < listaTessere.size(); i++) {
            if (this.listaTessere.get(i) == null) {
                this.listaTessere.add(i, listaTessere.get(j));
                this.currentSize++;
                j++;
            }
        }
    }

    public int getTesseraByTitolare(String titolare) throws TesseraLogicError {
        if (titolare == null || titolare.equals("")) throw new TesseraLogicError("Stringa vuota non è input valido");
        for (Tessera t : this.listaTessere) {
            if (t != null && t.getTitolare().equals(titolare)) {
                return this.listaTessere.indexOf(t);
            }
        }
        return -1;
    }

    public void printTutteTessereList() {
        for (int i = 0; i < this.maxSize; i++) {
            if (this.listaTessere.get(i) != null) {
                System.out.println("Indice " + i + ": " + this.listaTessere.get(i).getTitolare());
            }
        }
    }

    public void printTitolareOrdinato() {
        List<Tessera> ordinati = new ArrayList<>();
        for (Tessera temp : this.listaTessere) {
            if (temp != null) {
                ordinati.add(temp);
            }
        }
        ordinati.sort(Comparator.comparingInt(Tessera::getPunti));
        System.out.println("Stampo titolari ordinati per punti");
        ordinati.forEach(t -> System.out.println(t.getTitolare() + " -> " + t.getPunti()));
    }

    public void printTesseraListThreshold(int threshold) {
        System.out.println("Stampo tutte le tessere con punti minori di " + threshold);
        for (Tessera t : this.listaTessere) {
            if (t != null && t.getPunti() < threshold) {
                System.out.println(t.getTitolare());
            }
        }
    }

    public void increasePuntiTesseraListThreshold(int threshold) {
        for (Tessera t : this.listaTessere) {
            if (t != null && t.getPunti() > threshold) {
                t.increasePunti(10);
            }
        }
    }

    public void movePoints(int index1, int index2) throws TesseraLogicError {
        // tutti a Tessera in index2 - senza punti1 e punti2
        if (index1 < 0 || index1 >= this.maxSize) throw new TesseraLogicError("Indice 1 dato non valido");
        if (index2 < 0 || index2 >= this.maxSize) throw new TesseraLogicError("Indice 2 dato non valido");
        if (this.listaTessere.get(index1) == null)
            throw new TesseraLogicError("Non esiste la tessera con indice " + index1);
        if (this.listaTessere.get(index2) == null)
            throw new TesseraLogicError("Non esiste la tessera con indice " + index2);
        this.listaTessere.get(index2).increasePunti(this.listaTessere.get(index1).getPunti());
        this.listaTessere.get(index1).setPunti(0);
        System.out.println("Ho spostato i punti da " + this.listaTessere.get(index1).getTitolare() + " a " + this.listaTessere.get(index2).getTitolare());
    }

    public void printLetteraPuntiTitolari() {
        int[] tuttiPunti = new int[26];
        char c = 'A';
        for (int i = 0; i < 26; i++) {
            for (Tessera tessera : this.listaTessere) {
                if (tessera != null && tessera.getTitolare().startsWith(String.valueOf(c))) {
                    tuttiPunti[i] += tessera.getPunti();
                }
            }
            c++;
        }
        c = 'A';
        for (int i = 0; i < 26; i++) {
            if (tuttiPunti[i] > 0) {
                System.out.println("I titolari che iniziano per '" + c + "' hanno assieme " + tuttiPunti[i] + " punti");
            }
            c++;
        }

        tuttiPunti = new int[26];
        c = 'a';
        for (int i = 0; i < 26; i++) {
            for (Tessera tessera : this.listaTessere) {
                if (tessera != null && tessera.getTitolare().startsWith(String.valueOf(c))) {
                    tuttiPunti[i] += tessera.getPunti();
                }
            }
            c++;
        }
        c = 'a';
        for (int i = 0; i < 26; i++) {
            if (tuttiPunti[i] > 0) {
                System.out.println("I titolari che iniziano per '" + c + "' hanno assieme " + tuttiPunti[i] + " punti");
            }
            c++;
        }
    }


}
