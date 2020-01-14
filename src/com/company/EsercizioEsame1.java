package com.company;

public class EsercizioEsame1 {

    private int dim;
    private int[] pippo;

    public EsercizioEsame1(int dim) {
        this.dim = dim;
        this.pippo = new int[this.dim];
        for (int i = 0; i < this.dim; i++) {
            this.pippo[i] = 0;
        }
    }

    public void setPippo(int index, int pippa) {
        if (index >= 0 && index < this.dim) {
            this.pippo[index] = pippa;
        }
    }

    public int getPippo(int index) {
        if (index >= 0 && index < this.dim) {
            return this.pippo[index];
        } else {
            return 0;
        }
    }

    public int numeroIstanze() {
        int contatore = 0;
        for (int i = 0; i < this.dim; i++) {
            if (this.pippo[i] > 0) {
                contatore++;
            }
        }
        return contatore;
    }

}
