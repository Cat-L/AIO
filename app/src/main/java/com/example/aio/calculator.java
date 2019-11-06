package com.example.aio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;

public class calculator extends AppCompatActivity implements View.OnClickListener {

    Button btn_0;
    Button btn_1;
    Button btn_2;
    Button btn_3;
    Button btn_4;
    Button btn_5;
    Button btn_6;
    Button btn_7;
    Button btn_8;
    Button btn_9;
    Button btn_point; //小数点
    Button btn_clear; //清除
    Button btn_del;   //删除
    Button btn_plus;
    Button btn_minus;
    Button btn_multiply;
    Button btn_divide;
    Button btn_equal;
    Button btn_left;
    Button btn_right;
    private TextView et_input;
    private StringBuilder x = new StringBuilder();

    private void initView() {
        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_point = (Button) findViewById(R.id.btn_point);
        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_del = (Button) findViewById(R.id.btn_del);
        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_minus = (Button) findViewById(R.id.btn_minus);
        btn_multiply = (Button) findViewById(R.id.btn_multiply);
        btn_divide = (Button) findViewById(R.id.btn_divide);
        btn_equal = (Button) findViewById(R.id.btn_equal);
        et_input = (TextView) findViewById(R.id.et_input);
        btn_left = (Button) findViewById(R.id.btn_left);
        btn_right = (Button) findViewById(R.id.btn_right);

        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_point.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_left.setOnClickListener(this);
        btn_right.setOnClickListener(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);


        initView();
    }

    @Override
    public void onClick(View v) {
        int last = 0;
        if (x.length() != 0) {
            last = x.codePointAt(x.length() - 1);

        }
        switch (v.getId()) {
            case R.id.btn_0:
                x = x.append("0");
                et_input.setText(x);
                break;
            case R.id.btn_1:
                x = x.append("1");
                et_input.setText(x);
                break;
            case R.id.btn_2:
                x = x.append("2");
                et_input.setText(x);
                break;
            case R.id.btn_3:
                x = x.append("3");
                et_input.setText(x);
                break;
            case R.id.btn_4:
                x = x.append("4");
                et_input.setText(x);
                break;
            case R.id.btn_5:
                x = x.append("5");
                et_input.setText(x);
                break;
            case R.id.btn_6:
                x = x.append("6");
                et_input.setText(x);
                break;
            case R.id.btn_7:
                x = x.append("7");
                et_input.setText(x);
                break;
            case R.id.btn_8:
                x = x.append("8");
                et_input.setText(x);
                break;
            case R.id.btn_9:
                x = x.append("9");
                et_input.setText(x);
                break;
            case R.id.btn_plus:
                x = x.append("+");
                et_input.setText(x);
                break;
            case R.id.btn_minus:
                x = x.append("-");
                et_input.setText(x);
                break;
            case R.id.btn_multiply:
                x = x.append("*");
                et_input.setText(x);
                break;
            case R.id.btn_divide:
                x = x.append("/");
                et_input.setText(x);
                break;
            case R.id.btn_point:
                if ((last >= '0' && last <= '9' || last == ')') && judje1()) {
                    x = x.append(".");
                    et_input.setText(x);
                }
                break;
            case R.id.btn_right:// )右括号
                if ((last >= '0' && last <= '9' || last == ')') && judje2() == 1) {
                    x = x.append(")");
                    et_input.setText(x);
                }
                break;
            case R.id.btn_left:// （左括号
                if ((last != '(') || (last <= '0' && last >= '9')) {
                    x = x.append("(");
                    et_input.setText(x);
                }
                break;

            case R.id.btn_del: //删除
                if (x.length() != 0) {
                    x = x.delete(x.length() - 1, x.length());
                    et_input.setText(x);
                }
                break;
            case R.id.btn_clear: //清空
                x = x.delete(0, x.length());
                et_input.setText(x);
                break;
            case R.id.btn_equal: // =等于
                if ((x.length() > 1)) {
                    InfixInToDuffix inf = new InfixInToDuffix();
                    String jieguo;
                    try {
                        String a = inf.toSuffix(x);
                        jieguo = inf.dealEquation(a);

                    } catch (Exception ex) {
                        jieguo = "error";
                    }
                    et_input.setText(x + "=" + jieguo);
                    x = x.delete(0, x.length());
                    if (Character.isDigit(jieguo.charAt(0))) {
                        x = x.append(jieguo);
                    }
                }
                break;
            default:
                break;
        }
    }

    private boolean judje1() {
        String a = "+-*/.";
        int[] b = new int[a.length()];
        int max;
        for (int i = 0; i < a.length(); i++) {
            String c = "" + a.charAt(i);
            b[i] = x.lastIndexOf(c);
        }
        Arrays.sort(b);
        if (b[a.length() - 1] == -1) {
            max = 0;
        } else {
            max = b[a.length() - 1];
        }
        if (x.indexOf(".", max) == -1) {
            return true;
        } else {
            return false;
        }
    }

    private int judje2() {
        int a = 0, b = 0;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) == '(') {
                a++;
            }
            if (x.charAt(i) == ')') {
                b++;
            }
        }
        if (a == b)
            return 0;
        if (a > b)
            return 1;
        return 2;
    }
}

