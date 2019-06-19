//
package pl.comp.model.sudoku;

import pl.comp.model.exceptions.DaoException;

public class SudokuBoardDaoFactory {


    Dao getFileDao(String fileName)throws DaoException {
        FileSudokuBoardDao file = new FileSudokuBoardDao(fileName);
        return file;


    }

}