package mx.unam.fciencias.materialdesign;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class DetailActivity extends MainMenuActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent starIntent = getIntent();
        ActionBar actionBar = getSupportActionBar();
        String detailFragmentTitle = null;
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(starIntent.getStringExtra(ENTRY_MESSAGE_KEY));
        } else {
            detailFragmentTitle = starIntent.getStringExtra(ENTRY_MESSAGE_KEY);
        }
        Bundle detailFragmentArgs = new Bundle();
        detailFragmentArgs.putInt(DetailsFragment.INDEX_KEY,
                startIntent.getIntExtra(DetailsFragment.INDEX_KEY, -1));
        detailFragmentArgs.putInt(DetailsFragment.MASTER_LIST_SIZE_KEY,
                startIntent.getIntExtra(DetailsFragment.MASTER_LIST_SIZE_KEY, -1));
        DetailsFragment detailsFragment = new DetailsFragment();
        detailsFragment.setArguments(detailFragmentArgs);
        getSupportFragmentManager().beginTransaction().add(
                R.id.color_detail_holder, detailsFragment).commit();
    }
}