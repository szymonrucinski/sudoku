package pl.comprog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.date.CurrentTime;
import org.junit.Test;


public class LoggerTest {

@Test
    public void GameLog() {

        Logger logger = LoggerFactory.getLogger(getClass());
        SudokuBoard NewGeneratedBoard = new SudokuBoard();
        logger.info("Time:");
        logger.info("New Generated Game:");

        String[] DisplayNewGeneratedSudoku = NewGeneratedBoard.display();
        for (int i = 0; i < 81; i++) {
            logger.debug(DisplayNewGeneratedSudoku[i]);
            if (i % 9 == 8) logger.info("%n");
        }
    }

}
