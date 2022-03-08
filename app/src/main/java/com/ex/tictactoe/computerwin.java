package com.ex.tictactoe;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class computerwin extends Dialog {

    private final String message1;
    private final Drawable drawabl,iconwin;

    private final ComputerActivity2 mainActivity;
    public computerwin(@NonNull Context context, String message11, Drawable draw,Drawable iconwin) {
        super(context);
        this.message1=message11;
        this.drawabl=draw;
        this.iconwin=iconwin;
        this.mainActivity=((ComputerActivity2)context);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.winnerdialog);

        final TextView messagee=findViewById(R.id.winlose);

        final ImageView imgv=findViewById(R.id.winloseimg);
        final ImageView imgwin=findViewById(R.id.xoxo);

        imgv.setImageDrawable(drawabl);
        imgwin.setImageDrawable(iconwin);
        messagee.setText(message1);

    }
}
