package com.example.caraoucoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class ResultActivity extends AppCompatActivity {

    private Button backButton;
    private ImageView image;
    private int[] options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        backButton = findViewById(R.id.buttonBack);
        image = findViewById(R.id.imageId);
        options = new int[2];

        options[0] = R.drawable.moeda_cara;
        options[1] = R.drawable.moeda_coroa;

        int option = this.randomNumber(0,1);

        image.setImageResource(options[option]);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private int randomNumber(int low, int high) {
        Random r = new Random();

        high++;
        int result = r.nextInt(high - low) + low;

        return  result;
    }
}
