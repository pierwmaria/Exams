package com.company;

import java.io.IOException;

public class UsaTessera {

    public static final int maxNumTessere = 1024;

    public static void main(String[] arg) {

        try {

            // Creo 3 tessere normali
            Tessera t1 = new Tessera();
            Tessera t2 = new Tessera();
            Tessera t3 = new Tessera();
            Tessera t4 = new Tessera();


            //Creo 1 TesseraManagement
            TesseraManagement tm1 = new TesseraManagement();

            //Creo 1 TesseraList

            TesseraList tl1 = new TesseraList(100);

            // Creo 2 TesseraGold
            TesseraGold tg1 = new TesseraGold();
            TesseraGold tg2 = new TesseraGold();

            // Stampo numero di tessere emesse
            System.out.println("Numero tessere emesse: " + Tessera.getNumeroTessereEmesse());


            // Reset acquisti di t1
            //t1.resetPuntiAndAcquisti();

            // Set di titolari
            t1.setTitolare("Pier Maria Baraldo");
            t2.setTitolare("Francesco Rodriguez");
            t3.setTitolare("Alberto Visconti");
            t4.setTitolare("Pippo Argenton");
            tg1.setTitolare("Giorgio Thefire");
            tg2.setTitolare("Gold Richer");

            // Set del secondo titolare TesseraGold
            tg1.setSecondoTitolare("Jacopo Thefire 2nd");
            tg2.setSecondoTitolare("Gold ricco 2nd");

            // Compro qualcosa
            t1.buySomething(20);
            t2.buySomething(10);
            t3.buySomething(30);
            t1.buySomething(30);
            t2.buySomething(20);
            tg1.buySomething(40);
            tg2.buySomething(4000);
            t4.buySomething(500);


            // Vedo quanti punti hanno
            System.out.println(t1.getTitolare() + " ha " + t1.getPunti() + " punti");
            System.out.println(t2.getTitolare() + " ha " + t2.getPunti() + " punti");
            System.out.println(t3.getTitolare() + " ha " + t3.getPunti() + " punti");
            System.out.println(t4.getTitolare() + " ha " + t4.getPunti() + " punti");
            System.out.println(tg1.getTitolare() + " ha " + tg1.getPunti() + " punti");
            System.out.println(tg2.getTitolare() + " ha " + tg2.getPunti() + " punti");


            // Compro qualcosa un'altra volta
            t1.buySomething(30);
            t2.buySomething(10);

            // Vedo quanti punti hanno una seconda volta
            System.out.println(t1.getTitolare() + " dopo secondo acquisto ha " + t1.getPunti() + " punti");
            System.out.println(t2.getTitolare() + " dopo secondo acquisto ha " + t2.getPunti() + " punti");


            //Spendo punti t1 e t2
            System.out.println("Spesa di 40 punti per t1 e t2");
            t1.spendPunti(40);
            t2.spendPunti(40);


            // t1.spendPunti(1000);                // eccezione lanciata
            // t2.spendPunti(1000);                // non eseguita - contrazione dello stack

            //GetTitolare con indice 0
            System.out.println("Nome proprietario Tessera indice 0 è: " + Tessera.getNomeTitolare(0));
            // System.out.println("Name EsercizioTessera owner of -2 is: " + Tessera.getNomeTitolare(-2));
            // System.out.println("Name EsercizioTessera owner of 10 is: " + EsercizioTessera.getNomeTitolare(10));

            // Ciclo for che serve solo per vedere il lancio di un'eccezione per dimensione massima raggiunta
            /*
            for (int i = 0; i < UsaTessera.maxNumTessere; i++) {
                Tessera t = new Tessera();
                // dopo un po' si spacca perché dimensione massima raggiunta
            }
            */

            //Aumento punti da input utente

            t1.increasePuntiIO();
            System.out.println("t1 ha punti :" + t1.getPunti());

            System.exit(0);


            /**
             * Per DAVE
             * Da qui in avanti fino a System.exit testo Array e list
             * Aggiungo tessere prima su uno poi sull'altro, provo a far eun increasePoint a tutti e poi le stampo
             * ordinate per punti, ma la lista che mi dà ha solo tessere con 0 punti =(
             */

            //Aggiungo tessere a Tesseremanagement
            System.out.println("TESSERAMANAGEMENT:");

            tm1.addTesseraIO();
            tm1.addTesseraIO();

            tm1.addTessera(t1, 0);


            System.out.println("Tessere emesse da Management:");

            tm1.printTutteTessere();

            tm1.getTesseraIO();

            System.out.println("Tessere ordinate per punti");

            tm1.printTitolareOrdinato();

            System.out.println("TESSERALIST:");

            tl1.addTesseraToListIO();
            tl1.addTesseraToListIO();

            System.out.println("Tessere presenti in TesseraList:");

            tl1.printTutteTessereList();

            System.out.println("TesseraList ordinata per punti");

            tl1.printTitolareOrdinato();

            tl1.getTesseraFromListIO();


            System.out.println("Numero di tessere emesse: " + Tessera.getNumeroTessereEmesse());



//            tm1.addTessera(t1, 0);
//            tm1.addTessera(t2, 1);
//            tm1.addTessera(t3, 2);
//            tm1.addTessera(tg2, 3);
//            tm1.addTessera(tg1, 4);
//            tm1.addTessera(t4, 5);


            //Aggiungo alla lista la tessera t1
            //tl1.addTesseraToList(t1, 0);

            // Cerco tessera chiedendo input utente per indice
            // tm1.getTesseraIO();

            //Stampo TesseraList
            //System.out.println("Print TesseraLIST");

            //tl1.getTesseraFromListIO();

            // t1.getTitolareTesseraIO();
            // t1.getPuntiTesseraIO();


            //Stampo da TesseraList tessera con indice 0
            //System.out.println("Stampa da lista tessera con indice 0" + tl1.getTesseraFromList(0));

            //Chiedo indice per trovare Tessera da List

            tl1.addTesseraToList(t1, 0);
            tl1.addTesseraToList(t2, 3);
            tl1.addTesseraToList(t3, 2);
            tl1.addTesseraToList(t4, 6);
            tl1.printTutteTessereList();
            tl1.printTitolareOrdinato();

            //System.out.println("Stampo List Tessere: "); PROBLEM
            // tl1.printTutteTessereList();

            //System.out.println("Stampo TesseraList ordinata"); PROBLEM
            //tl1.printTitolareOrdinato();

            //Stampo le tessere inserite dall'utente
            System.out.println("Print tessere inserite da inserimento utente:");
            tm1.printTutteTessere();

            //Stampo tessere con titolare ordinato
            System.out.println("Print titolareOrdinato da inserimento utente");
            tm1.printTitolareOrdinato();

            //Richiedo tessera con indice sbagliato

            Tessera temp = tm1.getTessera(4);
            if (temp != null) {
                System.out.println("GetTessera, e getTitolare di tessera con indice 4: " + temp.getTitolare());
            }

            System.out.println("Posizione nel vettore dato il nome titolare" + tm1.getTesseraByTitolare("Pier"));

            System.out.println("Stampare il titolare con massimo numero di punti disponibili: " + tm1.getTesseraMaxPunti().getTitolare());

            System.out.println("Stampare titolari con punti minori 5000");
            //tm1.printTesseraThreshold(5000);

            System.out.println("Aumentare di 10 i punti delle carte con punti maggiori di 40");
            tm1.increasePuntiTesseraThreshold(40);

            System.out.println("Stampo elenco ordinato per punti TesseraManager");
            tm1.printTitolareOrdinato();

            //Get tessera da manager

            temp = tm1.getTessera(1);
            if (temp != null) {
                System.out.println("Stampo punti indice 1 " + temp.getPunti());
            }
            temp = tm1.getTessera(3);
            if (temp != null) {
                System.out.println("Stampo punti indice 1 " + temp.getPunti());
            }

            System.out.println("Sposto punti da indice 3 a indice 1");
            tm1.movePoints(3, 1);

            Tessera temp1 = tm1.getTessera(1);
            Tessera temp3 = tm1.getTessera(3);
            System.out.println("stampo punti indice 1 " + temp1.getPunti());
            System.out.println("stampo punti indice 3 " + temp3.getPunti());

            tm1.printLetteraPuntiTitolari();


            // Cath per i messaggi di errore
        } catch (IOException ioe) {
            System.err.println("Message from exception: " + ioe.getMessage());
        } catch (NotEnoughPoints nep) {
            // output con standard err non in ordine
            System.err.println("Message from exception: " + nep.getMessage());
        } catch (MaxTessereReached mtr) {
            System.err.println("Message from exception: " + mtr.getMessage());
        } catch (TesseraNotFound tnf) {
            System.err.println("Message from exception: " + tnf.getMessage());
        } catch (TesseraLogicError tle) {
            System.err.println("Message from exception: " + tle.getMessage());
        }

    }

}
