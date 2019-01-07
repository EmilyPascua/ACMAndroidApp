package com.example.kylo.acm_app;


import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.kylo.acm_app.api.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class ResourceFragment extends Fragment {

    TextView textResult;

    public ResourceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_resource, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.hackathons_recycler);
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter();
        recyclerView.setAdapter(recyclerAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

//        // Inflate the layout for this fragment
//        View rootView = inflater.inflate(R.layout.fragment_resource, container, false);
//        textResult = (TextView) rootView.findViewById(R.id.stuff);
//
//        //Replace this later with strings
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://www.eventbriteapi.com")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        ApiInterface eventbriteApi = retrofit.create(ApiInterface.class);
//
//        Call<List<Hackathon>> call = eventbriteApi.getPost();
//
//        call.enqueue(new Callback<List<Hackathon>>() {
//            @Override
//            public void onResponse(Call<List<Hackathon>> call, Response<List<Hackathon>> response) {
//                if(!response.isSuccessful()){
//                    textResult.setText("Hello");
//                    return;
//                }
//
//                List<Hackathon> posts = response.body();
//
//                for(Hackathon post : posts){
//                    String content = "";
//                    content += "id: " + post.getId() + "\n";
//
//                    textResult.append(content);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Hackathon>> call, Throwable t) {
//                textResult.setText(t.getMessage());
//            }
//        });
//
//        return rootView;
        return null;
    }

}
