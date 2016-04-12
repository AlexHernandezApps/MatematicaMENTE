package com.example.alex.matematicamente;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.afollestad.materialdialogs.MaterialDialog;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

public class RegisterActivity extends AppCompatActivity {

    EditText edtxUsername, edtxPassword, edtxBoleta;
    Button btnNext;
    boolean band1=false,band2=false, band3=false;
    SubsamplingScaleImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        imageView = (SubsamplingScaleImageView) findViewById(R.id.image);
        imageView.setImage(ImageSource.resource(R.drawable.splash_icon));

        new MaterialDialog.Builder(this)
                .title("AÚN NO CUENTA CON UN REGISTRO")
                .content("Para comenzar a utilizar la aplicación haga su registro")
                .positiveText("OK")
                .cancelable(false)
                .show();
        setContentView(R.layout.activity_register);

        edtxBoleta = (EditText) findViewById(R.id.edtxBoleta);
        edtxUsername = (EditText) findViewById(R.id.edtxUsuario);
        edtxPassword = (EditText) findViewById(R.id.edtxContraseña);
        btnNext = (Button) findViewById(R.id.btnNext);

        btnNext.setEnabled(false);

        edtxBoleta.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!edtxBoleta.getText().toString().equals("")) {
                    band1 = true;
                } else {
                    band1 = false;
                }
                if(band1 && band2 && band3){
                    btnNext.setEnabled(true);
                }else{
                    btnNext.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        edtxPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!edtxPassword.getText().toString().equals("")) {
                    band2 = true;
                } else {
                    band2 = false;
                }
                if(band1 && band2 && band3){
                    btnNext.setEnabled(true);
                }else{
                    btnNext.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        edtxUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!edtxUsername.getText().toString().equals("")){
                    band3=true;
                }else{
                    band3=false;
                }
                if(band1 && band2 && band3){
                    btnNext.setEnabled(true);
                }else{
                    btnNext.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Saving in preferences login
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("user", edtxUsername.getText().toString());
                editor.putString("password", edtxPassword.getText().toString());
                editor.putString("boleta", edtxBoleta.getText().toString());
                editor.apply();
                //---------------------------------------
                new MaterialDialog.Builder(RegisterActivity.this)
                        .title("ÉXITO")
                        .content("Registro guardado con éxito")
                        .positiveText("OK")
                        .cancelable(false)
                        .show();
                setContentView(R.layout.activity_register);
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }
}
