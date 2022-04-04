package thg.application.usecases;

public interface UseCaseWithoutOutput<I> {
    void execute(I input);
}
