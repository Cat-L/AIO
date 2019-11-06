package com.example.aio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private EditText usernameText;
    private EditText passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setContentView(R.layout.linear_login);
        Button loginbutton= (Button) findViewById(R.id.LoginButton);
        usernameText=(EditText) findViewById(R.id.textView_logname);
        passwordText=(EditText) findViewById(R.id.textView_password);
        loginbutton.setOnClickListener(this);

    }

    public void onLoginClick(View v){
        Toast.makeText(this,"aaa",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.LoginButton:
                String username=usernameText.getText().toString();
                String password=passwordText.getText().toString();
                if (findUser(username,password)){
                    Intent intent=new Intent(Login.this,function_select.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(this, "账号或密码错误", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }

    protected boolean findUser(String username,String password){
        Map<String,String> user=new HashMap<>();

        user.put("admin","admin");
        user.put("a","123456");

        String temp_pass=user.get(username);
        if (temp_pass==null)
            return false;
        Object result= temp_pass.equals(password);
        if (result==null)
            return false;
        else
            return (boolean)result;

    }
}
