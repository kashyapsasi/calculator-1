package com.example.calculator1;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button buttonadd,buttonsub,buttondivide,buttonmultiply;
    EditText editTextn1,editTextn2;
    TextView textView;
    int num1,num2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        buttonadd=findViewById(R.id.addbtn);
        buttonsub=findViewById(R.id.subbtn);
        buttondivide=findViewById(R.id.dividebtn);
        buttonmultiply=findViewById(R.id.multiplybtn);
        editTextn1=findViewById(R.id.number1);
        editTextn2=findViewById(R.id.number2);
        textView=findViewById(R.id.answer);
        buttonadd.setOnClickListener(this);
        buttonsub.setOnClickListener(this);
        buttondivide.setOnClickListener(this);
        buttonmultiply.setOnClickListener(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public int gettinginteger(EditText editText)
    {
        if(editText.getText().toString().equals("")){
            Toast.makeText(this,"Enter number",Toast.LENGTH_SHORT).show();
            return 0;
        }else
            return Integer.parseInt(editText.getText().toString());

    }


    @Override
    public void onClick(View v) {
        num1=gettinginteger(editTextn1);
        num2=gettinginteger(editTextn2);
        int id = v.getId();
        if (id == R.id.addbtn) {
            textView.setText("Answer = " + (num1 + num2));
        } else if (id == R.id.subbtn) {
            textView.setText("Answer = " + (num1 - num2));
        } else if (id == R.id.dividebtn) {
            textView.setText("Answer = " + ((float) num1 / (float) num2));
        } else if (id == R.id.multiplybtn) {
            textView.setText("Answer = " + (num1 * num2));
        }
    }
}