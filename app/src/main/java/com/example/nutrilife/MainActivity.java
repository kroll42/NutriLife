/*Ciencia da Computacao - DACC
* PDM - Programacao para Dispositivos Moveis
* Docente: Prof. Lucas Marques
* Discente: Karolyne Muniz
* Icones por Freepik e paulalee em flaticon.com
* */

package com.example.nutrilife;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edt_nome, edt_peso, edt_altura;
    private RadioButton rb_fem, rb_masc;
    private Button button;
    private RadioGroup radioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = findViewById(R.id.radioGroup);
        edt_nome = findViewById(R.id.edt_nome);
        edt_altura = findViewById(R.id.edt_altura);
        edt_peso = findViewById(R.id.edt_peso);
        rb_fem = findViewById(R.id.rb_fem);
        rb_masc = findViewById(R.id.rb_masc);
        button = findViewById(R.id.button);
        rb_fem.setChecked(true);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sexoid = radioGroup.getCheckedRadioButtonId();


                String nome = edt_nome.getText().toString();
                RadioButton selec_sexo = findViewById(sexoid);
                String sexo = selec_sexo.getText().toString();
                Toast.makeText(MainActivity.this, "" + sexoid, Toast.LENGTH_SHORT).show();

                if (!edt_nome.getText().toString().isEmpty() && !edt_peso.getText().toString().isEmpty() && !edt_altura.getText().toString().isEmpty()
                    ){
                    AlertDialog.Builder janela = new AlertDialog.Builder(MainActivity.this);
                    janela.setTitle(R.string.app_name);
                    janela.setMessage("Todos os dados estão corretos?");
                    janela.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            double peso = Double.parseDouble(edt_peso.getText().toString());
                            double altura = Double.parseDouble(edt_altura.getText().toString());
                            double IMC = peso/(altura * altura);
                            Intent intent = new Intent(MainActivity.this, Resultado.class);
                            intent.putExtra("nome", nome);
                            intent.putExtra("sexo", sexo);
                            intent.putExtra("peso", peso);
                            intent.putExtra("altura", altura);
                            startActivity(intent);

                    }
                    });
                    janela.setNegativeButton("Não", null);
                    janela.create().show();

                }else {
                   AlertDialog.Builder janela = new AlertDialog.Builder(MainActivity.this);
                    janela.setTitle(R.string.app_name);
                    janela.setMessage("Preencha os dados corretamente!");
                    janela.setNeutralButton("OK", null);
                   janela.create().show();

                }
            }
        });

    }
}