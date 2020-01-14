package com.company;

public class NotEnoughPoints extends Exception {
    public NotEnoughPoints(String message) {
        // invoco costruttore Exception(String message) al posto di Exception()
        super(message);                 // setto message della classe Exception che estendo
    }

    public NotEnoughPoints() {

        super();
    }
}
