package com.example.alex.matematicamente;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

public class LoginActivity extends AppCompatActivity {

    EditText edtxUsername, edtxPassword;
    Button btnLogin;
    SubsamplingScaleImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtxUsername = (EditText) findViewById(R.id.edtxUsuario);
        edtxPassword = (EditText) findViewById(R.id.edtxContraseña);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        imageView = (SubsamplingScaleImageView) findViewById(R.id.image);

        imageView.setImage(ImageSource.resource(R.drawable.launcher_icon));
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        final String username = preferences.getString("user", "");
        final String password = preferences.getString("password","");

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this,
                        edtxUsername.getText().toString() + edtxPassword.getText().toString(),
                        Toast.LENGTH_LONG).show();
                //mainactivity
                if (edtxUsername.getText().toString().equals(username) && edtxPassword.getText().toString().equals(password)){
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }else {
                    new MaterialDialog.Builder(LoginActivity.this)
                            .title("ERROR EN LOGIN")
                            .content("Nombre de usuario o contraseña inválidos")
                            .positiveText("OK")
                            .cancelable(false)
                            .show();
                }

            }
        });
    }
}
