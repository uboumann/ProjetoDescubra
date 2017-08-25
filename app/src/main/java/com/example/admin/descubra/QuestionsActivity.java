package com.example.admin.descubra;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class QuestionsActivity extends AppCompatActivity {

    private RadioGroup rg;
    private int verifyRadio, i = 1;
    private Button btnConfirm, btnBack;
    private RadioButton bRadio1, bRadio2, bRadio3, bRadio4;
    private TextView question;
    int[] times = new int[]{0, 1, 2, 3};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        times[0] = 1;//São Paulo
        times[1] = 1;//Palmeiras
        times[2] = 1;//Corinthians
        times[3] = 1;//Santos


        question = (TextView) findViewById((R.id.pergunta));
        bRadio1 = (RadioButton) findViewById(R.id.respost1);
        bRadio2 = (RadioButton) findViewById(R.id.respost2);
        bRadio3 = (RadioButton) findViewById(R.id.respost3);
        bRadio4 = (RadioButton) findViewById(R.id.respost4);
        btnConfirm = (Button) findViewById(R.id.btn_click);
        btnBack = (Button) findViewById(R.id.btn_back);

        question(bRadio1, bRadio2, bRadio3, bRadio4, question, i);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rg = (RadioGroup) findViewById(R.id.questions);
                verifyRadio = rg.getCheckedRadioButtonId();

                if (verifyRadio != -1) {

                    i++;
                    question(bRadio1, bRadio2, bRadio3, bRadio4, question, i);

                    if (i == 9) {

                        result(times);
                    } else {
                        switch (verifyRadio) {

                            case R.id.respost1: {
                                times[0] = times[0] + 1;

                                break;
                            }
                            case R.id.respost2: {
                                times[1] = times[1] + 1;


                                break;
                            }
                            case R.id.respost3: {
                                times[2] = times[2] + 1;


                            }
                            break;

                            case R.id.respost4: {
                                times[3] = times[3] + 1;

                                break;
                            }

                        }
                    }
                } else {
                    Toast.makeText(QuestionsActivity.this, "Escolha uma resposta", Toast.LENGTH_LONG).show();
                }
            }

        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 1) {
                    Intent intent = new Intent(QuestionsActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                } else {
                    rg = (RadioGroup) findViewById(R.id.questions);
                    verifyRadio = rg.getCheckedRadioButtonId();
                    i--;
                    question(bRadio1, bRadio2, bRadio3, bRadio4, question, i);
                    switch (verifyRadio) {

                        case R.id.respost1: {
                            times[0] = times[0] - 1;

                            break;
                        }
                        case R.id.respost2: {
                            times[1] = times[1] - 1;

                            break;
                        }
                        case R.id.respost3: {
                            times[2] = times[2] - 1;

                        }
                        break;

                        case R.id.respost4: {
                            times[3] = times[3] - 1;

                            break;
                        }
                    }
                }
            }
        });


    }

    private void result(int vMax[]) {

int max=0;
        int nMax=0;
        for (int i = 0; i < vMax.length; i++)
        {
            if (vMax[i] > max)
            {
                max = vMax[i];
                nMax=i;
                Log.e("I", String.valueOf(i));
            }
        }
        Log.e("Numero do time maior", String.valueOf(max));
        Log.e("Array", Arrays.toString(vMax));
        switch (nMax){
            case 0:{
                Intent intent = new Intent(QuestionsActivity.this, ResultActivity.class);
                intent.putExtra("validation","C");
                startActivity(intent);
                finish();
                break;
            }
            case 1:{
                Intent intent = new Intent(QuestionsActivity.this, ResultActivity.class);
                intent.putExtra("validation","B");
                startActivity(intent);
                finish();
                break;
            }
            case 2:{
                Intent intent = new Intent(QuestionsActivity.this, ResultActivity.class);
                intent.putExtra("validation","A");
                startActivity(intent);
                finish();
                break;
            }
            case 3:{
                Intent intent = new Intent(QuestionsActivity.this, ResultActivity.class);
                intent.putExtra("validation","D");
                startActivity(intent);
                finish();
                break;
            }
        }



    }


    private void question(RadioButton tRadio1, RadioButton tRadio2, RadioButton
            tRadio3, RadioButton tRadio4, TextView tQuestion, int i) {

        switch (i) {

            case 1: {
                tQuestion.setText("Quantos anos você tem?");
                tRadio1.setText("Entre 10 e 20 anos.");
                tRadio2.setText("Entre 20 e 40 anos.");
                tRadio3.setText("Entre 40 e 60 anos.");
                tRadio4.setText("Mais de 60 anos.");
                break;
            }
            case 2: {
                tQuestion.setText("Qual sua cor favorita?");
                tRadio1.setText("Vermelho.");
                tRadio2.setText("Verde.");
                tRadio3.setText("Preto.");
                tRadio4.setText("Branco.");
                break;
            }
            case 3: {
                tQuestion.setText("Quantos títulos internacionais seu time tem?");
                tRadio1.setText("Mais que 10.");
                tRadio2.setText("Entre 4 e 5.");
                tRadio3.setText("Entre 0 e 3.");
                tRadio4.setText("Entre 5 e 10");
                break;
            }
            case 4: {
                tQuestion.setText("Qual jogador você gosta mais?");
                tRadio1.setText("Kaká.");
                tRadio2.setText("Gabriel Jesus.");
                tRadio3.setText("Jadson");
                tRadio4.setText("Neymar");
                break;

            }
            case 5: {
                tQuestion.setText("Qual técnico você acha melhor?");
                tRadio1.setText("Muricy Ramalho.");
                tRadio2.setText("Cuca.");
                tRadio3.setText("Fábio Carille.");
                tRadio4.setText("Dorival Junior.");
                break;
            }
            case 6: {
                tQuestion.setText("Qual seu placar preferido?");
                tRadio1.setText("3x0.");
                tRadio2.setText("2x1.");
                tRadio3.setText("1x0.");
                tRadio4.setText("5x2.");
                break;
            }
            case 7: {
                tQuestion.setText("Qual seu goleiro favorito?");
                tRadio1.setText("Rogério Ceni.");
                tRadio2.setText("Marcos.");
                tRadio3.setText("Cássio");
                tRadio4.setText("Vanderlei");
                break;
            }
            case 8: {
                tQuestion.setText("Quantos mundiais e libertadores seu time tem?");
                tRadio1.setText("3 Mundiais e 3 Libertadores.");
                tRadio2.setText("0 Mundiais e 1 Libertadores.");
                tRadio3.setText("1 Mundial e 1 Libertadores.");
                tRadio4.setText("2 Mundiais e 3 Libertadores.");
                break;
            }
        }

    }
}