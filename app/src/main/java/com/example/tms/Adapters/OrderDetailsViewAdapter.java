package com.example.tms.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tms.Models.OrderModel;
import com.example.tms.R;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailsViewAdapter extends  RecyclerView.Adapter<OrderDetailsViewAdapter.ViewHolder>{
    List<OrderModel> orderModels = new ArrayList<>();
    OrderDetailsViewAdapter.OnClickListener onClickListener;

    public OrderDetailsViewAdapter(List<OrderModel> orderModels) {
        this.orderModels = orderModels;
    }

    @NonNull
    @Override
    public OrderDetailsViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cardView = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_details, parent,false);
        return new ViewHolder(cardView);

    }

    @Override
    public void onBindViewHolder(@NonNull OrderDetailsViewAdapter.ViewHolder holder, int position) {
        /*holder.name.setText(eventModels.get(position).getName());
        holder.description.setText(eventModels.get(position).getDescription());
        holder.day.setText(eventModels.get(position).getDay());
        holder.month.setText(eventModels.get(position).getMonth());
        holder.venue.setText(eventModels.get(position).getVenue());*/
        //Glide.with(holder.imageView).load(orderModels.get(position).getUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return orderModels.size();
    }


    public interface OnClickListener {
        void onClick(int position, OrderModel model);
    }


    public void setOnClickListener(OrderDetailsViewAdapter.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView eventName, ticketCategory, numberOfTickets, orderedAt, location, totalPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            eventName = itemView.findViewById(R.id.eventName);
            ticketCategory = itemView.findViewById(R.id.ticketCategory);
            numberOfTickets = itemView.findViewById(R.id.numberOfTickets);
            orderedAt = itemView.findViewById(R.id.orderedAt);
            location = itemView.findViewById(R.id.locationVenue);
            totalPrice = itemView.findViewById(R.id.totalPrice);
        }

        @Override
        public void onClick(View view) {
            if (onClickListener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    OrderModel model = orderModels.get(position);
                    onClickListener.onClick(position, model);
                }
            }
        }


    }
}
