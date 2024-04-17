package com.example.fridgemobile;

import android.content.Context;
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

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CheckBox cb = new CheckBox(context);
        cb.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return new ViewHolder(cb);
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

        ViewHolder(CheckBox checkBox) {
            super(checkBox);
            this.checkBox = checkBox;
        }
    }
}
