package com.ex.tictactoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class PublicPlay extends AppCompatActivity {


    Button reset;
    TextView win,player1,player2,xx,oo;
    ImageView img1,img2,b1,b2,b3,b4,b5,b6,b7,b8,b9;


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_play);

        player1=findViewById(R.id.p1pp);
        player2=findViewById(R.id.p2pp);
        b1=findViewById(R.id.button1pp);
        b2=findViewById(R.id.button2pp);
        b3=findViewById(R.id.button3pp);
        b4=findViewById(R.id.button4pp);
        b5=findViewById(R.id.button5pp);
        b6=findViewById(R.id.button6pp);
        b7=findViewById(R.id.button7pp);
        b8=findViewById(R.id.button8pp);
        b9=findViewById(R.id.button9pp);
        win=findViewById(R.id.winnerpp);
        reset=findViewById(R.id.resetpp);
        img1=findViewById(R.id.img1pp);
        img2=findViewById(R.id.img2pp);



    }
}