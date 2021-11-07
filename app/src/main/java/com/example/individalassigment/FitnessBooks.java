package com.example.individalassigment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FitnessBooks extends AppCompatActivity {
    Button btnAdd;
    EditText edtText;
    ListView list_ofname;
    String [] books = new String[]{"The Fitness Mindset","The One-Minute Workout", "Glute Lab","Ready to run","Good to Go","Breathwork","The Champion's Mind","Nutrition in Crisis"};
    List<String> list;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitnessbooks);
        btnAdd =findViewById(R.id.btnAdd);
        edtText=findViewById(R.id.edtText);
        list_ofname=findViewById(R.id.list_ofname);
        list= new ArrayList<String>(Arrays.asList(books));
        adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);
        list_ofname.setAdapter(adapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                list.add(edtText.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

    }

    public void btnSaveOnClick(View view) {
//        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
//        SharedPreferences.Editor editor = prefs.edit();
//        Gson gson = new Gson();
//        String booksString = gson.toJson(books);
//        editor.putString("1", booksString);
//        editor.commit();
//        Toast.makeText(this, "Data Saved:\n" + booksString,
//                Toast.LENGTH_SHORT).show();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        List <String> booksString = Collections.singletonList(gson.toJson(list));
        editor.putString("1", String.valueOf(booksString));
        editor.commit();
        Toast.makeText(this, "Data Saved:\n" + booksString,
                Toast.LENGTH_SHORT).show();
    }


}