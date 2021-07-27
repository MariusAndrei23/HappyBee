package com.example.happybee.ui.Stupina;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StupinaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public StupinaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Stupina");
    }

    public LiveData<String> getText() {
        return mText;
    }
}