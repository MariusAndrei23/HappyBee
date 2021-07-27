package com.example.happybee.ui.Statistici;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StatisticiViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public StatisticiViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Statistici");
    }

    public LiveData<String> getText() {
        return mText;
    }
}