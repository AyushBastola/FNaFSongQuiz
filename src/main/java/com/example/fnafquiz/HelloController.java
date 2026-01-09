package com.example.fnafquiz;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class HelloController {
    @FXML
    private Label category;
    @FXML
    private Label song;
    @FXML
    private Label lyrics;
    @FXML
    private Label question2;
    @FXML
    private ChoiceBox choices;
    @FXML
    private Button nextQuestion;
    @FXML
    private int questionNum;
    @FXML
    private String[] lyricList = {
            "We're waiting every night\nTo finally roam and invite\nNewcomers to play with us\nFor many years we've been all alone", // FNaF 1 Song by The Living Tombstone
            "Is this revenge I am seeking, or seeking someone to avenge me?\nStuck in my own paradox, I wanna set myself free\nMaybe I should chase and find before they'll try to stop it\nIt won't be long before I'll become a puppet", // It's Been So Long by The Living Tombstone
            "Let's try to make it right, don't wanna start a fight.\n" +
                    "And we're so sorry if we give you all a little fright.\n" +
                    "We're not so scary if you see us in the daylight.\n" +
                    "You'll be so happy just as long as you survive the night", // Survive the Night by MandoPony
            "I really hate you\nStop getting in my way\nI've lost my patience\nWhen are you gonna decay?", // Die In a Fire by The Living Tombstone
            "So my flashlight's on, and stay up 'til dawn\nI got this headache and my life's on the line\nI felt like I won, but I wasn't done\nThe nightmare repeats itself every time", // I Got No Time by The Living Tombstone
            "Can't wait to meet you\nSo join the animatronic family\nWe open real soon\nTry your best to hold onto sanity", // Join Us for a Bite by JT Music
            "I've been trying for so long to sing you the right song\n" +
                    "To show you something different every day\n" +
                    "So you hear what I have to say like puzzle pieces\n" +
                    "And now we're here at a standstill\n" +
                    "I wonder if you feel the kind of pain that rips your insides out\n" +
                    "That's something I know all about\n" +
                    "Shocking, ain't it?" // I Can't Fix You by The Living Tombstone
    };
    private String[] answerList = {
            "Five Nights at Freddy's 1 Song", // 0
            "It's Been So Long", // 1
            "Die In a Fire", // 2
            "I Got No Time", // 3
            "Join Us for a Bite", // 4
            "I Can't Fix You" // 5
    };
    private String[] songList = {
            "src/main/resources/fnaf1song.mp3",
            "src/main/resources/itsbeensolong.mp3",
            "src/main/resources/dieinafire.mp3",
            "src/main/resources/igotnotime.mp3",
            "src/main/resources/joinusforabite.mp3",
            "src/main/resources/icantfixyou.mp3"
    };
    @FXML
    int randomLyrics = (int) (Math.random() * lyricList.length); // Chooses randomly from the lyrics list
    @FXML
    protected void onSubmitButtonClick() {
        choices.setDisable(true);
        nextQuestion.setDisable(false);
        if (choices.getValue() == null) {
            question2.setText("Hey! Don't forget to make a choice before submitting.");
            choices.setDisable(false);
            nextQuestion.setDisable(true);
        } else if (choices.getValue().equals(answerList[randomLyrics])) { // The elements in both answerList and lyricList have to be in order. Ex: 0 is FNaF 1 song in lyricList, so it has to be in the same place.
            question2.setText("You got that right! Click on the button below the submit one for a new question.");
        } else {
            question2.setText("You didn't get it. Click on the button below the submit one for a new question.");
        }
    }
    @FXML
    private MediaPlayer mediaPlayer;
    @FXML
    protected void onQuestionButtonClick() {
        choices.setDisable(false);
        nextQuestion.setDisable(true);
        question2.setText("What song does this come from?");
        questionNum += 1;
        song.setText("Song " + questionNum); // Song number gets updated
        randomLyrics = (int) (Math.random() * lyricList.length); // Chooses randomly from the lyrics list
        lyrics.setText(lyricList[randomLyrics]); // Sets the lyric text to those lyrics
        String randomSong = songList[randomLyrics];
        Media sound = new Media(new File(randomSong).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        if (randomLyrics == 0) { // If the first lyrics are chosen, choose the category and choices.
            category.setText("Game: Five Nights at Freddy's");
            choices.getItems().clear();
            choices.getItems().addAll("Join Us for a Bite", "Die In a Fire", "I Got No Time", "Five Nights at Freddy's 1 Song");
        } else if (randomLyrics == 1) {
            category.setText("Game: Five Nights at Freddy's 2");
            choices.getItems().clear();
            choices.getItems().addAll("It's Been So Long", "Five Nights at Freddy's 1 Song", "I Got No Time", "Join Us for a Bite");
        } else if (randomLyrics == 2) {
            category.setText("Game: Five Nights at Freddy's 3");
            choices.getItems().clear();
            choices.getItems().addAll("Join Us for a Bite", "It's Been So Long", "Die In a Fire", "I Got No Time");
        } else if (randomLyrics == 3) {
            category.setText("Game: Five Nights at Freddy's 4");
            choices.getItems().clear();
            choices.getItems().addAll("I Got No Time", "Five Nights at Freddy's 1 Song", "Join Us for a Bite", "Die In a Fire");
        } else if (randomLyrics == 4 || randomLyrics == 5) {
            category.setText("Game: Five Nights at Freddy's: Sister Location");
            choices.getItems().clear();
            choices.getItems().addAll("Die In a Fire", "Join Us for a Bite", "It's Been So Long", "I Got No Time");
        }
    }
}
