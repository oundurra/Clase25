package com.example.clase25;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    UpFragment upfragment;
    MiddleFragment middlefragment;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        upfragment = new UpFragment();
        middlefragment = new MiddleFragment();

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.fragmentUp, upfragment, "FragmentUp");
        fragmentTransaction.add(R.id.fragmentMiddle, middlefragment, "FragmentMiddle");

        fragmentTransaction.commit();
    }

    public void enviarArriba() {
        EditText txtArriba = (EditText) upfragment.getView().findViewById(R.id.txtTextoArriba);
        EditText txtMedio = (EditText) middlefragment.getView().findViewById(R.id.txtTextoMedio);
        txtArriba.setText(txtMedio.getText().toString());
        txtMedio.setText("");
    }

    public void enviarAlCentro() {
        EditText txtArriba = (EditText) upfragment.getView().findViewById(R.id.txtTextoArriba);
        EditText txtMedio = (EditText) middlefragment.getView().findViewById(R.id.txtTextoMedio);
        txtMedio.setText(txtArriba.getText().toString());
        txtArriba.setText("");
    }
}