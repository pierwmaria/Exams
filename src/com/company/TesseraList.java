package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TesseraList {

    private int maxSize;
    private List<Tessera> listaTessere;


    public TesseraList(int maxSize) throws MaxTessereReached{
        this.maxSize = maxSize;
        this.listaTessere = new ArrayList<>(this.maxSize);
        for (int i = 0; i < this.maxSize; i++){
            this.listaTessere.add(i, null);
        }
    }

    public void addTesseraToList(Tessera t, int indice) throws TesseraLogicError{
        if (indice < 0 || indice >= this.maxSize) throw new TesseraLogicError("Indice non valido");
        this.listaTessere.add(indice, t);
    }

    //Tessera dato indice inserito dall'utente

    public List<Tessera> getTesseraFromListIO() throws TesseraLogicError {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserisci l'indice della tessera che vuoi avere");
        int indice = sc.nextInt();
        if (indice < 0 || indice >= maxSize) throw new TesseraLogicError("Indice dato non valido");
        if (this.listaTessere.get(indice) != null){
            System.out.println("Hai richiesto la tessera " + this.listaTessere.get(indice).toString());
        } else {
            System.out.println("Hai richiesto una tessera vuota");
        }
        return this.listaTessere.get(indice);
    }

    public List<Tessera> getTesseraFromList(int indice) throws  TesseraLogicError{
        if (indice < 0 || indice >= this.maxSize) throw new TesseraLogicError("Indice non valido");
        return this.listaTessere.get(indice);    }

    public void setTessereList(List<Tessera> listaTessere) {
        this.listaTessere = listaTessere;
    }

    //NON FUNZIONA. PROBLEMA!
//    public void printTutteTessereList() {
//        this.listaTessere.forEach(t -> System.out.println(t.getTitolare()));
//    }
//
//    public void printTitolareOrdinato() {
//        List<Tessera> ordinati = new ArrayList<>();
//        ordinati.addAll(this.listaTessere);
//        ordinati.sort(Comparator.comparingInt(Tessera::getPunti));
//        ordinati.forEach(t -> System.out.println(t.getTitolare() + " -> " + t.getPunti()));
//    }
}
