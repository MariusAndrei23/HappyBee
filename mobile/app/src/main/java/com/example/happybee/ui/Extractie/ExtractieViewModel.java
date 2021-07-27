package com.example.happybee.ui.Extractie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ExtractieViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ExtractieViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Extractie");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
