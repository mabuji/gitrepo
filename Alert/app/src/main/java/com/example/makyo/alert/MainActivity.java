package com.example.makyo.alert;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.elegy1004.alert.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.buttonTest);
        Button buttonT = (Button) findViewById(R.id.buttonTip);
        button.setOnClickListener(this);
        buttonT.setOnClickListener(this);
    }
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.buttonTest:
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        LayoutInflater inflater = getLayoutInflater();
                        final View view1=inflater.inflate(R.layout.login_dialog ,null);
                        builder.setView(view1)

                                .setTitle("Login")

                                .setPositiveButton(R.string.login, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int id) {
                                        EditText edittext = (EditText)view1.findViewById(R.id.editTestUserId);
                                        EditText edit2 = (EditText)view1.findViewById(R.id.editTestPwd);
                                        String zh = edittext.getText().toString();
                                        String mm =edit2.getText().toString();


                                        if(zh.equals("abc") && mm.equals("123")) {
                                            Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_LONG).show();
                                        }
                                        else{
                                            Toast.makeText(MainActivity.this, "帐号或密码错误", Toast.LENGTH_LONG).show();
                                        }
                                    }

                                })
                                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        finish();
                                    }
                                });
                        builder.show();
                        break;
                    case R.id.buttonTip:
                        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                        dialog.setTitle("提示");
                        dialog.setMessage("这是一条提示！");
                        dialog.setCancelable(false);
                        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                        dialog.show();                        break;
                    default:
                        break;

                }

            }




}






