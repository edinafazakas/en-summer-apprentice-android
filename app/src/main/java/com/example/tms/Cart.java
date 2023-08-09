package com.example.tms;

import android.content.Context;

import com.example.tms.Models.EventModel;

import java.util.List;

public class Cart {
    private Context context;
    //private

    public Cart(Context context){
        this.context = context;
    }

    public void insertEventTicket(EventModel item){
        List<EventModel> eventModels= getCart();
        boolean existAlready = false;
        int n = 0;
        for (int i = 0; i < eventModels.size(); i++){
            if(eventModels.get(i).getName().equals(item.getName())){
                existAlready = true;
                n = i;
                break;
            }
        }

        /*if(existAlready){
            eventModels.get(n).set
        }*/

    }

    private List<EventModel> getCart(){
        return null;
    }
}
