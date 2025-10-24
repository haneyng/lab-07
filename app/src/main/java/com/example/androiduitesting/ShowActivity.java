package com.example.androiduitesting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class ShowActivity extends AppCompatActivity {

    private TextView instructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_show);

        final Button backButton = findViewById(R.id.button_back);
        backButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        instructions = findViewById(R.id.show_city_text);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // update text
        getSupportFragmentManager().setFragmentResultListener("requestKey", this, (requestKey, bundle) -> {
            String cityName = bundle.getString("bundleKey");
            instructions.setText(cityName);
        });
    }
}