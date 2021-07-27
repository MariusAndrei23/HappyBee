package com.example.happybee.ui.Verificari;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.happybee.Pagina_de_info;
import com.example.happybee.R;

public class VerificariFragment extends FragmentActivity {
    private VerificariViewModel verificariViewModel;
    TextView iconInfo;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        verificariViewModel =
                new ViewModelProvider(this).get(VerificariViewModel.class);
        View root = inflater.inflate(R.layout.fragment_verificari, container, false);


        iconInfo=root.findViewById(R.id.iconInfoVerificari);
        iconInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent intent=new Intent(getActivity(), Pagina_de_info.class);
               // startActivity(intent);
            }
        });
        return root;
    }
}
