package com.ex.tictactoe;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class WinDialog extends Dialog {

    private final String message,p1,p2;

    private final MainActivity mainActivity;
    public WinDialog(@NonNull Context context,String message,String play1,String play2) {
        super(context);
        this.message=message;
        this.p1=play1;
        this.p2=play2;
        this.mainActivity=((MainActivity)context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win_dialog);

        final TextView messagetv=findViewById(R.id.messagewin);
        final Button btn3=findViewById(R.id.tbt);
        final Button btn4=findViewById(R.id.fbf);

        messagetv.setText(message);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                Themeselected themeselected=new Themeselected(mainActivity,"play",p1,p2);
                themeselected.setCancelable(true);
                themeselected.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                Window window=themeselected.getWindow();
                window.setGravity(Gravity.CENTER);
                themeselected.show();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                Toast.makeText(mainActivity, "Unlock In Update Version", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
