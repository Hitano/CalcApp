package jp.techacademy.tanooka.hiroshi.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

class MainActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher {

    EditText editText1, editText2;
    Button buttonPlus, buttonMinus, buttonMultiply, buttonDivide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // +, -, *, / のbuttonをセット(初期状態では非アクティブ)
        buttonPlus = (Button)findViewById(R.id.buttonPlus);
        buttonPlus.setOnClickListener(this);
        buttonPlus.setEnabled(false);
        buttonMinus = (Button)findViewById(R.id.buttonMinus);
        buttonMinus.setOnClickListener(this);
        buttonMinus.setEnabled(false);
        buttonMultiply = (Button)findViewById(R.id.buttonMultiply);
        buttonMultiply.setOnClickListener(this);
        buttonMultiply.setEnabled(false);
        buttonDivide = (Button)findViewById(R.id.buttonDivide);
        buttonDivide.setOnClickListener(this);
        buttonDivide.setEnabled(false);

        // 数値入力用editTextをセット
        editText1 = (EditText)findViewById(R.id.editText1);
        editText1.addTextChangedListener(this);
        editText2 = (EditText)findViewById(R.id.editText2);
        editText2.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged (CharSequence s, int start, int count, int after) {
        buttonActivate();
    }

    @Override
    public void onTextChanged (CharSequence s, int start, int before, int after) {
        buttonActivate();
    }

    @Override
    public void afterTextChanged (Editable editInputNumber) {
        buttonActivate();
    }

    // ボタンをアクティブor非アクティブにする
    private void buttonActivate () {
        // 数値が未入力の場合
        if (editText1.length() == 0 || editText2.length() == 0) {
            buttonPlus.setEnabled(false);
            buttonMinus.setEnabled(false);
            buttonMultiply.setEnabled(false);
            buttonDivide.setEnabled(false);
        } else {
            buttonPlus.setEnabled(true);
            buttonMinus.setEnabled(true);
            buttonMultiply.setEnabled(true);
            // 0で除算している場合は/ボタンだけ非アクティブのまま
            if (Double.parseDouble(editText2.getText().toString()) != 0) {
                buttonDivide.setEnabled(true);
            }
        }
    }

    @Override
    public void onClick(View v) {
        // editTextの数値を代入
        Double number1 = Double.parseDouble(editText1.getText().toString());
        Double number2 = Double.parseDouble(editText2.getText().toString());

        Intent intent = new Intent(this, SecondActivity.class);

        // 数値とオペレータを渡す
        intent.putExtra("Number1", number1);
        intent.putExtra("Number2", number2);
        intent.putExtra("Operator", v.getId()); // => (View)R.id.buttonPlus/Minus/Multiply/Divide

        startActivity(intent);
    }
}
