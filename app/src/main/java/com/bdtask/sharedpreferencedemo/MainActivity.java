package com.bdtask.sharedpreferencedemo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText input;
    Button saveButton;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        textView       = findViewById(R.id.text);
        input          = findViewById(R.id.input);
        saveButton     = findViewById(R.id.save);


        sharedPreferences = getSharedPreferences("com.bdtask.sharedpreferencedemo",MODE_PRIVATE);
        editor            = sharedPreferences.edit();


      String previousText  = sharedPreferences.getString("text","");
        if (!previousText.isEmpty()){
            textView.setText(previousText);
        }



        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (input.getText().toString().isEmpty()){

                }else {
                    textView.setText(input.getText().toString());
                    editor.putString("text",input.getText().toString());
                    editor.apply();
                }
            }
        });



    }
}
