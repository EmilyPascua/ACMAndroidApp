package com.example.kylo.acm_app.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kylo.acm_app.R;
import com.example.kylo.acm_app.model.Announcement;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AnnouncementAdapter extends RecyclerView.Adapter<AnnouncementAdapter.AnnouncementViewHolder>{
    private List<Announcement> mAnnouncements;
    private LayoutInflater mInflater;
    private Context mContext;

    public AnnouncementAdapter(Context context, List<Announcement> announcements){
        this.mInflater = LayoutInflater.from(context);
        this.mAnnouncements = announcements;
        this.mContext = context;
    }

    @Override
    public AnnouncementViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.announcement_item, parent, false);
        AnnouncementViewHolder viewHolder = new AnnouncementViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AnnouncementAdapter.AnnouncementViewHolder holder, int position) {
        holder.bind(position);

        if (mAnnouncements != null) {
            Announcement currentAnnouncement = mAnnouncements.get(position);
        }
    }

    @Override
    public int getItemCount() {
        if (mAnnouncements != null) {
            return mAnnouncements.size();
        }
        return 0;
    }

    public void setAnnouncements(List<Announcement> announcements){
        this.mAnnouncements = announcements;
        notifyDataSetChanged();
    }

    //view holder class

    public class AnnouncementViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        TextView author;
        TextView message;
        ImageView image;
        TextView date;

        public AnnouncementViewHolder(View itemView) {
            super(itemView);
            this.title = (TextView) itemView.findViewById(R.id.announcement_title);
            this.author = (TextView) itemView.findViewById(R.id.announcement_author);
            this.message = (TextView) itemView.findViewById(R.id.announcement_message);
            this.image = (ImageView) itemView.findViewById(R.id.announcement_image);
            this.date = (TextView) itemView.findViewById(R.id.announcement_date);
        }

        void bind(final int listIndex) {
            Picasso.with(mContext).load(mAnnouncements.get(listIndex).getImage()).into(image);
            title.setText(mAnnouncements.get(listIndex).getTitle());
            author.setText(mAnnouncements.get(listIndex).getAuthor());
            message.setText(mAnnouncements.get(listIndex).getMessage());
            date.setText(mAnnouncements.get(listIndex).getDate());
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent announcementIntent = new Intent(Intent.ACTION_VIEW);
            mContext.startActivity(announcementIntent);
        }
    }
}
