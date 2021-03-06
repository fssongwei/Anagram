package com.example.songwei.anagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import java.lang.String;

import android.app.AlertDialog;
import android.content.DialogInterface;

public class Game_Medium extends AppCompatActivity {
    int count = 0;
    int rightAnsNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game__medium);

        final TextView text = (TextView) findViewById(R.id.text2);
        final EditText answer = (EditText) findViewById(R.id.answer2);
        final Button next = (Button) findViewById(R.id.next2);

        final String anagrams[][] = {{"feasts","safest"} ,{"filets","itself"} ,{"filler","refill"} ,{"former","reform"} ,{"framed","farmed"} ,{"friend","finder"} ,{"fringe","finger"} ,{"grease","agrees"} ,{"hearty","earthy"} ,{"heater","reheat"} ,{"hocked","choked"} ,{"hustle","sleuth"} ,{"impart","armpit"} ,{"insect","nicest"} ,{"insult","sunlit"} ,{"joiner","rejoin"} ,{"kisser","skiers"} ,{"lashes","hassle"} ,{"laymen","namely"} ,{" leader","dealer"} ,{"limped","dimple"} ,{"listen","silent"} ,{"manors","ransom"} ,{"maples","sample"} ,{"marine","airmen"} ,{"remain","mating"} ,{"molest","motels"}};

        text.setText(anagrams[0][0]);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(count == 27){
                    count = 0;
                    AlertDialog.Builder dialog = new AlertDialog.Builder(Game_Medium.this);
                    dialog.setTitle("End");
                    dialog.setMessage("Congratulation! You have completed 27 anagrams, "+ rightAnsNum + " right answers and " + (27-rightAnsNum) + " wrong answers.");
                    dialog.setCancelable(false);
                    rightAnsNum = 0;
                    dialog.setPositiveButton("Return", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent=new Intent(Game_Medium.this,MainActivity.class);
                            startActivity(intent);
                        }
                    });
                    dialog.setNegativeButton("New Game", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            text.setText(anagrams[0][0]);
                            answer.setText("");
                        }
                    });
                    dialog.show();
                }
                else {

                    String user_answer = answer.getText().toString();
                    if (user_answer.equals(anagrams[count][1])) {
                        rightAnsNum++;
                        AlertDialog.Builder dialog = new AlertDialog.Builder(Game_Medium.this);
                        dialog.setTitle("Right Answer");
                        dialog.setMessage("Your Answer " + user_answer + " is right, points + 1!");
                        dialog.show();
                    } else {
                        AlertDialog.Builder dialog = new AlertDialog.Builder(Game_Medium.this);
                        dialog.setTitle("Wrong Answer");
                        dialog.setMessage("Your Answer " + user_answer + " is wrong, the right answer should be " + anagrams[count][1]);
                        dialog.show();
                    }
                    count++;

                    if (count < 27) {
                        text.setText(anagrams[count][0]);
                        answer.setText("");
                    }
                }
            }
        });

    }


}
