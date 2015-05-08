package framework.aplicacion.com.framework.Activities.Bar;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;

import framework.aplicacion.com.framework.R;

/**
 * Created by Max_Sandoval on 02/05/2015.
 */
public class Documentos extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documentos);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.drawable.dr_documentos);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setTitle("Documentos");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#9d51c5")));

    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            finish();
            overridePendingTransition(R.anim.right_in, R.anim.right_out);
        }
        return super.onKeyDown(keyCode, event);
    }
}