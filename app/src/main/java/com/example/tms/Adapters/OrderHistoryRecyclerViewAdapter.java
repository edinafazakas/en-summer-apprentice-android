package com.example.tms.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tms.Models.OrderModel;
import com.example.tms.R;

import java.util.ArrayList;
import java.util.List;

public class OrderHistoryRecyclerViewAdapter extends  RecyclerView.Adapter<OrderHistoryRecyclerViewAdapter.ViewHolder>{
    List<OrderModel> orderModels = new ArrayList<>();
    OrderHistoryRecyclerViewAdapter.OnClickListener onClickListener;

    public OrderHistoryRecyclerViewAdapter(List<OrderModel> orderModels) {
        this.orderModels = orderModels;
    }

    @NonNull
    @Override
    public OrderHistoryRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cardView = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_card, parent,false);
        return new ViewHolder(cardView);

    }

    @Override
    public void onBindViewHolder(@NonNull OrderHistoryRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.orderID.setText(orderModels.get(position).getOrderID());
        holder.totalPrice.setText(orderModels.get(position).getTotalPrice());
        Glide.with(holder.imageView).load(orderModels.get(position).getUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return orderModels.size();
    }


    public interface OnClickListener {
        void onClick(int position, OrderModel model);
    }


    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView orderID, totalPrice;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            orderID = itemView.findViewById(R.id.order_id);
            totalPrice = itemView.findViewById(R.id.totalPrice);
            imageView = itemView.findViewById(R.id.card_image_order);
            imageView.setOnClickListener(this);
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
