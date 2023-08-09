package com.example.tms.Activities;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tms.Adapters.EventRecyclerViewAdapter;
import com.example.tms.Adapters.ShoppingCartViewAdapter;
import com.example.tms.R;
import com.example.tms.Repositories.EventRepo;
import com.example.tms.Repositories.ShoppingCartRepo;

public class ShoppingCartActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    ShoppingCartViewAdapter shoppingCartViewAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_cart);
        recyclerView = findViewById(R.id.cartRecyclerView);
        initRecyclerView();
    }

    void initRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        shoppingCartViewAdapter = new ShoppingCartViewAdapter(ShoppingCartRepo.getShoppingCartRepo().getShoppingCartModels());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(shoppingCartViewAdapter);
    }
}
