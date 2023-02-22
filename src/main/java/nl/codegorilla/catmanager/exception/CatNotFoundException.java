package nl.codegorilla.catmanager.exception;


public class CatNotFoundException extends RuntimeException{
    public CatNotFoundException(String message) {
        super(message);
    }
}
