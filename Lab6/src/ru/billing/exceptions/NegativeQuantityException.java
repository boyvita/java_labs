package ru.billing.exceptions;

public class NegativeQuantityException extends Exception {
    public NegativeQuantityException(String m) {
        super(m);
    }
    
    public NegativeQuantityException() {
        super("so bad");
    }
}
