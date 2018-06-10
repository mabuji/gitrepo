package com.example.yoyo.calculatorupper;

import android.support.annotation.IntRange;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class jinzhiActivity extends AppCompatActivity implements View.OnClickListener{
    Button one,two,three,four,five,six,seven,eight,nine,zero,a,b,c,d,e,f,ce_jinzhi;
    String equation="";
    EditText result_jinzhi;
    String oldRadix = "",radix_result="";
    public void init(){
        result_jinzhi = (EditText)findViewById(R.id.result_jinzhi);
        ce_jinzhi = (Button) findViewById(R.id.ce_jinzhi) ;
        one = (Button)findViewById(R.id.one);
        two = (Button)findViewById(R.id.two);
        three = (Button)findViewById(R.id.three);
        four = (Button)findViewById(R.id.four);
        five = (Button)findViewById(R.id.five);
        six = (Button)findViewById(R.id.six);
        seven = (Button)findViewById(R.id.seven);
        eight = (Button)findViewById(R.id.eight);
        nine = (Button)findViewById(R.id.nine);
        zero = (Button)findViewById(R.id.zero);
        a = (Button)findViewById(R.id.a);
        b = (Button)findViewById(R.id.b);
        c = (Button)findViewById(R.id.c);
        d = (Button)findViewById(R.id.d);
        e = (Button)findViewById(R.id.e);
        f = (Button)findViewById(R.id.f);

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
        this.a.setOnClickListener(this);
        this.b.setOnClickListener(this);
        this.c.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.ce_jinzhi.setOnClickListener(this);

        }


    public void forbidFromTwo(){
        two.setEnabled(false);
        three.setEnabled(false);
        four.setEnabled(false);
        five.setEnabled(false);
        six.setEnabled(false);
        seven.setEnabled(false);
    }

    public void freeFromtwo(){
        two.setEnabled(true);
        three.setEnabled(true);
        four.setEnabled(true);
        five.setEnabled(true);
        six.setEnabled(true);
        seven.setEnabled(true);
    }

    public void forbidFromEight(){
        eight.setEnabled(false);
        nine.setEnabled(false);
    }

    public void freeFromEight(){
        eight.setEnabled(true);
        nine.setEnabled(true);
    }

    public void forbidFromA(){
        a.setEnabled(false);
        b.setEnabled(false);
        c.setEnabled(false);
        d.setEnabled(false);
        e.setEnabled(false);
        f.setEnabled(false);
    }

    public void freeFromA(){
        a.setEnabled(true);
        b.setEnabled(true);
        c.setEnabled(true);
        d.setEnabled(true);
        e.setEnabled(true);
        f.setEnabled(true);
    }

    public String DtoB(){
        String text;
        text= Integer.toBinaryString(Integer.parseInt(result_jinzhi.getText().toString()));
        return text;
    }

    public String DtoO(){
        String text;
        text= Integer.toOctalString(Integer.parseInt(result_jinzhi.getText().toString()));
        return text;
    }

    public String DtoH(){
        String text;
        text= Integer.toHexString(Integer.parseInt(result_jinzhi.getText().toString()));
        return text;
    }

    public String HtoD(){
        int text = Integer.valueOf(result_jinzhi.getText().toString(),16);
        return String.valueOf(text);
    }

   public String OtoD(){
       int text;
       text = Integer.valueOf(result_jinzhi.getText().toString(),8);
       return String.valueOf(text);
   }

    public String BtoD(){
        int text;
        text = Integer.valueOf(result_jinzhi.getText().toString(),2);
        return String.valueOf(text);
    }

    public String BtoO(){
        int text = Integer.valueOf(result_jinzhi.getText().toString(),2);
        String number = Integer.toOctalString(text);
        return number;
    }

    public String OtoB(){
        int text = Integer.valueOf(result_jinzhi.getText().toString(),8);
        String number = Integer.toBinaryString(text);
        return number;
    }

    public String BtoH(){
        int text = Integer.valueOf(result_jinzhi.getText().toString(),2);
        String number = Integer.toHexString(text);
        return number;
    }

    public String HtoB(){
        int text = Integer.valueOf(result_jinzhi.getText().toString(),16);
        String number = Integer.toBinaryString(text);
        return number;
    }

    public String OtoH(){
        int text = Integer.valueOf(result_jinzhi.getText().toString(),8);
        String number = Integer.toHexString(text);
        return number;
    }

    public String HtoO(){
        int text = Integer.valueOf(result_jinzhi.getText().toString(),16);
        String number = Integer.toOctalString(text);
        return number;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jinzhi);
        init();
    }
    public void checkRadix(View v){
        boolean checked = ((RadioButton)v).isChecked();
        switch (v.getId()){

            case R.id.binaryradix:
                if(checked){
                    forbidFromTwo();
                    forbidFromEight();
                    forbidFromA();
                    if(oldRadix.equals("D")){
                        radix_result = DtoB();
                        result_jinzhi.setText(radix_result);
                    } else  if(oldRadix.equals("O")) {
                        radix_result = OtoB();
                        result_jinzhi.setText(radix_result);
                    } else if(oldRadix.equals("H")){
                        radix_result = HtoB();
                        result_jinzhi.setText(radix_result);
                    }
                    oldRadix = "B";
            }break;

            case R.id.octonary:
                if(checked){
                    freeFromtwo();
                    forbidFromEight();
                    forbidFromA();
                    if(oldRadix.equals("D")){
                        radix_result = DtoO();
                        result_jinzhi.setText(radix_result);
                    } else if(oldRadix.equals("B")){
                        radix_result = BtoO();
                        result_jinzhi.setText(radix_result);
                    } else if(oldRadix.equals("H")){
                        radix_result = HtoO();
                        result_jinzhi.setText(radix_result);
                    }
                    oldRadix = "O";
                }break;

            case R.id.decimal:
                if(checked){
                    freeFromtwo();
                    freeFromEight();
                    forbidFromA();
                    if(oldRadix.equals("H")){
                        radix_result=HtoD();
                        result_jinzhi.setText(radix_result);
                    }else if(oldRadix.equals("O")){
                        radix_result = OtoD();
                        result_jinzhi.setText(radix_result);
                    }else if(oldRadix.equals("B")){
                        radix_result = BtoD();
                        result_jinzhi.setText(radix_result);
                    }
                    oldRadix = "D";
            }break;

            case R.id.hex:
                if(checked){
                    freeFromtwo();
                    freeFromEight();
                    freeFromA();
                    if(oldRadix.equals("D")){
                        radix_result = DtoH();
                        result_jinzhi.setText(radix_result);
                    }else if(oldRadix.equals("B")) {
                        radix_result = BtoH();
                        result_jinzhi.setText(radix_result);
                    } else if(oldRadix.equals("O")){
                        radix_result = OtoH();
                        result_jinzhi.setText(radix_result);
                    }
                    oldRadix="H";
                }break;
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == one.getId()) {

            this.equation += "1";
            this.result_jinzhi.setText(this.equation);
        } else if (v == this.two) {

            this.equation += "2";
            this.result_jinzhi.setText(this.equation);
        } else if (v == this.three) {

            this.equation += "3";
            this.result_jinzhi.setText(this.equation);
        } else if (v == this.four) {

            this.equation += "4";
            this.result_jinzhi.setText(this.equation);
        } else if (v == this.five) {

            this.equation += "5";
            this.result_jinzhi.setText(this.equation);
        } else if (v == this.six) {

            this.equation += "6";
            this.result_jinzhi.setText(this.equation);
        } else if (v == this.seven) {

            this.equation += "7";
            this.result_jinzhi.setText(this.equation);
        } else if (v == this.eight) {

            this.equation += "8";
            this.result_jinzhi.setText(this.equation);
        } else if (v == this.nine) {

            this.equation += "9";
            this.result_jinzhi.setText(this.equation);
        } else if (v == this.zero) {

            this.equation += "0";
            this.result_jinzhi.setText(this.equation);
        } else if (v == this.a) {

            this.equation += "A";
            this.result_jinzhi.setText(this.equation);
        } else if (v == this.b) {

            this.equation += "B";
            this.result_jinzhi.setText(this.equation);
        } else if (v == this.c) {

            this.equation += "C";
            this.result_jinzhi.setText(this.equation);
        } else if (v == this.d) {

            this.equation += "D";
            this.result_jinzhi.setText(this.equation);
        } else if (v == this.e) {

            this.equation += "E";
            this.result_jinzhi.setText(this.equation);
        } else if (v == this.f) {

            this.equation += "F";
            this.result_jinzhi.setText(this.equation);
        }else if (v == this.ce_jinzhi) {

            this.equation="";
            this.result_jinzhi.setText("0");
        }
    }
}
