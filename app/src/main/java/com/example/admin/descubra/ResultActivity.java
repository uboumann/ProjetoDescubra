package com.example.admin.descubra;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        String validation = getIntent().getExtras().getString("validation");
        TextView nameTeam=(TextView)findViewById(R.id.name_team);
        ImageView imageTeam = (ImageView) findViewById(R.id.image_team);

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
    }
}
