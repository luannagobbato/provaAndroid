package com.example.luanna.calculadoraimc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.StringTokenizer;

public class Tela2 extends Activity {
    private Double imc;
    private String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        Intent it = getIntent();
        if(it != null) {
            Bundle params = it.getExtras();
            if (params != null){
                imc = params.getDouble("imc");
                nome = params.getString("nome");
                mostraResultado();
            }
        }
    }

    public void mostraResultado(){
        TextView output = findViewById(R.id.output);
        TextView nm = findViewById(R.id.nomeT2);
        TextView rslt = findViewById(R.id.result);
        rslt.setText(String.format ("%.2f", imc));
        int fem;

        nm.setText(nome);

        //MULHER
        if (imc < 19.1)
            output.setText("abaixo do peso");

        if(imc >= 19.1 && imc < 25.8)
            output.setText("No peso Normal");

        if(imc >= 25.8 && imc < 27.3)
            output.setText("Marginalmente acima do peso");

        if(imc >= 27.3 && imc < 32.3)
            output.setText("Acima do peso ideal");

        if(imc >=32.3)
            output.setText("Obeso");
    }
}
