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
        Button dialog=(Button) findViewById(R.id.dialog1);
        imageView=(ImageView) findViewById(R.id.imageView1);

        dialog.setOnClickListener(this);
        ChangePicButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.changeButton:
                imageView.setImageResource(R.drawable.pic2);
                break;
            case R.id.dialog1:
                onDialogClick();
            default:
                break;
        }
    }
    public void onDialogClick(){
        final String[] datasource={"as","df"};

        final List<String > selected=new ArrayList<>();
        AlertDialog dialog=new AlertDialog
                .Builder(this)
                .setTitle("muti select")
                .setIcon(R.drawable.pic1)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String result=selected.toString().replace('[',' ').replace(']',' ');
                        Toast.makeText(jump_pic.this,result,Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("cancel",null)
                .setMultiChoiceItems(datasource,null,new DialogInterface.OnMultiChoiceClickListener(){

                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                String itemstr=datasource[which];
                                selected.add(itemstr);
//                                Toast.makeText(jump_pic.this,"selected:"+itemstr,Toast.LENGTH_SHORT).show();
                            }
                        }).create();
        dialog.show();

        }


}

