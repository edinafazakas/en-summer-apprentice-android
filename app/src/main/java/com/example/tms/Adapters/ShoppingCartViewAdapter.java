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
import com.example.tms.Models.ShoppingCartModel;
import com.example.tms.R;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartViewAdapter extends  RecyclerView.Adapter<ShoppingCartViewAdapter.ViewHolder>{
    List<ShoppingCartModel> shoppingCartModels = new ArrayList<>();

    public ShoppingCartViewAdapter(List<ShoppingCartModel> shoppingCartModels) {
        this.shoppingCartModels = shoppingCartModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cardView = LayoutInflater.from(parent.getContext()).inflate(R.layout.shoppingcart_item_card, parent,false);
        return new ViewHolder(cardView);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(shoppingCartModels.get(position).getName());
        holder.ticketCategory.setText(shoppingCartModels.get(position).getTicketCategory());
        holder.numberOfTickets.setText(shoppingCartModels.get(position).getNumberOfTickets());
        holder.totalPrice.setText(shoppingCartModels.get(position).getTotalPrice());
    }

    @Override
    public int getItemCount() {
        return shoppingCartModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView name, ticketCategory, numberOfTickets, totalPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameCart);
            ticketCategory = itemView.findViewById(R.id.ticketCategoryCart);
            numberOfTickets = itemView.findViewById(R.id.numberOfTicketsCart);
            totalPrice = itemView.findViewById(R.id.totalPriceCart);
        }
    }
}
