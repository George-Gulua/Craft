package com.example.craft.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.craft.R;
import com.example.craft.mvvm.models.Favourites;

import java.util.ArrayList;

;

public class FavouritesAdapter extends RecyclerView.Adapter<FavouritesAdapter.FavouritesViewHolder> {
    ArrayList<Favourites> data;
    Context context;

    public FavouritesAdapter(ArrayList<Favourites> data, Context context) {
        this.data = data;
        this.context=context;
    }

    @NonNull
    @Override
    public FavouritesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.item_favorites, parent, false);
        return new FavouritesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final FavouritesViewHolder holder, int position) {
        final Favourites temp = data.get(position);

        holder.text.setText(data.get(position).getText());
        holder.img.setImageResource(data.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class FavouritesViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView text, date;
        public FavouritesViewHolder(@NonNull View itemView) {
            super(itemView);
            img=(ImageView)itemView.findViewById(R.id.imageNewsItem);
            text=(TextView)itemView.findViewById(R.id.textNewsItem);
        }
    }

}

