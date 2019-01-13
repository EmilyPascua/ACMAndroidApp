package com.example.kylo.acm_app.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kylo.acm_app.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AnnounceFragment extends Fragment {


    public AnnounceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Announcements");
        return inflater.inflate(R.layout.fragment_announce, container, false);
    }

}
