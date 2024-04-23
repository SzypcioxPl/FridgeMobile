package com.example.fridgemobile;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @GET("ingredients")
    Call<List<String>> getIngredients();

    @POST("addIngredients")
    Call<Void> addIngredients(@Body List<String> ingredients);
    @GET("recipes/match")
    Call<List<Recipe>> getMatchedRecipes();


}
