package mx.unam.fciencias.materialdesign;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends MainMenuActivity {

    InfiniteListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {

            actionBar.setDisplayHomeAsUpEnabled(true);

        }



        setContentView(R.layout.activity_second);
        Button button = findViewById(R.id.add_to_list_button);
        button.setOnClickListener(this::addListElement);
        RecyclerView infiniteList = findViewById(R.id.infinite_list);
        infiniteList.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        infiniteList.setLayoutManager(layoutManager);
        listAdapter = new InfiniteListAdapter(getResources());
        addListElement(null);
        infiniteList.setAdapter(listAdapter);

    }

    public void addListElement(View button){
        listAdapter.addItem();
    }

}