package com.company;

public class UsaTessera2 {

    public static void main(String args[]) {

        try {

            TesseraList tl1 = new TesseraList(UsaTessera.maxNumTessere);

            Tessera t1 = new Tessera();
            Tessera t2 = new Tessera();
            Tessera t3 = new Tessera();
            Tessera t4 = new Tessera();

            tl1.addTesseraToList(t1, 2);
            tl1.addTesseraToList(t2, 4);
            tl1.addTesseraToList(t3, 6);
            tl1.addTesseraToList(t4, 7);
            Tessera result1 = tl1.getTesseraFromList(8);
            if (result1 == null) {
                System.out.println("Non esiste la tessera con indice 8");
            } else {
                System.out.println("Tessera con indice 8: " + result1.toString());
            }

            // printa nulla perché non ci sono i nomi dei titolari nonstante le tessere non siano null
            tl1.printTutteTessereList();

            t1.setTitolare("Pinco Pallino");
            t2.setTitolare("Piero Baraldo");
            t3.setTitolare("Davide Marino");
            t4.setTitolare("Silvia Chiusano");

            t1.setPunti(4096);
            t2.setPunti(2048);
            t3.setPunti(1024);
            t4.setPunti(512);

            tl1.printTitolareOrdinato();

            for (int i = 0; i < 30; i++) {
                t1.spendPunti(8);
                t2.spendPunti(4);
                t3.spendPunti(2);
                t4.spendPunti(1);
            }

            // Ora hanno speso dei punti
            tl1.printTitolareOrdinato();

            // Così vedi anche i punti e il numero di acquisti
            System.out.println(t1.toString());
            System.out.println(t2.toString());
            System.out.println(t3.toString());
            System.out.println(t4.toString());

            TesseraList tl2 = new TesseraList(UsaTessera.maxNumTessere);
            Tessera t5 = new Tessera();
            Tessera t6 = new Tessera();
            Tessera t7 = new Tessera();
            Tessera t8 = new Tessera();

            t5.setTitolare("Cacca Puzza");
            t6.setTitolare("Minchia Zio");
            t7.setTitolare("Uffa Che Coglioni");
            t8.setTitolare("Zio Fa Che Cammurria");

            t5.setPunti(4096);
            t6.setPunti(2048);
            t7.setPunti(1024);
            t8.setPunti(512);

            tl2.addTesseraToList(t5, 0);
            tl2.addTesseraToList(t6, 1);
            tl2.addTesseraToList(t7, 2);
            tl2.addTesseraToList(t8, 3);

            // Ora metto tutto in tl1
            tl1.addAllTesseraList(tl2.getListaTessere());
            // Ed eccone il risultato
            tl1.printTitolareOrdinato();

            System.out.println("Indice del titolare con il nome Davide Marino: " + tl1.getTesseraByTitolare("Davide Marino"));
            System.out.println("Indice del titolare con il nome Vaffanculo Scemo: " + tl1.getTesseraByTitolare("Vaffanculo Scemo"));
            System.out.println("Ora tl1 ha come dimensione totale di " + tl1.getCurrentSize());

            tl1.printTesseraListThreshold(512);
            tl1.increasePuntiTesseraListThreshold(4000);
            // aumentato di 10 punti solo Cacca Puzza
            tl1.printTitolareOrdinato();
            // sposto i punti da
            tl1.movePoints(0, 3);
            tl1.printTitolareOrdinato();
            // stampo titolari per lettera-punti
            tl1.printLetteraPuntiTitolari();

        } catch (Exception e) {
            System.out.println("Questo è l'errore: " + e.getMessage());
            e.printStackTrace();
        }

    }

}
