package com.example.happybee.ui.Cantar;

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
import com.example.happybee.ui.Cantar.CantarViewModel;

public class CantarFragment extends Fragment {

    private CantarViewModel cantarViewModel;
    TextView iconInfo;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        cantarViewModel =
                new ViewModelProvider(this).get(CantarViewModel.class);
        View root = inflater.inflate(R.layout.fragment_cantar, container, false);
        //final TextView textView = root.findViewById(R.id.text_cantar);
        cantarViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });

        iconInfo=root.findViewById(R.id.iconInfoCantar);
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
