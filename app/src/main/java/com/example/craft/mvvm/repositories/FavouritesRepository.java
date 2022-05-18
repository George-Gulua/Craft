package com.example.craft.mvvm.repositories;


import com.example.craft.R;
import com.example.craft.mvvm.models.Favourites;

import java.util.ArrayList;
import java.util.Collections;

public class FavouritesRepository {
    ArrayList<Favourites> holder;

    public FavouritesRepository() {
        holder = new ArrayList<>();

        Favourites n1 = new Favourites(R.drawable.club_vyz, "Клуб вязания и шитья. Здесь вас научат вязать...");
        holder.add(n1);

        Favourites n2 = new Favourites(R.drawable.club_vyz, "Клуб вязания и шитья. Здесь вас научат вязать...");
        holder.add(n2);



    }

    public ArrayList<Favourites> getHolder() {
        Collections.reverse(holder);
        return holder;
    }
}
