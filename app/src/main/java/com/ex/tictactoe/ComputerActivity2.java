package com.ex.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class ComputerActivity2 extends AppCompatActivity {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,reset;
    TextView win,play1,play2,xx,oo;
    ImageView img1,img2;

    static String x = "x",winnerr="";
    int x1=0,o1=0;
    int turn_count = 0;

    Button[] bArrary;
    MediaPlayer mdraw,mall,mwin,mreset;

    Drawable xi,oi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer2);

        String aint=getIntent().getStringExtra("v1");


        xx=findViewById(R.id.no1c);
        oo=findViewById(R.id.no2c);
        play1=findViewById(R.id.p1c);
        play2=findViewById(R.id.p2c);
        b1=findViewById(R.id.button1c);
        b2=findViewById(R.id.button2c);
        b3=findViewById(R.id.button3c);
        b4=findViewById(R.id.button4c);
        b5=findViewById(R.id.button5c);
        b6=findViewById(R.id.button6c);
        b7=findViewById(R.id.button7c);
        b8=findViewById(R.id.button8c);
        b9=findViewById(R.id.button9c);
        win=findViewById(R.id.winnerc);
        reset=findViewById(R.id.resetc);
        img1=findViewById(R.id.img1c);
        img2=findViewById(R.id.img2c);

        bArrary = new Button[]{b1,b2,b3,b4,b5,b6,b7,b8,b9};

        if(aint.equals("a")){
            xi=getResources().getDrawable(R.drawable.x);
            oi=getResources().getDrawable(R.drawable.o);
        }else if(aint.equals("b")){
            xi=getResources().getDrawable(R.drawable.x1);
            oi=getResources().getDrawable(R.drawable.o1);
        }


         img1.setImageDrawable(xi);
         img2.setImageDrawable(oi);
         mreset=MediaPlayer.create(this,R.raw.reset);
         mwin=MediaPlayer.create(this,R.raw.win);
         mall=MediaPlayer.create(this,R.raw.all);
         mdraw=MediaPlayer.create(this,R.raw.draw);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mreset.start();
                turn_count = 0;
                winnerr="";
                x="x";

                win.setText("");
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
                b1.setText("");
                b2.setText("");
                b3.setText("");
                b4.setText("");
                b5.setText("");
                b6.setText("");
                b7.setText("");
                b8.setText("");
                b9.setText("");
                b1.setEnabled(true);
                b2.setEnabled(true);
                b3.setEnabled(true);
                b4.setEnabled(true);
                b5.setEnabled(true);
                b6.setEnabled(true);
                b7.setEnabled(true);
                b8.setEnabled(true);
                b9.setEnabled(true);

                if(x1==5 || o1==2){
                    if(x1>o1){
                        windialog("You are Legend",getResources().getDrawable(R.drawable.wing),xi);

                    }
                    if(x1<o1) {
                        windialog("You are Loser",getResources().getDrawable(R.drawable.lose),xi);
                    }
                }
                if(x1==10 || o1==10){
                    if(x1>o1){
                        windialog("You are Ultra Legend",getResources().getDrawable(R.drawable.wing),xi);
                    }
                    if(x1<o1){
                        windialog("You are Ultra Loser",getResources().getDrawable(R.drawable.lose),xi);
                    }
                }
            }
        });

        for (Button b : bArrary){
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button b = (Button) v;
                    buttonClicked(b);
                    Handler myHandler = new Handler();

                    myHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            randomClick();
                        }
                    },100);

                }
            });
            //set custom font to all buttons

        }


    }
    public void randomClick(){
        Random rand = new Random();
        if(winnerr==""){
            if (turn_count<9) {
            Button nextB = bArrary[rand.nextInt(bArrary.length)];
            while (!nextB.isClickable()) {
                nextB = bArrary[rand.nextInt(bArrary.length)];
            }
            buttonClicked(nextB);
        }
        }
    }
    public void buttonClicked(Button b){

        // i just wanna change the text on the button to X/O.

        if(x=="x") {
            mreset.start();
            b.setText("X");
            b.setBackground(xi);
            b.setClickable(false);
            x="o";
            turn_count++;
        }else if(x=="o"){
            mreset.start();
            b.setText("O");
            b.setBackground(oi);
            b.setClickable(false);
            x="x";
            turn_count++;
        }
        checkForWinner();
    }

    private void checkForWinner() {
        if(!b1.isClickable() && !b2.isClickable() && !b3.isClickable() && !b4.isClickable() &&
                !b5.isClickable() && !b6.isClickable() && !b7.isClickable() && !b8.isClickable() &&
                !b9.isClickable() && win.getText()==""){
            win.setText("DRAW");
            mdraw.start();
        }
        if(b1.getText()=="X" && b2.getText()=="X" && b3.getText()=="X" ||
                b1.getText()=="O" && b2.getText()=="O" && b3.getText()=="O"){
            if(b1.getText()=="X"){
                win.setText("X winner");
                x1=x1+1;
                xx.setText(x1+"");
            }else {
                win.setText("O Winner");
                o1=o1+1;
                oo.setText(o1+"");
            }
            winnerr="y";
            mwin.start();
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
            if(b4.getText()=="X"){
                win.setText("X winner");
                x1=x1+1;
                xx.setText(x1+"");
            }else {
                win.setText("O Winner");
                o1=o1+1;
                oo.setText(o1+"");
            }
            mwin.start();
            winnerr="y";
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
            if(b7.getText()=="X"){
                win.setText("X winner");
                x1=x1+1;
                xx.setText(x1+"");
            }else {
                win.setText("O Winner");
                o1=o1+1;
                oo.setText(o1+"");
            }
            mwin.start();
            winnerr="y";
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
            if(b1.getText()=="X"){
                win.setText("X winner");
                x1=x1+1;
                xx.setText(x1+"");
            }else {
                win.setText("O Winner");
                o1=o1+1;
                oo.setText(o1+"");
            }
            winnerr="y";
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
            if(b2.getText()=="X"){
                win.setText("X winner");
                x1=x1+1;
                xx.setText(x1+"");
            }else {
                win.setText("O Winner");
                o1=o1+1;
                oo.setText(o1+"");
            }
            mwin.start();
            winnerr="y";
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
            if(b3.getText()=="X"){
                win.setText("X winner");
                x1=x1+1;
                xx.setText(x1+"");
            }else {
                win.setText("O Winner");
                o1=o1+1;
                oo.setText(o1+"");
            }
            mwin.start();
            winnerr="y";
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
            if(b1.getText()=="X"){
                win.setText("X winner");
                x1=x1+1;
                xx.setText(x1+"");
            }else {
                win.setText("O Winner");
                o1=o1+1;
                oo.setText(o1+"");
            }
            mwin.start();
            winnerr="y";
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
            if(b3.getText()=="X"){
                win.setText("X winner");
                x1=x1+1;
                xx.setText(x1+"");
            }else {
                win.setText("O Winner");
                o1=o1+1;
                oo.setText(o1+"");
            }
            mwin.start();
            winnerr="y";
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
    }
    private void windialog(String message1, Drawable iconwinlose, Drawable iconxo){
        computerwin winnerdialog=new computerwin(ComputerActivity2.this,message1,iconwinlose,iconxo);
        winnerdialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        Window window=winnerdialog.getWindow();
        window.setGravity(Gravity.CENTER);
        winnerdialog.setCancelable(true);
        winnerdialog.show();
    }
}