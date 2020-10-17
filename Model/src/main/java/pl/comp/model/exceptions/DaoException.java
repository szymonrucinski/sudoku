package pl.comp.model.exceptions;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class DaoException extends SudokuException {


    private static final ResourceBundle exceptionMessages;

    public static final String NULL_BOARD = "null.board";
    public static final String MISSING_FILE = "missing.file";
    public static final String NULL_NAME = "null.name";
    public static final String OPEN_ERROR = "open.error";
    public static final String INVALID_CAST = "invalid.cast";
    public static final String SQL_ERROR = "sql.error";
    public static final String NO_JDBC_DRIVER = "no.JDBC.driver";
    public static final String NO_SUCH_RECORD = "no.such.record";
    public static final String  SAVE_LOADED = "save.loaded";
    public static final String  SAVE_ERROR = "save.error";
    public static final String  ASSET_ERROR = "asset.error";




    static {
        Locale locale = Locale.getDefault(Locale.Category.DISPLAY);
        exceptionMessages = ResourceBundle.getBundle("exceptionMessageLanguage", locale);
    }

    public DaoException(final String message) {
        super(message);
    }

    public DaoException(final String message, final Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getLocalizedMessage() {
        String message;
        try {
            message = exceptionMessages.getString(getMessage());
        } catch (MissingResourceException mre) {
            message = "No resource for " + getMessage() + "key";
        }
        return message;
    }
}
