package com.company;

import java.io.IOException;
import java.util.Scanner;

public class TesseraManagement {

    /**
     * A partire dall'ultimo assignment aggiungere:
     * 1) interazione IO con utente - FATTO
     * a) inserimento dati
     * b) visualizzazione dati (da terminale)
     * 2) gestione eccezioni su IO, gestire se utente da valore sbagliato (es. negativo) - FATTO
     * 3) in una delle classi sostituire vettore con lista (ArrayList) - FATTO
     */

    private boolean dirty;
    private final int maxNumTessere = UsaTessera.maxNumTessere; // final significa costante e non variabile
    private Tessera[] tutteTessere; // nuovo array


    // Costruttore

    public TesseraManagement() {
        this.dirty = false;
        this.tutteTessere = new Tessera[maxNumTessere]; //allocazione array tutteTessere
    }


    //Inizializzare progetto con indice i

    public void addTessera(Tessera t, int indice) throws TesseraLogicError {
        if (indice < 0 || indice >= maxNumTessere) throw new TesseraLogicError("Indice dato non valido");
        this.tutteTessere[indice] = t;
        this.dirty = true;
    }

    //come mai posso scrivere il titolare ma non posso aggungere punti?
    public void addTesseraIO() throws TesseraLogicError, IOException, MaxTessereReached {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserire titolare nuova TesseraManagement:");
        String titolare = sc.nextLine();
        System.out.println("Inserire indice:");
        int indice = sc.nextInt();
        if (indice < 0 || indice >= maxNumTessere) throw new TesseraLogicError("Indice dato non valido");
        Tessera t = new Tessera(titolare);
        this.tutteTessere[indice] = t;
        this.dirty = true;
        System.out.println("Ho inserito la tessera " + t.toString() + " in TesseraManagement");
    }

    //Trovare tessera dato id con input utente

    public Tessera getTesseraIO() throws TesseraLogicError {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserisci l'indice della tessera che desideri");
        int indice = sc.nextInt();
        if (indice < 0 || indice >= maxNumTessere) throw new TesseraLogicError("Indice dato non valido");
        if (this.tutteTessere[indice] != null) {
            System.out.println("Hai richiesto la tessera " + this.tutteTessere[indice].toString());
        } else {
            System.out.println("Hai richiesto una tessera vuota");
        }
        return this.tutteTessere[indice];
    }

    //Leggere informazioni (titolare, punti) da oggetto con indice i

    public Tessera getTessera(int indice) throws TesseraLogicError {
        if (indice < 0 || indice >= maxNumTessere) throw new TesseraLogicError("Indice dato non valido");
        if (this.tutteTessere[indice] != null) {
            System.out.println("Hai richiesto la tessera " + this.tutteTessere[indice].toString());
        } else {
            System.out.println("Hai richiesto una tessera vuota");
        }
        return this.tutteTessere[indice];
    }

    //Cercare posizione i nel vettore dato il nome del titolare

    public int getTesseraByTitolare(String titolare) throws TesseraLogicError {
        if (titolare == null || titolare.equals("")) throw new TesseraLogicError("Stringa vuota non è input valido");
        for (int i = 0; i < this.maxNumTessere; i++) {
            if (this.tutteTessere[i] != null && this.tutteTessere[i].getTitolare().equals(titolare)) {
                return i;
            }
        }
        return -1;
    }

    public int getMaxNumTessere() {
        return this.maxNumTessere;
    }


    //Stampare tutti gli elementi del vettore

    public void printTutteTessere() {
        for (int i = 0; i < this.maxNumTessere; i++) {
            if (this.tutteTessere[i] == null) continue;
            System.out.println(this.tutteTessere[i].getTitolare());
        }
    }

    //Stampare nome del titolare ordinate in base ai punti (con punti a fianco)

    public void printTitolareOrdinato() {
        Tessera[] tessereOrdinateCrescente = new Tessera[this.maxNumTessere];
        System.arraycopy(this.tutteTessere, 0, tessereOrdinateCrescente, 0, this.maxNumTessere);
        for (int i = 0; i < tessereOrdinateCrescente.length - 1; i++) {
            for (int j = i + 1; j < tessereOrdinateCrescente.length; j++) {
                if (tessereOrdinateCrescente[i] != null && tessereOrdinateCrescente[j] != null && tessereOrdinateCrescente[j].getPunti() < tessereOrdinateCrescente[i].getPunti()) {
                    Tessera temp = tessereOrdinateCrescente[j];
                    tessereOrdinateCrescente[j] = tessereOrdinateCrescente[i];
                    tessereOrdinateCrescente[i] = temp;
                }
            }
        }
        for (Tessera c : tessereOrdinateCrescente) {
            if (c != null && !c.getTitolare().isEmpty()) {
                System.out.println(c.getTitolare() + " - " + c.getPunti());
            }
        }
    }

    //Cercare il titolare con il massimo dei punti

    public Tessera getTesseraMaxPunti() {
        if (!this.dirty) {
            return null;
        } else {
            Tessera wanted = null;
            for (Tessera t : this.tutteTessere) {
                if (wanted == null && t != null) {
                    wanted = t;
                } else if (t != null && t.getPunti() > wanted.getPunti()) {
                    wanted = t;
                }
            }
            return wanted;
        }
    }

    //Stampare nomi dei titolari con punti minori di un valore x dato

    public void printTesseraThreshold(int threshold) {
        for (Tessera t : this.tutteTessere) {
            if (t != null && t.getPunti() < threshold) {
                System.out.println(t.getTitolare());
            }
        }
    }

    //Aumentare di 10 i punti i tutti i titolari con punti maggiori di y dato

    public void increasePuntiTesseraThreshold(int threshold) {
        for (Tessera t : this.tutteTessere) {
            if (t != null && t.getPunti() > threshold) {
                t.increasePunti(10);
            }
        }
    }

    //Spostare punti da indice i a indice j, se li possiede

    public void movePoints(int index1, int index2) throws TesseraLogicError {
        // tutti a Tessera in index2 - senza punti1 e punti2
        if (index1 < 0 || index1 >= maxNumTessere) throw new TesseraLogicError("Indice 1 dato non valido");
        if (index2 < 0 || index2 >= maxNumTessere) throw new TesseraLogicError("Indice 2 dato non valido");
        if (this.tutteTessere[index1] == null)
            throw new TesseraLogicError("Non esiste la tessera con indice " + index1);
        if (this.tutteTessere[index2] == null)
            throw new TesseraLogicError("Non esiste la tessera con indice " + index2);
        this.tutteTessere[index2].increasePunti(this.tutteTessere[index1].getPunti());
        this.tutteTessere[index1].setPunti(0);
    }

    //Stampare un report in cui sisommano i punti in base alla prima lettera del titolare (opzionale)

    public void printLetteraPuntiTitolari() {
        int[] tuttiPunti = new int[26];
        char c = 'A';
        for (int i = 0; i < 26; i++) {
            for (Tessera tessera : this.tutteTessere) {
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
            for (Tessera tessera : this.tutteTessere) {
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
