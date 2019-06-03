//Packages and import
package gui;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import pl.comprog.BackTrackingSudokuSolver;
import pl.comprog.FileSudokuBoardDao;
import pl.comprog.LevelDifficulty;
import pl.comprog.SudokuBoard;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class GamingArena
{


    public static Scene GamingScene(SudokuBoard sudokuPassed, int level, Stage stage, Scene menu,boolean IsEnglish) {

        ResourceBundle bundlePL = ResourceBundle.getBundle("gui.LanguagePack");
        ResourceBundle bundleEN = ResourceBundle.getBundle("gui.LanguagePackPL");


        SudokuBoard solution = Getsolution(sudokuPassed);
         SudokuBoard sudoku = (SudokuBoard)solution.clone();



        //Sudoku setup

            LevelDifficulty lvd = new LevelDifficulty();
            if(level!=4)lvd.selectLevel(sudoku, level);
            if(level==4)lvd.selectLevel(sudokuPassed, level);


        System.out.println("SOLUTION.DISPLAY");
            solution.display();
        System.out.println("sudoku.DISPLAY");
            sudoku.display();

        //Grid of boxes
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));

        //List containing TextFields
        List<List<TextField>> boardTextFields = new ArrayList<>();
        for (int i = 0; i < 9; i++)
            boardTextFields.add(new ArrayList<>());

        //SETTING UP A LIST
        for (int x = 0; x < 9; x++){
            for (int y = 0; y < 9; y++) {
                TextField emptyTextField = new TextField();
                int valueFromSudokuField = sudoku.get(y,x);
                emptyTextField.setText(String.valueOf(valueFromSudokuField));
                emptyTextField.setEditable(true);
                emptyTextField.setAlignment(Pos.CENTER);
                emptyTextField.setPrefHeight(40);
                emptyTextField.setPrefWidth(40);
                emptyTextField.setFont(Font.font("Helvetica", 15));
                emptyTextField.setTextFormatter(new TextFormatter<String>((TextFormatter.Change change) -> {
                    if (change.getText().matches("[0-9]*") && !(change.getControlNewText().length() > 1)) {
                        return change;
                    } else {
                        return null;
                    }
                }));
                int X1=x;
                int Y1 =y;
                grid.add(emptyTextField,x,y);


                emptyTextField.textProperty().addListener((observable, oldValue, newValue) -> {
                    if (newValue.equals("")) {
                        sudoku.set(Y1, X1, 0);
                    } else {
                        sudoku.set(Y1, X1, Integer.parseInt(newValue));
                    }
                });


            }
    }



        //Instantiating the BorderPane class
        BorderPane root = new BorderPane();
        root.setBottom(new TextField("Bottom"));
        root.setCenter(new TextField("Center"));





        //Buttons
        Button verifyButton = new Button("Verify");
        Button saveGame = new Button("Save");
        Button homeButton = new Button("Go Back");
        Pane controls = new Pane();
        verifyButton.setLayoutX(60);
        homeButton.setLayoutX(160);
        saveGame.setLayoutX(280);

        //Language configuration
        if(IsEnglish==true)
        {
            verifyButton.setText(bundleEN.getString("verifyButton"));
            saveGame.setText(bundleEN.getString("saveGame"));
            homeButton.setText(bundleEN.getString("homeButton"));

        }
        else {
            verifyButton.setText(bundlePL.getString("verifyButton"));
            saveGame.setText(bundlePL.getString("saveGame"));
            homeButton.setText(bundlePL.getString("homeButton"));
        }


        //Add to Pane
        controls.getChildren().addAll(homeButton,verifyButton,saveGame);
        root.setCenter(grid);
        root.setBottom(controls);
        homeButton.setOnAction(e -> stage.setScene(menu));
        verifyButton.setOnAction(e -> validate(solution,sudoku,IsEnglish));
        saveGame.setOnAction(e -> saveGame(sudoku));


        //Scene setup
        Scene GamingArena = new Scene(root, 400, 400);

        return GamingArena;
    }

    private static void  validate(SudokuBoard solution, SudokuBoard sudoku, boolean IsEnglish)
    {

        String setTitle = "OK";
       String setContentText="OK";


        Alert alert = new Alert(Alert.AlertType.INFORMATION);


        solution.display();
        for(int i =0;i<9;i++){
            for(int j=0;j<9;j++)
            {
                if(sudoku.get(i,j)==solution.get(i,j))continue;
                else  setContentText="FAIL!";


            }
        }
        alert.setTitle("BRAVO");
        alert.setContentText(setContentText);
        alert.showAndWait();
        System.out.println("VALIDATE");
        sudoku.display();
        System.out.println("VALIDATE");
        solution.display();


    }

    public static SudokuBoard saveGame (SudokuBoard sudoku)
    {
        FileSudokuBoardDao fileSudokuBoardDao = new FileSudokuBoardDao("saveTest.dat");
        fileSudokuBoardDao.write(sudoku);
        sudoku.display();
        return sudoku;
    }

    private static SudokuBoard Getsolution(SudokuBoard sudokuBoard){
        BackTrackingSudokuSolver solver = new BackTrackingSudokuSolver();
        SudokuBoard solution = (SudokuBoard)sudokuBoard.clone();
        solver.solve(solution);

        return solution;
    }


}