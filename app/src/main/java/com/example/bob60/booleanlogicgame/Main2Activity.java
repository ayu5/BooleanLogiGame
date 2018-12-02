package com.example.bob60.booleanlogicgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.sql.SQLOutput;
import java.util.Random;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    protected static String getQuestion1() {
        Random rand = new Random();

        String[] questions = new String[] {"1", "2", "Red", "Blue"};
        String[][] answers = new String[][] {
                {"red1", "blue1"},
                {"red2, blue2"},
                {"red1", "red2"},
                {"blue1", "blue2"}};

        int randNum = rand.nextInt(questions.length);
        String question = questions[randNum];
        String[] answer = answers[randNum];

        return question;
    }

    protected static String getQuestion2() {
        Random rand = new Random();

        String[] questions = new String[] {"Blue & 1", "Blue & 2", "Red & 1", "Red & 2"};
        String[][] answers = new String[][] {
                {"blue1"},
                {"blue2"},
                {"red1"},
                {"red2"}};

        int randNum = rand.nextInt(questions.length);
        String question = questions[randNum];
        String[] answer = answers[randNum];

        return question;
    }

    protected static String getQuestion3() {
        Random rand = new Random();

        String[] questions = new String[] {"Blue", "Red", "Yellow", "1", "2", "3"};
        String[][] answers = new String[][] {
                {"blue1", "blue2", "blue3"},
                {"red1", "red2", "red3"},
                {"yellow1", "yellow2", "yellow3"},
                {"blue1", "red1", "yellow1"},
                {"blue2", "red2", "yellow2"},
                {"blue3", "red3", "yellow3"}};

        int randNum = rand.nextInt(questions.length);
        String question = questions[randNum];
        String[] answer = answers[randNum];

        return question;
    }

    protected static String getQuestion4() {
        Random rand = new Random();

        String[] questions = new String[] {
                "Blue & 1", "Blue & 2", "Blue & 3",
                "Red & 1", "Red & 2", "Red & 3",
                "Yellow & 1", "Yellow & 2", "Yellow & 3"};
        String[][] answers = new String[][] {
                {"blue1"}, {"blue2"}, {"blue3"},
                {"red1"}, {"red2"}, {"red3"},
                {"yellow1"}, {"yellow2"}, {"yellow3"}};

        int randNum = rand.nextInt(questions.length);
        String question = questions[randNum];
        String[] answer = answers[randNum];

        return question;
    }

    protected static String getQuestion5() {
        Random rand = new Random();

        String[] questions = new String[] {
                "Blue or 1", "Blue or 2", "Blue or 3",
                "Red or 1", "Red or 2", "Red or 3",
                "Yellow or 1", "Yellow or 2", "Yellow or 3"};
        String[][] answers = new String[][] {
                {"blue1", "blue2", "blue3", "red1", "yellow1"},
                {"blue1", "blue2", "blue3", "red2", "yellow2"},
                {"blue1", "blue2", "blue3", "red3", "yellow3"},
                {"red1", "red2", "red3", "blue1", "yellow1"},
                {"red1", "red2", "red3", "blue2", "yellow2"},
                {"red1", "red2", "red3", "blue3", "yellow3"},
                {"yellow1", "yellow2", "yellow3", "blue1", "red1"},
                {"yellow1", "yellow2", "yellow3", "blue2", "red2"},
                {"yellow1", "yellow2", "yellow3", "blue3", "red3"}};

        int randNum = rand.nextInt(questions.length);
        String question = questions[randNum];
        String[] answer = answers[randNum];

        return question;
    }

    protected static String getQuestion6() {
        Random rand = new Random();

        String[] questions = new String[] {
                "Blue & not 1", "Blue & not 2", "Blue & not 3",
                "Red & not 1", "Red & not 2", "Red & not 3",
                "Yellow & not 1", "Yellow & not 2", "Yellow & not 3"};
        String[][] answers = new String[][] {
                {"blue2", "blue3"},
                {"blue1", "blue3"},
                {"blue1", "blue2"},
                {"red2", "red3"},
                {"red1", "red3"},
                {"red1", "red2"},
                {"yellow2", "yellow3"},
                {"yellow1", "yellow3"},
                {"yellow1", "yellow2"}};

        int randNum = rand.nextInt(questions.length);
        String question = questions[randNum];
        String[] answer = answers[randNum];

        return question;
    }

    protected static String getQuestion7() {
        Random rand = new Random();

        String[] questions = new String[] {
                "not Blue & not 1", "not Blue & not 2", "not Blue & not 3",
                "not Red & not 1", "not Red & not 2", "not Red & not 3",
                "not Yellow & not 1", "not Yellow & not 2", "not Yellow & not 3"};
        String[][] answers = new String[][] {
                {"red2", "red3", "yellow2", "yellow3"},
                {"red1", "red3", "yellow1", "yellow3"},
                {"red1", "red2", "yellow1", "yellow2"},
                {"blue2", "blue3", "yellow2", "yellow3"},
                {"blue1", "blue3", "yellow1", "yellow3"},
                {"blue1", "blue2", "yellow1", "yellow2"},
                {"blue2", "blue3", "red2", "red3"},
                {"blue1", "blue3", "red1", "red3"},
                {"blue1", "blue2", "red1", "red2"}};

        int randNum = rand.nextInt(questions.length);
        String question = questions[randNum];
        String[] answer = answers[randNum];

        return question;
    }

    public static void main(String[] args) {
        System.out.println(getQuestion1());
    }
}
