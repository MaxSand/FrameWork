package framework.aplicacion.com.framework.Activities.Bar;

import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.SQLException;

import framework.aplicacion.com.framework.R;
import framework.aplicacion.com.framework.SQLite.BDDAdapter;
import framework.aplicacion.com.framework.SQLite.BDDCursor;

/**
 * Created by Max_Sandoval on 02/05/2015.
 */
public class Miembros extends ActionBarActivity {


    private BDDAdapter dbAdapter;
    private Cursor cursor;
    private BDDCursor bddAdapter ;
    private ListView listMiembros;
    private TextView sinMiembros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miembros);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.drawable.dr_miembros);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setTitle("Miembros");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#cc3366")));

        listMiembros = (ListView)this.findViewById(R.id.listMiembros);
        sinMiembros = (TextView)this.findViewById(R.id.ceroMiembros);

        dbAdapter = new BDDAdapter(this);
        try {
            dbAdapter.abrir();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            consultar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(listMiembros.getCount()==0){
            sinMiembros.setText(R.string.ListVacia);
        }

    }
    private void consultar() throws SQLException {
        cursor = dbAdapter.getCursor();
        startManagingCursor(cursor);
        bddAdapter = new BDDCursor(this, cursor);
        listMiembros.setAdapter(bddAdapter);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            finish();
            overridePendingTransition(R.anim.right_in, R.anim.right_out);
        }
        return super.onKeyDown(keyCode, event);
    }
}