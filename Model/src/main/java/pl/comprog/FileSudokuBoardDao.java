package pl.comprog;
import java.io.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotSame;


public class FileSudokuBoardDao implements Dao <SudokuBoard>, AutoCloseable{

    private final String filename;


    FileSudokuBoardDao(String filename)
    {
        this.filename = filename;
    }

    @Override
    public SudokuBoard read() {
        SudokuBoard sudokuBoard = new SudokuBoard();

        try (
                FileInputStream fi = new FileInputStream(new File(filename));
                ObjectInputStream oi = new ObjectInputStream(fi);

        ) {
            return (SudokuBoard) oi.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }


        return sudokuBoard;
    }

    @Override
    public void write(SudokuBoard obj) {

        try (
                FileOutputStream fos = new FileOutputStream(filename);
                ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void finalize() {
        close();
    }

    @Override
    public void close()
    {
        System.out.println("Closing");
    }
}
