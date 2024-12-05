package com.example.maioremenor;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private EditText etNumeros;
    private TextView tvResposta;
    //private TextView tvMaior;
    //private TextView tvMenor;
    private Button btnDescobrir;
    private TextView tvInstrucao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNumeros = findViewById(R.id.etNumeros);
        etNumeros.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tvResposta = findViewById(R.id.tvResposta);
        tvResposta.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tvInstrucao = findViewById(R.id.tvInstrucao);
        tvInstrucao.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        btnDescobrir = findViewById(R.id.btnDescobrir);
        btnDescobrir.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        btnDescobrir.setOnClickListener(op -> descobrirMaiorMenor());

    }
    private void descobrirMaiorMenor() {
        //double[] numeros = new double[20];
        String entrada = etNumeros.getText().toString();
        String[] numerosTexto = entrada.split(",");
        int[] num = new int[20];
        int maior = 0;
        int menor = 0;
        try {

                for (int i = 0; i < 20; i++) {
                    num[i] = Integer.parseInt(numerosTexto[i]);
                    maior = Math.max(num[i], maior);
                    menor = Math.min(num[i], menor);
                    if (num[i] < 0) this.finish();
                    if (num[i] > maior) {
                        maior = num[i];
                    } else if (num[i] < menor) {
                        menor = num[i];
                    }
                }

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        String resposta = getString(R.string.tvMaior) + " " + maior + " " + getString(R.string.tvMenor) + " " + menor;
        tvResposta.setText(resposta);
    }
        //double maior = Math.max(listaNumeros);

}
