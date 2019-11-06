package com.example.aio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class function_select extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function_select);

        Button jump_pic=(Button)findViewById(R.id.functionselect_JumPicButton);
        Button dialog=(Button)findViewById(R.id.functionselect_DialogButton);
        Button calculator=(Button)findViewById(R.id.functionselect_Calculator);

        dialog.setOnClickListener(this);
        jump_pic.setOnClickListener(this);
        calculator.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.functionselect_DialogButton:
                Intent intent_dialog=new Intent(function_select.this,Dialog.class);
                startActivity(intent_dialog);
                break;
            case R.id.functionselect_JumPicButton:
                Intent intent_jumppic=new Intent(function_select.this,jump_pic.class);
                startActivity(intent_jumppic);
                break;
            case R.id.functionselect_Calculator:
                Intent intent_calcu=new Intent(function_select.this,calculator.class);
                startActivity(intent_calcu);
                break;

        }

    }
}
