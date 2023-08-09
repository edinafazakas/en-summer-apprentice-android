package com.example.tms.Activities;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.tms.Adapters.EventRecyclerViewAdapter;
import com.example.tms.Adapters.OrderDetailsViewAdapter;
import com.example.tms.R;
import com.example.tms.Repositories.EventRepo;
import com.example.tms.Repositories.OrderRepo;

public class OrderDetails extends AppCompatActivity {
    OrderDetailsViewAdapter orderDetailsViewAdapter;
    CardView cardView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_details);
        //cardView = findViewById(R.id.order_details_cardview);
        initCardView();
    }

    void initCardView(){
        orderDetailsViewAdapter = new OrderDetailsViewAdapter(OrderRepo.getOrderRepo().getOrderModelsList());
        //cardView.set
    }

}
