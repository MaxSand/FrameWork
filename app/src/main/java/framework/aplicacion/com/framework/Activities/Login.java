package framework.aplicacion.com.framework.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import framework.aplicacion.com.framework.R;


public class Login extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

    }
    public void acceder (View v){
        Intent act =new Intent(this,Cuenta.class);
        startActivity(act);
    }
    public void registrar (View v){
        Intent act =new Intent(this,Registro.class);
        startActivity(act);
        overridePendingTransition(R.anim.left_in, R.anim.left_out);
    }
}
