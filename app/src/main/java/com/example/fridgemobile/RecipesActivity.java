package com.example.fridgemobile;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fridgemobile.R;
import com.example.fridgemobile.Recipe;
import com.example.fridgemobile.RecipesAdapter;

import java.util.List;

public class RecipesActivity extends AppCompatActivity {

    private RecyclerView recipesRecyclerView;
    private RecipesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        recipesRecyclerView = findViewById(R.id.recipesRecyclerView);
        recipesRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Pobranie przepisów przekazanych do aktywności
        List<Recipe> recipes = (List<Recipe>) getIntent().getSerializableExtra("recipes");

        if (recipes != null) {
            adapter = new RecipesAdapter(recipes);
            recipesRecyclerView.setAdapter(adapter);
        } else {
            Toast.makeText(this, "No recipes to display", Toast.LENGTH_LONG).show();
        }
    }
}
