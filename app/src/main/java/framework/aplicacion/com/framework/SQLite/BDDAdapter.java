package framework.aplicacion.com.framework.SQLite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;

/**
 * Created by Max_Sandoval on 08/05/2015.
 */
public class BDDAdapter {
    //Constante con el nombre de la tabla
    public static final String C_TABLA = "Miembros";
    //Constantes con el nombre de las columnas en la tabla
    public static final String C_COLUMNA_ID = "_id";
    public static final String C_COLUMNA_NOMBRE = "nombre";
    public static final String C_COLUMNA_CODIGO = "codigo";
    public static final String C_COLUMNA_ENTIDAD = "entidad";
    public static final String C_COLUMNA_ROL = "rol";

    private Context contexto;
    private BDDHelper dbHelper;
    private SQLiteDatabase db;

    //lista de columnas de la tabla para utilizarla en las consultas a la base de datos
    private String[] columnas = new String[]{ C_COLUMNA_ID, C_COLUMNA_NOMBRE, C_COLUMNA_CODIGO, C_COLUMNA_ENTIDAD, C_COLUMNA_ROL} ;

    public BDDAdapter(Context context) {
        this.contexto = context;
    }

    public BDDAdapter abrir() throws SQLException {
        dbHelper = new BDDHelper(contexto);
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void cerrar() {
        dbHelper.close();
    }

    //Devuelve cursor con todas las columnas de la tabla
    public Cursor getCursor() throws SQLException {
        Cursor c = db.query( true, C_TABLA, columnas, null, null, null, null, null, null);
        return c;
    }
}
