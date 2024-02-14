package com.example.magicsquare;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Arrays;


public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox vBox0 = new VBox();
        vBox0.setPrefHeight(400.0);
        vBox0.setPrefWidth(807.0);
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefHeight(434.0);
        anchorPane.setMaxHeight(-1.0);
        anchorPane.setPrefWidth(679.0);
        anchorPane.setMaxWidth(-1.0);
        TextField[][] num = new TextField[3][3];
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num.length; j++) {
                TextField textField = new TextField();
                num[i][j] = textField;
                anchorPane.getChildren().add(num[i][j]);
                num[i][j].setPrefHeight(52.0);
                num[i][j].setPrefWidth(92.0);
                num[i][j].setAlignment(Pos.CENTER);
                num[i][j].setStyle("-fx-background-color: silver");
                num[i][j].setFont(new Font("Elephant", 20));

            }
        }


        num[0][0].setLayoutX(96.0);
        num[0][0].setLayoutY(174.0);

        num[0][1].setLayoutX(96);
        num[0][1].setLayoutY(252);

        num[0][2].setLayoutX(96);
        num[0][2].setLayoutY(334);

        num[1][0].setLayoutX(241.0);
        num[1][0].setLayoutY(174);

        num[1][1].setLayoutX(241);
        num[1][1].setLayoutY(252);

        num[1][2].setLayoutX(241);
        num[1][2].setLayoutY(334);


        num[2][0].setLayoutX(380.0);
        num[2][0].setLayoutY(174);


        num[2][1].setLayoutX(380);
        num[2][1].setLayoutY(252);

        num[2][2].setLayoutX(380.0);
        num[2][2].setLayoutY(334.0);

        Label result = new Label();
        result.setPrefHeight(150);
        result.setPrefWidth(700);
        result.setLayoutX(179);
        result.setLayoutY(420);
        result.setFont(Font.font("Cambria Math", FontWeight.EXTRA_BOLD, 28));
        anchorPane.getChildren().add(result);


        Label titleLabel = new Label();
        titleLabel.setAlignment(Pos.CENTER_RIGHT);
        titleLabel.setPrefHeight(121.0);
        titleLabel.setPrefWidth(588.0);
        String titleText = "THE MAGIC SQUARE!";
        titleLabel.setFont(Font.font("Showcard Gothic", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 42));
        titleLabel.setTextFill(Color.BROWN);


        //Typing Animation of the title of the program
        final IntegerProperty i = new SimpleIntegerProperty(0);
        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(
                Duration.seconds(0.35),
                event -> {

                    if (i.get() > titleText.length()) {
                        timeline.pause();
                        timeline.setAutoReverse(true);
                    } else {
                        titleLabel.setText(titleText.substring(0, i.get()));
                        i.set(i.get() + 1);
                    }
                });
        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();


        ImageView checkImage = new ImageView("https://cdn3.iconfinder.com/data/icons/cursor/100/fb_Cursor_25-512.png");
        checkImage.setFitWidth(80);
        checkImage.setFitHeight(80);
        Button check = new Button("Check", checkImage);
        anchorPane.getChildren().add(titleLabel);
        check.setPrefHeight(110);
        check.setPrefWidth(300);
        check.setLayoutX(534.0);
        check.setLayoutY(170);
        check.setFont(Font.font("broadway", FontWeight.EXTRA_BOLD, 35));
        check.setTextFill(Color.BLUE);
        check.setMnemonicParsing(false);

        ImageView resetImage = new ImageView("https://i.pinimg.com/originals/86/16/9a/86169a7c0ea169c3aa1f5e8bf9555220.png");
        resetImage.setFitWidth(80);
        resetImage.setFitHeight(80);
        Button resetButton = new Button("Reset", resetImage);
        resetButton.setPrefHeight(110);
        resetButton.setPrefWidth(300);
        resetButton.setLayoutX(534.0);
        resetButton.setLayoutY(305);
        resetButton.setFont(Font.font("STENCIL", FontWeight.EXTRA_BOLD, 35));
        resetButton.setTextFill(Color.ORANGE);
        resetButton.setMnemonicParsing(false);

        /* Adding buttons to parent */
        anchorPane.getChildren().add(resetButton);
        anchorPane.getChildren().add(check);
        /* Shifting focus between TextFields */
        num[0][0].setOnKeyPressed(evt -> {
            if (evt.getCode() == KeyCode.ENTER) {
                num[1][0].requestFocus();
            }
        });
        num[1][0].setOnKeyPressed(evt -> {
            if (evt.getCode() == KeyCode.ENTER) {
                num[2][0].requestFocus();
            }
        });
        num[2][0].setOnKeyPressed(evt -> {
            if (evt.getCode() == KeyCode.ENTER) {
                num[0][1].requestFocus();
            }
        });
        num[0][1].setOnKeyPressed(evt -> {
            if (evt.getCode() == KeyCode.ENTER) {
                num[1][1].requestFocus();
            }
        });
        num[1][1].setOnKeyPressed(evt -> {
            if (evt.getCode() == KeyCode.ENTER) {
                num[2][1].requestFocus();
            }
        });
        num[2][1].setOnKeyPressed(evt -> {
            if (evt.getCode() == KeyCode.ENTER) {
                num[0][2].requestFocus();
            }
        });
        num[0][2].setOnKeyPressed(evt -> {
            if (evt.getCode() == KeyCode.ENTER) {
                num[1][2].requestFocus();
            }
        });
        num[1][2].setOnKeyPressed(evt -> {
            if (evt.getCode() == KeyCode.ENTER) {
                num[2][2].requestFocus();
            }
        });
        num[2][2].setOnKeyPressed(evt -> {
            if (evt.getCode() == KeyCode.ENTER && num[0][0].getText() != null) {
                check.requestFocus();

            }
        });
        /* Check Button Functions */
        check.setOnAction(e -> {
            // TRY-CATCH BLOCK FOR THE NUMBER FORMAT EXCEPTION
            try {
                if (Validity(toIntArray(num))) // Check if the input is integers between 1-9 with no repetition
                    /* Check whether it's a magic square or not */
                    if (IsMagicSquare(toIntArray(num))) {
                        result.setText("It's a Magic Square");
                        result.setTextFill(Color.DARKGREEN);
                        ImageView congratsIMG = new ImageView("https://b.thumbs.redditmedia.com/JZBkPBHomeNFaCXxeUuRU80HL2H_U83PEzASXmAW-9Y.png");
                        congratsIMG.setFitWidth(100);
                        congratsIMG.setFitHeight(100);
                        result.setGraphic(congratsIMG);
                        result.setContentDisplay(ContentDisplay.BOTTOM);
                        result.setLayoutX(179);
                        check.setTextFill(Color.GREEN);
                        resetButton.setTextFill(Color.GREEN);
                        titleLabel.setTextFill(Color.GREEN);
                        resetButton.requestFocus();


                    } else {
                        result.setText("It's NOT a Magic Square");
                        result.setTextFill(Color.RED);
                        ImageView sadEmojiIMG = new ImageView("https://cdn.shopify.com/s/files/1/1061/1924/products/Sad_Face_Emoji_large.png?v=1571606037");
                        sadEmojiIMG.setFitWidth(55);
                        sadEmojiIMG.setFitHeight(55);
                        result.setGraphic(sadEmojiIMG);
                        result.setContentDisplay(ContentDisplay.BOTTOM);
                        result.setLayoutX(150);
                        check.setTextFill(Color.RED);
                        resetButton.setTextFill(Color.RED);
                        titleLabel.setTextFill(Color.RED);
                        resetButton.requestFocus();
                        for (TextField[] textFields : num) {
                            for (int j = 0; j < num.length; j++) {
                                textFields[j].setText(null);
                            }
                        }


                    }

                else {
                    result.setText("Invalid integer, elements must be between 1 and 9 and not repeated");
                    result.setTextFill(Color.RED);
                    check.setTextFill(Color.RED);
                    ImageView sadEmojiIMG = new ImageView("https://cdn.shopify.com/s/files/1/1061/1924/products/Sad_Face_Emoji_large.png?v=1571606037");
                    sadEmojiIMG.setFitWidth(55);
                    sadEmojiIMG.setFitHeight(55);
                    result.setGraphic(sadEmojiIMG);
                    result.setContentDisplay(ContentDisplay.BOTTOM);
                    result.setLayoutX(28);
                    result.setWrapText(true);
                    titleLabel.setTextFill(Color.RED);
                    resetButton.setTextFill(Color.RED);
                    resetButton.requestFocus();
                    for (TextField[] textFields : num) {
                        for (int j = 0; j < num.length; j++) {
                            textFields[j].setText(null);
                        }
                    }


                }
            } catch (NumberFormatException ex) {  //NUMBER FORMAT EXCEPTION HERE IS USED WHEN THE INPUT CONTAINS SPACES OR NON-INTEGER VALUES
                result.setText("All fields should be filled with Integers only");
                result.setTextFill(Color.RED);
                check.setTextFill(Color.RED);
                ImageView sadEmojiIMG = new ImageView("https://cdn.shopify.com/s/files/1/1061/1924/products/Sad_Face_Emoji_large.png?v=1571606037");
                sadEmojiIMG.setFitWidth(55);
                sadEmojiIMG.setFitHeight(55);
                result.setGraphic(sadEmojiIMG);
                result.setContentDisplay(ContentDisplay.BOTTOM);
                result.setLayoutX(36);
                titleLabel.setTextFill(Color.RED);
                resetButton.setTextFill(Color.RED);
                resetButton.requestFocus();
                for (TextField[] textFields : num) {
                    for (int j = 0; j < num.length; j++) {
                        textFields[j].setText(null);
                    }
                }


            }
        });
        resetButton.setOnAction(e -> {   //RESET BUTTON THAT CLEAN ALL FIELDS TO PLAY AGAIN
            for (TextField[] textFields : num) {
                for (int j = 0; j < num.length; j++) {
                    textFields[j].setText(null);
                    resetButton.setTextFill(Color.ORANGE);
                    check.setTextFill(Color.BLUE);
                    titleLabel.setTextFill(Color.BROWN);
                    result.setText(null);
                    result.setGraphic(null);
                    num[0][0].requestFocus();
                }
            }
        });
        GridPane.setHalignment(check, HPos.CENTER);
        anchorPane.setStyle("-fx-background-color: LIGHTSKYBLUE "); //BACKGROUND COLOR
        Scene scene = new Scene(anchorPane, 850, 600);
        scene.setFill(Color.LIGHTSKYBLUE);
        primaryStage.setScene(scene);
        primaryStage.setTitle("3x3 Magic Square Checker");
        primaryStage.show();
    }




    // This method take the TextFields array and convert it to an INTEGER Array if possible then return the new Integer Array
    public static int[][] toIntArray(TextField[][] array) {
        int[][] intArray = new int[3][3];
        int length = intArray.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                intArray[i][j] = Integer.parseInt(array[i][j].getText());

            }
        }
        return intArray;
    }

    // This method check the repetition and make sure that the range of the integers is between 1- 9
    public static boolean Validity(int[][] arrayCheck) {
        int length = arrayCheck.length;
        for (int[] ints : arrayCheck) {
            Arrays.sort(ints);
            for (int j = 1; j < length; j++) {
                if (ints[j] < 1 || ints[j] > 9 || ints[j] == ints[j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    // This method check if the given integer array is a magic square or not and return the result (true or false)
    static boolean IsMagicSquare(int[][] intArray) {
        int length = intArray.length;
        int diagonalSum = 0, diagonalSum2 = 0;
        for (int i = 0; i < length; i++) {
            diagonalSum += intArray[i][i];
            diagonalSum2 += intArray[i][length - 1 - i];
        }
        if (diagonalSum != diagonalSum2) {
            return false;
        } else {
            for (int i = 0; i < length; i++) {
                int sumOfCol = 0;
                int sumOfRow = 0;
                for (int j = 0; j < length; j++) {
                    sumOfCol += intArray[j][i];
                    sumOfRow += intArray[i][j];
                }
                if (sumOfCol != sumOfRow || sumOfCol != diagonalSum || sumOfRow != 15) {
                    return false;
                }
            }
        }
        return true;
    }
}