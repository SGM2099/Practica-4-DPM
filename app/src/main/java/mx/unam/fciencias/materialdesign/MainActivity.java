package mx.unam.fciencias.materialdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.launch_second_activity);
        button.setOnClickListener(this::launchSecondActivity);
    }

    public void launchSecondActivity(View button){
        startActivity(new Intent(this, SecondActivity.class));
    }

}