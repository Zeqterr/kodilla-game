package com.kodilla;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class rpgame extends Application {
    private Image imageback = new Image("file:src/main/resources/Battleground1.png");
    private final Image playableMage = new Image("file:resources/playablecharacters/pcmage.png");
    private final FlowPane player1 = new FlowPane(Orientation.HORIZONTAL);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        grid.setHgap(5.5);
        grid.setVgap(5.5);
        grid.setBackground(background);

        ImageView img = new ImageView(playableMage);
        img.setFitWidth(100);
        img.setFitHeight(100);
//        player1.getChildren().add(img);
        grid.add(img, 0, 0, 3, 1);

        Scene scene = new Scene(grid, 1600, 900, Color.BLACK);

        primaryStage.setTitle("RPGcodilla");
        primaryStage.setScene(scene);
        primaryStage.show();

        /*
        Button goToLeft = new Button();
        goToLeft.setText("Left");
        goToLeft.setOnAction((e) -> {
            goToLeft();
        });


        goToLeft();
    }
         */

    }
}