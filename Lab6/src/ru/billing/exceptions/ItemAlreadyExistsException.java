package ru.billing.exceptions;

public class ItemAlreadyExistsException extends Exception {
    public ItemAlreadyExistsException(String m) {
        super(m);
    }
    
    public ItemAlreadyExistsException() {
        super("Item already exists!");
    }
}
