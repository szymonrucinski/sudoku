package pl.comp.view.gui;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import pl.comp.model.exceptions.DaoException;
import pl.comp.model.logger.FileAndConsoleLoggerFactory;
import pl.comp.model.sudoku.JdbcSudokuBoardDao;
import pl.comp.model.sudoku.SudokuBoard;
import pl.comp.model.sudoku.SudokuBoardDaoFactory;

import java.io.InputStream;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main extends Application {
    final int sceneWidth = 400;
    final int sceneHeight = 400;

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
    Text szymon;

    Boolean IsEnglish;
    Boolean loadedSave = false;


    SudokuBoard LoadGame() {


        SudokuBoard SudokuLoadedFromFile;

        SudokuBoardDaoFactory sudokuBoardDaoFactory = new SudokuBoardDaoFactory();
        try (JdbcSudokuBoardDao dao = (JdbcSudokuBoardDao) sudokuBoardDaoFactory.getDatabaseDao("sudoku")) {
            SudokuLoadedFromFile = dao.read();

            return SudokuLoadedFromFile;

        } catch (DaoException e) {

            logger.log(Level.INFO, DaoException.OPEN_ERROR);
        }

        return new SudokuBoard();

    }


    @Override
    public void start(Stage stage) throws Exception {
        IsEnglish = false;
        Pane layout = new Pane();
        layout.setPrefSize(400, 400);


        try {
            InputStream backgroundStream = getClass().getClassLoader().getResourceAsStream("background.jpg");
            Image img = new Image(backgroundStream);
            ImageView imgView = new ImageView(img);
            imgView.setFitWidth(400);
            imgView.setFitHeight(400);
            layout.getChildren().addAll(imgView);
            GaussianBlur blur = new GaussianBlur(5);
            imgView.setEffect(blur);
        } catch (NullPointerException e) {
            logger.log(Level.INFO, DaoException.ASSET_ERROR);
        }

        InputStream author = getClass().getClassLoader().getResourceAsStream("logo.png");
        Image img = new Image(author);
        ImageView authorView = new ImageView(img);
        authorView.setFitWidth(50);
        authorView.setFitHeight(50);
        authorView.setLayoutX(80);
        authorView.setLayoutY(15);


        layout.getChildren().addAll(authorView);


        AudioClip note = new AudioClip(getClass().getClassLoader().getResource("audio.mp3").toExternalForm());
        note.play();
        note.setCycleCount(AudioClip.INDEFINITE);
        String shanghai = getClass().getClassLoader().getResource("shanghai.ttf").toExternalForm();
        Text menuText = new Text();
        menuText.setText("Sudoku");
        menuText.setFont(Font.loadFont(shanghai, 60));
        menuText.setFill(Color.RED);
        menuText.setX(sceneWidth / 2 - menuText.getLayoutBounds().getWidth() / 2 + 10);
        menuText.setY(60);
        DropShadow dropShadow = new DropShadow();

        menuText.setEffect(dropShadow);
        menuText.setCache(true);


        difficulty = new Text();
        difficulty.setText("Difficulty");
        difficulty.setFont(Font.loadFont(shanghai, 25));
        difficulty.setFill(Color.YELLOW);
        difficulty.setX(sceneWidth / 2 - difficulty.getLayoutBounds().getWidth() / 2);
        difficulty.setY(90);
        DropShadow dropShadow1 = new DropShadow();

        difficulty.setEffect(dropShadow1);
        difficulty.setCache(true);


        languages = new Text();
        languages.setText("Languages");
        languages.setFont(Font.loadFont(shanghai, 25));
        languages.setFill(Color.YELLOW);
        languages.setX(sceneWidth / 2 - languages.getLayoutBounds().getWidth() / 2);
        languages.setY(160);
        DropShadow dropShadow2 = new DropShadow();

        languages.setEffect(dropShadow1);
        languages.setCache(true);


        szymon = new Text();
        szymon.setText("by Szymon Rucinski");
        szymon.setFont(Font.loadFont(shanghai, 25));
        szymon.setFill(Color.YELLOW);
        szymon.setX(sceneWidth / 2 - szymon.getLayoutBounds().getWidth() / 2);
        szymon.setY(350);
        DropShadow dropShadow3 = new DropShadow();

        szymon.setEffect(dropShadow3);
        szymon.setCache(true);


        //Buttons
        b2 = new Button();
        b2.setMinWidth(60);
        b2.setText(bundlePL.getString("b2"));
        b2.setLayoutX(100);
        b2.setLayoutY(100);
        b2.setOnAction(e -> stage.setScene(GamingArena.GamingScene(new SudokuBoard(), 0, stage, menu, IsEnglish)));

        b3 = new Button();
        b3.setMinWidth(60);
        b3.setText(bundlePL.getString("b3"));

        b3.setLayoutX(170);
        b3.setLayoutY(100);
        b3.setOnAction(e -> stage.setScene(GamingArena.GamingScene(new SudokuBoard(), 1, stage, menu, IsEnglish)));

        b4 = new Button();
        b4.setMinWidth(60);
        b4.setText(bundlePL.getString("b4"));

        //language.Polish(b4,"b4");
        b4.setLayoutX(240);
        b4.setLayoutY(100);
        b4.setOnAction(e -> stage.setScene(GamingArena.GamingScene(new SudokuBoard(), 2, stage, menu, IsEnglish)));

        b5 = new Button();
        b5.setMinWidth(60);
        b5.setText(bundlePL.getString("b5"));

        b5.setLayoutX(130);
        b5.setLayoutY(170);
        // b5.setOnAction(e -> language.Polish(b2,"b2"));
        b5.setOnAction(e -> English());


        b6 = new Button();
        b6.setMinWidth(60);
        b6.setText(bundlePL.getString("b6"));
        b6.setLayoutX(200);
        b6.setLayoutY(170);
        b6.setOnAction(e -> Polish());

        b7 = new Button();
        b7.setMinWidth(120);
        b7.setText("LoadGame");
        b7.setLayoutX(sceneWidth / 2 - 65);
        b7.setLayoutY(230);
        if (loadedSave == false) {
            b7.setText("Run Saved Game");
            LoadGame();
        }
        b7.setOnAction(e -> stage.setScene(GamingArena.GamingScene(LoadGame(), 4, stage, menu, IsEnglish)));


        {
            Button back = new Button("Back");
            back.setOnAction(f -> stage.setScene(menu));
        }

        layout.getChildren().addAll(b2, b3, b4, menuText, b5, b6, b7, languages, difficulty, szymon);

        menu = new Scene(layout, 400, 400);

        stage.setTitle("Sudoku");

        FadeTransition ft = new FadeTransition(Duration.millis(5000), menuText);
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
        languages.setX(sceneWidth / 2 - languages.getLayoutBounds().getWidth() / 2);
        difficulty.setX(sceneWidth / 2 - languages.getLayoutBounds().getWidth() / 2);


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
        languages.setX(sceneWidth / 2 - languages.getLayoutBounds().getWidth() / 2 - 10);
        difficulty.setX(sceneWidth / 2 - languages.getLayoutBounds().getWidth() / 2 - 10);


        return IsEnglish = true;

    }

    public static void main(String[] args) {
        launch(args);
    }
}