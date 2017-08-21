package com.example.admin.descubra;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class QuestionsActivity extends AppCompatActivity {

    private Button btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);



        btnConfirm=(Button)findViewById(R.id.btn_click);


        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup rg=(RadioGroup)findViewById(R.id.questions);
                int verifyRadio = rg.getCheckedRadioButtonId();
                switch (verifyRadio){

                    case R.id.respost1:{

                        Intent intent = new Intent(QuestionsActivity.this, ResultActivity.class);
                        intent.putExtra("validation", "A");
                        startActivity(intent);
                        break;
                    }
                    case R.id.respost2:{
                        Intent intent = new Intent(QuestionsActivity.this, ResultActivity.class);
                        intent.putExtra("validation", "B");
                        startActivity(intent);
                        break;
                    }
                    case R.id.respost3:{
                        Intent intent = new Intent(QuestionsActivity.this, ResultActivity.class);
                        intent.putExtra("validation", "C");
                        startActivity(intent);
                        break;
                    }
                    case R.id.respost4:{
                        Intent intent = new Intent(QuestionsActivity.this, ResultActivity.class);
                        intent.putExtra("validation", "D");
                        startActivity(intent);

                        break;
                    }

                }

            }
        });


    }
}
