package com.company;


import java.io.IOException;
import java.util.*;

public class Tessera implements List<Tessera> {

    private String titolare;
    private int punti, acquisti, id;

    private static final int maxNumTessere = UsaTessera.maxNumTessere;
    private static int contatore = 0;
    private static String[] listaTitolari = new String[maxNumTessere];
    private static int [] listaPunti = new int[maxNumTessere];

    public static int getNumeroTessereEmesse() {
        return contatore;
    }

    public static String getNomeTitolare(int id) throws TesseraNotFound {
        if (id < 0 || id >= contatore) throw new TesseraNotFound("Id non valido");
        return listaTitolari[id];
    }

    public void increaseContatore(){
        contatore ++;
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
        listaPunti[contatore] = this.punti;
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
        listaPunti[contatore] = this.punti;
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
        return id; }

    public void increasePunti(int punti) {
        this.punti += punti;
    }

    public void setPunti(int punti) {
        this.punti = punti;
        listaPunti[this.id] = punti;
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
        if (this.listaTitolari[indice] !=null) {
            System.out.println("Il titolare della tessera richiesta è" + this.listaTitolari[indice].toString());
        } else {
            System.out.println("Hai richiesto una tessera vuota");
        }
       // return this.listaTitolari[indice];
    }

    public void getPuntiTesseraIO() throws TesseraLogicError {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserisci l'Id della tessera di cui vuoi sapere i punti");
        int indice = sc.nextInt();
        if (indice < 0 || indice >= maxNumTessere) throw new TesseraLogicError("Indice dato non valido");
        else{
            System.out.println("La tessera numero " + indice + " possiede " + this.listaPunti[indice] + " punti");
        }
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
        } else throw new NotEnoughPoints("Punti insufficienti per titolare " + this.titolare);
    }

    private boolean checkEnoughPunti(int punti) {
        return this.punti >= punti;
    }

    private void increaseAcquisti() {
        this.acquisti++;
    }

    public int getAcquisti() {
        return acquisti;
    }

    public String toString() {
        return "ID: " + this.id + ", Titolare: " + this.titolare + ", Punti: " + this.punti + ", Acquisti: " + this.acquisti;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Tessera> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Tessera tessera) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Tessera> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Tessera> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Tessera get(int index) {
        return null;
    }

    @Override
    public Tessera set(int index, Tessera element) {
        return null;
    }

    @Override
    public void add(int index, Tessera element) {

    }

    @Override
    public Tessera remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<Tessera> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Tessera> listIterator(int index) {
        return null;
    }

    @Override
    public List<Tessera> subList(int fromIndex, int toIndex) {
        return null;
    }
}
