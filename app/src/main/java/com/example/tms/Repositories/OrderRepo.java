package com.example.tms.Repositories;

import com.example.tms.Models.EventModel;
import com.example.tms.Models.OrderModel;

import java.util.ArrayList;
import java.util.List;

public class OrderRepo {
    private static OrderRepo orderRepo;
    List<OrderModel> orderModels = new ArrayList<>();

    public OrderRepo(){
        orderModels.add(new OrderModel("1", "Standard", "2023-07-09", "2", "2800", "https://png.pngtree.com/png-clipart/20190925/original/pngtree-ticket-icon-vector-illustration-isolated-png-image_4979073.jpg"));
        orderModels.add(new OrderModel("2", "Standard", "2023-04-19", "5", "6000", "https://png.pngtree.com/png-clipart/20190925/original/pngtree-ticket-icon-vector-illustration-isolated-png-image_4979073.jpg"));
        orderModels.add(new OrderModel("3", "Standard", "2023-05-06", "1", "700", "https://png.pngtree.com/png-clipart/20190925/original/pngtree-ticket-icon-vector-illustration-isolated-png-image_4979073.jpg"));
        orderModels.add(new OrderModel("4", "VIP", "2023-07-23", "9", "8030", "https://png.pngtree.com/png-clipart/20190925/original/pngtree-ticket-icon-vector-illustration-isolated-png-image_4979073.jpg"));
    }

    public static OrderRepo getOrderRepo(){
        if(orderRepo == null){
            orderRepo = new OrderRepo();
        }
        return orderRepo;
    }

    public List<OrderModel> getOrderModelsList(){
        return orderModels;
    }
}
