package javafxexamples;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MessengerInterface extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Интерфейс мессенджера");

        Parent ui = createInterface();
        ui.prefHeight(primaryStage.getHeight());

        primaryStage.setScene(new Scene(ui, 800, 600));
        primaryStage.show();
    }

    private Parent createInterface() {
        HBox ui = new HBox();

        HBox.setHgrow(ui, Priority.ALWAYS);
        ui.setPrefHeight(600);
//        ui.setFillHeight(true);

        // Chat
        VBox chat = new VBox();
        chat.prefHeightProperty().bind(ui.heightProperty());

        TextArea showText = new TextArea();
        showText.setEditable(false);

        TextField enterText = new TextField();
        Platform.runLater(enterText::requestFocus);
        enterText.promptTextProperty().setValue("Введите сообщение...");

        Button sendButton = new Button("Отправить");
        sendButton.setMinSize(100, 30);
        sendButton.setMaxSize(100, 30);

        sendButton.setOnAction(event -> sendMessage(enterText, showText));

        enterText.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER)
                sendMessage(enterText, showText);
        });

        HBox yourMessage = new HBox(enterText, sendButton);
        enterText.prefWidthProperty().bind(yourMessage.widthProperty());
        enterText.prefHeightProperty().bind(yourMessage.heightProperty());

        chat.getChildren().addAll(
                showText,
                yourMessage
        );

        // Contacts
        VBox contacts = new VBox();
        contacts.prefHeightProperty().bind(ui.heightProperty());
        VBox.setVgrow(contacts, Priority.NEVER);
        contacts.setAlignment(Pos.TOP_CENTER);
//        contacts.setFillWidth(true);

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

    private void sendMessage(TextField enterText, TextArea showText) {
        String textFromUser = enterText.getText().strip();
        if (textFromUser.length() > 0) {
            if (showText.getText().length() > 0)
                showText.setText(showText.getText() + "\n" + textFromUser);
            else
                showText.setText(textFromUser);
        }
        enterText.clear();
    }
}
