package com.example.learnCyrillicGame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class HelloApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 500);
        stage.setTitle("Пример б, в, г, ґ, д, ж, з, к, л, м, н, п, р, с, т, ф, х, ц, ч, ш, щ Hello!");



        HelloController controller = fxmlLoader.getController();
        scene.setOnKeyPressed(e -> controller.setOnKeyPressed(e));
        scene.setOnKeyReleased(e -> controller.setOnKeyReleased(e));



        // background javafx key event
        //Creating an image


        FileInputStream fis = new FileInputStream("/Users/louisfrochaux/IdeaProjects/demo/src/grass.jpg");
        Image image = new Image(fis, 250, 300, false, false);

        //Setting the image view
        ImageView imageView = new ImageView(image);

        //Setting the position of the image
        imageView.setX(50);
        imageView.setY(25);

        //Creating a Group object
        Group root = new Group(imageView);

        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}