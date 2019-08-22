package com.example.luanna.calculadoraimc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Tela3 extends Activity {
    private Double imc ;
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

        nm.setText(nome);

            // HOMEM
            if (imc < 20.7)
                output.setText("abaixo do peso");

            if (imc >= 20.7 && imc < 26.4)
                output.setText("No peso Normal");

            if (imc >= 26.4 && imc < 27.8)
                output.setText("Marginalmente acima do peso");

            if (imc >= 27.8 && imc < 31.1)
                output.setText("Acima do peso ideal");

            if (imc >= 31.1)
                output.setText("Obeso");
    }
}
