package com.example.kylo.acm_app;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kylo.acm_app.api.ApiClient;
import com.example.kylo.acm_app.api.ApiInterface;
import com.example.kylo.acm_app.model.eventbrite.Events;
import com.example.kylo.acm_app.model.eventbrite.Search;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class ResourceFragment extends Fragment {

    private TextView textResult;
    private List<Events> hackathons;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter recyclerAdapter;

    public ResourceFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_resource, container, false);
        recyclerView = rootView.findViewById(R.id.hackathons_recycler);

        LoadJson(container);

        return rootView;
    }

    public void LoadJson(final ViewGroup container){
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        String query = "hackathon";
        String sortBy = "best";
        String apiKey = "D3KDL4YXCVE33DW4K2T2";

        Call<Search> call;
        call = apiInterface.getEvents(query, sortBy, apiKey);

        call.enqueue(new Callback<Search>() {
            @Override
            public void onResponse(Call<Search> call, Response<Search> response) {
                hackathons = response.body().getEvents();
                recyclerAdapter = new RecyclerAdapter(hackathons, container.getContext());
                recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
                recyclerView.setAdapter(recyclerAdapter);
                recyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Search> call, Throwable t) {

            }
        });
    }

}
