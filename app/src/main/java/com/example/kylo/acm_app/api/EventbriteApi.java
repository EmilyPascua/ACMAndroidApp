package com.example.kylo.acm_app.api;

import com.example.kylo.acm_app.model.Hackathon;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EventbriteApi {

    @GET("posts")
    Call<List<Hackathon>> getPost();
}
