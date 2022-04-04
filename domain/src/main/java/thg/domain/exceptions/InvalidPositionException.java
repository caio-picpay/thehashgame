package thg.domain.exceptions;

public class InvalidPositionException extends RuntimeException{
    public InvalidPositionException(){
        super("invalid position");
    }
}
