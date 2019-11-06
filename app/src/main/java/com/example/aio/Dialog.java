package com.example.aio;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Dialog extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        Button dialog=(Button) findViewById(R.id.Dialog1);

        dialog.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Dialog1:
                onDialogClick();
            default:
                break;

        }
    }


    public void onDialogClick(){
        final String[] datasource={"a","b","c","d","e","f"};

        final List<String > selected=new ArrayList<>();
        AlertDialog dialog=new AlertDialog
                .Builder(this)
                .setTitle("muti select")
                .setIcon(R.drawable.pic1)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String result=selected.toString().replace('[',' ').replace(']',' ');
                        Toast.makeText(Dialog.this,result,Toast.LENGTH_SHORT).show();
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
