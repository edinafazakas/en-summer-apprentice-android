package com.example.tms;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit;
    public static Retrofit getRetrofit(){
        Gson gson = new GsonBuilder()
                .setLenient().create();
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://10.0.2.2:7068//api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }
}
