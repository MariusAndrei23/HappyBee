package com.example.happybee.ui.Despre;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.happybee.R;
import com.example.happybee.ui.Tratare.TratareViewModel;

public class DespreViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public DespreViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Despre");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
