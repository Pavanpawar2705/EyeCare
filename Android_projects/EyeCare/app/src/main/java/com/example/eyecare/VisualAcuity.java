package com.example.eyecare;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class VisualAcuity extends AppCompatActivity implements View.OnClickListener {


    private TextView directions;
    private Button startTest;
    private ImageView image;
    private int type;
    int counter=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.test_instructions);


        directions = (TextView) findViewById(R.id.test_instructions);
        startTest = (Button) findViewById(R.id.startTest);
        image = (ImageView) findViewById(R.id.image);

        startTest.setOnClickListener(this);
       //image.setImageResource(R.drawable.v_acuity);

        setInfo();

    }

    private void setInfo() {


        String info = getResources().getString(R.string.visual_acuity) ;

        directions.setText(Html.fromHtml(info));

        if (Build.VERSION.SDK_INT >= 24) {
            directions.setText(Html.fromHtml(info, Html.FROM_HTML_MODE_LEGACY));
        } else {
            directions.setText(Html.fromHtml(info));
        }
    }

    @Override
    public void onClick(View view) {


        counter++;


        if (counter<=1) {
            directions.setVisibility(View.INVISIBLE);
            image.setVisibility(View.VISIBLE);
            switch (counter) {

                case 1:
                    image.setImageResource(R.drawable.v_acuity);
                    break;



            }
        }
        else
        {
            image.setVisibility(View.INVISIBLE);
            directions.setVisibility(View.VISIBLE);
            String x=getResources().getString(R.string.va_results) ;
            directions.setText(Html.fromHtml(x));
            startTest.setVisibility(View.INVISIBLE);
        }


    }
}
