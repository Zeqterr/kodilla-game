package com.kodilla.model;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.util.Duration;

public class rpgameSubScene extends SubScene {
    public final static String FONT_PATH = "src/main/java/com/kodilla/model/resources/kenvector_future.ttf";
    private boolean isHidden = true;
    public rpgameSubScene() {
        super(new AnchorPane(), 600, 400);
        prefWidth(600);
        prefHeight(400);
        Image backgroundImage = new Image("file:src/main/java/com/kodilla/model/resources/yellow_panel.png", 600, 400, false, true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        AnchorPane root2 = (AnchorPane) this.getRoot();
        root2.setBackground(new Background(background));
        setLayoutX(1024);
        setLayoutY(180);
    }
    public void moveSubScene() {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(0.5));
        transition.setNode(this);
        if(isHidden) {
            transition.setToX(-676);
            isHidden = false;
        } else {
            transition.setToX(0);
            isHidden = true;
        }
        transition.play();
    }
    public AnchorPane getPane() {
        return (AnchorPane) this.getRoot();
    }
}