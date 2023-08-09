package com.example.tms.Repositories;

import com.example.tms.Models.EventModel;

import java.util.ArrayList;
import java.util.List;

public class EventRepo {
    private static EventRepo eventRepo;
    List<EventModel> eventModels = new ArrayList<>();

    public EventRepo(){
        eventModels.add(new EventModel("Untold", "Pop music and not only", "3-6", "AUG", "Cluj-Napoca", "https://images.pexels.com/photos/1190298/pexels-photo-1190298.jpeg?cs=srgb&dl=pexels-wendy-wei-1190298.jpg&fm=jpg"));
        eventModels.add(new EventModel("Soccer game", "Exciting match with the friends", "28", "SEP", "Cluj-Napoca", "https://images.mlssoccer.com/image/private/t_q-best/prd-league/nkiijghg8wni2aodsyvb.jpg"));
        eventModels.add(new EventModel("Wine Festival", "Taste the finest wines", "19", "NOV", "Cluj-Napoca", "https://images.ctfassets.net/8x8155mjsjdj/1af9dvSFEPGCzaKvs8XQ5O/a7d4adc8f9573183394ef2853afeb0b6/Copy_of_Red_Wine_Blog_Post_Header.png"));
        eventModels.add(new EventModel("Classical Concert", "Hosted by the Philharmonics of Cluj-Napoca", "2", "DEC", "Cluj-Napoca", "https://images.theconversation.com/files/497498/original/file-20221128-24-3ldy04.jpg?ixlib=rb-1.1.0&rect=7%2C845%2C5071%2C2535&q=45&auto=format&w=1356&h=668&fit=crop"));

    }

    public static EventRepo getEventsRepo(){
        if(eventRepo == null){
            eventRepo = new EventRepo();
        }
        return eventRepo;
    }

    public List<EventModel> getEventModelList(){
        return eventModels;
    }
}
