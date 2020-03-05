package com.example.bottomnavigationproject.service;

import com.example.bottomnavigationproject.model.Film;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface FilmService {

    @GET("films")
    Call<ArrayList<Film>> films();

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://ghibliapi.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}

