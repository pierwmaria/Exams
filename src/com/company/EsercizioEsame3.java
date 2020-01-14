package com.company;

public class EsercizioEsame3 {

    private int[] arrayPippo = new int[100];

    public EsercizioEsame3() {
    }

    public int pari() {
        int somma = 0;
        for (int i = 0; i < arrayPippo.length; i++) {
            if (i % 2 == 0) {
                somma += arrayPippo[i];
            }
        }
        return somma;
    }

    public float media() {
        float media = 0;
        for (int i = 0; i < arrayPippo.length; i++) {
            media += arrayPippo[i];
        }
        media = media / arrayPippo.length;
        return media;
    }

}
