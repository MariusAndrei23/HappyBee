package com.example.happybee.ui.Verificari;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class VerificariViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public VerificariViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
