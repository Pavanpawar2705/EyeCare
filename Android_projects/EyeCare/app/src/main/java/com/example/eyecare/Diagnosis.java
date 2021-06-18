package com.example.eyecare;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

public class Diagnosis extends Fragment {
    private int mInputSize = 224;
    private String mModelPath = "tf_lite_model.tflite";
    private String mLabelPath = "dict.txt";
    private Classifier classifier;
    private static final int GALLERY_REQUEST_CODE = 123;
    private Button button;
    private ImageView imageView;
    private TextView textView;
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override

    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {

        View root=inflater.inflate(R.layout.diagnosis_layout,container,false);
        button = root.findViewById(R.id.button);
        imageView = root.findViewById(R.id.imageView);
        textView = root.findViewById(R.id.result);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Pick an Image"), GALLERY_REQUEST_CODE);

            }
        });

        try {
            initClassifier();
        } catch (IOException e) {
            e.printStackTrace();
        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = ((BitmapDrawable)((ImageView)imageView).getDrawable()).getBitmap();

                List<Classifier.Recognition> result = classifier.recognizeImage(bitmap);

                String res=result.get(0).toString();
                textView.setText(res);
                //Toast.makeText(MainActivity.this, result.get(0).toString(), Toast.LENGTH_SHORT).show() ;


            }
        });
    return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GALLERY_REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null) {
            Uri ImageData = data.getData();
            imageView.setImageURI(ImageData);
        }
    }

    private void initClassifier() throws IOException {
        classifier = new Classifier(button.getContext().getAssets(), mModelPath, mLabelPath, mInputSize);
    }



}
