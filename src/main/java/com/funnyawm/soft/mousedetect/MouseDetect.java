package com.funnyawm.soft.mousedetect;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.net.URL;

public class MouseDetect extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        URL file = MouseDetect.class.getResource("bgm.mp3");
        assert file != null;
        Media media = new Media(file.toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        primaryStage.setOnCloseRequest(e -> mediaPlayer.stop());
        mediaPlayer.setVolume(0.5);
        mediaPlayer.play();
        Button button = new Button("点击检测鼠标左键是否正常");
        button.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(null);
                alert.setHeaderText("喜报！");
                alert.setContentText("你的鼠标左键没有问题！");
                alert.showAndWait();
                primaryStage.close();
            }
        });
        StackPane root = new StackPane();
        root.getChildren().add(button);
        Scene scene = new Scene(root, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}