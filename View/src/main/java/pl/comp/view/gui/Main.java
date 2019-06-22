package pl.comp.view.gui;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import pl.comp.model.exceptions.DaoException;
import pl.comp.model.logger.FileAndConsoleLoggerFactory;
import pl.comp.model.sudoku.*;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.scene.effect.DropShadow;

//--module-path ${PATH_TO_FX} --add-modules=javafx.controls,javafx.fxml,javafx.media


public class Main extends Application {

    ResourceBundle bundleEN = ResourceBundle.getBundle("LanguagePackPL");
    ResourceBundle bundlePL = ResourceBundle.getBundle("LanguagePack");
    private static final Logger logger = FileAndConsoleLoggerFactory.getConfiguredLogger(Main.class.getName());

    private static Scene menu;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Text languages;
    Text difficulty;

    Boolean IsEnglish;
    Boolean loadedSave = false;


    SudokuBoard LoadGame() {

              /* FileSudokuBoardDao fileSudokuBoardDao = new FileSudokuBoardDao("saveTest.dat");
             SudokuBoard SudokuLoadedFromFile = fileSudokuBoardDao.read();
             return SudokuLoadedFromFile;*/

        SudokuBoard SudokuLoadedFromFile;

        SudokuBoardDaoFactory sudokuBoardDaoFactory = new SudokuBoardDaoFactory();
        try (JdbcSudokuBoardDao dao = (JdbcSudokuBoardDao) sudokuBoardDaoFactory.getDatabaseDao("sudoku")) {
            SudokuLoadedFromFile = dao.read();

            return SudokuLoadedFromFile;


            /* FileSudokuBoardDao fileSudokuBoardDao = new FileSudokuBoardDao("saveTest.dat");
             SudokuBoard SudokuLoadedFromFile = fileSudokuBoardDao.read();
             return SudokuLoadedFromFile;*/

        } catch (DaoException e) {

            logger.log(Level.INFO,DaoException.OPEN_ERROR);
        }

        return new SudokuBoard();

    }


    @Override
    public void start(Stage stage) throws Exception {
        IsEnglish = false;
        //MENU DESIGN//
        Pane layout = new Pane();
        layout.setPrefSize(400, 400);

        InputStream background = Files.newInputStream(Paths.get("View/src/main/resources/images/background.jpg"));
        Image img = new Image(background);
        background.close();

        ImageView imgView = new ImageView(img);


        imgView.setFitWidth(400);
        imgView.setFitHeight(400);
        layout.getChildren().addAll(imgView);

        GaussianBlur blur = new GaussianBlur(5);
        imgView.setEffect(blur);


        Text menuText = new Text();
        menuText.setText("Sudoku");
        menuText.setFont(Font.font("shanghai", FontWeight.BOLD, FontPosture.REGULAR, 60));
        menuText.setFill(Color.RED);
        menuText.setX(90);
        menuText.setY(60);
        DropShadow dropShadow = new DropShadow();

        menuText.setEffect(dropShadow);
        menuText.setCache(true);

        difficulty = new Text();
        difficulty.setText("Difficulty");
        difficulty.setFont(Font.font("shanghai", FontWeight.BOLD, FontPosture.REGULAR, 20));
        difficulty.setFill(Color.YELLOW);
        difficulty.setX(145);
        difficulty.setY(96);
        DropShadow dropShadow1 = new DropShadow();

        difficulty.setEffect(dropShadow1);
        difficulty.setCache(true);


        languages = new Text();
        languages.setText("Languages");
        languages.setFont(Font.font("shanghai", FontWeight.BOLD, FontPosture.REGULAR, 20));
        languages.setFill(Color.YELLOW);
        languages.setX(145);
        languages.setY(150);
        DropShadow dropShadow2 = new DropShadow();

        languages.setEffect(dropShadow1);
        languages.setCache(true);


        //Buttons
        b2 = new Button();
        b2.setText(bundlePL.getString("b2"));
        b2.setLayoutX(100);
        b2.setLayoutY(100);
        b2.setOnAction(e -> stage.setScene(GamingArena.GamingScene(new SudokuBoard(), 0, stage, menu, IsEnglish)));

        b3 = new Button();
        //language.Polish(b3,"b3");
        b3.setText(bundlePL.getString("b3"));

        b3.setLayoutX(156);
        b3.setLayoutY(100);
        b3.setOnAction(e -> stage.setScene(GamingArena.GamingScene(new SudokuBoard(), 1, stage, menu, IsEnglish)));

        b4 = new Button();
        b4.setText(bundlePL.getString("b4"));

        //language.Polish(b4,"b4");
        b4.setLayoutX(230);
        b4.setLayoutY(100);
        b4.setOnAction(e -> stage.setScene(GamingArena.GamingScene(new SudokuBoard(), 2, stage, menu, IsEnglish)));

        b5 = new Button();
        //language.Polish(b5,"b5");
        b5.setText(bundlePL.getString("b5"));

        b5.setLayoutX(130);
        b5.setLayoutY(160);
        // b5.setOnAction(e -> language.Polish(b2,"b2"));
        b5.setOnAction(e -> English());


        b6 = new Button();
        //language.Polish(b6,"b6");
        b6.setText(bundlePL.getString("b6"));
        b6.setLayoutX(200);
        b6.setLayoutY(160);
        b6.setOnAction(e -> Polish());

        b7 = new Button();
        b7.setText("LoadGame");
        b7.setLayoutX(150);
        b7.setLayoutY(210);
        if (loadedSave == false) {
            b7.setText("Run Saved Game");
            LoadGame();
        }
        b7.setOnAction(e -> stage.setScene(GamingArena.GamingScene(LoadGame(), 4, stage, menu, IsEnglish)));


        {
            Button back = new Button("Back");
            back.setOnAction(f -> stage.setScene(menu));
        }
        ;

        layout.getChildren().addAll(b2, b3, b4, menuText, b5, b6, b7, languages, difficulty);
        //audio
        ///////////

        File audioFile = new File("View/src/main/resources/music/music.wav");
        Media audio = new Media(audioFile.toURI().toString());
        MediaPlayer audioPlayer = new MediaPlayer(audio);
        audioPlayer.setCycleCount(20);
        audioPlayer.play();


        menu = new Scene(layout, 400, 400);
        stage.setTitle("Sudoku");

        FadeTransition ft = new FadeTransition(Duration.millis(8000), menuText);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        stage.setScene(menu);
        stage.show();
    }

    boolean Polish() {

        b2.setText(bundlePL.getString("b2"));
        b3.setText(bundlePL.getString("b3"));
        b4.setText(bundlePL.getString("b4"));
        b5.setText(bundlePL.getString("b5"));
        b6.setText(bundlePL.getString("b6"));
        b7.setText(bundlePL.getString("b7"));
        languages.setText(bundlePL.getString("languages"));
        difficulty.setText(bundlePL.getString("difficulty"));

        return IsEnglish = false;

    }

    boolean English() {

        b2.setText(bundleEN.getString("b2"));
        b3.setText(bundleEN.getString("b3"));
        b4.setText(bundleEN.getString("b4"));
        b7.setText(bundleEN.getString("b7"));
        b5.setText(bundleEN.getString("b5"));
        b6.setText(bundleEN.getString("b6"));
        languages.setText(bundleEN.getString("languages"));
        difficulty.setText(bundleEN.getString("difficulty"));

        return IsEnglish = true;

    }

    public static void main(String[] args) {
        launch(args);
    }
}