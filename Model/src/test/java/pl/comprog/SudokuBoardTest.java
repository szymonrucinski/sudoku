package pl.comprog;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotSame;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertFalse;



public class SudokuBoardTest
{

    public void SudokuBoardTest()
    {

    }

    @Test
    public  void testFillWith0()
    {
        SudokuBoard sudoku = new SudokuBoard();
        assertEquals(0,sudoku.get(0,0));
        assertEquals(0,sudoku.get(5,5));
    }

    @Test

    public void testGetBoard()
    {
        SudokuBoard sudoku = new SudokuBoard();

        //column 1
        sudoku.set(0, 0, 4);
        assertEquals(4,sudoku.get(0,0));
        sudoku.set(1, 0, 7);
        sudoku.set(2, 0, 1);
        sudoku.set(3, 0, 9);
        sudoku.set(4, 0, 3);
        //column 2
        sudoku.set(5, 1, 7);
        //column 3
        sudoku.set(0, 2, 9);
        sudoku.set(2, 2, 8);
        sudoku.set(6, 2, 7);
        //column 4
        sudoku.set(0, 3, 8);
        sudoku.set(1, 3, 6);
        sudoku.set(4, 3, 4);
        sudoku.set(5, 3, 9);
        //column 5
        sudoku.set(0, 4, 1);
        sudoku.set(8, 4, 9);
        //column 6
        sudoku.set(3, 5, 8);
        sudoku.set(4, 5, 1);
        sudoku.set(7, 5, 6);
        sudoku.set(8, 5, 3);
        //column 7
        sudoku.set(2, 6, 4);
        sudoku.set(6, 6, 6);
        sudoku.set(8, 6, 2);
        //column 8
        sudoku.set(3, 7, 6);
        //column 9
        sudoku.set(4, 8, 2);
        sudoku.set(5, 8, 5);
        sudoku.set(6, 8, 8);
        sudoku.set(7, 8, 4);
        sudoku.set(8, 8, 7);
        assertEquals(7,sudoku.get(8,8));
    }

    @Test
    public    void testGetColumn()
    {
        SudokuBoard sudoku = new SudokuBoard();
        sudoku.set(0, 0, 1);
        sudoku.set(1, 0, 2);
        sudoku.set(2, 0, 3);
        sudoku.set(3, 0, 4);
        sudoku.set(4, 0, 5);
        sudoku.set(5, 0, 6);
        sudoku.set(6, 0, 7);
        sudoku.set(7, 0, 8);
        sudoku.set(8, 0, 9);
        assertTrue(sudoku.getColumn(0).verify());
    }
    @Test
    public void testGetColumnWrong()
    {
        SudokuBoard sudoku = new SudokuBoard();
        sudoku.set(0, 0, 1);
        sudoku.set(1, 0, 2);
        sudoku.set(2, 0, 3);
        sudoku.set(3, 0, 4);
        sudoku.set(4, 0, 5);
        sudoku.set(5, 0, 6);
        sudoku.set(6, 0, 6);
        sudoku.set(7, 0, 8);
        sudoku.set(8, 0, 9);
        assertFalse(sudoku.getColumn(0).verify());
    }

    @Test
    public  void testGetRow()
    {
        SudokuBoard sudoku = new SudokuBoard();
        sudoku.set(0, 0, 1);
        sudoku.set(0, 1, 2);
        sudoku.set(0, 2, 3);
        sudoku.set(0, 3, 4);
        sudoku.set(0, 4, 5);
        sudoku.set(0, 5, 6);
        sudoku.set(0, 6, 7);
        sudoku.set(0, 7, 8);
        sudoku.set(0, 8, 9);
        assertTrue(sudoku.verify(0, 0));
        assertTrue(sudoku.verify(2, 3));
        assertTrue(sudoku.verify(5, 6));
        assertTrue(sudoku.verify(8, 8));
    }

    @Test
    public  void testGetRowWrong()
    {
        SudokuBoard sudoku = new SudokuBoard();
        sudoku.set(0, 0, 1);
        sudoku.set(0, 1, 2);
        sudoku.set(0, 2, 3);
        sudoku.set(0, 3, 4);
        sudoku.set(0, 4, 5);
        sudoku.set(0, 5, 6);
        sudoku.set(0, 6, 7);
        sudoku.set(0, 7, 8);
        sudoku.set(0, 8, 8);
        assertFalse(sudoku.getRow(0).verify());
    }


