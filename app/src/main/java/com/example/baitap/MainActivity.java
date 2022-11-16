package com.example.baitap;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText user , pass ;
    Button btndangnhap ;
    CheckBox cbluu;
    String thongtinluu = "tk_mk login";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addcontrols();
        addEvent();
    }
    private  void addEvent(){
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //luu thong tin dang nhap
                SharedPreferences sharedPreferences = getSharedPreferences(thongtinluu,MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                //luu thong tin dang phan ra
                editor.putString("userName",user.getText().toString());
                editor.putString("passWord",pass.getText().toString());
                editor.putBoolean("save",cbluu.isChecked());
                editor.commit();
              Intent intent = new Intent(MainActivity.this,Home.class);
               Toast.makeText(MainActivity.this, "login thanh cong", Toast.LENGTH_SHORT).show();
              startActivity(intent);
            }
        });
    }
    private void   addcontrols(){
        user =findViewById(R.id.username);
        pass = findViewById(R.id.pass);
        btndangnhap =findViewById(R.id.login);
        cbluu = findViewById(R.id.checkBox);
    }

    protected void onResume(){
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences(thongtinluu,MODE_PRIVATE);
        String username =sharedPreferences.getString("userName","");
        String password =sharedPreferences.getString("passWord","");
        boolean save = sharedPreferences.getBoolean("save",false);
        if(save == true){
            user.setText(username);
            pass.setText(password);
        }

    }
}