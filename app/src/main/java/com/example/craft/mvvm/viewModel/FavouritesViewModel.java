package com.example.craft.mvvm.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.craft.mvvm.models.Favourites;
import com.example.craft.mvvm.repositories.FavouritesRepository;

import java.util.ArrayList;

public class FavouritesViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Favourites>> currentName;

    public MutableLiveData<ArrayList<Favourites>> getCurrentName() {

        if (currentName == null) {
            currentName = new MutableLiveData<ArrayList<Favourites>>();
        }
        currentName.setValue(new FavouritesRepository().getHolder());
        return currentName;
    }
}

