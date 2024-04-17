package com.example.fridgemobile;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private IngredientAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Załadowanie składników z bazy danych (symulacja)
        loadIngredients();

        findViewById(R.id.submit_button).setOnClickListener(view -> submitIngredients());
    }

    private void loadIngredients() {
        // Symulacja ładowania danych
        List<String> ingredients = Arrays.asList("Salt", "Pepper", "Olive oil", "Tomato", "Onion");
        adapter = new IngredientAdapter(this, ingredients);
        recyclerView.setAdapter(adapter);
    }

    private void submitIngredients() {
        HashSet<String> selectedIngredients = adapter.getSelectedIngredients();
        // Logika zapisu do bazy i pobierania przepisów
        // Zamiast tego symulujemy wyświetlenie zaznaczonych składników
        Toast.makeText(this, "Selected Ingredients: " + selectedIngredients, Toast.LENGTH_LONG).show();
    }
}
