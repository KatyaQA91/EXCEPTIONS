package netology.ru;

public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(String b) {
        super(b);
    }
}