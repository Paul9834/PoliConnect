package com.policonnect.team.policonnect20;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.policonnect.team.policonnect20.MainActivityFragments.MainActivity;

/**
 * Esta clase maneja la pantalla de LogIn y sus acciones
 *
 * @version 2
 * @author: PoliConnect Team
 **/
public class Login extends AppCompatActivity {
    private static long back_pressed;
    private Button mLogInButton;
    private EditText mUser;
    private EditText mPassword;
    private ProgressDialog loadingBar;
    private static final String TAG = "Login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLogInButton = findViewById(R.id.loginButton);
        mUser = findViewById(R.id.loginName);
        mPassword = findViewById(R.id.loginPass);
        loadingBar = new ProgressDialog(this, R.style.Theme_AppCompat_DayNight_Dialog);
        loadingBar.setCanceledOnTouchOutside(false);


        mLogInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tryToLogIn();
            }
        });
    }


    /**
     * Se presionó el botón 'Entrar'. Si las credenciales son correctas, se pasa a la actividad Dummy
     * y cierra la actual, si no, se muestra un Toast dependiendo de lo que esté incorrecto.
     **/
    private void tryToLogIn() {
        String dataUser = mUser.getText().toString();
        if (dataUser.isEmpty()) {
            Toast.makeText(Login.this, R.string.toast_nouser, Toast.LENGTH_SHORT).show();
            return;
        }
        String dataPass = mPassword.getText().toString();
        if (dataPass.isEmpty()) {
            Toast.makeText(Login.this, R.string.toast_nopass, Toast.LENGTH_SHORT).show();
            return;
        }
        loadingBar.setTitle(R.string.progressdialog_loggin);
        loadingBar.setMessage(getString(R.string.progressdialog_pleasewait));
        loadingBar.show();
        if (confirmData(dataUser, dataPass)) {
            loadingBar.cancel();
            Intent i = new Intent(Login.this, MainActivity.class);
            startActivity(i);
            finish();
            return;
        }
        loadingBar.cancel();
        Toast.makeText(this, R.string.toast_nocoincidence, Toast.LENGTH_SHORT).show();

    }


    /**
     * Confirma los datos ingresados en la base de datos.
     *
     * @param dataUser texto ingresado en el campo de 'usuario'
     * @param dataPass texto ingresado en el campo de 'contraseña'
     * @return si los datos son correctos o no
     **/
    private boolean confirmData(String dataUser, String dataPass) {
        return dataUser.equals("aaa") && dataPass.equals("aaa");
    }


    /**
     * Este método asegura que el usuario salga de la aplicación cuando este oprima e botón "atrás" dos
     * veces con un lapso de tiempo de menos de 2 segundos.
     * Sobreescribe en metodo onBackPressed
     **/
    @Override
    public void onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis()) {
            System.exit(0);
        } else
            Toast.makeText(getBaseContext(), R.string.toast_backagain, Toast.LENGTH_SHORT).show();
        back_pressed = System.currentTimeMillis();
    }


    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

}
