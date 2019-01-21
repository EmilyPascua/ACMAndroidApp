package com.example.kylo.acm_app.fragment;


import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kylo.acm_app.R;
import com.example.kylo.acm_app.RecyclerHackathons;
import com.example.kylo.acm_app.api.ApiClient;
import com.example.kylo.acm_app.api.ApiInterface;
import com.example.kylo.acm_app.model.mlh.Event;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class ResourceFragment extends Fragment {

    private List<Event> hackathons;
    private RecyclerView recyclerView;
    private RecyclerHackathons recyclerAdapter;
    private CollapsingToolbarLayout collapsingToolbar;

    public ResourceFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_resource, container, false);
        recyclerView = rootView.findViewById(R.id.hackathons_recycler);

        getActivity().setTitle("");
        collapsingToolbar = (CollapsingToolbarLayout) rootView.findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("Hackathons");

        LoadJson(container);

        return rootView;
    }

    public void LoadJson(final ViewGroup container){
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<List<Event>> call;
        call = apiInterface.getEvents();

        call.enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                hackathons = filterEvents(response.body());
                recyclerAdapter = new RecyclerHackathons(hackathons, container.getContext());
                recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
                recyclerView.setAdapter(recyclerAdapter);
                recyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {

            }
        });
    }

    public List<Event> filterEvents(final List<Event> allEvents){
        List<Event> caEvents = new ArrayList<>();
        for(int i = 0; i < allEvents.size(); i++){
            //Filter California Events
            if(allEvents.get(i).getLocation().contains("CA")){
                caEvents.add(allEvents.get(i));
            }
        }
        return caEvents;

    }

}
