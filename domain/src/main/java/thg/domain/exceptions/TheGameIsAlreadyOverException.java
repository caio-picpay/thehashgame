package thg.domain.exceptions;

public class TheGameIsAlreadyOverException extends RuntimeException{
    public TheGameIsAlreadyOverException(){
        super("the game is already over");
    }
}
