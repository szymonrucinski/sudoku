package pl.comp.model.exceptions;

public class SudokuException extends Exception {

    public SudokuException(final String message) {
        super(message);
    }

    public SudokuException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
