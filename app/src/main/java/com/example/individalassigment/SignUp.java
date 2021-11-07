package com.example.individalassigment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;

public class SignUp extends AppCompatActivity {
    EditText fullname;
    EditText username;
    EditText email;
    Spinner spinner;
    EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

    }

    public void btnShow_signup(View view) {

        fullname=findViewById(R.id.fullname);
        username=findViewById(R.id.username);
        email=findViewById(R.id.email);
        spinner=findViewById(R.id.spinner);
        pass=findViewById(R.id.pass);
        signupinf sign=new signupinf(fullname.getText().toString(),username.getText().toString(),email.getText().toString(),spinner.getSelectedItem().toString(),pass.getText().toString());
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String signupinf = gson.toJson(sign);
        editor.putString("2", signupinf);
        editor.commit();
        Toast.makeText(this, "Data Saved:\n" + signupinf,
                Toast.LENGTH_SHORT).show();

        Intent intent=new Intent(this, MainActivity.class);
        String title = "logIN";
        intent.putExtra("Data",title);
        startActivity(intent);
    }
}