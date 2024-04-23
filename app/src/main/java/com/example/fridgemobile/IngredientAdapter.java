package com.example.fridgemobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.recyclerview.widget.RecyclerView;

import java.util.HashSet;
import java.util.List;

public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.ViewHolder> {

    private List<String> ingredients;
    private Context context;
    private HashSet<String> selectedIngredients = new HashSet<>();

    public IngredientAdapter(Context context, List<String> ingredients) {
        this.context = context;
        this.ingredients = ingredients;
    }
    public void clearSelections() {
        selectedIngredients.clear();
        notifyDataSetChanged(); // Powiadom adapter o zmianie, aby odświeżyć widok
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_ingredient, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String ingredient = ingredients.get(position);
        holder.checkBox.setText(ingredient);
        holder.checkBox.setChecked(selectedIngredients.contains(ingredient));
        holder.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                selectedIngredients.add(ingredient);
            } else {
                selectedIngredients.remove(ingredient);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    public HashSet<String> getSelectedIngredients() {
        return selectedIngredients;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;

        ViewHolder(View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.checkbox_ingredient);
        }
    }
}
