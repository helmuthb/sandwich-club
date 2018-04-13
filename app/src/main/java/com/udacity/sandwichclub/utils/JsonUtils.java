package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();
        try {
            JSONObject sandwichJson = new JSONObject(json);
            JSONObject name = sandwichJson.getJSONObject("name");
            sandwich.setMainName(name.getString("mainName"));
            sandwich.setPlaceOfOrigin(sandwichJson.getString("placeOfOrigin"));
            sandwich.setDescription(sandwichJson.getString("description"));
            sandwich.setImage(sandwichJson.getString("image"));
            JSONArray akaJson = name.getJSONArray("alsoKnownAs");
            List<String> aka = new ArrayList<String>(akaJson.length());
            for (int i=0; i<akaJson.length(); i++) {
                aka.add(akaJson.getString(i));
            }
            sandwich.setAlsoKnownAs(aka);
            JSONArray ingredientsJson = sandwichJson.getJSONArray("ingredients");
            List<String> ingredients = new ArrayList<String>(ingredientsJson.length());
            for (int i=0; i<ingredientsJson.length(); i++) {
                ingredients.add(ingredientsJson.getString(i));
            }
            sandwich.setIngredients(ingredients);
        }
        catch (JSONException e) {
            // return what was achieved so far
        }
        return sandwich;
    }
}
