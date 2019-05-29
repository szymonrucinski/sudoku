package gui;

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
import pl.comprog.SudokuBoard;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.scene.effect.DropShadow;
//--module-path ${PATH_TO_FX} --add-modules=javafx.controls,javafx.fxml,javafx.media


public class Main extends Application
{
    private static Scene menu;


    @Override
    public void start(Stage stage) throws Exception
    {

        SudokuBoard board = new SudokuBoard();
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

        //Difficulty Level

        Button b2 = new Button("Easy");
        b2.setLayoutX(40);
        b2.setLayoutY(100);
        b2.setOnAction(e -> stage.setScene(GamingArena.GamingScene(0)));  //Lambda Expression (e = events, code after '->' operator)

        Button b3 = new Button("Medium");
        b3.setLayoutX(100);
        b3.setLayoutY(100);
        b3.setOnAction(e -> stage.setScene(GamingArena.GamingScene(1)));

        Button b4 = new Button("Hard");
        b4.setLayoutX(180);
        b4.setLayoutY(100);
        //b4.setOnAction(e -> stage.setScene(GamingArena.GamingScene(2)));

        Button b5 = new Button("Polish");
        b5.setLayoutX(180);
        b5.setLayoutY(150);
        //b5.setOnAction(e -> );

        Button b6 = new Button("English");
        b6.setLayoutX(180);
        b6.setLayoutY(150);
        //b5.setOnAction(e -> );


        {
            //stage.setScene(Hard.hardScene());
            Button back = new Button("Back");
            back.setOnAction(f -> stage.setScene(menu));
            //Add button to the hardScene
        };

        layout.getChildren().addAll(b2, b3, b4,menuText,b5,b6);
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