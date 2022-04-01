package app.usecases;

public interface UseCase<I, O> {
    O execute(I input);
}
