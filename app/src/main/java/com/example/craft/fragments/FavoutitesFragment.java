package com.example.craft.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.craft.R;
import com.example.craft.adapters.FavouritesAdapter;
import com.example.craft.mvvm.models.Favourites;
import com.example.craft.mvvm.viewModel.FavouritesViewModel;

import java.util.ArrayList;


public class FavoutitesFragment extends Fragment {

    FavouritesAdapter adapter;
    FavouritesViewModel newsViewModel;
    RecyclerView rcv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favoutites, container, false);

        newsViewModel = new ViewModelProvider(this).get(FavouritesViewModel.class);
        final Observer<ArrayList<Favourites>> nameObserver = new Observer<ArrayList<Favourites>>() {
            @Override
            public void onChanged(@Nullable final ArrayList<Favourites> news) {
                adapter = new FavouritesAdapter(news,requireContext());
                rcv.setAdapter(adapter);
            }
        };
        rcv = view.findViewById(R.id.favouritesRecycler);

        newsViewModel.getCurrentName().observe(getViewLifecycleOwner(), nameObserver);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),1);
        rcv.setLayoutManager(gridLayoutManager);

        return view;
    }
}