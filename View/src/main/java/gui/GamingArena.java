package gui;
import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;
import pl.comprog.BackTrackingSudokuSolver;
import pl.comprog.FileSudokuBoardDao;
import pl.comprog.LevelDifficulty;
import pl.comprog.SudokuBoard;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static javafx.scene.input.KeyCode.T;


public class GamingArena
{



    public static Scene GamingScene(SudokuBoard sudoku, int level, Stage stage, Scene menu,boolean IsEnglish) {

        ResourceBundle bundlePL = ResourceBundle.getBundle("gui.LanguagePack");
        ResourceBundle bundleEN = ResourceBundle.getBundle("gui.LanguagePackPL");

        //Sudoku setup
        BackTrackingSudokuSolver solver = new BackTrackingSudokuSolver();
        solver.solve(sudoku);
        SudokuBoard solution = (SudokuBoard) sudoku.clone();
        LevelDifficulty lvd = new LevelDifficulty();
        lvd.selectLevel(sudoku, level);

        //Grid of boxes
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));

        //LIST CONTAINING FIELDS
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
                    System.out.println(newValue);
                    System.out.println(X1);
                    System.out.println(Y1);


                    if (newValue.equals("")) {
                        sudoku.set(X1, Y1, 0);
                    } else {
                        sudoku.set(X1, Y1, Integer.parseInt(newValue));
                        System.out.println("NEW VALUE"+(sudoku.get(X1,Y1)));
                        System.out.println(X1);
                        System.out.println(Y1);

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
        verifyButton.setLayoutX(200);
        homeButton.setLayoutX(280);
        saveGame.setLayoutX(360);

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



            controls.getChildren().addAll(homeButton,verifyButton,saveGame);

      root.setCenter(grid);
      root.setBottom(controls);
      homeButton.setOnAction(e -> stage.setScene(menu));
     verifyButton.setOnAction(e -> validate(solution,sudoku,IsEnglish));



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

    }

    public SudokuBoard saveGame (SudokuBoard sudoku)
    {

        FileSudokuBoardDao fileSudokuBoardDao = new FileSudokuBoardDao("save.dat");
        fileSudokuBoardDao.write(sudoku);
        sudoku.display();
        return sudoku;

    }






}