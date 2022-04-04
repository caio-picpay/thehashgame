package thg.domain.exceptions;

public class PositionAlreadyMarkedException extends RuntimeException{
    public PositionAlreadyMarkedException(){
        super("position already marked");
    }
}
