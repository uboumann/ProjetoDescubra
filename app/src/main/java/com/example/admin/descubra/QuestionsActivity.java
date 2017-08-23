package com.example.admin.descubra;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class QuestionsActivity extends AppCompatActivity {

    private RadioGroup rg;
    private int verifyRadio;
    private Button btnConfirm;
    private RadioButton bRadio1, bRadio2, bRadio3, bRadio4;
    private TextView question;
    private String Res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        bRadio1 = (RadioButton) findViewById(R.id.respost1);
        bRadio2 = (RadioButton) findViewById(R.id.respost2);
        bRadio3 = (RadioButton) findViewById(R.id.respost3);
        bRadio4 = (RadioButton) findViewById(R.id.respost4);
        btnConfirm = (Button) findViewById(R.id.btn_click);


        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rg = (RadioGroup) findViewById(R.id.questions);
                verifyRadio = rg.getCheckedRadioButtonId();
                switch (verifyRadio) {

                    case R.id.respost1: {
                        String valueRes=question1(1);
                        if (valueRes.equals("res1")){
                            Intent intent = new Intent(QuestionsActivity.this, ResultActivity.class);
                            intent.putExtra("validation", "A");
                            startActivity(intent);
                        }
                        break;
                    }
                    case R.id.respost2: {
                        question1(2);
                        break;
                    }
                    case R.id.respost3: {
                        String valueRes=question1(3);
                        if (valueRes.equals("res3")){
                            Intent intent = new Intent(QuestionsActivity.this, ResultActivity.class);
                            intent.putExtra("validation", "C");
                            startActivity(intent);
                        }
                        break;
                    }
                    case R.id.respost4: {
                        Intent intent = new Intent(QuestionsActivity.this, ResultActivity.class);
                        intent.putExtra("validation", "D");
                        startActivity(intent);

                        break;
                    }

                }

            }
        });


    }


    public String question1(int value) {
        question=(TextView)findViewById(R.id.pergunta);
        bRadio1 = (RadioButton) findViewById(R.id.respost1);
        bRadio2 = (RadioButton) findViewById(R.id.respost2);
        bRadio3 = (RadioButton) findViewById(R.id.respost3);
        bRadio4 = (RadioButton) findViewById(R.id.respost4);
        btnConfirm = (Button) findViewById(R.id.btn_click);
        Res="";
        if (value != 0) {
            question.setText("Quantos mundiais seu time tem?");
            bRadio1.setText("Nenhum");
            bRadio2.setText("2 mundiais");
            bRadio3.setText("3 mundiais");
            bRadio4.setText("4 mundiais");

            btnConfirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rg = (RadioGroup) findViewById(R.id.questions);
                    verifyRadio = rg.getCheckedRadioButtonId();
                    switch (verifyRadio) {

                        case R.id.respost1: {
                            Res="res1";
                            break;
                        }
                        case R.id.respost2: {
                            Res="res1";
                            break;
                        }


                        case R.id.respost3: {
                            Res="res3";

                            break;
                        }
                        case R.id.respost4: {
                            Res="res3";
                            break;
                        }

                    }

                }


            });
        }

        return Res;
    }
}
