package ru.billing.exceptions;

public class CatalogLoadException extends Exception {
    public CatalogLoadException(String message) {
        super(message);
    }
    
    public CatalogLoadException() {
        super("Error with loading catalog");
    }
    
    public CatalogLoadException(Exception e) {
        super(e);
    }
}
