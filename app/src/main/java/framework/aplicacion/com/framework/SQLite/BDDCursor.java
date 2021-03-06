package framework.aplicacion.com.framework.SQLite;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import java.sql.SQLException;

/**
 * Created by Max_Sandoval on 08/05/2015.
 */
public class BDDCursor extends CursorAdapter {

    private BDDAdapter dbAdapter = null ;

    public BDDCursor(Context context, Cursor c) throws SQLException {
        super(context, c);
        dbAdapter = new BDDAdapter(context);
        dbAdapter.abrir();
    }

    public void bindView(View view, Context context, Cursor cursor)
    {
        TextView tv = (TextView) view ;

        tv.setText(cursor.getString(cursor.getColumnIndex(BDDAdapter.C_COLUMNA_NOMBRE)));
    }

    public View newView(Context context, Cursor cursor, ViewGroup parent)
    {
        final LayoutInflater inflater = LayoutInflater.from(context);
        final View view = inflater.inflate(android.R.layout.simple_dropdown_item_1line, parent, false);

        return view;
    }

}
