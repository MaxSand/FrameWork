package framework.aplicacion.com.framework.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Max_Sandoval on 08/05/2015.
 */
public class BDDHelper extends SQLiteOpenHelper{
    private static int version = 1;
    private static String name = "FrameWorkDb" ;
    private static SQLiteDatabase.CursorFactory factory = null;

    String sqlTabla = "CREATE TABLE Miembros (_id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, codigo INTEGER, entidad TEXT, rol TEXT)";

    public BDDHelper(Context contexto) {
        super(contexto, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(this.getClass().toString(), "Creando base de datos");
        db.execSQL(sqlTabla);
        Log.i(this.getClass().toString(), "Base de datos creada");

        db.execSQL("INSERT INTO Miembros(_id, nombre, codigo, entidad, rol) VALUES(1,'Nombre0','51515151','Academia de Cien','Estudiante')");
        db.execSQL("INSERT INTO Miembros(_id, nombre, codigo, entidad, rol) VALUES(2,'Nombre1','51515151','Academia de Cien','Estudiante')");
        db.execSQL("INSERT INTO Miembros(_id, nombre, codigo, entidad, rol) VALUES(3,'Nombre2','51515151','Academia de Cien','Estudiante')");
        db.execSQL("INSERT INTO Miembros(_id, nombre, codigo, entidad, rol) VALUES(4,'Nombre3','51515151','Academia de Cien','Estudiante')");
        Log.i(this.getClass().toString(), "Datos iniciales HIPOTECA insertados");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
