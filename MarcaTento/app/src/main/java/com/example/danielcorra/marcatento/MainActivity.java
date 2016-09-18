package com.example.danielcorra.marcatento;

import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_1, btn_3, btn_6, btn_9, btn_12;
    TextView pntNos, pntEles;
    Drawable round_button, round_button_selected;
    Integer nos, eles, pontoDaRodada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_12 = (Button) findViewById(R.id.btn_12);

        pntNos = (TextView) findViewById(R.id.pntNos);
        pntEles = (TextView) findViewById(R.id.pntEles);

        nos = 0;
        eles = 0;
        pontoDaRodada = 1;

        round_button = getApplicationContext().getDrawable(R.drawable.round_button);
        round_button_selected = getApplicationContext().getDrawable(R.drawable.round_button_selected);
    }

    //Caixa de Dialogo informando o vencedor
    public void nosVencemos(int layout){
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(layout);
        dialog.setTitle("Fim de Jogo!");
        dialog.show();
        nos = 0;
        eles = 0;
        pontoDaRodada = 1;
        pntNos.setText("0");
        pntEles.setText("0");
    }

    // Setar todos os botoes
    public void setarBotoes(){
        btn_1.setBackground(round_button);
        btn_3.setBackground(round_button);
        btn_6.setBackground(round_button);
        btn_9.setBackground(round_button);
        btn_12.setBackground(round_button);
    }

    /**
     * Botoes Pontuar
     */
    public void btnPontuarNos(View view){
        Integer pontuacaoAtual = Integer.parseInt(pntNos.getText().toString());
        pontuacaoAtual+=pontoDaRodada;
        if (pontuacaoAtual >= 12){
            nosVencemos(R.layout.dialogo);
            setarBotoes();
            btn_1.setBackground(round_button_selected);
        } else {
            pntNos.setText(pontuacaoAtual.toString());
        }
    }

    public void btnPontuarEles(View view){
        Integer pontuacaoAtual = Integer.parseInt(pntEles.getText().toString());
        pontuacaoAtual+=pontoDaRodada;

        if (pontuacaoAtual >= 12){
            nosVencemos(R.layout.dialogo2);
            setarBotoes();
            btn_1.setBackground(round_button_selected);
        } else {
            pntEles.setText(pontuacaoAtual.toString());
        }
    }

    /**
     * Evento dos Botoes
     * @param view
     */
    public void btn1(View view){
        setarBotoes();
        pontoDaRodada = 1;
        btn_1.setBackground(round_button_selected);
    }

    public void btn3(View view){
        setarBotoes();
        pontoDaRodada = 3;
        btn_3.setBackground(round_button_selected);
    }

    public void btn6(View view){
        setarBotoes();
        pontoDaRodada = 6;
        btn_6.setBackground(round_button_selected);
    }

    public void btn9(View view){
        setarBotoes();
        pontoDaRodada = 9;
        btn_9.setBackground(round_button_selected);
    }

    public void btn12(View view){
        setarBotoes();
        pontoDaRodada = 12;
        btn_12.setBackground(round_button_selected);
    }
}

