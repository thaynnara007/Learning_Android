package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editAlcoholPrice, editGasolinePrice;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAlcoholPrice = findViewById(R.id.inputAlcohol);
        editGasolinePrice = findViewById(R.id.inputGasoline);
        textResult = findViewById(R.id.textResult);
    }

    public void calculate(View view){
        String alcoholPrice = editAlcoholPrice.getText().toString();
        String gasolinePrice = editGasolinePrice.getText().toString();

        Boolean allFieldsFilled = validatedFields(alcoholPrice, gasolinePrice);

        if (allFieldsFilled) {
            String result = getBetterOption(alcoholPrice, gasolinePrice);
            textResult.setText(result);
        }
        else textResult.setText("Preencha todos os campos primeiro");
    }

    private String getBetterOption(String alcoholPrice, String gasolinePrice){

        Double alcoholValue = Double.parseDouble(alcoholPrice);
        Double gasolineValue = Double.parseDouble(gasolinePrice);
        Double result = (alcoholValue / gasolineValue);
        String resultText ;

        if ( result >= 0.7) resultText = "É melhor usar a gasolina.";
        else resultText = "É melhor usar o álcool.";

        return resultText;
    }

    private Boolean validatedFields(String alcoholPrice, String gasolinePrice){
        Boolean validated = true;

        if (alcoholPrice == null || alcoholPrice.equals("")) validated = false;
        else if (gasolinePrice == null || gasolinePrice.equals("")) validated = false;

        return validated;
    }
}
