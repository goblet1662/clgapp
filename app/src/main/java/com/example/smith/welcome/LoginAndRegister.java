package com.example.smith.welcome;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.AdapterView;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.transitionseverywhere.extra.Scale;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.ArrayList;
import java.util.List;

import fr.ganfra.materialspinner.MaterialSpinner;

public class LoginAndRegister extends AppCompatActivity {
String sdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_and_register);

        final Button bt=(Button)findViewById(R.id.bt);
        final Button bt2=(Button)findViewById(R.id.bt2);
        final TextView tv3=(TextView) findViewById(R.id.textView3);
        final ViewGroup transitionsContainer = (ViewGroup)findViewById(R.id.transitions_container);
        final Button button = (Button) transitionsContainer.findViewById(R.id.bt);
        final Spinner spinner=(Spinner) findViewById(R.id.spinner);
        final ArrayAdapter adapter=ArrayAdapter.createFromResource(this,R.array.Type,R.layout.spinneritem);
        spinner.setAdapter(adapter);

                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        TransitionManager.beginDelayedTransition(transitionsContainer);
                        switch (spinner.getSelectedItem().toString()) {
                            case "Student":
                                bt.setVisibility(View.VISIBLE);
                                tv3.setVisibility(View.INVISIBLE);
                                bt2.setVisibility(View.INVISIBLE);
                                break;
                            case "Teacher":
                                bt.setVisibility(View.VISIBLE);
                                tv3.setVisibility(View.VISIBLE);
                                bt2.setVisibility(View.VISIBLE);
                                break;
                            default:
                                bt.setVisibility(View.INVISIBLE);
                                tv3.setVisibility(View.INVISIBLE);
                                bt2.setVisibility(View.INVISIBLE);

                                break;
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });

                bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                                startActivity(new Intent(getApplicationContext(),Login.class));
                    }
                });

                bt2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getApplicationContext(),Register.class));
                    }
                });

    }
}

