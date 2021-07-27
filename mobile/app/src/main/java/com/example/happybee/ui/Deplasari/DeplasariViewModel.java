package com.example.happybee.ui.Deplasari;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DeplasariViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public DeplasariViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
