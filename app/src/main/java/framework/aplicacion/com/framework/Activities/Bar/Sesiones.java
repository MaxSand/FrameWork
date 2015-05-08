package framework.aplicacion.com.framework.Activities.Bar;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import framework.aplicacion.com.framework.R;

/**
 * Created by Max_Sandoval on 02/05/2015.
 */
public class Sesiones extends ActionBarActivity {

    private TextView sesionA,sesionC;
    private ListView sesionActiva, sesionConcluida;
    private LinearLayout layoutA, layoutB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesiones);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.drawable.dr_sesion);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setTitle("Sesiones");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#33cc99")));

        sesionA=(TextView)this.findViewById(R.id.ceroActiva);
        sesionC=(TextView)this.findViewById(R.id.ceroConcluida);
        sesionActiva=(ListView)this.findViewById(R.id.listActivas);
        sesionConcluida=(ListView)this.findViewById(R.id.listConcluidas);
        layoutA =(LinearLayout)this.findViewById(R.id.layoutA);
        layoutB =(LinearLayout)this.findViewById(R.id.layoutB);

        if(sesionActiva.getCount()==0){
            sesionA.setText(R.string.sesionA);
        }if (sesionConcluida.getCount()==0){
            sesionC.setText(R.string.sesionC);
        }

    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            finish();
            overridePendingTransition(R.anim.right_in, R.anim.right_out);
        }
        return super.onKeyDown(keyCode, event);
    }
}