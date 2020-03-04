package com.example.conversorbinario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView buton0;
    TextView buton1;
    TextView clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        buton0 = (TextView) findViewById(R.id.button3);
        buton1 = (TextView) findViewById(R.id.button2);
        clear = (TextView) findViewById((R.id.button4));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String binary = ((TextView) findViewById(R.id.textView2)).getText().toString();
        System.out.println(binary);
        final TextView tvBin = (TextView) findViewById(R.id.textView2);
        int decimal=Integer.parseInt(binary,2);
        final TextView tvDecimal = (TextView)findViewById(R.id.textView3);
        tvDecimal.setText(Integer.toString(decimal));
        System.out.println(decimal);
        buton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                (TextView) ((TextView) findViewById(R.id.textView2)).setText("0");
            }
        });
        buton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvBin.setText(tvBin+"1");
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvBin.setText("");
                tvDecimal.setText("");
            }
        });
    }
}
