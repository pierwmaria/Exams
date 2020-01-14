package com.company;

public class EsercizioEsame2 {

    int[] arrayPorcoddio = new int[100];

    public EsercizioEsame2() {
    }

    // qualcuno li ha settati, altrimenti sta classe è inutile

    public int getPosizionePiuGrande() {
        int maggiore = this.arrayPorcoddio[0];
        int indiceVoluto = 0;
        for (int i = 1; i < 100; i++) {
            if (this.arrayPorcoddio[i] > maggiore) {
                maggiore = this.arrayPorcoddio[i];
                indiceVoluto = i;
            }
        }
        return indiceVoluto;
    }

    public int getMax10() {
        int numeriMaggiori = 0;
        for (int i = 1; i < 100; i++) {
            if (this.arrayPorcoddio[i] > 10) {
                numeriMaggiori++;
            }
        }
        return numeriMaggiori;
    }

}
