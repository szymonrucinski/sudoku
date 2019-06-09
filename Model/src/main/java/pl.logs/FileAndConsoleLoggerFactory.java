package pl.logs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import ch.qos.logback.core.FileAppender;
import pl.comprog.SudokuBoard;
import pl.date.CurrentTime;

public class GameLog {
    Logger logger;
    CurrentTime ct;

    private GameLog(){

        this.logger = LoggerFactory.getLogger(getClass());
    }

    public void NewGeneratedBoardLog(SudokuBoard NewGeneratedBoard){
        logger.info("Time:");
        logger.info(ct.getDate());
        logger.info("New Generated Game:");
        String[] DisplayNewGeneratedSudoku=NewGeneratedBoard.display();
        for(int i =0;i<90;i++)
        {
        logger.info(DisplayNewGeneratedSudoku[i]);
        if(i%9==8)        logger.info("%n");
        }
    }






}
