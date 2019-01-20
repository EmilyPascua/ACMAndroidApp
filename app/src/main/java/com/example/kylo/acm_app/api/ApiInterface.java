package com.example.kylo.acm_app.api;

import com.example.kylo.acm_app.model.mlh.Event;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("na-2019")
    Call<List<Event>> getEvents();
}


