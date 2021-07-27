package com.example.happybee.ui.lista;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.happybee.Pagina_de_info;
import com.example.happybee.R;
import com.example.happybee.ui.Stupina.StupinaViewModel;
import com.example.happybee.ui.Verificari.VerificariFragment;
import com.example.happybee.ui.Verificari.VerificariViewModel;

public class BlankFragment extends FragmentActivity {

    private BlankViewModel mViewModel;
    TextView iconADD;

    public static BlankFragment newInstance() {
        return new BlankFragment();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        mViewModel =
                new ViewModelProvider(this).get(BlankViewModel.class);
        View root = inflater.inflate(R.layout.blank_fragment, container, false);



//        iconADD=root.findViewById(R.id.textView50);
//        iconADD.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(getActivity(), VerificariFragment.class);
//                intent.putExtra("position",2);
//                startActivity(intent);
//                startActivity(intent);
//
////                FragmentManager fragmentManager = getSupportFragmentManager();
////                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
////                    fragmentManager.beginTransaction()
////                            .replace(R.id.nav_verificari, VerificariFragment.class, null)
////                            .setReorderingAllowed(true)
////                            .addToBackStack("name") // name can be null
////                            .commit();
//                }
//
//            }
//        return root;
      //  });
        return root;

    }

}