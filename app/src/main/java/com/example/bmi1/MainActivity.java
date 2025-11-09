package com.example.bmi1;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity {
    EditText etWight,etHeight;
    Button btnCalculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        connectComponenta();
    }

    private void connectComponenta() {
        etWight = findViewById(R.id.etWeightMain);
        etHeight = findViewById(R.id.etHeightMain);
        btnCalculate = findViewById(R.id.btnCalculateMain);

    }

    public void calculate(View view) {

        String weight = etWight.getText().toString();
        String height = etHeight.getText().toString();


        if(weight.isEmpty() || !TextUtils.isDigitsOnly(weight) || weight.isEmpty() || !TextUtils.isDigitsOnly(weight)) {
            Toast.makeText(this, "CHeck data you entered!", Toast.LENGTH_SHORT).show();
            return;
        }
        double w,h ,bmi;
        w =Double.parseDouble(weight);
        h = Double.parseDouble(height);
        bmi =w /(h*h);

        Toast.makeText(this, "your bmi is :" + bmi, Toast.LENGTH_LONG).show();



    }
}