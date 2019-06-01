package gui;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import pl.comprog.BackTrackingSudokuSolver;
import pl.comprog.LevelDifficulty;
import pl.comprog.SudokuBoard;

import static javafx.scene.input.KeyCode.T;


public class GamingArena
{


    public static Scene GamingScene(SudokuBoard sudoku, int level, Stage stage, Scene menu)
    {
        //Instantiating the BorderPane class
        BorderPane root = new BorderPane();
        root.setBottom(new TextField("Bottom"));
        root.setCenter(new TextField("Center"));



        stage.setTitle("Solve Sudoku");

        //Buttons

        Button verifyButton = new Button("Verify");
        Button homebutton = new Button("Go Back");
        Pane controls = new Pane();
        verifyButton.setLayoutX(200);
        homebutton.setLayoutX(280);


        controls.getChildren().addAll(homebutton,verifyButton);




        //Sudoku setup
        BackTrackingSudokuSolver solver = new BackTrackingSudokuSolver();
        solver.solve(sudoku);
        SudokuBoard solution = (SudokuBoard) sudoku.clone();
            LevelDifficulty lvd = new LevelDifficulty();
            lvd.selectLevel(sudoku, level);


        //Grid of boxes
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));

       // grid.add(textField, 9, 9);
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
             grid.add(inputBox.createBox(i,j,sudoku.get(i,j)), i, j);

            }
        }

      root.setCenter(grid);
      root.setBottom(controls);
      homebutton.setOnAction(e -> stage.setScene(menu));
      verifyButton.setOnAction(e -> validate(solution,grid));



        Scene GamingArena = new Scene(root, 400, 400);

        return GamingArena;
    }

static boolean validate(SudokuBoard solution,GridPane grid)
{

}


}