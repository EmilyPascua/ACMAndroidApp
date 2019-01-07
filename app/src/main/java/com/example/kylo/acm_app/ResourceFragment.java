package com.example.kylo.acm_app;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kylo.acm_app.api.EventbriteApi;
import com.example.kylo.acm_app.model.Hackathon;

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
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_resource, container, false);
        textResult = (TextView) rootView.findViewById(R.id.stuff);

        //Replace this later with strings
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EventbriteApi eventbriteApi = retrofit.create(EventbriteApi.class);

        Call<List<Hackathon>> call = eventbriteApi.getPost();

        call.enqueue(new Callback<List<Hackathon>>() {
            @Override
            public void onResponse(Call<List<Hackathon>> call, Response<List<Hackathon>> response) {
                if(!response.isSuccessful()){
                    textResult.setText("Code: " + response.code());
                    return;
                }

                List<Hackathon> posts = response.body();

                for(Hackathon post : posts){
                    String content = "";
                    content += "ID: " + post.getId() + "\n";
                    content += "User ID: " + post.getUserId() + "\n";
                    content += "Title: " + post.getTitle() + "\n";
                    content += "Text: " + post.getText() + "\n\n";

                    textResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Hackathon>> call, Throwable t) {
                textResult.setText(t.getMessage());
            }
        });

        return rootView;
    }

}
