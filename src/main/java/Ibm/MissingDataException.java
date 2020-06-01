package Ibm;

public class MissingDataException extends IllegalStateException{

    public MissingDataException(String message) {
        super(message);
    }
}
