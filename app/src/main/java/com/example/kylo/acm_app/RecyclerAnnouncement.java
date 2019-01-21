package com.example.kylo.acm_app;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kylo.acm_app.model.Announcement;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAnnouncement extends RecyclerView.Adapter<RecyclerAnnouncement.RecyclerViewHolder>{

    private List<Announcement> mAnnouncements;
    private Context mContext;

    public RecyclerAnnouncement(List<Announcement> announcements, Context context) {
        this.mAnnouncements = announcements;
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
        return mAnnouncements.size();
    }

    public void setAnnouncements(List<Announcement> announcements){
        this.mAnnouncements = announcements;
        notifyDataSetChanged();
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
            Picasso.with(mContext).load(mAnnouncements.get(position).getImage()).into(mEventImage);
            mEventLocation.setText(mAnnouncements.get(position).getAuthor());
            mEventStart.setText(mAnnouncements.get(position).getDate());
            mEventName.setText(mAnnouncements.get(position).getTitle());
            mEventTimeRange.setText(mAnnouncements.get(position).getMessage());
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }

    }
}
