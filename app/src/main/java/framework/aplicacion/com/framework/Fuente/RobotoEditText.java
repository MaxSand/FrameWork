package framework.aplicacion.com.framework.Fuente;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by Max_Sandoval on 25/04/2015.
 */
public class RobotoEditText extends EditText {

    public RobotoEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public RobotoEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RobotoEditText(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(),"Font/Roboto-Light.ttf");
            setTypeface(tf);
        }
    }

}