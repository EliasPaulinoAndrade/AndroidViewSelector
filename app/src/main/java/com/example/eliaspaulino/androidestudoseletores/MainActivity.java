package com.example.eliaspaulino.androidestudoseletores;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewGroup layout = (ViewGroup) findViewById(R.id.lay);

        Selector seletor = new Selector();
        List<View> views = seletor  .findFarByClass(layout, LinearLayout.class)
                                    .findFarByClass(LinearLayout.class)
                                    .getViews();

        for(View view : views){
            view.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        }
        Log.d("TESTE", "onCreate: " + views);
    }
}
