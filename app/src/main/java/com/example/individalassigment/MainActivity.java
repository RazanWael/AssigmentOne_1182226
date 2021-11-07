package com.example.individalassigment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText pass;
    CheckBox remember;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        remember=findViewById(R.id.remember);
        username = findViewById(R.id.username);
        pass = findViewById(R.id.pass);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        Gson gson =new Gson();
        String remeber= prefs.getString("remember" , " ");
        if (remeber.equals("true")) {
            String signJson = prefs.getString("2", " ");
            signupinf sign = gson.fromJson(signJson, signupinf.class);
            if (sign != null) {
                username.setText(sign.getUsername());
                pass.setText((sign.getPass()));
            }
        }else{
            username.setText("");
            pass.setText("");
        }




    }

    public void btnShow_login(View view) {

        username=findViewById(R.id.username);
        pass=findViewById(R.id.pass);
        remember.findViewById(R.id.remember);
        signupinf sign=new signupinf(username.getText().toString(),pass.getText().toString());
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String signupinf = gson.toJson(sign);
        editor.putString("2", signupinf);
        if (remember.isChecked()==true){
            SharedPreferences prefss = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editorr = prefs.edit();
            Gson gsonn = new Gson();
            editor.putString("remember", "true");
            editor.commit();
        }
        editor.commit();
        Toast.makeText(this, "Data Saved:\n" + signupinf,
                Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this, MainActivity2.class);
        String title = "MainActivity";
        intent.putExtra("Data",title);
        startActivity(intent);
    }

    public void btnShow_signup(View view) {
        Intent intent=new Intent(this, SignUp.class);
        String title = "SignUp";
        intent.putExtra("Data",title);
        startActivity(intent);
    }
}