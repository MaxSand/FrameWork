package framework.aplicacion.com.framework.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import framework.aplicacion.com.framework.R;


public class Login extends ActionBarActivity {

    private EditText email, contrasena;
    private TextView recuperar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        email =(EditText)this.findViewById(R.id.email);
        contrasena = (EditText)this.findViewById(R.id.contrasena);
        recuperar = (TextView)this.findViewById(R.id.recuperar);

    }
    public void acceder (View v){
        Intent act =new Intent(this,Cuenta.class);
        startActivity(act);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
    public void registrar (View v){
        Intent act =new Intent(this,Registro.class);
        startActivity(act);
        overridePendingTransition(R.anim.left_in, R.anim.left_out);
    }
}
