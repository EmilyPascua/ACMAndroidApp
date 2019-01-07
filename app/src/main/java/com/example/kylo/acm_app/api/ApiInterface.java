package com.example.kylo.acm_app.api;

import com.example.kylo.acm_app.model.eventbrite.Events;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {


    @GET("search")
    Call<Events> getEvents(
        @Query("q") String q,
        @Query("sort_by") String sortBy,
        @Query("token") String token
    );
}
