
import org.apache.commons.lang3.builder.ToStringBuilder;
import java.util.ArrayList;
import java.util.Random;
/**
 * opis.
 */
public class BackTrackingSudokuSolver implements SudokuSolver {
    public static final int SIZE = 9;
    public static final int EMPTY = 0;

    public BackTrackingSudokuSolver() {
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("size", SIZE).toString();
    }

    public boolean solve(SudokuBoard sudokuBoard) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (sudokuBoard.get(row, col) == EMPTY) {
                    ArrayList<Integer> randomNumbers = new ArrayList<Integer>();
                    for (int i = 1; i <= SIZE; i++) {
                        randomNumbers.add(i);
                    }
                    Random rand = new Random();
                    for (int number = 0; number < SIZE; number++) {
                        int pickedNumber = rand.nextInt(randomNumbers.size());
                        int numberToCheck = randomNumbers.get(pickedNumber);
                        randomNumbers.remove(pickedNumber);
                        sudokuBoard.set(row, col, numberToCheck);
                        if (sudokuBoard.verify(row, col)) {
                            if (solve(sudokuBoard)) {
                                return true;
                            } else {
                                sudokuBoard.set(row, col, EMPTY);
                            }
                        } else {
                            sudokuBoard.set(row, col, EMPTY);
                        }
                    }
                    sudokuBoard.set(row, col, EMPTY);
                    return false;
                }
            }
        }
        return true;
    }
}
