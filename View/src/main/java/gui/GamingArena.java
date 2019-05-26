package gui;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import pl.comprog.BackTrackingSudokuSolver;
import pl.comprog.LevelDifficulty;
import pl.comprog.SudokuBoard;
//import pl.compprog.EasyDifficulty;

import java.awt.*;
import java.util.Optional;
import java.util.OptionalInt;





public class GamingArena
{
    public Node getNodeByRowColumnIndex( int row, int column,GridPane grid) {
        Node result = null;
        ObservableList<Node> childrens = grid.getChildren();
        for(Node node : childrens) {
            if(grid.getRowIndex(node) == row && grid.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }
        return result;
    }

    public static Scene GamingScene(int level)
    {
        SudokuBoard sudoku = new SudokuBoard();
        BackTrackingSudokuSolver solver = new BackTrackingSudokuSolver();
        solver.solve(sudoku);
        SudokuBoard solution = (SudokuBoard) sudoku.clone();

        solution.display();
        LevelDifficulty lvd = new LevelDifficulty();
        lvd.selectLevel(sudoku,level);

        Button button = new Button("Go Back");
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(40, 40, 40, 40));

        TextField textField = new TextField();

        grid.add(textField, 9, 9);

        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
             grid.add(new javafx.scene.control.TextField("" + sudoku.get(j,i)), i, j);
            }
        }

        Scene easy = new Scene(grid, 400, 400);











        //Checking if correct();
        Button checkCorrect = new Button();
        //checkCorrect.setOnAction(e->);





        return easy;
    }




}