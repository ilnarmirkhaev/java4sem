package javafxexamples;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MessengerInterface extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Интерфейс мессенджера");

        Parent ui = createInterface();

        primaryStage.setScene(new Scene(ui, 800, 600));
        primaryStage.show();
    }

    private Parent createInterface() {
        HBox ui = new HBox();
        ui.setPrefHeight(600);
        ui.setFillHeight(true);

        // Chat
        VBox chat = new VBox();

        Text text = new Text("Ну привет");

        TextField textArea = new TextField();
        textArea.promptTextProperty().setValue("Введите сообщение...");
        Button sendButton = new Button("Отправить");
        sendButton.setOnAction(event -> {
            String textFromUser = textArea.getText();
            text.setText(textFromUser);
            textArea.clear();
        });

        HBox yourMessage = new HBox(textArea, sendButton);

        chat.getChildren().addAll(
                text,
                yourMessage
        );

        // Contacts
        VBox contacts = new VBox();
        contacts.setAlignment(Pos.TOP_CENTER);
        contacts.setFillWidth(true);

        Label contactsLabel = new Label("Контакты");

        ObservableList<String> myContactsList = FXCollections.observableArrayList(
                "Петя Иванов", "Ваня Сидоров", "Мама ♥"
        );
        ListView<String> contactsList = new ListView<>(myContactsList);

        contacts.getChildren().addAll(
                contactsLabel,
                contactsList
        );

        // Add all to UI
        ui.getChildren().addAll(
                chat,
                contacts
        );

        return ui;
    }
}
