package com.ex.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Console;
import java.nio.IntBuffer;

public class MainActivity extends AppCompatActivity {

    Button button,com,com2;
    ImageButton setting;
    EditText pl1,pl2;
    TextView coinsall;
    int coinssall=0;
    int a=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.button);
        setting=findViewById(R.id.setting);
        com2=findViewById(R.id.button23);
        pl1=findViewById(R.id.plaer1);
        pl2=findViewById(R.id.plaer2);
        coinsall=findViewById(R.id.allcoins);





        database  database=new database(this);

        Cursor t=database.getcoin();
        StringBuffer buffer =new StringBuffer();
        while (t.moveToNext()){
            a+=t.getInt(1);
            buffer.append(a);
        }
        coinsall.setText(a+"");



        //SQLiteDatabase sdb=database.getReadableDatabase();




        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Unlock In Update Version", Toast.LENGTH_SHORT).show();
            }
        });



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a,b;
                    a=pl1.getText().toString();
                    b=pl2.getText().toString();
                    if(a=="" && b==""){
                        Toast.makeText(MainActivity.this, "Enter Your Name", Toast.LENGTH_SHORT).show();
                    }else {
                        WinDialog winDialog=new WinDialog(MainActivity.this,"Choose Any Option",a,b);
                        winDialog.setCancelable(true);
                        winDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                        Window window=winDialog.getWindow();
                        window.setGravity(Gravity.CENTER);
                        winDialog.show();
                    }
            }
        });

        com2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a="",b="";
                Themeselected themeselected=new Themeselected(MainActivity.this,"com",a,b);
                themeselected.setCancelable(true);
                themeselected.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                Window window=themeselected.getWindow();
                window.setGravity(Gravity.CENTER);
                themeselected.show();
            }
        });
    }


}

