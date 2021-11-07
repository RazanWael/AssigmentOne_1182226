package com.example.individalassigment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void btnShow_stop(View view) {
        Intent intent=new Intent(this,Stop_watch.class);
        String title = "Stop Watch";
        intent.putExtra("Data",title);
        startActivity(intent);
    }

    public void btnShow_food(View view) {
        Intent intent=new Intent(this, FitnessBooks.class);
        String title = "Fitness";
        intent.putExtra("Data",title);
        startActivity(intent);

    }


}