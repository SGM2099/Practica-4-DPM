package mx.unam.fciencias.materialdesign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

public class SettingsActivity extends MainMenuActivity
    implements SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportFragmentManager().beginTransaction().add(
                android.R.id.content, new SettingsFragment()
        ).commit();

    }

    @Override
    protected void onResume() {

        super.onResume();

        sharedPreferences.registerOnSharedPreferenceChangeListener(this);

    }

    @Override
    protected void onPause() {

        sharedPreferences.unregisterOnSharedPreferenceChangeListener(this);

        super.onPause();

    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {

        if(! themePreferenceKey.equals(s)) return;

        String selectedPreference = sharedPreferences.getString(s, lightThemeId);

        applyTheme(selectedPreference, true);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.menu_settings) return true;

        return super.onOptionsItemSelected(item);

    }

}