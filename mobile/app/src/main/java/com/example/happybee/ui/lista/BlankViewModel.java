package com.example.happybee.ui.lista;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BlankViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<String> mText;

    public BlankViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Stupina");
    }

    public LiveData<String> getText() {
        return mText;
    }
}