    @Test
    public  void testGetBox()
    {
        SudokuBoard sudoku = new SudokuBoard();
        sudoku.set(0, 0, 1);
        sudoku.set(0, 1, 2);
        sudoku.set(0, 2, 3);
        sudoku.set(1, 0, 4);
        sudoku.set(1, 1, 5);
        sudoku.set(1, 2, 6);
        sudoku.set(2, 0, 7);
        sudoku.set(2, 1, 8);
        sudoku.set(2, 2, 9);

        sudoku.set(6, 6, 1);
        sudoku.set(6, 7, 2);
        sudoku.set(6, 8, 3);
        sudoku.set(7, 6, 4);
        sudoku.set(7, 7, 5);
        sudoku.set(7, 8, 6);
        sudoku.set(8, 6, 7);
        sudoku.set(8, 7, 8);
        sudoku.set(8, 8, 9);

        assertTrue(sudoku.verify(0, 0));
        assertTrue(sudoku.verify(2, 3));
        assertTrue(sudoku.verify(5, 6));
        assertTrue(sudoku.verify(8, 8));
    }

    @Test
    public  void testGetBoxWrong()
    {
        SudokuBoard sudoku = new SudokuBoard();
        sudoku.set(0, 0, 1);
        sudoku.set(0, 1, 2);
        sudoku.set(0, 2, 3);
        sudoku.set(1, 0, 4);
        sudoku.set(1, 1, 9);
        sudoku.set(1, 2, 6);
        sudoku.set(2, 0, 7);
        sudoku.set(2, 1, 8);
        sudoku.set(2, 2, 9);
        assertFalse(sudoku.getBox(0, 0).verify());

        sudoku.set(6, 6, 1);
        sudoku.set(6, 7, 2);
        sudoku.set(6, 8, 3);
        sudoku.set(7, 6, 4);
        sudoku.set(7, 7, 9);
        sudoku.set(7, 8, 6);
        sudoku.set(8, 6, 7);
        sudoku.set(8, 7, 8);
        sudoku.set(8, 8, 9);
        assertFalse(sudoku.getBox(6, 6).verify());
    }


    @Test
    public  void testVerify()
    {
        SudokuBoard sudoku = new SudokuBoard();
//box
        sudoku.set(0, 0, 1);
        sudoku.set(0, 1, 2);
        sudoku.set(0, 2, 3);
        sudoku.set(1, 0, 4);
        sudoku.set(1, 1, 5);
        sudoku.set(1, 2, 6);
        sudoku.set(2, 0, 7);
        sudoku.set(2, 1, 8);
        sudoku.set(2, 2, 9);
//col
        sudoku.set(0, 3, 4);
        sudoku.set(0, 4, 5);
        sudoku.set(0, 5, 6);
        sudoku.set(0, 6, 7);
        sudoku.set(0, 7, 8);
        sudoku.set(0, 8, 9);
//row
        sudoku.set(3, 0, 2);
        sudoku.set(4, 0, 5);
        sudoku.set(5, 0, 6);
        sudoku.set(6, 0, 3);
        sudoku.set(7, 0, 8);
        sudoku.set(8, 0, 9);

        assertTrue(sudoku.verify(0, 0));
        assertTrue(sudoku.verify(2, 3));
        assertTrue(sudoku.verify(5, 6));
        assertTrue(sudoku.verify(8, 8));
    }


    @Test
    public  void testVerifyWrong()
    {
        SudokuBoard sudoku = new SudokuBoard();
        //box
        sudoku.set(0, 0, 1);
        sudoku.set(0, 1, 2);
        sudoku.set(0, 2, 3);
        sudoku.set(1, 0, 4);
        sudoku.set(1, 1, 5);
        sudoku.set(1, 2, 6);
        sudoku.set(2, 0, 7);
        sudoku.set(2, 1, 8);
        sudoku.set(2, 2, 9);
        //col
        sudoku.set(0, 3, 4);
        sudoku.set(0, 4, 5);
        sudoku.set(0, 5, 6);
        sudoku.set(0, 6, 7);
        sudoku.set(0, 7, 8);
        sudoku.set(0, 8, 9);
        //row
        sudoku.set(3, 0, 4);
        sudoku.set(4, 0, 5);
        sudoku.set(5, 0, 6);
        sudoku.set(6, 0, 3);
        sudoku.set(7, 0, 8);
        sudoku.set(8, 0, 9);

        assertFalse(sudoku.verify(0, 0));
    }

