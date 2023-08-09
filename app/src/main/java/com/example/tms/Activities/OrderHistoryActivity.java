package com.example.tms.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tms.Adapters.EventRecyclerViewAdapter;
import com.example.tms.Adapters.OrderHistoryRecyclerViewAdapter;
import com.example.tms.Adapters.OrderRecyclerViewAdapter;
import com.example.tms.Models.EventModel;
import com.example.tms.Models.OrderModel;
import com.example.tms.R;
import com.example.tms.Repositories.EventRepo;
import com.example.tms.Repositories.OrderRepo;

public class OrderHistoryActivity extends AppCompatActivity {
    OrderHistoryRecyclerViewAdapter orderHistoryRecyclerViewAdapter;
    RecyclerView recyclerView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_history);
        recyclerView = findViewById(R.id.recyclerViewOrder);
        initRecyclerView();

        orderHistoryRecyclerViewAdapter.setOnClickListener(new OrderHistoryRecyclerViewAdapter.OnClickListener() {
            @Override
            public void onClick(int position, OrderModel model) {
                Intent intent = new Intent(OrderHistoryActivity.this, OrderDetails.class);
                startActivity(intent);
            }
        });
    }

    void initRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        orderHistoryRecyclerViewAdapter = new OrderHistoryRecyclerViewAdapter(OrderRepo.getOrderRepo().getOrderModelsList());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(orderHistoryRecyclerViewAdapter);
    }
}