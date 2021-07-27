package com.example.happybee.ui.Cantar;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CantarViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public CantarViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Cantar");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
