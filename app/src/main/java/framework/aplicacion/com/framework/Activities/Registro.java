package framework.aplicacion.com.framework.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import framework.aplicacion.com.framework.R;

/**
 * Created by Max_Sandoval on 25/04/2015.
 */
public class Registro extends ActionBarActivity {

    private EditText nuevoEmail, nuevaContrasena, confContrasena;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        getSupportActionBar().hide();
        nuevoEmail=(EditText)this.findViewById(R.id.nuevoEmail);
        nuevaContrasena=(EditText)this.findViewById(R.id.nuevoContrasena);
        confContrasena=(EditText)this.findViewById(R.id.confContrasena);

    }
    public void crear  (View v){
        Intent act =new Intent(this,Cuenta.class);
        startActivity(act);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            finish();
            overridePendingTransition(R.anim.right_in, R.anim.right_out);
        }
        return super.onKeyDown(keyCode, event);
    }
}