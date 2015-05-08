package framework.aplicacion.com.framework.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import framework.aplicacion.com.framework.Activities.Bar.Documentos;
import framework.aplicacion.com.framework.Activities.Bar.Miembros;
import framework.aplicacion.com.framework.Activities.Bar.Sesiones;
import framework.aplicacion.com.framework.Activities.Nuevos.nuevoMiembro;
import framework.aplicacion.com.framework.Activities.Nuevos.nuevoSesion;
import framework.aplicacion.com.framework.R;

/**
 * Created by Max_Sandoval on 25/04/2015.
 */
public class Cuenta extends ActionBarActivity {

    private SharedPreferences prefs;
    private ImageView perfil;
    private ImageView sesiones, miembros, documentos;
    private EditText nombre,entidad, codigo, rol;
    private TextView sesionAct, sesionCon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuenta);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.mipmap.ic_logo);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setTitle("Perfil");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#bb367bbf")));

        perfil = (ImageView)this.findViewById(R.id.perfil);
        nombre = (EditText)this.findViewById(R.id.nombre);
        entidad = (EditText)this.findViewById(R.id.entidad);
        codigo = (EditText)this.findViewById(R.id.codigo);
        rol = (EditText)this.findViewById(R.id.rol);
        sesionAct = (TextView)this.findViewById(R.id.sesionAct);
        sesionCon = (TextView)this.findViewById(R.id.sesionCon);
        sesiones = (ImageView)this.findViewById(R.id.sesiones);
        miembros = (ImageView)this.findViewById(R.id.miembros);
        documentos = (ImageView)this.findViewById(R.id.documentos);

        sesiones.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), Sesiones.class));
                overridePendingTransition(R.anim.left_in, R.anim.left_out);
            }
        });
        miembros.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), Miembros.class));
                overridePendingTransition(R.anim.left_in, R.anim.left_out);
            }
        });
        documentos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), Documentos.class));
                overridePendingTransition(R.anim.left_in, R.anim.left_out);
            }
        });

        perfil.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, 100);
            }
        });
    }

    public void nuevoMiembro (View v){
        Intent act =new Intent(this,nuevoMiembro.class);
        startActivity(act);
        overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);
    }
    public void nuevoSesion (View v){
        Intent act =new Intent(this,nuevoSesion.class);
        startActivity(act);
        overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);
    }

    public void onPause(){
        super.onPause();
        savePreferences("nombre",nombre.getText().toString());
        savePreferences("entidad",entidad.getText().toString());
        savePreferences("codigo",codigo.getText().toString());
        savePreferences("rol",rol.getText().toString());
    }
    public void onResume(){
        super.onResume();
        loadSavedPreferences();
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String picturePath = prefs.getString("imagenPerfil", "");
        if (!picturePath.equals("")) {
            perfil.setImageBitmap(BitmapFactory.decodeFile(picturePath));
        }
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent imageResult) {
        super.onActivityResult(requestCode, resultCode, imageResult);

        if(resultCode == RESULT_OK){
            Uri selectedImage = imageResult.getData();
            perfil.setImageURI(selectedImage);
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            Cursor cursor = this.getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            prefs = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor edit=prefs.edit();
            edit.putString("imagenPerfil", picturePath);
            edit.commit();
        }
    }
    private void savePreferences(String key, String value) {

        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, value);
        editor.commit();

    }
    private void loadSavedPreferences() {

        prefs= PreferenceManager.getDefaultSharedPreferences(this);

        nombre.setText(prefs.getString("nombre", "Nombre.."));
        entidad.setText(prefs.getString("entidad", "Academia.."));
        codigo.setText(prefs.getString("codigo", "Codigo.."));
        rol.setText(prefs.getString("rol", "Rol en entidad.."));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