    @Test
    public   void testVerifyWith0()
    {
        SudokuBoard sudoku = new SudokuBoard();
        //box
        sudoku.set(0, 0, 1);
        sudoku.set(0, 1, 2);
        sudoku.set(0, 2, 0);
        sudoku.set(1, 0, 4);
        sudoku.set(1, 1, 5);
        sudoku.set(1, 2, 0);
        sudoku.set(2, 0, 7);
        sudoku.set(2, 1, 8);
        sudoku.set(2, 2, 0);
        //col
        sudoku.set(0, 3, 0);
        sudoku.set(0, 4, 5);
        sudoku.set(0, 5, 6);
        sudoku.set(0, 6, 0);
        sudoku.set(0, 7, 8);
        sudoku.set(0, 8, 9);
        //row
        sudoku.set(3, 0, 0);
        sudoku.set(4, 0, 5);
        sudoku.set(5, 0, 6);
        sudoku.set(6, 0, 3);
        sudoku.set(7, 0, 0);
        sudoku.set(8, 0, 9);

        assertTrue(sudoku.verify(0, 0));
        assertTrue(sudoku.verify(2, 3));
        assertTrue(sudoku.verify(5, 6));
        assertTrue(sudoku.verify(8, 8));
    }
    @Test
    public void testVerifyOnlyWith0() {
        SudokuBoard sudoku = new SudokuBoard();
        assertTrue(sudoku.verify(0, 0));
        assertTrue(sudoku.verify(2, 3));
        assertTrue(sudoku.verify(5, 6));
        assertTrue(sudoku.verify(8, 8));
    }




    @Test
    public  void testCheckBoard()
    {
        SudokuBoard sudoku = new SudokuBoard();
        //box
        sudoku.set(0, 0, 1);
        sudoku.set(0, 1, 2);
        sudoku.set(0, 2, 3);
        sudoku.set(1, 0, 4);
        sudoku.set(1, 1, 5);
        sudoku.set(1, 2, 6);
        sudoku.set(2, 0, 7);
        sudoku.set(2, 1, 8);
        sudoku.set(2, 2, 9);
        //col
        sudoku.set(0, 3, 4);
        sudoku.set(0, 4, 5);
        sudoku.set(0, 5, 6);
        sudoku.set(0, 6, 7);
        sudoku.set(0, 7, 8);
        sudoku.set(0, 8, 9);
        //row
        sudoku.set(3, 0, 2);
        sudoku.set(4, 0, 5);
        sudoku.set(5, 0, 6);
        sudoku.set(6, 0, 3);
        sudoku.set(7, 0, 8);
        sudoku.set(8, 0, 9);

        assertTrue(sudoku.checkBoard());
    }


    @Test
    public  void testCheckBoardWrong()
    {
        SudokuBoard sudoku = new SudokuBoard();
        //box
        sudoku.set(0, 0, 1);
        sudoku.set(0, 1, 2);
        sudoku.set(0, 2, 3);
        sudoku.set(1, 0, 4);
        sudoku.set(1, 1, 5);
        sudoku.set(1, 2, 6);
        sudoku.set(2, 0, 7);
        sudoku.set(2, 1, 8);
        sudoku.set(2, 2, 9);
        //col
        sudoku.set(0, 3, 4);
        sudoku.set(0, 4, 5);
        sudoku.set(0, 5, 6);
        sudoku.set(0, 6, 7);
        sudoku.set(0, 7, 8);
        sudoku.set(0, 8, 9);
        //row
        sudoku.set(3, 0, 4);
        sudoku.set(4, 0, 5);
        sudoku.set(5, 0, 6);
        sudoku.set(6, 0, 3);
        sudoku.set(7, 0, 8);
        sudoku.set(8, 0, 9);

        assertEquals(false,  sudoku.checkBoard());
    }

