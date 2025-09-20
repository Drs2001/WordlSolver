package com.DylanSpence.wordlhax;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class HaxController {

    int totalChecked = 0;

    @FXML
    TextField invalidField;

    @FXML
    TextField field1;

    @FXML
    TextField field2;

    @FXML
    TextField field3;

    @FXML
    TextField field4;

    @FXML
    TextField field5;

    @FXML
    CheckBox check1;

    @FXML
    CheckBox check2;

    @FXML
    CheckBox check3;

    @FXML
    CheckBox check4;

    @FXML
    CheckBox check5;

    @FXML
    VBox allWords;

    @FXML
    public void getWords()
    {
        allWords.getChildren().clear();
        checkedBoxes();
        try {
            File file = new File("src/main/java/com/DylanSpence/wordlhax/5letter.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine() && isFieldsEmpty())
            {
                String word = reader.nextLine();
                if(checkWordAnyPos(word) && checkWordExact(word) && checkInvalidLetters(word)) {
                    Button b = new Button();
                    b.setText(word);
                    allWords.getChildren().add(b);
                }
            }

        }
        catch(FileNotFoundException e) {
            System.out.println("Error");
        }
    }

    @FXML
    public void reset()
    {
        invalidField.setText("");
        field1.setText("");
        field2.setText("");
        field3.setText("");
        field4.setText("");
        field5.setText("");
        check1.setSelected(false);
        check2.setSelected(false);
        check3.setSelected(false);
        check4.setSelected(false);
        check5.setSelected(false);
        allWords.getChildren().clear();
    }

    public Boolean checkWordAnyPos(String word)
    {
        if(word.contains(field1.getText()) && word.contains(field2.getText())
                && word.contains(field3.getText()) && word.contains(field4.getText()) && word.contains(field5.getText()))
        {
            return true;
        }
        return false;
    }

    public Boolean checkWordExact(String word)
    {
        int count = 0;
        if(check1.isSelected())
        {
            if(word.charAt(0) == field1.getText().charAt(0))
            {
                count++;
            }
        }
        if(check2.isSelected())
        {
            if(word.charAt(1) == field2.getText().charAt(0))
            {
                count++;
            }
        }
        if(check3.isSelected())
        {
            if(word.charAt(2) == field3.getText().charAt(0))
            {
                count++;
            }
        }
        if(check4.isSelected())
        {
            if(word.charAt(3) == field4.getText().charAt(0))
            {
                count++;
            }
        }
        if(check5.isSelected())
        {
            if(word.charAt(4) == field5.getText().charAt(0))
            {
                count++;
            }
        }
        if(count == totalChecked) {
            return true;
        }
        return false;
    }

    public Boolean checkInvalidLetters(String word)
    {
        String invalidLetters = invalidField.getText();

        if(invalidLetters.length() != 0) {
            for (int i = 0; i < invalidLetters.length(); i++) {
                for (int j = 0; j < word.length(); j++) {
                    if (word.charAt(j) == invalidLetters.charAt(i)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void checkedBoxes()
    {
        int count  = 0;
        if(check1.isSelected())
        {
            count++;
        }
        if(check2.isSelected())
        {
            count++;
        }
        if(check3.isSelected())
        {
            count++;
        }
        if(check4.isSelected())
        {
            count++;
        }
        if(check5.isSelected())
        {
            count++;
        }
        this.totalChecked = count;
    }

    public Boolean isFieldsEmpty()
    {
        int count = 0;
        if(field1.getText().equals(""))
        {
            count++;
        }
        if(field2.getText().equals(""))
        {
            count++;
        }
        if(field3.getText().equals(""))
        {
            count++;
        }
        if(field4.getText().equals(""))
        {
            count++;
        }
        if(field5.getText().equals(""))
        {
            count++;
        }

        if(count != 5)
        {
            return true;
        }

        return false;
    }
}