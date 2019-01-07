package com.example.kylo.acm_app;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kylo.acm_app.model.mlh.Event;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>{

    //List of hackathons
    private List<Event> mHackathons;
    private Context mContext;

    public RecyclerAdapter(List<Event> hackathons, Context context) {
        this.mHackathons = hackathons;
        this.mContext = context;
    }


    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hackathon_item,viewGroup,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder recyclerViewHolder, int i) {
        recyclerViewHolder.bind(i);
    }


    @Override
    public int getItemCount() {
        return mHackathons.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView mEventName;
        TextView mEventDescription;
        TextView mEventStart;
        TextView mEventEnd;
        TextView mEventCreated;
        public RecyclerViewHolder(View itemView){
            super(itemView);
            mEventName = (TextView) itemView.findViewById(R.id.event_name);
            mEventDescription = (TextView) itemView.findViewById(R.id.event_description);
            mEventStart = (TextView) itemView.findViewById(R.id.event_start);
            mEventEnd = (TextView) itemView.findViewById(R.id.event_end);
            mEventCreated = (TextView) itemView.findViewById(R.id.event_created);
        }

        void bind(final int position){
            mEventName.setText(mHackathons.get(position).getName());
            mEventDescription.setText(mHackathons.get(position).getEndDate());
            mEventStart.setText(mHackathons.get(position).getImageUrl());
            mEventEnd.setText(mHackathons.get(position).getLocation());
            mEventCreated.setText(mHackathons.get(position).getStartDate());
        }

        @Override
        public void onClick(View view) {
//            String urlString = mNews.get(getAdapterPosition()).getUrl();
//            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlString));
//            mContext.startActivity(browserIntent);
        }

    }
}
