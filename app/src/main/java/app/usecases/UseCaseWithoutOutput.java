package app.usecases;

public interface UseCaseWithoutOutput<I> {
    void execute(I input);
}
