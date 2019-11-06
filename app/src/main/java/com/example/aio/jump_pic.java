package com.example.aio;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static androidx.core.os.LocaleListCompat.create;

public class jump_pic extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump_pic);

        Button ChangePicButton=(Button) findViewById(R.id.changeButton);

        imageView=(ImageView) findViewById(R.id.imageView1);

        ChangePicButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.changeButton:
                imageView.setImageResource(R.drawable.pic2);
                break;
            default:
                break;
        }
    }



}

