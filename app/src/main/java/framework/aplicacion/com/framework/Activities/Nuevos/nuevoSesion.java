package framework.aplicacion.com.framework.Activities.Nuevos;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;

import framework.aplicacion.com.framework.R;

/**
 * Created by Max_Sandoval on 01/05/2015.
 */
public class nuevoSesion extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nsesion);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.mipmap.ic_logo);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setTitle("Nueva Sesion");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ff38b760")));
        //ConstructorPDF.crear(this);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            finish();
            overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
        }
        return super.onKeyDown(keyCode, event);
    }

}