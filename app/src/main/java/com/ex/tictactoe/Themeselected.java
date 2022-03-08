package com.ex.tictactoe;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.app.ActivityCompat;

public class Themeselected extends Dialog {

    private final MainActivity mainActivity;
    private final String act,a11,b;

    public Themeselected(@NonNull Context context , String ac,String a1,String b1) {
        super(context);
        this.act=ac;
        this.a11=a1;
        this.b=b1;
        this.mainActivity=((MainActivity)context);

    }
    String v1="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.themeselected);

        database  database=new database(getContext());
        int a=0;
        Cursor t=database.getcoin();
        StringBuffer buffer =new StringBuffer();
        while (t.moveToNext()){
            a+=t.getInt(1);
            buffer.append(a);
        }

        int c=a;
        final RadioButton rb1=findViewById(R.id.ts1);
        final RadioButton rb2=findViewById(R.id.ts2);
        final TextView tsc=findViewById(R.id.tsc);
        final TextView tsci1=findViewById(R.id.tsi1);
        final TextView tsci2=findViewById(R.id.tsi2);

        tsc.setText(c+"");
        if(c>=0){
            tsci1.setAlpha(1);
            tsci1.setText("");
        }else if(c>=0){
            tsci2.setAlpha(1);
            tsci2.setText("");
        }

        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRadioButtonClicked(v);
                dismiss();
                if(c<00){
                    Toast.makeText(mainActivity, "Coins is LessThan 1000", Toast.LENGTH_SHORT).show();
                }else {

                    if (act.equals("com")) {
                        Intent intent=new Intent(getContext(),ComputerActivity2.class);
                        intent.putExtra("v1",v1);
                        getContext().startActivity(intent);
                    }
                    if (act.equals("play")) {
                        Intent intent=new Intent(getContext(),PlayActivity.class);
                        intent.putExtra("v1",v1).putExtra("a",a11).putExtra("b",b);
                        getContext().startActivity(intent);
                    }
                }
            }
        });
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRadioButtonClicked(v);
                dismiss();
                if(c<00){
                    Toast.makeText(mainActivity, "Coins is LessThan 5000", Toast.LENGTH_SHORT).show();
                }else {
                    if (act.equals("com")) {
                        Intent intent=new Intent(getContext(),ComputerActivity2.class);
                        intent.putExtra("v1",v1);
                        getContext().startActivity(intent);
                    }
                    if (act.equals("play")) {
                        Intent intent=new Intent(getContext(),PlayActivity.class);
                        intent.putExtra("v1",v1).putExtra("a",a11).putExtra("b",b);
                        getContext().startActivity(intent);
                    }
                }
            }
        });

    }


    public void onRadioButtonClicked(View view){
        boolean isSelected=((AppCompatRadioButton)view).isChecked();
        switch (view.getId()){
            case R.id.ts1:
                if(isSelected){
                    v1="a";
                }
                break;

            case R.id.ts2:
                if(isSelected){
                    v1="b";
                }
                break;
        }
    }
}
