package com.example.nutrilife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Resultado extends AppCompatActivity {
    private TextView txt_resultado;
    private Button btn_voltar;
    String msg;
    Double IMC ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        btn_voltar = findViewById(R.id.btn_voltar);
        txt_resultado = findViewById(R.id.txt_resultado);

        Intent intent = getIntent();

        String nome = intent.getStringExtra("nome");
        String sexo = intent.getStringExtra("sexo");
        double peso = intent.getDoubleExtra("peso", 0); // Correção aqui
        double altura = intent.getDoubleExtra("altura", 0); // Correção aqui



       IMC = peso/(altura * altura);
        Toast.makeText(this, "" + peso + "" + altura + "" + IMC, Toast.LENGTH_SHORT).show();
        if ( sexo.equals("Feminino") ) {
            if (IMC < 19) {
                msg = "Olá "+ nome +"\n" + "Seu IMC é: " + IMC + "\n" + "Classificação: Abaixo do normal" + "\n\n"
                        + "Riscos: " + "\n"+"Queda de cabelo, infertilidade, ausência menstrual, fadiga, stress, ansiedade.";

            } else if (IMC >= 19 && IMC <= 23.9) {
                msg = "Olá "+ nome +"\n" + "Seu IMC é: " + IMC + "\n" + "Classificação: Peso normal" + "\n\n"
                        + "Riscos: Menor riscos de doenças cardíacas e vasculares";
                }  else if ((IMC >= 24) && (IMC <= 28.9 )) {
                msg = "Olá "+ nome +"\n" + "Seu IMC é: " + IMC + "\n" + "Classificação: Obesidade leve" + "\n\n"
                        + "Riscos: " + "\n"+ "Fadiga, má circulação, varizes";

            }  else if ((IMC >= 29) && (IMC <= 38.9)) {
                msg = "Olá "+ nome +"\n" + "Seu IMC é: " + IMC + "\n" + "Classificação: Obesidade Moderada" + "\n\n"
                        + "Diabetes, angina, infarto, aterosclerose";
            }  else  {
                msg = "Olá "+ nome +"\n" + "Seu IMC é: " + IMC + "\n" + "Classificação: Obesidade Mórbida" + "\n\n"
                        +  "Riscos: " + "\n"+"Apneia do sono, falta de ar, refluxo, dificuldade para se mover, escaras, diabetes, infarto, AVC";
            }

        }else
        if (IMC < 20.7) {
             msg = "Olá "+ nome +"\n" + "Seu IMC é: " + IMC + "\n" + "Classificação: Abaixo do normal" + "\n\n"
                    + "Riscos: " + "\n"+"Queda de cabelo, infertilidade, fadiga, stress, ansiedade.";
        } else if (IMC < 26.4) {
            msg = "Olá "+ nome +"\n" + "Seu IMC é: " + IMC + "\n" + "Classificação: Peso normal" + "\n\n"
                    + "Riscos: Menor riscos de doenças cardíacas e vasculares";
        } else if (IMC < 27.8) {
            msg = "Olá "+ nome +"\n" + "Seu IMC é: " + IMC + "\n" + "Classificação: Obesidade leve" + "\n\n"
                    + "Riscos: " + "\n"+ "Fadiga, má circulação, varizes";
        } else if (IMC < 31.1) {
            msg = "Olá "+ nome +"\n" + "Seu IMC é: " + IMC + "\n" + "Classificação: Obesidade Moderada" + "\n\n"
                    + "Diabetes, angina, infarto, aterosclerose";
        } else {
            msg = "Olá "+ nome +"\n" + "Seu IMC é: " + IMC + "\n" + "Classificação: Obesidade Mórbida" + "\n\n"
                    +  "Riscos: " + "\n"+"Apneia do sono, falta de ar, refluxo, dificuldade para se mover, escaras, diabetes, infarto, AVC";
        }

        txt_resultado.setText(msg);

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}