//
package pl.comprog;
public class SudokuBoardDaoFactory {


    Dao getFileDao(String fileName) {
        FileSudokuBoardDao file = new FileSudokuBoardDao(fileName);
        return file;


    }

}