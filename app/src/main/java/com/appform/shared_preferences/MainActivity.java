package com.appform.shared_preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText entrada;
    Button guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        entrada = findViewById(R.id.input);

        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        entrada.setText(preferences.getString("usuarios", ""));

        guardar = findViewById(R.id.save);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save(view);
            }
        });
    }

    public void save(View view){
        SharedPreferences preference = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor Obj_editor = preference.edit();
        Obj_editor.putString("usuarios", entrada.getText().toString());
        Obj_editor.commit();
        finish();
    }
}