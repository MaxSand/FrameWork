package framework.aplicacion.com.framework.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import framework.aplicacion.com.framework.R;

/**
 * Created by Max_Sandoval on 25/04/2015.
 */
public class Registro extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        getSupportActionBar().hide();

    }
    public void crear  (View v){
        Intent act =new Intent(this,Cuenta.class);
        startActivity(act);
    }
}