package com.example.happybee.ui.Tratare;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TratareViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public TratareViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Tratare");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
