package com.example.scoreboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.AndroidException;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Integer rusPoint=0;
    private Integer gerPoint=0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("rusPoint", rusPoint);
        outState.putInt("gerPoint", gerPoint);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null &&
                savedInstanceState.containsKey("rusPoint")) {
            rusPoint = savedInstanceState.getInt("rusPoint");
        }
        if (savedInstanceState != null &&
                savedInstanceState.containsKey("gerPoint")) {
            gerPoint = savedInstanceState.getInt("gerPoint");
        }
        resetUI();
    }

    private void resetUI() {
        ((TextView) findViewById(R.id.rusPoints)).setText(rusPoint.toString());
        ((TextView) findViewById(R.id.gerPoints)).setText(gerPoint.toString());
    }

    public void addPointRus(View view){
        TextView textViewRus = findViewById(R.id.rusPoints);
        rusPoint++;
        if (rusPoint == 100){
            textViewRus.setText(":З ");
        } else {
            textViewRus.setText(rusPoint.toString());
        }
    }


    public void addPointGer(View view){
        TextView textViewGer = findViewById(R.id.gerPoints);
        gerPoint++;
        if (gerPoint == 100){
            textViewGer.setText(":D");
        } else {
            textViewGer.setText(gerPoint.toString());
        }
    }


    public void reset(View view){
        TextView textViewRus = findViewById(R.id.rusPoints);
        TextView textViewGer = findViewById(R.id.gerPoints);
        rusPoint=0;
        gerPoint=0;
        textViewRus.setText(rusPoint.toString());
        textViewGer.setText(gerPoint.toString());
    }
}