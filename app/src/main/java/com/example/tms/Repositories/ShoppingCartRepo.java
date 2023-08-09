package com.example.tms.Repositories;

import com.example.tms.Models.OrderModel;
import com.example.tms.Models.ShoppingCartModel;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartRepo {
    private static ShoppingCartRepo shoppingCartRepo;
    List<ShoppingCartModel> shoppingCartModels = new ArrayList<>();

    public ShoppingCartRepo(){
        shoppingCartModels.add(new ShoppingCartModel("Untold", "Standard", "2", "1800€"));
        shoppingCartModels.add(new ShoppingCartModel("Wine Festival", "Standard", "3", "2400€"));
        shoppingCartModels.add(new ShoppingCartModel("Soccer game", "VIP", "1", "700€"));
    }

    public static ShoppingCartRepo getShoppingCartRepo(){
        if(shoppingCartRepo == null){
            shoppingCartRepo = new ShoppingCartRepo();
        }
        return shoppingCartRepo;
    }

    public List<ShoppingCartModel> getShoppingCartModels(){
        return shoppingCartModels;
    }
}
