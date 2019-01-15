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
public class AnnounceFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerAnnouncement recyclerAdapter;
    private CollapsingToolbarLayout collapsingToolbar;

    public AnnounceFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_announce, container, false);
        recyclerView = rootView.findViewById(R.id.announcement_recycler);

        getActivity().setTitle("");
        collapsingToolbar = (CollapsingToolbarLayout) rootView.findViewById(R.id.collapsing_toolbar2);
        collapsingToolbar.setTitle("Announcements");

        LoadData(container);

        return rootView;
    }

    public void LoadData(final ViewGroup container){
        List<Announcement> hackathons = new ArrayList<>();

        String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam cursus pulvinar orci at hendrerit. Suspendisse cursus est a quam porta, vitae faucibus lectus varius. Aliquam ipsum mi, blandit id rhoncus ac, tempus aliquam dui. Phasellus quis consequat nibh, ut commodo sem. ";

        Announcement announcement1 = new Announcement("Venom Fundraiser", "Wilson Thomas", lorem, "https://i.ytimg.com/vi/xLCn88bfW1o/maxresdefault.jpg", "January 15, 1997");
        Announcement announcement2 = new Announcement("Welcome to ACM", "Emily Pascua", lorem, "https://www.acm.org/binaries/content/gallery/acm/ctas/ambassadors-for-acm.jpg/ambassadors-for-acm.jpg", "January 15, 1997");
        Announcement announcement3 = new Announcement("Changes to Leaders", "Emily Pascua", lorem, "https://i.ytimg.com/vi/xLCn88bfW1o/maxresdefault.jpg", "January 15, 1997");
        Announcement announcement4 = new Announcement("Meeting 10", "Wilson Thomas", lorem, "https://i.ytimg.com/vi/xLCn88bfW1o/maxresdefault.jpg", "January 15, 1997");
        Announcement announcement5 = new Announcement("Regarding the Website", "Ryan Dunning", lorem, "https://i.ytimg.com/vi/xLCn88bfW1o/maxresdefault.jpg", "January 15, 1997");
        Announcement announcement6 = new Announcement("Game Development", "Ingelbert Figueroa", lorem, "https://i.ytimg.com/vi/xLCn88bfW1o/maxresdefault.jpg", "January 15, 1997");
        Announcement announcement7 = new Announcement("Game Dev. Project", "Ingelbert Figueroa", lorem, "https://i.ytimg.com/vi/xLCn88bfW1o/maxresdefault.jpg", "January 15, 1997");
        Announcement announcement8 = new Announcement("Designing a Website", "Deric Kwok", lorem, "https://i.ytimg.com/vi/xLCn88bfW1o/maxresdefault.jpg", "January 15, 1997");
        Announcement announcement9 = new Announcement("B.S.A.A.", "Chris Redfield", lorem, "https://i.ytimg.com/vi/xLCn88bfW1o/maxresdefault.jpg", "January 15, 1997");
        Announcement announcement10 = new Announcement("Resident Evil", "Chris Refield", lorem, "https://i.ytimg.com/vi/xLCn88bfW1o/maxresdefault.jpg", "January 15, 1997");
        Announcement announcement11 = new Announcement("Running out of News", "Albert Wesker", lorem, "https://i.ytimg.com/vi/xLCn88bfW1o/maxresdefault.jpg", "January 15, 1997");

        hackathons.add(announcement1);
        hackathons.add(announcement2);
        hackathons.add(announcement3);
        hackathons.add(announcement4);
        hackathons.add(announcement5);
        hackathons.add(announcement6);
        hackathons.add(announcement7);
        hackathons.add(announcement8);
        hackathons.add(announcement9);
        hackathons.add(announcement10);
        hackathons.add(announcement11);

        Log.e("Size", "size is: " +hackathons.size());

        recyclerAdapter = new RecyclerAnnouncement(hackathons, container.getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
        recyclerView.setAdapter(recyclerAdapter);
        recyclerAdapter.notifyDataSetChanged();
    }

    public List<Announcement> createData(){
        List<Announcement> data = new ArrayList<>();

        String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam cursus pulvinar orci at hendrerit. Suspendisse cursus est a quam porta, vitae faucibus lectus varius. Aliquam ipsum mi, blandit id rhoncus ac, tempus aliquam dui. Phasellus quis consequat nibh, ut commodo sem. ";

        Announcement announcement1 = new Announcement("Venom Fundraiser", "Wilson Thomas", lorem, "https://i.ytimg.com/vi/xLCn88bfW1o/maxresdefault.jpg", "January 15, 1997");
        Announcement announcement2 = new Announcement("Welcome to ACM", "Emily Pascua", lorem, "https://www.acm.org/binaries/content/gallery/acm/ctas/ambassadors-for-acm.jpg/ambassadors-for-acm.jpg", "January 15, 1997");
        Announcement announcement3 = new Announcement("Changes to Leaders", "Emily Pascua", lorem, "https://i.ytimg.com/vi/xLCn88bfW1o/maxresdefault.jpg", "January 15, 1997");
        Announcement announcement4 = new Announcement("Meeting 10", "Wilson Thomas", lorem, "https://i.ytimg.com/vi/xLCn88bfW1o/maxresdefault.jpg", "January 15, 1997");
        Announcement announcement5 = new Announcement("Regarding the Website", "Ryan Dunning", lorem, "https://i.ytimg.com/vi/xLCn88bfW1o/maxresdefault.jpg", "January 15, 1997");
        Announcement announcement6 = new Announcement("Game Development", "Ingelbert Figueroa", lorem, "https://i.ytimg.com/vi/xLCn88bfW1o/maxresdefault.jpg", "January 15, 1997");
        Announcement announcement7 = new Announcement("Game Dev. Project", "Ingelbert Figueroa", lorem, "https://i.ytimg.com/vi/xLCn88bfW1o/maxresdefault.jpg", "January 15, 1997");
        Announcement announcement8 = new Announcement("Designing a Website", "Deric Kwok", lorem, "https://i.ytimg.com/vi/xLCn88bfW1o/maxresdefault.jpg", "January 15, 1997");
        Announcement announcement9 = new Announcement("B.S.A.A.", "Chris Redfield", lorem, "https://i.ytimg.com/vi/xLCn88bfW1o/maxresdefault.jpg", "January 15, 1997");
        Announcement announcement10 = new Announcement("Resident Evil", "Chris Refield", lorem, "https://i.ytimg.com/vi/xLCn88bfW1o/maxresdefault.jpg", "January 15, 1997");
        Announcement announcement11 = new Announcement("Running out of News", "Albert Wesker", lorem, "https://i.ytimg.com/vi/xLCn88bfW1o/maxresdefault.jpg", "January 15, 1997");

        data.add(announcement1);
        data.add(announcement2);
        data.add(announcement3);
        data.add(announcement4);
        data.add(announcement5);
        data.add(announcement6);
        data.add(announcement7);
        data.add(announcement8);
        data.add(announcement9);
        data.add(announcement10);
        data.add(announcement11);

        return data;

    }

}
