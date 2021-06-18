package com.example.eyecare;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

public class VirtualTests1 extends Fragment {
    public ListView listView;
    String tests[]={"Near Vision","Far Vision","Colour Blindness","Amsler Grid","Visual Acuity","Astigmatism"};
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.virtualtests1_layout, container,false);
        listView=root.findViewById(R.id.listView);
        //ArrayAdapter ad=new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,tests);
        MyAdapter ad=new MyAdapter(getActivity(),R.layout.single_test,tests);
        listView.setAdapter(ad);


        return root;
    }
}
