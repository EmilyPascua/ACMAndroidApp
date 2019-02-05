package com.example.kylo.acm_app.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
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
import com.example.kylo.acm_app.model.Announcement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

/* firebase imports */
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnnounceFragment extends Fragment {
    //firebase variable
    final private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference mDatabaseReference;

    private RecyclerView recyclerView;
    private CollapsingToolbarLayout collapsingToolbar;

    private RecyclerAnnouncement mAnnouncementAdapter;
    private List<Announcement> mAnnouncements;

    public AnnounceFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mAnnouncements = new ArrayList<>();

        View rootView = inflater.inflate(R.layout.fragment_announce, container, false);
        recyclerView = rootView.findViewById(R.id.announcement_recycler);
        mAnnouncementAdapter = new RecyclerAnnouncement(mAnnouncements,container.getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
        recyclerView.setAdapter(mAnnouncementAdapter);
        getActivity().setTitle("");

        collapsingToolbar = (CollapsingToolbarLayout) rootView.findViewById(R.id.collapsing_toolbar2);
        collapsingToolbar.setTitle("Announcements");

//        LoadData(container);
        retrieveData();
        return rootView;
    }

    public void retrieveData() {
        //gets a reference to the database
        mDatabaseReference = database.getReference();

        //queries specific location on database
        Query query = mDatabaseReference.child(getString(R.string.announcements));
        //attaches a listener
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot singleSnapshot : dataSnapshot.getChildren()) {
                    Announcement announcement = new Announcement();

                    Map<String, Object> firebaseAnnouncements = (HashMap<String, Object>) singleSnapshot.getValue();

                    announcement.setTitle(firebaseAnnouncements.get(getString(R.string.announcements_title)).toString());
                    announcement.setAuthor(firebaseAnnouncements.get(getString(R.string.announcements_author)).toString());
                    announcement.setMessage(firebaseAnnouncements.get(getString(R.string.announcements_message)).toString());
                    announcement.setImage(firebaseAnnouncements.get(getString(R.string.announcements_image)).toString());
                    announcement.setDate(firebaseAnnouncements.get(getString(R.string.announcements_date)).toString());

                    mAnnouncements.add(announcement);
                }

                if (mAnnouncements.size() != 0 && mAnnouncements != null) {
                    Log.d("anouncements:","not empty");
                    mAnnouncementAdapter.setAnnouncements(mAnnouncements);
                }else{
                    Log.d("Announcements: ", "Announcements are empty");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Do Nothing
            }
        });
    }
}
