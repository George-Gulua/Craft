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
import com.example.craft.adapters.NewsAdapter;
import com.example.craft.mvvm.models.News;
import com.example.craft.mvvm.viewModel.NewsViewModel;

import java.util.ArrayList;


public class ChoiceFragment extends Fragment {

    NewsAdapter adapter;
    NewsViewModel newsViewModel;
    RecyclerView rcv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_choice, container, false);

        newsViewModel = new ViewModelProvider(this).get(NewsViewModel.class);
        final Observer<ArrayList<News>> nameObserver = new Observer<ArrayList<News>>() {
            @Override
            public void onChanged(@Nullable final ArrayList<News> news) {
                adapter = new NewsAdapter(news,requireContext());
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