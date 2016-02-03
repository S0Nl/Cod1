package com.example.yorik.gotonextactivity2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NameActivity extends Activity implements OnClickListener {

    EditText etName;
    TextView textView;
    Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name);

        etName = (EditText) findViewById(R.id.etName);
        textView = (TextView) findViewById(R.id.textView);
        btnOK = (Button) findViewById(R.id.btnOK);
        btnOK.setOnClickListener(this);

        Intent intent = getIntent();
        String question = intent.getStringExtra("question"); // получаем интент
        textView.setText(question); // формируем строку вывода

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("name", etName.getText().toString());
        setResult(RESULT_OK, intent);
        finish();

        Toast toast = Toast.makeText(getApplicationContext(), "Good", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

    }
}