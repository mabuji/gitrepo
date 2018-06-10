package com.example.yoyo.calculatorupper;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bmi,danwei,jinzhi;
    EditText result_main;
    public String equation = "";
    private Button one, two, three, four, five, six, seven, eight, nine, zero;
    private Button add, sub, mul, division, ce, del, dot, calculate, radical, reciprocal, power, sin, cos, tan;
    public String result = "";

    public void activitySkip() {
        bmi = (Button) findViewById(R.id.bmi);
        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bmiIntent = new Intent(MainActivity.this, BMIActivity.class);
                startActivity(bmiIntent);
            }
        });
        danwei = (Button)findViewById(R.id.danwei);
        danwei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent danweiIntent = new Intent(MainActivity.this,DanweiActivity.class);
                startActivity(danweiIntent);
            }
        });
        jinzhi = (Button)findViewById(R.id.jinzhi);
        jinzhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jinzhiIntent = new Intent(MainActivity.this,jinzhiActivity.class);
                startActivity(jinzhiIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id){
            case R.id.help:
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("帮助");
                builder.setMessage("这是一个简单的帮助");
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"单击了取消",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"单击了确定",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.create();
                builder.show();
                break;
            case R.id.exit:
                System.exit(-1);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void init() {

        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        zero = (Button) findViewById(R.id.zero);

        add = (Button) findViewById(R.id.add);
        sub = (Button) findViewById(R.id.sub);
        mul = (Button) findViewById(R.id.mul);
        division = (Button) findViewById(R.id.division);
        ce = (Button) findViewById(R.id.ce);
        del = (Button) findViewById(R.id.del);
        dot = (Button) findViewById(R.id.dot);
        calculate = (Button) findViewById(R.id.calculate);
        radical = (Button) findViewById(R.id.radical);
        reciprocal = (Button) findViewById(R.id.reciprocal);
        power = (Button) findViewById(R.id.power);
        sin = (Button) findViewById(R.id.sin);
        cos = (Button) findViewById(R.id.cos);
        tan = (Button) findViewById(R.id.tan);
        result_main = (EditText) findViewById(R.id.result_main);

        this.one.setOnClickListener(this);
        this.two.setOnClickListener(this);
        this.three.setOnClickListener(this);
        this.four.setOnClickListener(this);
        this.five.setOnClickListener(this);
        this.six.setOnClickListener(this);
        this.seven.setOnClickListener(this);
        this.eight.setOnClickListener(this);
        this.nine.setOnClickListener(this);
        this.zero.setOnClickListener(this);
        this.dot.setOnClickListener(this);

        this.add.setOnClickListener(this);
        this.sub.setOnClickListener(this);
        this.mul.setOnClickListener(this);
        this.division.setOnClickListener(this);
        this.ce.setOnClickListener(this);
        this.del.setOnClickListener(this);
        this.calculate.setOnClickListener(this);
        this.radical.setOnClickListener(this);
        this.reciprocal.setOnClickListener(this);
        this.power.setOnClickListener(this);
        this.sin.setOnClickListener(this);
        this.cos.setOnClickListener(this);
        this.tan.setOnClickListener(this);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activitySkip();
        init();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == one.getId()) {

            this.equation += "1";
            this.result_main.setText(this.equation);
        } else if (v == this.two) {

            this.equation += "2";
            this.result_main.setText(this.equation);
        } else if (v == this.three) {

            this.equation += "3";
            this.result_main.setText(this.equation);
        } else if (v == this.four) {

            this.equation += "4";
            this.result_main.setText(this.equation);
        } else if (v == this.five) {

            this.equation += "5";
            this.result_main.setText(this.equation);
        } else if (v == this.six) {

            this.equation += "6";
            this.result_main.setText(this.equation);
        } else if (v == this.seven) {

            this.equation += "7";
            this.result_main.setText(this.equation);
        } else if (v == this.eight) {

            this.equation += "8";
            this.result_main.setText(this.equation);
        } else if (v == this.nine) {

            this.equation += "9";
            this.result_main.setText(this.equation);
        } else if (v == this.zero) {

            this.equation += "0";
            this.result_main.setText(this.equation);
        } else if (v == this.dot) {

            if (!(this.equation == "" || this.equation == null)) {
                if (!this.equation.matches(".{" + (this.equation.length() - 1)
                        + "}[+-/*^.]")) {
                    String[] num = this.equation.split("[\\^]|[/]|[+]|[*]|[-]");
                    if (!num[num.length - 1].contains(".")) {
                        this.equation += ".";
                        this.result_main.setText(this.equation);
                    }
                }




            }
        } else if (v == this.calculate) {

            if (!(this.equation == "" || this.equation == null)) {
                if (!this.equation.matches(".{" + (this.equation.length() - 1)
                        + "}[+-/*^√]")) {
                    this.equation += "=";
                    result = Calculators.calculate(this.equation);
                    this.equation += result;
                    this.result_main.setText(this.equation);
                    this.equation = result;
                }
            }
        } else if (v == this.ce) {

            this.equation = "";
            this.result_main.setText(this.equation);
        } else if (v == this.del) {

            if (!(this.equation == "" || this.equation == null)) {
                this.equation = this.equation.substring(0,
                        this.equation.length() - 1);
                this.result_main.setText(this.equation);
            }

        } else if (v == this.add) {

            if (!(this.equation == "" || this.equation == null)) {
                if (!this.equation.matches(".{" + (this.equation.length() - 1)
                        + "}[+-/*^]")) {
                    this.equation += "+";
                    this.result_main.setText(this.equation);
                }
            }
        } else if (v == this.sub) {

            if (!(this.equation == "" || this.equation == null)) {
                if (!this.equation.matches(".{" + (this.equation.length() - 1)
                        + "}[+-/*^]")) {
                    this.equation += "-";
                    this.result_main.setText(this.equation);
                }
            }
        } else if (v == this.mul) {

            if (!(this.equation == "" || this.equation == null)) {
                if (!this.equation.matches(".{" + (this.equation.length() - 1)
                        + "}[+-/*^]")) {
                    this.equation += "*";
                    this.result_main.setText(this.equation);
                }
            }
        } else if (v == this.division) {

            if (!(this.equation == "" || this.equation == null)) {
                if (!this.equation.matches(".{" + (this.equation.length() - 1)
                        + "}[+-/*^]")) {
                    this.equation += "/";
                    this.result_main.setText(this.equation);
                }
            }
        }  else if (v == this.radical) {

            if (!(this.equation == "" || this.equation == null)) {
                if (!this.equation.matches(".{" + (this.equation.length() - 1)
                        + "}[\\^]|[/]|[+]|[*]|[-][√]]")) {
                    this.equation += "√";
                    this.result_main.setText(this.equation);
                }
            }

        } else if (v == this.reciprocal) {

            if (!(this.equation == "" || this.equation == null)) {
                if (!this.equation.matches(".{" + (this.equation.length() - 1)
                        + "}[+-/*^]")) {
                    Double num = Double.parseDouble(this.equation);
                    num = 1 / num;
                    this.equation = num + "";
                    this.result_main.setText(this.equation);
                }
            }
        } else if (v == this.power) {

            if (!(this.equation == "" || this.equation == null)) {
                if (!this.equation.matches(".{" + (this.equation.length() - 1)
                        + "}[+-/*^]")) {
                    this.equation += "^";
                    this.result_main.setText(this.equation);
                }
            }
        } else if (v == this.sin) {

            if (!(this.equation == "")) {
                this.equation += "s";
                result = Calculators.calculate(this.equation);
                this.result_main.setText(result);
                this.equation = "";
            }

        } else if (v == this.cos) {

            if (!(this.equation == "")) {
                this.equation += "c";
                result = Calculators.calculate(this.equation);
                this.result_main.setText(result);
                this.equation = "";
            }
        } else if (v == this.tan) {

            if (!(this.equation == "")) {
                this.equation += "t";
                result = Calculators.calculate(this.equation);
                this.result_main.setText(result);
                this.equation = "";
            }
        }
    }
}
