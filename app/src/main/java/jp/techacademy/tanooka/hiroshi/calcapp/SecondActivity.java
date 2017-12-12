package jp.techacademy.tanooka.hiroshi.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        Double number1 = intent.getDoubleExtra("Number1", 0);
        Double number2 = intent.getDoubleExtra("Number2", 0);
        Integer operator = intent.getIntExtra("Operator", 0);

        TextView calcResult = (TextView)findViewById(R.id.calcResult);

        // オペレータに応じて計算、結果を表示する
        switch(operator) {
            case R.id.buttonPlus:
                calcResult.setText(String.valueOf(number1 + number2));
                break;
            case R.id.buttonMinus:
                calcResult.setText(String.valueOf(number1 - number2));
                break;
            case R.id.buttonMultiply:
                calcResult.setText(String.valueOf(number1 * number2));
                break;
            case R.id.buttonDivide:
                calcResult.setText(String.valueOf(number1 / number2));
                break;
            default:
                calcResult.setText("Error");
                break;
        }
    }
}
