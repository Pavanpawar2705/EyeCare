package com.example.eyecare;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class StartTest extends AppCompatActivity implements View.OnClickListener {

    private TextView info;
    private Button startTest;
    private int type;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_test);
//
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();

        String title = intent.getStringExtra("name");
        type = intent.getIntExtra("type", -1);
//        getSupportActionBar().setTitle(title);

        info = findViewById(R.id.textView2);
        startTest =findViewById(R.id.startTest);

        startTest.setOnClickListener(this);

        setInfo(type);

    }

    private void setInfo(int type) {

        String[] infos = getResources().getStringArray(R.array.test_infos);

        info.setText(Html.fromHtml(infos[type]));

        if (Build.VERSION.SDK_INT >= 24) {
            info.setText(Html.fromHtml(infos[type], Html.FROM_HTML_MODE_LEGACY));
        } else {
            info.setText(Html.fromHtml(infos[type]));
        }

       //info.setText(infos[type]);

    }

    @Override
    public void onClick(View view) {

        switch (type){
            case 0:
                startActivity(new Intent(this, NearVision.class));
                break;
            case 1:
                startActivity(new Intent(this, FarVision.class));
                break;

            case 2:
                startActivity(new Intent(this, ColorBlindnessTest.class));
                break;
            case 3:
                startActivity(new Intent(this, AmslerGridTest.class));
                break;
            case 4:
                startActivity(new Intent(this, VisualAcuity.class));
                break;
            case 5:
                startActivity(new Intent(this, AstigmatismTest.class));
                break;
//            default:
//                Intent intent = new Intent(this, TestInstruction.class);
//                intent.putExtra("type", type);
//                startActivity(intent);
        }


    }
}
