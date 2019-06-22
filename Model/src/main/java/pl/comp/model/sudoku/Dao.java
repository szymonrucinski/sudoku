//道
//道
//道
//道
//import pl.exceptions;

package pl.comp.model.sudoku;
import pl.comp.model.exceptions.DaoException;

public interface Dao<T>{

    T read() throws DaoException;
    void write(T obj) throws DaoException;
}
