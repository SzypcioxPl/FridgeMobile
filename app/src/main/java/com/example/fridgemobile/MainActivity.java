package com.example.fridgemobile;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fridgemobile.ApiService;
import com.example.fridgemobile.IngredientAdapter;
import com.example.fridgemobile.R;
import com.example.fridgemobile.RetrofitClient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private IngredientAdapter adapter;
    private Button submitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        submitButton = findViewById(R.id.submit_button);
        submitButton.setOnClickListener(view -> submitIngredients());
        submitButton.setEnabled(false);  // Wyłącz przycisk na początku

        loadIngredients();
    }

    private void loadIngredients() {
        ApiService apiService = RetrofitClient.getRetrofitInstance().create(ApiService.class);
        Call<List<String>> call = apiService.getIngredients();
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    adapter = new IngredientAdapter(MainActivity.this, response.body());
                    recyclerView.setAdapter(adapter);
                    submitButton.setEnabled(true);  // Włączenie przycisku po załadowaniu składników
                } else {
                    Toast.makeText(MainActivity.this, "Failed to load ingredients", Toast.LENGTH_LONG).show();
                }
            }


            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                // Logowanie błędu
                Log.e("MainActivity", "Error connecting to the service", t);
                Toast.makeText(MainActivity.this, "Error connecting to the service: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int totalItemCount = layoutManager.getItemCount();
                int lastVisibleItem = layoutManager.findLastVisibleItemPosition();

                int visibleThreshold = 5;
                if (totalItemCount <= (lastVisibleItem + visibleThreshold)) {
                    // Załaduj więcej danych tutaj
                }
            }
        });

    }


    private void submitIngredients() {
        if (adapter != null) {
            HashSet<String> selectedIngredients = adapter.getSelectedIngredients();
            if (selectedIngredients.isEmpty()) {
                Toast.makeText(this, "No ingredients selected", Toast.LENGTH_SHORT).show();
                return;
            }

            ApiService apiService = RetrofitClient.getRetrofitInstance().create(ApiService.class);
            Call<Void> call = apiService.addIngredients(new ArrayList<>(selectedIngredients));
            call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(MainActivity.this, "Ingredients successfully added to the fridge", Toast.LENGTH_LONG).show();
                        adapter.clearSelections(); // Odznacz wszystkie checkboxy po pomyślnym dodaniu składników

                        // Tutaj wywołujemy getMatchedRecipes, aby pobrać i wyświetlić przepisy
                        getMatchedRecipes();
                    } else {
                        Toast.makeText(MainActivity.this, "Failed to add ingredients", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Log.e("MainActivity", "Error sending ingredients to the API", t);
                    Toast.makeText(MainActivity.this, "Error connecting to the API: " + t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        } else {
            Toast.makeText(this, "Adapter is not initialized", Toast.LENGTH_SHORT).show();
        }
    }


    private void getMatchedRecipes() {
        ApiService apiService = RetrofitClient.getRetrofitInstance().create(ApiService.class);
        Call<List<Recipe>> call = apiService.getMatchedRecipes();
        call.enqueue(new Callback<List<Recipe>>() {
            @Override
            public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Można otworzyć nową Activity z listą przepisów lub użyć DialogFragment do ich wyświetlenia
                    showRecipes(response.body());
                } else {
                    Toast.makeText(MainActivity.this, "Failed to get matched recipes", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Recipe>> call, Throwable t) {
                Log.e("MainActivity", "Error getting matched recipes", t);
                Toast.makeText(MainActivity.this, "Error connecting to the API: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void showRecipes(List<Recipe> recipes) {
        Intent intent = new Intent(this, RecipesActivity.class);
        intent.putExtra("recipes", (Serializable) recipes);
        startActivity(intent);
    }




}
