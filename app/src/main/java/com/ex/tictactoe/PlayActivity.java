package com.ex.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class PlayActivity extends AppCompatActivity {



    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,reset;
    TextView win,play1,play2,xx,oo;
    ImageView img1,img2;

    Drawable xi,oi;
    static String x = "x";
    int x1=0,o1=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        database  databasein=new database(this);



        MediaPlayer mreset=MediaPlayer.create(this,R.raw.reset);
        MediaPlayer mwin=MediaPlayer.create(this,R.raw.win);
        MediaPlayer mall=MediaPlayer.create(this,R.raw.all);
        MediaPlayer mdraw=MediaPlayer.create(this,R.raw.draw);


        String plays1=getIntent().getStringExtra("a");
        String plays2=getIntent().getStringExtra("b");
        String theme=getIntent().getStringExtra("v1");



        xx=findViewById(R.id.no1);
        oo=findViewById(R.id.no2);
        play1=findViewById(R.id.p1);
        play2=findViewById(R.id.p2);
        b1=findViewById(R.id.button1);
        b2=findViewById(R.id.button2);
        b3=findViewById(R.id.button3);
        b4=findViewById(R.id.button4);
        b5=findViewById(R.id.button5);
        b6=findViewById(R.id.button6);
        b7=findViewById(R.id.button7);
        b8=findViewById(R.id.button8);
        b9=findViewById(R.id.button9);
        win=findViewById(R.id.winner);
        reset=findViewById(R.id.reset);
        img1=findViewById(R.id.img1);
        img2=findViewById(R.id.img2);

        play1.setText(plays1);
        play2.setText(plays2);


        if(theme.equals("a")){
            xi=getResources().getDrawable(R.drawable.x);
            oi=getResources().getDrawable(R.drawable.o);
            img1.setImageDrawable(getResources().getDrawable(R.drawable.x));
            img2.setImageDrawable(getResources().getDrawable(R.drawable.o));
        }else if(theme.equals("b")){
            xi=getResources().getDrawable(R.drawable.x1);
            oi=getResources().getDrawable(R.drawable.o1);
            img1.setImageDrawable(getResources().getDrawable(R.drawable.x1));
            img2.setImageDrawable(getResources().getDrawable(R.drawable.o1));
        }


        reset.setVisibility(View.INVISIBLE);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mreset.start();

                b1.setBackground(getResources().getDrawable(R.drawable.i123));
                b2.setBackground(getResources().getDrawable(R.drawable.i123));
                b3.setBackground(getResources().getDrawable(R.drawable.i123));
                b4.setBackground(getResources().getDrawable(R.drawable.i123));
                b5.setBackground(getResources().getDrawable(R.drawable.i123));
                b6.setBackground(getResources().getDrawable(R.drawable.i123));
                b7.setBackground(getResources().getDrawable(R.drawable.i123));
                b8.setBackground(getResources().getDrawable(R.drawable.i123));
                b9.setBackground(getResources().getDrawable(R.drawable.i123));

                b1.setClickable(true);
                b2.setClickable(true);
                b3.setClickable(true);
                b4.setClickable(true);
                b5.setClickable(true);
                b6.setClickable(true);
                b7.setClickable(true);
                b8.setClickable(true);
                b9.setClickable(true);

                b1.setEnabled(true);
                b2.setEnabled(true);
                b3.setEnabled(true);
                b4.setEnabled(true);
                b5.setEnabled(true);
                b6.setEnabled(true);
                b7.setEnabled(true);
                b8.setEnabled(true);
                b9.setEnabled(true);

                b1.setText("");
                b2.setText("");
                b3.setText("");
                b4.setText("");
                b5.setText("");
                b6.setText("");
                b7.setText("");
                b8.setText("");
                b9.setText("");

                Random random=new Random();
                int r=random.nextInt(5);
                int coinss=r;
                Boolean i=databasein.insert(r);

                if(i==true){
                    Toast.makeText(PlayActivity.this, r+" "+"Coins"+" "+"Collected", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(PlayActivity.this, "Not Collected", Toast.LENGTH_SHORT).show();
                }


                win.setText("");

                if(x=="x"){
                    x="o";
                }else {
                    x="x";
                }


                reset.setVisibility(View.INVISIBLE);
                if (x == "o") {
                    img2.setBackground(getResources().getDrawable(R.drawable.i123));
                    img1.setBackground(getResources().getDrawable(R.drawable.gg));
                }else if(x=="x"){
                    img1.setBackground(getResources().getDrawable(R.drawable.i123));
                    img2.setBackground(getResources().getDrawable(R.drawable.gg));
                }

                if(x1==5 || o1==5){
                    if(x1>o1){
                        windialog(plays1+" are Legend",getResources().getDrawable(R.drawable.wing),xi);

                    }
                    if(x1<o1) {
                        windialog(plays2+" are Legend",getResources().getDrawable(R.drawable.wing),oi);
                    }
                }
                if(x1==10 || o1==10){
                    if(x1>o1){
                        windialog(plays1+" are Ultra Legend",getResources().getDrawable(R.drawable.wing),xi);
                    }
                    if(x1<o1){
                        windialog(plays2+" are Ultra Legend",getResources().getDrawable(R.drawable.wing),oi);
                    }
                }

            }
        });




        if (x == "o") {
            img2.setBackground(getResources().getDrawable(R.drawable.i123));
            img1.setBackground(getResources().getDrawable(R.drawable.gg));
        }else if(x=="x"){
            img1.setBackground(getResources().getDrawable(R.drawable.i123));
            img2.setBackground(getResources().getDrawable(R.drawable.gg));
        }



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mreset.start();
                if (x == "o") {
                    img1.setBackground(getResources().getDrawable(R.drawable.i123));
                    img2.setBackground(getResources().getDrawable(R.drawable.gg));
                    b1.setBackground(oi);
                    b1.setText("O");
                    b1.setClickable(false);
                    x="x";
                }else if(x=="x"){
                    img2.setBackground(getResources().getDrawable(R.drawable.i123));
                    img1.setBackground(getResources().getDrawable(R.drawable.gg));
                    b1.setBackground(xi);
                    b1.setText("X");
                    b1.setClickable(false);
                    x="o";
                }

                if(!b1.isClickable() && !b2.isClickable() && !b3.isClickable() && !b4.isClickable() &&
                        !b5.isClickable() && !b6.isClickable() && !b7.isClickable() && !b8.isClickable() &&
                        !b9.isClickable() && win.getText()==""){
                    mdraw.start();
                    win.setText("DRAW");
                }


                if(b1.getText()=="X" && b2.getText()=="X" && b3.getText()=="X" ||
                        b1.getText()=="O" && b2.getText()=="O" && b3.getText()=="O"){
                    mwin.start();
                    if(b1.getText()=="X"){
                        win.setText("X winner");
                        x1=x1+1;
                        xx.setText(x1+"");
                    }else {
                        win.setText("O Winner");
                        o1=o1+1;
                        oo.setText(o1+"");
                    }

                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    b8.setEnabled(false);
                    b9.setEnabled(false);
                }
                if(b1.getText()=="X" && b4.getText()=="X" && b7.getText()=="X" ||
                        b1.getText()=="O" && b4.getText()=="O" && b7.getText()=="O"){
                    mwin.start();
                    if(b1.getText()=="X"){
                        win.setText("X winner");
                        x1=x1+1;
                        xx.setText(x1+"");
                    }else {
                        win.setText("O Winner");
                        o1=o1+1;
                        oo.setText(o1+"");
                    }
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    b8.setEnabled(false);
                    b9.setEnabled(false);
                }
                if(b1.getText()=="X" && b5.getText()=="X" && b9.getText()=="X" ||
                        b1.getText()=="O" && b5.getText()=="O" && b9.getText()=="O"){
                    mwin.start();
                    if(b1.getText()=="X"){
                        win.setText("X winner");
                        x1=x1+1;
                        xx.setText(x1+"");
                    }else {
                        win.setText("O Winner");
                        o1=o1+1;
                        oo.setText(o1+"");
                    }
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    b8.setEnabled(false);
                    b9.setEnabled(false);
                }
                if(win.getText().equals("")){
                    reset.setVisibility(View.INVISIBLE);
                }else {
                    reset.setVisibility(View.VISIBLE);
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mreset.start();
                if (x == "o") {
                    img1.setBackground(getResources().getDrawable(R.drawable.i123));
                    img2.setBackground(getResources().getDrawable(R.drawable.gg));
                    b2.setBackground(oi);
                    b2.setClickable(false);
                    b2.setText("O");
                    x="x";
                }else if(x=="x"){
                    img2.setBackground(getResources().getDrawable(R.drawable.i123));
                    img1.setBackground(getResources().getDrawable(R.drawable.gg));
                    b2.setBackground(xi);
                    b2.setClickable(false);
                    b2.setText("X");
                    x="o";
                }

                if(!b1.isClickable() && !b2.isClickable() && !b3.isClickable() && !b4.isClickable() &&
                        !b5.isClickable() && !b6.isClickable() && !b7.isClickable() && !b8.isClickable() &&
                        !b9.isClickable() && win.getText()==""){
                    mdraw.start();
                    win.setText("DRAW");
                }

                if(b1.getText()=="X" && b2.getText()=="X" && b3.getText()=="X" ||
                        b1.getText()=="O" && b2.getText()=="O" && b3.getText()=="O"){
                    mwin.start();
                    if(b2.getText()=="X"){
                        win.setText("X winner");
                        x1=x1+1;
                        xx.setText(x1+"");
                    }else {
                        win.setText("O Winner");
                        o1=o1+1;
                        oo.setText(o1+"");
                    }
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    b8.setEnabled(false);
                    b9.setEnabled(false);
                }
                if(b2.getText()=="X" && b5.getText()=="X" && b8.getText()=="X" ||
                        b2.getText()=="O" && b5.getText()=="O" && b8.getText()=="O"){
                    mwin.start();
                    if(b2.getText()=="X"){
                        win.setText("X winner");
                        x1=x1+1;
                        xx.setText(x1+"");
                    }else {
                        win.setText("O Winner");
                        o1=o1+1;
                        oo.setText(o1+"");
                    }
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    b8.setEnabled(false);
                    b9.setEnabled(false);
                }
                if(win.getText().equals("")){
                    reset.setVisibility(View.INVISIBLE);
                }else {
                    reset.setVisibility(View.VISIBLE);
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mreset.start();
                if (x == "o") {
                    img1.setBackground(getResources().getDrawable(R.drawable.i123));
                    img2.setBackground(getResources().getDrawable(R.drawable.gg));
                    b3.setBackground(oi);
                    b3.setClickable(false);
                    b3.setText("O");
                    x="x";
                }else if(x=="x"){
                    img2.setBackground(getResources().getDrawable(R.drawable.i123));
                    img1.setBackground(getResources().getDrawable(R.drawable.gg));
                    b3.setBackground(xi);
                    b3.setClickable(false);
                    b3.setText("X");
                    x="o";
                }
                if(!b1.isClickable() && !b2.isClickable() && !b3.isClickable() && !b4.isClickable() &&
                        !b5.isClickable() && !b6.isClickable() && !b7.isClickable() && !b8.isClickable() &&
                        !b9.isClickable() && win.getText()==""){
                    mdraw.start();
                    win.setText("DRAW");
                }

                if(b3.getText()=="X" && b5.getText()=="X" && b7.getText()=="X" ||
                        b3.getText()=="O" && b5.getText()=="O" && b7.getText()=="O"){
                    mwin.start();
                    if(b3.getText()=="X"){
                        win.setText("X winner");
                        x1=x1+1;
                        xx.setText(x1+"");
                    }else {
                        win.setText("O Winner");
                        o1=o1+1;
                        oo.setText(o1+"");
                    }
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    b8.setEnabled(false);
                    b9.setEnabled(false);
                }
                if(b1.getText()=="X" && b2.getText()=="X" && b3.getText()=="X" ||
                        b1.getText()=="O" && b2.getText()=="O" && b3.getText()=="O"){
                    mwin.start();
                    if(b3.getText()=="X"){
                        win.setText("X winner");
                        x1=x1+1;
                        xx.setText(x1+"");
                    }else {
                        win.setText("O Winner");
                        o1=o1+1;
                        oo.setText(o1+"");
                    }
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    b8.setEnabled(false);
                    b9.setEnabled(false);
                }
                if(b3.getText()=="X" && b6.getText()=="X" && b9.getText()=="X" ||
                        b3.getText()=="O" && b6.getText()=="O" && b9.getText()=="O"){
                    mwin.start();
                    if(b3.getText()=="X"){
                        win.setText("X winner");
                        x1=x1+1;
                        xx.setText(x1+"");
                    }else {
                        win.setText("O Winner");
                        o1=o1+1;
                        oo.setText(o1+"");
                    }
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    b8.setEnabled(false);
                    b9.setEnabled(false);
                }
                if(win.getText().equals("")){
                    reset.setVisibility(View.INVISIBLE);
                }else {
                    reset.setVisibility(View.VISIBLE);
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mreset.start();
                if (x == "o") {
                    img1.setBackground(getResources().getDrawable(R.drawable.i123));
                    img2.setBackground(getResources().getDrawable(R.drawable.gg));
                    b4.setBackground(oi);
                    b4.setClickable(false);
                    b4.setText("O");
                    x="x";
                }else if(x=="x"){
                    img2.setBackground(getResources().getDrawable(R.drawable.i123));
                    img1.setBackground(getResources().getDrawable(R.drawable.gg));
                    b4.setBackground(xi);
                    b4.setClickable(false);
                    b4.setText("X");
                    x="o";
                }

                if(!b1.isClickable() && !b2.isClickable() && !b3.isClickable() && !b4.isClickable() &&
                        !b5.isClickable() && !b6.isClickable() && !b7.isClickable() && !b8.isClickable() &&
                        !b9.isClickable() && win.getText()==""){
                    mdraw.start();
                    win.setText("DRAW");
                }

                if(b4.getText()=="X" && b5.getText()=="X" && b6.getText()=="X" ||
                        b4.getText()=="O" && b5.getText()=="O" && b6.getText()=="O"){
                    mwin.start();
                    if(b4.getText().equals("X")){
                        win.setText("X winner");
                        x1=x1+1;
                        xx.setText(x1+"");
                    }else {
                        win.setText("O Winner");
                        o1=o1+1;
                        oo.setText(o1+"");
                    }
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    b8.setEnabled(false);
                    b9.setEnabled(false);
                }
                if(b1.getText()=="X" && b4.getText()=="X" && b7.getText()=="X" ||
                        b1.getText()=="O" && b4.getText()=="O" && b7.getText()=="O"){
                    mwin.start();
                    if(b4.getText().equals("X")){
                        win.setText("X winner");
                        x1=x1+1;
                        xx.setText(x1+"");
                    }else {
                        win.setText("O Winner");
                        o1=o1+1;
                        oo.setText(o1+"");
                    }
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    b8.setEnabled(false);
                    b9.setEnabled(false);
                }
                if(win.getText().equals("")){
                    reset.setVisibility(View.INVISIBLE);
                }else {
                    reset.setVisibility(View.VISIBLE);
                }
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mreset.start();
                if (x == "o") {
                    img1.setBackground(getResources().getDrawable(R.drawable.i123));
                    img2.setBackground(getResources().getDrawable(R.drawable.gg));
                    b5.setBackground(oi);
                    b5.setClickable(false);
                    b5.setText("O");
                    x="x";
                }else if(x=="x"){
                    img2.setBackground(getResources().getDrawable(R.drawable.i123));
                    img1.setBackground(getResources().getDrawable(R.drawable.gg));
                    b5.setBackground(xi);
                    b5.setClickable(false);
                    b5.setText("X");
                    x="o";
                }
                if(!b1.isClickable() && !b2.isClickable() && !b3.isClickable() && !b4.isClickable() &&
                        !b5.isClickable() && !b6.isClickable() && !b7.isClickable() && !b8.isClickable() &&
                        !b9.isClickable() && win.getText()==""){
                    mdraw.start();
                    win.setText("DRAW");
                }

                if(b1.getText()=="X" && b5.getText()=="X" && b9.getText()=="X" ||
                        b1.getText()=="O" && b5.getText()=="O" && b9.getText()=="O"){
                    mwin.start();
                    if(b5.getText().equals("X")){
                        win.setText("X winner");
                        x1=x1+1;
                        xx.setText(x1+"");
                    }else {
                        win.setText("O Winner");
                        o1=o1+1;
                        oo.setText(o1+"");
                    }
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    b8.setEnabled(false);
                    b9.setEnabled(false);
                }
                if(b3.getText()=="X" && b5.getText()=="X" && b7.getText()=="X" ||
                        b3.getText()=="O" && b5.getText()=="O" && b7.getText()=="O"){
                    mwin.start();
                    if(b5.getText().equals("X")){
                        win.setText("X winner");
                        x1=x1+1;
                        xx.setText(x1+"");
                    }else {
                        win.setText("O Winner");
                        o1=o1+1;
                        oo.setText(o1+"");
                    }
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    b8.setEnabled(false);
                    b9.setEnabled(false);
                }
                if(b2.getText()=="X" && b5.getText()=="X" && b8.getText()=="X" ||
                        b2.getText()=="O" && b5.getText()=="O" && b8.getText()=="O"){
                    mwin.start();
                    if(b5.getText().equals("X")){
                        win.setText("X winner");
                        x1=x1+1;
                        xx.setText(x1+"");
                    }else {
                        win.setText("O Winner");
                        o1=o1+1;
                        oo.setText(o1+"");
                    }
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    b8.setEnabled(false);
                    b9.setEnabled(false);
                }
                if(b4.getText()=="X" && b5.getText()=="X" && b6.getText()=="X" ||
                        b4.getText()=="O" && b5.getText()=="O" && b6.getText()=="O"){
                    mwin.start();
                    if(b5.getText().equals("X")){
                        win.setText("X winner");
                        x1=x1+1;
                        xx.setText(x1+"");
                    }else {
                        win.setText("O Winner");
                        o1=o1+1;
                        oo.setText(o1+"");
                    }
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    b8.setEnabled(false);
                    b9.setEnabled(false);
                }
                if(win.getText().equals("")){
                    reset.setVisibility(View.INVISIBLE);
                }else {
                    reset.setVisibility(View.VISIBLE);
                }
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mreset.start();
                if (x == "o") {
                    img1.setBackground(getResources().getDrawable(R.drawable.i123));
                    img2.setBackground(getResources().getDrawable(R.drawable.gg));
                    b6.setBackground(oi);
                    b6.setClickable(false);
                    b6.setText("O");
                    x="x";
                }else if(x=="x"){
                    img2.setBackground(getResources().getDrawable(R.drawable.i123));
                    img1.setBackground(getResources().getDrawable(R.drawable.gg));
                    b6.setBackground(xi);
                    b6.setClickable(false);
                    b6.setText("X");
                    x="o";
                }
                if(!b1.isClickable() && !b2.isClickable() && !b3.isClickable() && !b4.isClickable() &&
                        !b5.isClickable() && !b6.isClickable() && !b7.isClickable() && !b8.isClickable() &&
                        !b9.isClickable() && win.getText()==""){
                    mdraw.start();
                    win.setText("DRAW");
                }

                if(b3.getText()=="X" && b6.getText()=="X" && b9.getText()=="X" ||
                        b3.getText()=="O" && b6.getText()=="O" && b9.getText()=="O"){
                    mwin.start();
                    if(b6.getText().equals("X")){
                        win.setText("X winner");
                        x1=x1+1;
                        xx.setText(x1+"");
                    }else {
                        win.setText("O Winner");
                        o1=o1+1;
                        oo.setText(o1+"");
                    }
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    b8.setEnabled(false);
                    b9.setEnabled(false);
                }
                if(b4.getText()=="X" && b5.getText()=="X" && b6.getText()=="X" ||
                        b4.getText()=="O" && b5.getText()=="O" && b6.getText()=="O"){
                    mwin.start();
                    if(b6.getText().equals("X")){
                        win.setText("X winner");
                        x1=x1+1;
                        xx.setText(x1+"");
                    }else {
                        win.setText("O Winner");
                        o1=o1+1;
                        oo.setText(o1+"");
                    }
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    b8.setEnabled(false);
                    b9.setEnabled(false);
                }
                if(win.getText().equals("")){
                    reset.setVisibility(View.INVISIBLE);
                }else {
                    reset.setVisibility(View.VISIBLE);
                }
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mreset.start();
                if (x == "o") {
                    img1.setBackground(getResources().getDrawable(R.drawable.i123));
                    img2.setBackground(getResources().getDrawable(R.drawable.gg));
                    b7.setBackground(oi);
                    b7.setClickable(false);
                    b7.setText("O");
                    x="x";
                }else if(x=="x"){
                    img2.setBackground(getResources().getDrawable(R.drawable.i123));
                    img1.setBackground(getResources().getDrawable(R.drawable.gg));
                    b7.setBackground(xi);
                    b7.setClickable(false);
                    b7.setText("X");
                    x="o";
                }
                if(!b1.isClickable() && !b2.isClickable() && !b3.isClickable() && !b4.isClickable() &&
                        !b5.isClickable() && !b6.isClickable() && !b7.isClickable() && !b8.isClickable() &&
                        !b9.isClickable() && win.getText()==""){
                    mdraw.start();
                    win.setText("DRAW");
                }

                if(b1.getText()=="X" && b4.getText()=="X" && b7.getText()=="X" ||
                        b1.getText()=="O" && b4.getText()=="O" && b7.getText()=="O"){
                    mwin.start();
                    if(b7.getText().equals("X")){
                        win.setText("X winner");
                        x1=x1+1;
                        xx.setText(x1+"");
                    }else {
                        win.setText("O Winner");
                        o1=o1+1;
                        oo.setText(o1+"");
                    }
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    b8.setEnabled(false);
                    b9.setEnabled(false);
                }
                if(b3.getText()=="X" && b5.getText()=="X" && b7.getText()=="X" ||
                        b3.getText()=="O" && b5.getText()=="O" && b7.getText()=="O"){
                    mwin.start();
                    if(b7.getText().equals("X")){
                        win.setText("X winner");
                        x1=x1+1;
                        xx.setText(x1+"");
                    }else {
                        win.setText("O Winner");
                        o1=o1+1;
                        oo.setText(o1+"");
                    }
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    b8.setEnabled(false);
                    b9.setEnabled(false);
                }
                if(b7.getText()=="X" && b8.getText()=="X" && b9.getText()=="X" ||
                        b7.getText()=="O" && b8.getText()=="O" && b9.getText()=="O"){
                    mwin.start();
                    if(b7.getText().equals("X")){
                        win.setText("X winner");
                        x1=x1+1;
                        xx.setText(x1+"");
                    }else {
                        win.setText("O Winner");
                        o1=o1+1;
                        oo.setText(o1+"");
                    }
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    b8.setEnabled(false);
                    b9.setEnabled(false);
                }
                if(win.getText().equals("")){
                    reset.setVisibility(View.INVISIBLE);
                }else {
                    reset.setVisibility(View.VISIBLE);
                }
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mreset.start();
                if (x == "o") {
                    img1.setBackground(getResources().getDrawable(R.drawable.i123));
                    img2.setBackground(getResources().getDrawable(R.drawable.gg));
                    b8.setBackground(oi);
                    b8.setClickable(false);
                    b8.setText("O");
                    x="x";
                }else if(x=="x"){
                    img2.setBackground(getResources().getDrawable(R.drawable.i123));
                    img1.setBackground(getResources().getDrawable(R.drawable.gg));
                    b8.setBackground(xi);
                    b8.setClickable(false);
                    b8.setText("X");
                    x="o";
                }
                if(!b1.isClickable() && !b2.isClickable() && !b3.isClickable() && !b4.isClickable() &&
                        !b5.isClickable() && !b6.isClickable() && !b7.isClickable() && !b8.isClickable() &&
                        !b9.isClickable() && win.getText()==""){
                    mdraw.start();
                    win.setText("DRAW");
                }

                if(b2.getText()=="X" && b5.getText()=="X" && b8.getText()=="X" ||
                        b2.getText()=="O" && b5.getText()=="O" && b8.getText()=="O"){
                    mwin.start();
                    if(b8.getText().equals("X")){
                        win.setText("X winner");
                        x1=x1+1;
                        xx.setText(x1+"");
                    }else {
                        win.setText("O Winner");
                        o1=o1+1;
                        oo.setText(o1+"");
                    }
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    b8.setEnabled(false);
                    b9.setEnabled(false);
                }
                if(b7.getText().equals("X") && b8.getText().equals("X") && b9.getText().equals("X") ||
                        b7.getText().equals("O") && b8.getText().equals("O") && b9.getText().equals("O")){
                    mwin.start();
                    if(b8.getText().equals("X")){
                        win.setText("X winner");
                        x1=x1+1;
                        xx.setText(x1+"");
                    }else {
                        win.setText("O Winner");
                        o1=o1+1;
                        oo.setText(o1+"");
                    }
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    b8.setEnabled(false);
                    b9.setEnabled(false);
                }
                if(win.getText().equals("")){
                    reset.setVisibility(View.INVISIBLE);
                }else {
                    reset.setVisibility(View.VISIBLE);
                }
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mreset.start();
                if (x == "o") {
                    img1.setBackground(getResources().getDrawable(R.drawable.i123));
                    img2.setBackground(getResources().getDrawable(R.drawable.gg));
                    b9.setBackground(oi);
                    b9.setClickable(false);
                    b9.setText("O");
                    x="x";
                }else if(x=="x"){
                    img2.setBackground(getResources().getDrawable(R.drawable.i123));
                    img1.setBackground(getResources().getDrawable(R.drawable.gg));
                    b9.setBackground(xi);
                    b9.setClickable(false);
                    b9.setText("X");
                    x="o";
                }
                if(!b1.isClickable() && !b2.isClickable() && !b3.isClickable() && !b4.isClickable() &&
                        !b5.isClickable() && !b6.isClickable() && !b7.isClickable() && !b8.isClickable() &&
                        !b9.isClickable() && win.getText()==""){
                    mdraw.start();
                    win.setText("DRAW");
                }

                if(b1.getText().equals("X") && b5.getText().equals("X") && b9.getText().equals("X") ||
                        b1.getText().equals("O") && b5.getText().equals("O") && b9.getText().equals("O")){
                    mwin.start();
                    if(b9.getText().equals("X")){
                        win.setText("X winner");
                        x1=x1+1;
                        xx.setText(x1+"");
                    }else {
                        win.setText("O Winner");
                        o1=o1+1;
                        oo.setText(o1+"");
                    }
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    b8.setEnabled(false);
                    b9.setEnabled(false);
                }
                if(b7.getText().equals("X") && b8.getText().equals("X") && b9.getText().equals("X") ||
                        b7.getText().equals("O") && b8.getText().equals("O") && b9.getText().equals("O")){
                    mwin.start();
                    if(b9.getText().equals("X")){
                        win.setText("X winner");
                        x1=x1+1;
                        xx.setText(x1+"");
                    }else {
                        win.setText("O Winner");
                        o1=o1+1;
                        oo.setText(o1+"");
                    }
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    b8.setEnabled(false);
                    b9.setEnabled(false);
                }
                if(b3.getText().equals("X") && b6.getText().equals("X") && b9.getText().equals("X") ||
                        b3.getText().equals("O") && b6.getText().equals("O") && b9.getText().equals("O")){
                    mwin.start();
                    if(b9.getText().equals("X")){
                        win.setText("X winner");
                        x1=x1+1;
                        xx.setText(x1+"");
                    }else {
                        win.setText("O Winner");
                        o1=o1+1;
                        oo.setText(o1+"");
                    }
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    b8.setEnabled(false);
                    b9.setEnabled(false);
                }
                if(win.getText().equals("")){
                    reset.setVisibility(View.INVISIBLE);
                }else {
                    reset.setVisibility(View.VISIBLE);
                }
            }
        });
    }


    private void windialog(String message1, Drawable iconwinlose,Drawable iconxo){
        Winnerdialog winnerdialog=new Winnerdialog(PlayActivity.this,message1,iconwinlose,iconxo);
        winnerdialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        Window window=winnerdialog.getWindow();
        window.setGravity(Gravity.CENTER);
        winnerdialog.setCancelable(true);
        winnerdialog.show();
    }
}