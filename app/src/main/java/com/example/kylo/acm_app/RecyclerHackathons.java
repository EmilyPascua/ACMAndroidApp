package com.example.kylo.acm_app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kylo.acm_app.model.mlh.Event;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerHackathons extends RecyclerView.Adapter<RecyclerHackathons.RecyclerViewHolder>{

    //List of hackathons
    private List<Event> mHackathons;
    private Context mContext;

    public RecyclerHackathons(List<Event> hackathons, Context context) {
        this.mHackathons = hackathons;
        this.mContext = context;
    }


    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.full_item,viewGroup,false);
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

        ImageView mEventImage;
        TextView mEventLocation;
        TextView mEventStart;
        TextView mEventName;
        TextView mEventTimeRange;

        public RecyclerViewHolder(View itemView){
            super(itemView);
            mEventImage = (ImageView) itemView.findViewById(R.id.image_url);
            mEventLocation = (TextView) itemView.findViewById(R.id.subtitle);
            mEventStart = (TextView) itemView.findViewById(R.id.date);
            mEventName = (TextView) itemView.findViewById(R.id.title);
            mEventTimeRange = (TextView) itemView.findViewById(R.id.description);


        }

        void bind(final int position){
            Picasso.with(mContext).load(mHackathons.get(position).getImageUrl()).into(mEventImage);
            mEventLocation.setText(mHackathons.get(position).getLocation());
            mEventStart.setText(mHackathons.get(position).getStartDate());
            mEventName.setText(mHackathons.get(position).getName());
            mEventTimeRange.setText(mHackathons.get(position).getStartDate() + " - " + mHackathons.get(position).getEndDate());
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            String urlString = mHackathons.get(getAdapterPosition()).getUrl();
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlString));
            mContext.startActivity(browserIntent);
        }

    }
}
