package com.example.happybee.ui.Extractie;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.happybee.Pagina_de_info;
import com.example.happybee.R;

public class ExtractieFragment extends Fragment {
    private ExtractieViewModel extractieViewModel;
    TextView iconInfo;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        extractieViewModel =
                new ViewModelProvider(this).get(ExtractieViewModel.class);
        View root = inflater.inflate(R.layout.fragment_extractie, container, false);
        //final TextView textView = root.findViewById(R.id.text_extractie);
        extractieViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });

        iconInfo=root.findViewById(R.id.iconInfoDeplasare);
        iconInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Pagina_de_info.class);
                startActivity(intent);
            }
        });
        return root;
    }
}
