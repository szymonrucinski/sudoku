package pl.comp.model.sudoku;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class SudokuBoard implements Cloneable, Serializable {
    public static final int SIZE = 9;
    private List<SudokuField> board;
    private List<SudokuBox> boxes;
    private List<SudokuColumn> columns;
    private List<SudokuRow> rows;

    public SudokuBoard() {
        SudokuField[] sboard = new SudokuField[81];
        SudokuBox[] sboxes = new SudokuBox[9];
        SudokuColumn[] scolumns = new SudokuColumn[9];
        SudokuRow[] srows = new SudokuRow[9];

        for (int i = 0; i < 81; i++) {
            sboard[i] = new SudokuField();
        }

        for (int x = 0; x < 9; x++) {
            srows[x] = new SudokuRow();
            scolumns[x] = new SudokuColumn();
            for (int y = 0; y < 9; y++) {
                srows[x].addField(sboard[x * SIZE + y]);
                scolumns[x].addField(sboard[x + y * SIZE]);
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sboxes[i * 3 + j] = new SudokuBox();
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        sboxes[i * 3 + j].addField(sboard[(i * 27) + (j * 3) + (x * 9 + y)]);
                    }
                }
            }

        }
        columns = Arrays.asList(scolumns);
        rows = Arrays.asList(srows);
        boxes = Arrays.asList(sboxes);
        board = Arrays.asList(sboard);
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        SudokuBoard ob = (SudokuBoard) obj;
        EqualsBuilder e = new EqualsBuilder();
        for (int i = 0; i < board.size(); i++) {
            e.append(this.board.get(i), ob.board.get(i));
        }
        return e.isEquals();
    }

    @Override
    public int hashCode() {
        HashCodeBuilder hs = new HashCodeBuilder(17, 37);
        for (SudokuField sudokuField : board) {
            hs.append(sudokuField);
        }
        return hs.toHashCode();
    }

    public int get(int x, int y) {
        return board.get(x * SIZE + y).getFieldValue();
    }

    public void set(int x, int y, int value) {
        board.get(x * SIZE + y).setFieldValue(value);
    }

    public SudokuRow getRow(int y) {
        return rows.get(y);
    }

    public SudokuColumn getColumn(int x) {
        return columns.get(x);
    }

    public SudokuBox getBox(int x, int y) {
        return boxes.get(x / 3 * 3 + y / 3);
    }

    public boolean verify(int row, int col) {
        return rows.get(row).verify() && columns.get(col).verify() && boxes.get(row / 3 * 3 + col / 3).verify();
    }

    public boolean checkBoard() {
        for (int i = 0; i < 9; i++) {
            if (!rows.get(i).verify() || !columns.get(i).verify() || !boxes.get(i).verify()) {
                return false;
            }
        }
        return true;
    }

    public void display() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board.get(i * SIZE + j).getFieldValue());
                System.out.print(" ");
            }
            System.out.printf("%n");
        }
    }

    @Override
    public Object clone() {
//
        byte[] object;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(this);
            object = baos.toByteArray();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return null;
        }

        try (ByteArrayInputStream bais = new ByteArrayInputStream(object);
             ObjectInputStream ois = new ObjectInputStream(bais)) {
            SudokuBoard clone = (SudokuBoard) ois.readObject();
            return clone;
        } catch (IOException | ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(System.getProperty("line.separator"));
        sb.append("-----------------").append(System.getProperty("line.separator"));
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                sb.append(board.get(x * SIZE + y).getFieldValue());
                if (y != 8) {
                    sb.append(" ");
                }
            }
            sb.append(System.getProperty("line.separator"));
            if (x % 3 == 2 && x != 8) {
                sb.append("- - - - - - - - -").append(System.getProperty("line.separator"));
            }
        }
        sb.append("-----------------");
        sb.append(System.getProperty("line.separator"));
        return sb.toString();
    }

}

