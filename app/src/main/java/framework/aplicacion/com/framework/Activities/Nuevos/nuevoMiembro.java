package framework.aplicacion.com.framework.Activities.Nuevos;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import framework.aplicacion.com.framework.R;
import framework.aplicacion.com.framework.SQLite.BDDHelper;

/**
 * Created by Max_Sandoval on 01/05/2015.
 */
public class nuevoMiembro extends ActionBarActivity {

    private EditText nombre,entidad, codigo, rol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nmiembro);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.mipmap.ic_logo);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setTitle("Nuevo Miembro");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ff38b760")));

        nombre = (EditText)this.findViewById(R.id.nuevoNombre);
        entidad = (EditText)this.findViewById(R.id.nuevoEntidad);
        codigo = (EditText)this.findViewById(R.id.nuevoCodigo);
        rol = (EditText)this.findViewById(R.id.nuevoRol);

        //Base de datos
        BDDHelper dbHelper = new BDDHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Toast.makeText(getBaseContext(), "Base de datos preparada", Toast.LENGTH_LONG).show();

    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            finish();
            overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
        }
        return super.onKeyDown(keyCode, event);
    }
    public void guardar (View v){

        finish();
        Toast toast1 = Toast.makeText(getApplicationContext(), R.string.guardado, Toast.LENGTH_SHORT);
        toast1.show();

        overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);
    }
}