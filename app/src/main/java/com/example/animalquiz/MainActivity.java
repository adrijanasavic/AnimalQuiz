package com.example.animalquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    String[] questions;
    int[][] answers;
    int queue[] = new int[6];
    int numberofquestioncomplete = 0;
    int anscnt = 0;
    int correct_ans_count;
    int correct_answer[] = new int[10];

    private int[] random_number_generator() {
        int question_list[] = new int[6];
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add( new Integer( i ) );
        }
        Collections.shuffle( list );
        for (int i = 0; i < 6; i++) {
            question_list[i] = list.get( i );
        }

        return question_list;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        questions = new String[]{
                "The strongest animal on the planet is?",
                "Is the biggest animal on the planet?",
                "The fastest animal is?",
                "Which animal lays the largest egg?",
                "Which of these birds moves south in the fall?",
                "Which of these animals is the highest?",
                "Which of the following animals is active at night?",
                "Which animal lives underground?",
                "Which animal carries a back house?",
                "Which animal has the pups of the rock?"};

        answers = new int[][]{
                {R.drawable.bear, R.drawable.elephant, R.drawable.lion, R.drawable.manky},
                {R.drawable.blue_whale, R.drawable.giraffe, R.drawable.cow, R.drawable.elephant},
                {R.drawable.horse, R.drawable.cheetah, R.drawable.dog, R.drawable.rabbit},
                {R.drawable.pigeon, R.drawable.duck, R.drawable.ostrich, R.drawable.chicken},
                {R.drawable.pigeon, R.drawable.parrot, R.drawable.sparrow, R.drawable.stork},
                {R.drawable.giraffe, R.drawable.elephant, R.drawable.cow, R.drawable.horse},
                {R.drawable.goose, R.drawable.swan, R.drawable.seagull, R.drawable.sismis},
                {R.drawable.butterfly, R.drawable.snail, R.drawable.mole, R.drawable.blue_whale},
                {R.drawable.rabbit, R.drawable.fox, R.drawable.mole, R.drawable.turtle},
                {R.drawable.duck, R.drawable.horse, R.drawable.dog, R.drawable.cat}
        };
        correct_answer[0] = 2;
        correct_answer[1] = 1;
        correct_answer[2] = 1;
        correct_answer[3] = 2;
        correct_answer[4] = 0;
        correct_answer[5] = 1;
        correct_answer[6] = 4;
        correct_answer[7] = 2;
        correct_answer[8] = 3;
        correct_answer[9] = 2;

        queue = random_number_generator();
        displayquestion();
    }


    public void displayquestion() {
        if (anscnt <= 4) {
            TextView ques = findViewById( R.id.lbl_question );
            ImageButton opt1 = findViewById( R.id.option1 );
            ImageButton opt2 = findViewById( R.id.option2 );
            ImageButton opt3 = findViewById( R.id.option3 );
            ImageButton opt4 = findViewById( R.id.option4 );

            ques.setText( questions[queue[numberofquestioncomplete]] );
            opt1.setImageResource( answers[queue[numberofquestioncomplete]][0] );
            opt2.setImageResource( answers[queue[numberofquestioncomplete]][1] );
            opt3.setImageResource( answers[queue[numberofquestioncomplete]][2] );
            opt4.setImageResource( answers[queue[numberofquestioncomplete]][3] );

            numberofquestioncomplete++;
        }
    }

    public void onClickCard(View view) {
        anscnt++;
        if (anscnt >= 5) {

            Intent i = getIntent();
            String user_name = i.getStringExtra( "name" );

            Intent intent = new Intent( getApplicationContext(), DisplayResult.class );
            intent.putExtra( "user_name", user_name );
            intent.putExtra( "total", Integer.toString( correct_ans_count ) );
            startActivity( intent );
        }

        ImageButton opt1 = findViewById( R.id.option1 );
        ImageButton opt2 = findViewById( R.id.option2 );
        ImageButton opt3 = findViewById( R.id.option3 );
        ImageButton opt4 = findViewById( R.id.option4 );


        if (anscnt < 5) {
            if (opt1.isPressed() == true) {
                if ((correct_answer[queue[numberofquestioncomplete - 1]] == 0)) {
                    correct_ans_count++;
                }
            }
            if (opt2.isPressed() == true) {
                if ((correct_answer[queue[numberofquestioncomplete - 1]] == 1)) {
                    correct_ans_count++;
                }

            }
            if (opt3.isPressed() == true) {
                if (correct_answer[queue[numberofquestioncomplete - 1]] == 2) {
                    correct_ans_count++;
                }
            }
            if (opt4.isPressed() == true) {
                if (correct_answer[queue[numberofquestioncomplete - 1]] == 3) {
                    correct_ans_count++;
                }
            }
        }
        if (anscnt < 5) {
            displayquestion();
        }

    }
}
