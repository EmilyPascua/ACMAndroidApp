package com.example.kylo.acm_app.fragment;


import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kylo.acm_app.R;
import com.example.kylo.acm_app.RecyclerAnnouncement;
import com.example.kylo.acm_app.api.ApiClient;
import com.example.kylo.acm_app.api.ApiInterface;
import com.example.kylo.acm_app.model.Announcement;
import com.example.kylo.acm_app.model.mlh.Event;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerAnnouncement recyclerAdapter;
    private CollapsingToolbarLayout collapsingToolbar;

    public MainFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_announce, container, false);
        recyclerView = rootView.findViewById(R.id.announcement_recycler);

        getActivity().setTitle("");
        LoadData(container);

        return rootView;
    }

    public void LoadData(final ViewGroup container){
        List<Announcement> hackathons = new ArrayList<>();

        String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam cursus pulvinar orci at hendrerit. Suspendisse cursus est a quam porta, vitae faucibus lectus varius. Aliquam ipsum mi, blandit id rhoncus ac, tempus aliquam dui. Phasellus quis consequat nibh, ut commodo sem. ";

        Announcement announcement9 = new Announcement("B.S.A.A.", "Chris Redfield", lorem, "https://i.ytimg.com/vi/xLCn88bfW1o/maxresdefault.jpg", "January 15, 1997");
        Announcement announcement10 = new Announcement("Resident Evil", "Chris Refield", lorem, "https://i.ytimg.com/vi/xLCn88bfW1o/maxresdefault.jpg", "January 15, 1997");
        Announcement announcement11 = new Announcement("Running out of News", "Albert Wesker", lorem, "https://i.ytimg.com/vi/xLCn88bfW1o/maxresdefault.jpg", "January 15, 1997");

        hackathons.add(announcement9);
        hackathons.add(announcement10);
        hackathons.add(announcement11);

        Log.e("Size", "size is: " +hackathons.size());

        recyclerAdapter = new RecyclerAnnouncement(hackathons, container.getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
        recyclerView.setAdapter(recyclerAdapter);
        recyclerAdapter.notifyDataSetChanged();
    }


}
