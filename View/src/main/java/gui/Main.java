package gui;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
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
import pl.comprog.BackTrackingSudokuSolver;
import pl.comprog.FileSudokuBoardDao;
import pl.comprog.SudokuBoard;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import javafx.scene.effect.DropShadow;
//--module-path ${PATH_TO_FX} --add-modules=javafx.controls,javafx.fxml,javafx.media


public class Main extends Application
{

    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/gui/UI.fxml"));
    ResourceBundle bundlePL = ResourceBundle.getBundle("gui.LanguagePack");
    ResourceBundle bundleEN = ResourceBundle.getBundle("gui.LanguagePackEN");
    private static Scene menu;
    SudokuBoard board = new SudokuBoard();
    Button b2 ;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;

    Boolean loadedSave =false;

    SudokuBoard Random = new SudokuBoard();


    // LangController language = new LangController();


    void Polish() {

        System.out.println("Polski");
        b2.setText(bundlePL.getString("b2"));
        System.out.println(bundlePL.getString("b2"));
        b3.setText(bundlePL.getString("b3"));
        b4.setText(bundlePL.getString("b4"));

    }

    void English() {

        System.out.println("English");
        b2.setText(bundleEN.getString("b2"));
        b3.setText(bundleEN.getString("b3"));
        b4.setText(bundleEN.getString("b4"));

    }


     SudokuBoard LoadGame(){
        FileSudokuBoardDao fileSudokuBoardDao = new FileSudokuBoardDao("save.dat");
         SudokuBoard sudokuBoard1 = new SudokuBoard();
         BackTrackingSudokuSolver solver = new BackTrackingSudokuSolver();
         sudokuBoard1 = fileSudokuBoardDao.read();
            System.out.println("SAVED FILE");
         sudokuBoard1.display();
         return sudokuBoard1;
    }

    SudokuBoard startLoaded(SudokuBoard board){
        loadedSave=true;
        board=LoadGame();
        System.out.println("Successfully loaded DATA");
        return board;

    }




    @Override
    public void start(Stage stage) throws Exception
    {
        //MENU DESIGN//
        boolean IsEnglish= true;
        Pane layout = new Pane();
        layout.setPrefSize(400,400);

        InputStream background = Files.newInputStream(Paths.get("View/src/res/images/background.jpg"));
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
        menuText.setFont(Font.font("shanghai", FontWeight.BOLD, FontPosture.REGULAR, 50));
        menuText.setFill(Color.RED);
        menuText.setX(80);
        menuText.setY(50);
        DropShadow dropShadow = new DropShadow();

        menuText.setEffect(dropShadow);
        menuText.setCache(true);

        //Buttons
        b2 = new Button();
        //language.Polish(b2,"b2");
        b2.setText(bundlePL.getString("b2"));
        b2.setLayoutX(40);
        b2.setLayoutY(100);
        b2.setOnAction(e -> stage.setScene(GamingArena.GamingScene( Random,0,stage,menu)));  //Lambda Expression (e = events, code after '->' operator)

        b3 = new Button();
        //language.Polish(b3,"b3");
        b3.setText(bundlePL.getString("b3"));

        b3.setLayoutX(100);
        b3.setLayoutY(100);
        b3.setOnAction(e -> stage.setScene(GamingArena.GamingScene(Random,1,stage,menu)));

        b4 = new Button();
        b4.setText(bundlePL.getString("b4"));

        //language.Polish(b4,"b4");
        b4.setLayoutX(180);
        b4.setLayoutY(100);
        b4.setOnAction(e -> stage.setScene(GamingArena.GamingScene(Random,2,stage,menu)));

        b5 = new Button();
        //language.Polish(b5,"b5");
        b5.setText(bundlePL.getString("b5"));

        b5.setLayoutX(180);
        b5.setLayoutY(200);
       // b5.setOnAction(e -> language.Polish(b2,"b2"));
        b5.setOnAction(e ->Polish());


        b6 = new Button();
        //language.Polish(b6,"b6");
        b6.setText(bundlePL.getString("b6"));
        b6.setLayoutX(180);
        b6.setLayoutY(150);
       // b6.setOnAction(e -> language.English(b2,"b2"));
        b6.setOnAction(e ->English());

        b7 = new Button();
        b7.setText("LoadGame");
        b7.setLayoutX(180);
        b7.setLayoutY(220);
        if(loadedSave==false) {b7.setText("Run Saved Game");board=startLoaded(board);System.out.println("tEST1");board.display();System.out.println("tEST2");}
        b7.setOnAction(e ->stage.setScene(GamingArena.GamingScene(board, 4,stage,menu)));



/*
        b8 = new Button();
        b8.setText("RunSavedGame");
        b8.setLayoutX(180);
        b8.setLayoutY(220);
        b8.setOnAction(e ->startLoaded());
        if(loadedSave==true)stage.setScene(GamingArena.GamingScene( board,4));

*/



        {
            Button back = new Button("Back");
            back.setOnAction(f -> stage.setScene(menu));
        };

        layout.getChildren().addAll(b2, b3, b4,menuText,b5,b6,b7);
        //audio
        ///////////
        File audioFile = new File("View/src/res/music/music.wav");
        Media audio = new Media(audioFile.toURI().toString());
        MediaPlayer audioPlayer = new MediaPlayer(audio);


        menu = new Scene(layout, 400, 400);
        stage.setTitle("Sudoku");
        //audioPlayer.setAutoPlay(true);
        audioPlayer.play();

        FadeTransition ft = new FadeTransition(Duration.millis(8000), menuText);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        stage.setScene(menu);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}