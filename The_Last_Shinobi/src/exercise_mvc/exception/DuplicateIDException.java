package exercise_mvc.exception;

public class DuplicateIDException extends Exception {
    public DuplicateIDException(String message) {
        super(message);
    }
}
