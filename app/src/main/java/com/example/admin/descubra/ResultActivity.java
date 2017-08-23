package com.example.admin.descubra;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private String validation;
    private TextView nameTeam;
    private ImageView imageTeam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        validation = getIntent().getExtras().getString("validation");
        nameTeam = (TextView)findViewById(R.id.name_team);
        imageTeam = (ImageView) findViewById(R.id.image_team);
        Button btnReset=(Button)findViewById(R.id.btn_reset);

        if (validation != null) {
            Log.e("result", validation);
            switch (validation) {
                case "A":
                    imageTeam.setImageResource(R.drawable.corinthians);
                    nameTeam.setText("Você torce para o Corinthians");
                    break;
                case "B":
                    imageTeam.setImageResource(R.drawable.palmeiras);
                    nameTeam.setText("Você torce para o Palmeiras");
                    break;
                case "C":
                    imageTeam.setImageResource(R.drawable.tricolor);
                    nameTeam.setText("Você torce para o São Paulo");
                    break;
                case "D":
                    imageTeam.setImageResource(R.drawable.santos);
                    nameTeam.setText("Você torce para o Santos");
                    break;
            }
        }
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }


}

