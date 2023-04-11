package mx.unam.fciencias.materialdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends MainMenuActivity {

    private Button launchSecondActivityButton;
    private String sharedViewTransitionName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
        launchSecondActivityButton = findViewById(R.id.launch_second_activity);
        launchSecondActivityButton.setOnClickListener(this::launchSecondActivity);
    }

    public void launchSecondActivity(View button){

        Intent intent = new Intent(this, SecondActivity.class);

        if (sharedViewTransitionName != null){

            sharedViewTransitionName = getString(R.string.shared_button_transitionName);

        }

        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                launchSecondActivityButton, sharedViewTransitionName);

        resultLauncher.launch(intent, optionsCompat);
    }

}