package com.example.tms.Activities;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tms.Adapters.EventRecyclerViewAdapter;
import com.example.tms.Methods.OrderMethods;
import com.example.tms.Models.EventModel;
import com.example.tms.Models.OrderDTOModel;
import com.example.tms.R;
import com.example.tms.Repositories.EventRepo;
import com.example.tms.RetrofitClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Method;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    EventRecyclerViewAdapter eventRecyclerViewAdapter;
    ImageView shoppingCart;
    ImageView orderHistoryIcon;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        orderHistoryIcon = findViewById(R.id.order_history_icon);
        shoppingCart = findViewById(R.id.shopping_cart_icon);
        initRecyclerView();

        eventRecyclerViewAdapter.setOnClickListener(new EventRecyclerViewAdapter.OnClickListener() {
            @Override
            public void onClick(int position, EventModel model) {
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                startActivity(intent);
            }
        });

        shoppingCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShoppingCartActivity.class);
                startActivity(intent);
            }
        });

        orderHistoryIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OrderHistoryActivity.class);
                startActivity(intent);
                OrderMethods orderMethods = RetrofitClient.getRetrofit().create(OrderMethods.class);
                Call<OrderDTOModel> call = orderMethods.getAllOrders();
                call.enqueue(new Callback<OrderDTOModel>() {
                    @Override
                    public void onResponse(Call<OrderDTOModel> call, Response<OrderDTOModel> response) {
                        Log.e(TAG, "onResponse: code: " + response.code());
                    }

                    @Override
                    public void onFailure(Call<OrderDTOModel> call, Throwable t) {
                        Log.e(TAG, "onFailure: " + t.getMessage());
                    }
                });
            }
        });
    }

    void initRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        eventRecyclerViewAdapter = new EventRecyclerViewAdapter(EventRepo.getEventsRepo().getEventModelList());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(eventRecyclerViewAdapter);
    }
}
