package com.example.luanna.calculadoraimc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.nio.DoubleBuffer;

public class Tela1 extends Activity {

    private double result, peso, altura;
    private String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);


    }


    // pega os atributos da tela
    public void calcular(View view){
        EditText nm = findViewById(R.id.nome);
        EditText alt =findViewById(R.id.altura);
        EditText ps =findViewById(R.id.peso);
        RadioButton btn = findViewById(R.id.fem);

        if(nm.length() == 0 || alt.length() == 0 || ps.length() == 0 ){
            Toast msg = Toast.makeText(this, "preencha todos os campos!!!", Toast.LENGTH_LONG);
            msg.show();
        } else {
            peso = Double.parseDouble(ps.getText().toString());
            altura = Double.parseDouble(alt.getText().toString());
            nome = nm.getText().toString();
            result = peso / (altura*altura);

            if (btn.isChecked()){
                Intent it = new Intent(this, Tela2.class);
                Bundle params = new Bundle();
                params.putString("nome",nome);
                params.putDouble("imc",result);
                it.putExtras(params);
                startActivity(it);
            } else {
                Intent it = new Intent(this, Tela3.class);
                Bundle params = new Bundle();
                params.putString("nome", nome);
                params.putDouble("imc", result);
                it.putExtras(params);
                startActivity(it);
            }
        }
    }
}
