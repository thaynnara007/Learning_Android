package com.example.calculadoragorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editValor;
    private TextView textPercent;
    private TextView textGorjeta;
    private TextView textTotal;
    private SeekBar seekBarGorjeta;

    private double percent = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor = findViewById(R.id.editValor);
        textPercent = findViewById(R.id.textPercent);
        textGorjeta = findViewById(R.id.textGorjeta);
        textTotal = findViewById(R.id.textTotal);
        seekBarGorjeta = findViewById(R.id.seekBarGorjeta);

        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                percent = progress;
                String percentText = Math.round(percent) + "%";

                textPercent.setText(percentText);
                calculate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void showToast(String text){
        Toast.makeText(
                getApplicationContext(),
                text,
                Toast.LENGTH_SHORT
        ).show();
    }

    private void calculate() {
        String value = editValor.getText().toString();

        if (value == null || value.equals(""))
            this.showToast("Digite um valor primeiro!");
        else {
            double valueNum = Double.parseDouble(value);

            double gorjeta = valueNum * (percent / 100);
            textGorjeta.setText("R$ " + gorjeta);

            double total = valueNum + gorjeta;
            textTotal.setText("R$ " + total);
        }
    }
}
