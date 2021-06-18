package com.example.eyecare;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyAdapter extends ArrayAdapter<String> {
//    public static final String name = "com.example.eyecare.NAME";
//    public static final String type = "com.example.eyecare.TYPE";
    String [] tests;
    private Context context;
    String colors [] ={"#2196F3","#4CAF50","#009688","#9C27B0","#03A9F4","#673AB7"};
    public MyAdapter(@NonNull Context context, int resource, @NonNull String[] tests) {
        super(context, resource, tests);
        this.context=context;
        this.tests=tests;
    }

    @Nullable
    @Override
    public String getItem(int position) {
        return tests[position];
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.single_test,parent,false);
        TextView t=convertView.findViewById(R.id.text);
        t.setText(getItem(position));
        RelativeLayout bg=convertView.findViewById(R.id.background);
        bg.setBackgroundColor(Color.parseColor(colors[position]));
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context, "You Clicked on:"+position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context,StartTest.class);
                intent.putExtra("name",tests[position]);
                intent.putExtra("type",position);
                context.startActivity(intent);

            }
        });
        return convertView;
    }
}
