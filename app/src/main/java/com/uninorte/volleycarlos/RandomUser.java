package com.uninorte.volleycarlos;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RandomUser {
    public static Gson g = new Gson();
    public String gender;
    public Name name;
//    public Location location;
    public String email;
//    public Login login;
 //   public Dob dob;
//    public Registered registered;
    public String phone;
    public String cell;
//    public Id id;
 //   public Picture picture;
    public String nat;

    public static ArrayList<RandomUser> getUser(JSONObject response){
        ArrayList<RandomUser> list = new ArrayList<>();
        try {
            JSONArray info = response.getJSONArray("results");
            for (int i = 0; i< info.length(); i++){
                String persona = info.getJSONObject(i).toString();
                RandomUser temp = g.fromJson(persona, RandomUser.class);
                list.add(temp);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        return list;
    }

    public static class Name{
        public String title;
        public String first;
        public String last;

        public Name(){}

        @NonNull
        @Override
        public String toString(){

            return g.toJson(this);
        }

    }
}
