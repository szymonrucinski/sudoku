package pl.comp.model.sudoku;

import pl.comp.model.exceptions.DaoException;

public class SudokuBoardDaoFactory {


    public Dao getFileDao(String fileName) throws DaoException {
        FileSudokuBoardDao file = new FileSudokuBoardDao(fileName);
        return file;


    }

    public final Dao getDatabaseDao(final String name) throws DaoException {
        return new JdbcSudokuBoardDao(name);
    }


}