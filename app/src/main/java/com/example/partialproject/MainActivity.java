package com.example.partialproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView ls;

    String[] animals = {"Lion", "Elephant", "Tiger", "Monkey"};
    ImageButton exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ls=findViewById(R.id.listView);

        exit=findViewById(R.id.btnExit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, animals);
        ls.setAdapter(adapter);

        ls.setOnItemClickListener((adapterView, view, i, l) -> {
            String selectedAnimal = animals[i];
            Toast.makeText(this, "You selected " + selectedAnimal, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MainActivity.this, AnimalDetailActivity.class);
            intent.putExtra("animal", selectedAnimal); // Pass the animal name
            startActivity(intent);
        });

    }
}