    @Test
    public void testCheckBoardWith0()
    {
        SudokuBoard sudoku = new SudokuBoard();
        //box
        sudoku.set(0, 0, 1);
        sudoku.set(0, 1, 2);
        sudoku.set(0, 2, 0);
        sudoku.set(1, 0, 4);
        sudoku.set(1, 1, 5);
        sudoku.set(1, 2, 0);
        sudoku.set(2, 0, 7);
        sudoku.set(2, 1, 8);
        sudoku.set(2, 2, 0);
        //col
        sudoku.set(0, 3, 0);
        sudoku.set(0, 4, 5);
        sudoku.set(0, 5, 6);
        sudoku.set(0, 6, 0);
        sudoku.set(0, 7, 8);
        sudoku.set(0, 8, 9);
        //row
        sudoku.set(3, 0, 0);
        sudoku.set(4, 0, 5);
        sudoku.set(5, 0, 6);
        sudoku.set(6, 0, 3);
        sudoku.set(7, 0, 0);
        sudoku.set(8, 0, 9);

        assertTrue(sudoku.checkBoard());
    }
    @Test
    public void testDisplay() {
        SudokuBoard sudoku = new SudokuBoard();
        sudoku.set(0, 0, 1);
        sudoku.set(1, 0, 2);
        sudoku.set(2, 0, 3);
        sudoku.set(3, 0, 4);
        sudoku.set(4, 0, 5);
        sudoku.set(5, 0, 6);
        sudoku.set(6, 0, 7);
        sudoku.set(7, 0, 8);
        sudoku.set(8, 0, 9);
        sudoku.display();
    }


    @Test
    public void checkOverrideEquals()
    {
        SudokuBoard sudoku = new SudokuBoard();
        sudoku.set(0, 0, 1);
        sudoku.set(1, 0, 2);
        sudoku.set(2, 0, 3);
        sudoku.set(3, 0, 4);
        sudoku.set(4, 0, 5);
        sudoku.set(5, 0, 6);
        sudoku.set(6, 0, 7);
        sudoku.set(7, 0, 8);
        sudoku.set(8, 0, 9);

        SudokuBoard sudoku1 = new SudokuBoard();
        sudoku1.set(0, 0, 1);
        sudoku1.set(1, 0, 2);
        sudoku1.set(2, 0, 3);
        sudoku1.set(3, 0, 4);
        sudoku1.set(4, 0, 5);
        sudoku1.set(5, 0, 6);
        sudoku1.set(6, 0, 7);
        sudoku1.set(7, 0, 8);
        sudoku1.set(8, 0, 9);

        assertTrue(sudoku.equals(sudoku1));

    }

    @Test
    public void checkOverrideEqualsWrong()
    {
        SudokuBoard sudoku = new SudokuBoard();
        sudoku.set(0, 0, 1);
        sudoku.set(1, 0, 2);
        sudoku.set(2, 0, 3);
        sudoku.set(3, 0, 4);
        sudoku.set(4, 0, 5);
        sudoku.set(5, 0, 6);
        sudoku.set(6, 0, 7);
        sudoku.set(7, 0, 8);
        sudoku.set(8, 0, 9);

        SudokuBoard sudoku1 = new SudokuBoard();
        sudoku1.set(0, 0, 9);
        sudoku1.set(1, 0, 8);
        sudoku1.set(2, 0, 7);
        sudoku1.set(3, 0, 6);
        sudoku1.set(4, 0, 5);
        sudoku1.set(5, 0, 4);
        sudoku1.set(6, 0, 3);
        sudoku1.set(7, 0, 2);
        sudoku1.set(8, 0, 1);

        assertFalse(sudoku.equals(sudoku1));
    }

    @Test
    public void checkOverrideEqualsTheSame()
    {
        SudokuBoard sudoku = new SudokuBoard();
        sudoku.set(0, 0, 1);
        sudoku.set(1, 0, 2);
        sudoku.set(2, 0, 3);
        sudoku.set(3, 0, 4);
        sudoku.set(4, 0, 5);
        sudoku.set(5, 0, 6);
        sudoku.set(6, 0, 7);
        sudoku.set(7, 0, 8);
        sudoku.set(8, 0, 9);
        assertTrue(sudoku.equals(sudoku));
    }

    @Test
    public void checkToString()
    {
        SudokuBoard sudoku = new SudokuBoard();
        System.out.println(sudoku.toString());
    }


}