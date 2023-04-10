package com.example.ex1_per;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void Salvar(View view){
        EditText edittext = (EditText) findViewById(R.id.edittext1);
        String message = edittext.getText().toString();

        SharedPreferences sharedPref= getApplicationContext().getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString(getString(R.string.chave), message);

        editor.commit();


    }

    public void Recuperar(View view){
        SharedPreferences sharedPref= getApplicationContext().getSharedPreferences(getString(R.string.preference_file_key),Context.MODE_PRIVATE);

        String aux = sharedPref.getString(getString( R.string.chave),null);

        TextView textView = (TextView) findViewById(R.id.textview_1);

        textView.setText(aux);

    }



}