package com.example.tms.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tms.Activities.MainActivity;
import com.example.tms.Activities.OrderActivity;
import com.example.tms.Models.EventModel;
import com.example.tms.R;

import java.util.ArrayList;
import java.util.List;

public class EventRecyclerViewAdapter extends  RecyclerView.Adapter<EventRecyclerViewAdapter.ViewHolder>{
    List<EventModel> eventModels = new ArrayList<>();
    OnClickListener onClickListener;

    public EventRecyclerViewAdapter(List<EventModel> eventModels) {
        this.eventModels = eventModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cardView = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_card, parent,false);
        return new ViewHolder(cardView);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(eventModels.get(position).getName());
        holder.description.setText(eventModels.get(position).getDescription());
        holder.day.setText(eventModels.get(position).getDay());
        holder.month.setText(eventModels.get(position).getMonth());
        holder.venue.setText(eventModels.get(position).getVenue());
        Glide.with(holder.imageView).load(eventModels.get(position).getUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return eventModels.size();
    }


    public interface OnClickListener {
        void onClick(int position, EventModel model);
    }


    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView name, description, day, month, venue;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);
            day = itemView.findViewById(R.id.day);
            month = itemView.findViewById(R.id.month);
            venue = itemView.findViewById(R.id.venue);
            imageView = itemView.findViewById(R.id.card_image);
            imageView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (onClickListener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    EventModel model = eventModels.get(position);
                    onClickListener.onClick(position, model);
                }
            }
        }


    }
}
