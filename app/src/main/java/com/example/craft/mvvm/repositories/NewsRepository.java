package com.example.craft.mvvm.repositories;


import com.example.craft.R;
import com.example.craft.mvvm.models.News;


import java.util.ArrayList;
import java.util.Collections;

public class NewsRepository {
    ArrayList<News> holder;

    public NewsRepository() {
        holder = new ArrayList<>();

        News n1 = new News(R.drawable.club_vyz, "Клуб вязания и шитья. Здесь вас научат вязать...");
        holder.add(n1);

        News n2 = new News(R.drawable.club_vyz, "Клуб вязания и шитья. Здесь вас научат вязать...");
        holder.add(n2);

        News n3 = new News(R.drawable.club_vyz, "Клуб вязания и шитья. Здесь вас научат вязать...");
        holder.add(n3);

        News n4 = new News(R.drawable.club_vyz, "Клуб вязания и шитья. Здесь вас научат вязать...");
        holder.add(n4);

        News n5 = new News(R.drawable.club_vyz, "Клуб вязания и шитья. Здесь вас научат вязать...");
        holder.add(n5);

        News n6 = new News(R.drawable.club_vyz, "Клуб вязания и шитья. Здесь вас научат вязать...");
        holder.add(n6);

        News n7 = new News(R.drawable.club_vyz, "Клуб вязания и шитья. Здесь вас научат вязать...");
        holder.add(n7);

        News n8 = new News(R.drawable.club_vyz, "Клуб вязания и шитья. Здесь вас научат вязать...");
        holder.add(n8);

    }

    public ArrayList<News> getHolder() {
        Collections.reverse(holder);
        return holder;
    }
}
