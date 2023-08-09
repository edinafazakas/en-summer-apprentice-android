package com.example.tms.Methods;

import com.example.tms.Models.OrderDTOModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OrderMethods {
    @GET("/Event/GetAll")
    Call<OrderDTOModel> getAllOrders();
}
