package com.example.songwei.anagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.*;
import android.view.View;
import android.widget.*;
import android.media.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btn_easy = (Button) findViewById(R.id.button);
        final Button btn_medium = (Button) findViewById(R.id.button2);
        final Button btn_hard = (Button) findViewById(R.id.button3);
        final Button btn_info = (Button) findViewById(R.id.button4);
        final Switch bgm_switch = (Switch) findViewById(R.id.switch2);
/*
        bgm_switch.setChecked(true);
        final MediaPlayer player = MediaPlayer.create(this,R.raw.bgm);
        player.setLooping(true); // Set looping
        player.setVolume(100,100);
        player.start();

        bgm_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bgm_switch.isChecked()){
                    player.start();
                } else {
                    player.stop();
                }
            }
        });
*/

        btn_easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Game.class);
                startActivity(intent);
            }
        });


        btn_medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Game_Medium.class);
                startActivity(intent);
            }
        });


        btn_hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Game_Hard.class);
                startActivity(intent);
                //text.setText("Hard");
            }
        });


        btn_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Info.class);
                startActivity(intent);
            }
        });



    }
}
