package thg.domain.exceptions;

public class InvalidMarkException extends RuntimeException{
    public InvalidMarkException(){
        super("invalid mark");
    }
}
