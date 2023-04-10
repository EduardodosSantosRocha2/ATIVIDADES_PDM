package com.example.ex2_pe;

import static java.lang.String.valueOf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String vet1[] = new String[10];
    String vet2[] =new String[10];
    String vet3[] =new String[10];




    Double valor;
    Double maior = 0.0;

    int pos =0;

    int cont =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


   public void add(View view){




        EditText edittext1 = (EditText) findViewById(R.id.edittext1);
        EditText edittext2 = (EditText) findViewById(R.id.edittext2);
        EditText edittext3 = (EditText) findViewById(R.id.edittext3);

        String message1 = edittext1.getText().toString();
        String message2 = edittext2.getText().toString();
        String message3 = edittext3.getText().toString();

        vet1[cont] = message1;
        vet2[cont] = message2;
        vet3[cont] = message3;
        cont++;

        edittext1.getText().clear();
        edittext2.getText().clear();
        edittext3.getText().clear();

    }


    public void Salvar(View view){


        for (int i=0;i<cont; i++){
            valor = Double.parseDouble(vet2[i]);

            if(valor > maior){
                maior = valor;
                pos = i;
            }
        }


        String message11 = valueOf(vet1[pos]);
        String message22 = valueOf(vet2[pos]);
        String message33 = valueOf(vet3[pos]);



        SharedPreferences sharedPref= getApplicationContext().getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString(getString(R.string.chave), "Nome: "+message11+"\nAltura: "+message22+"\n Idade:"+message33);

        editor.commit();


    }

    public void Recuperar(View view){
        SharedPreferences sharedPref= getApplicationContext().getSharedPreferences(getString(R.string.preference_file_key),Context.MODE_PRIVATE);

        String aux = sharedPref.getString(getString( R.string.chave),null);

        TextView textView = (TextView) findViewById(R.id.textview_1);

        textView.setText(aux);

    }



}