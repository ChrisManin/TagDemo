package m2iformation.fr.tagdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class EditTag extends AppCompatImageView implements View.OnTouchListener {
    private Integer tagColor;
    private int tagWeight;
    private Bitmap fingerTag;
    private Integer bkgColor;

    private OnOutListener onOutListener;


    Paint paint = new Paint();
    //Définir l'objet Paint
    Path path = new Path();

    public EditTag(Context context) {
        super(context);
        setOnTouchListener(this);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
    }


    //Ce constructeur est nécessaire car utilisé par l'inflater
    // (le programme qui construit l'écran)
    public EditTag(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnTouchListener(this);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
        setTagColor(attrs.getAttributeIntValue("http://schemas.android.com/apk/res-auto",
                "tagColor",
                Color.BLACK));

        setTagWeight(attrs.getAttributeIntValue("http://schemas.android.com/apk/res-auto",
                "tagWeight",
                10));
        setBkgColor(attrs.getAttributeIntValue("http://schemas.android.com/apk/res-auto",
                "bkgColor",
                Color.GRAY));
    }

    // Cette méthode est exécutée chaque fois que Android redessine la zone.
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawPath(path, paint);
    }

    public void setBkgColor(Integer backgroundColor) {
        this.bkgColor = backgroundColor;
        setBackgroundColor(bkgColor);
    }

    public Integer getBakcgroundColor() {
        return bkgColor;
    }

    public Integer getTagColor() {
        return tagColor;
    }

    public int getTagWeight() {
        return tagWeight;
    }

    public Bitmap getFingerTag() {
        return fingerTag;
    }

    public void setTagColor(Integer tagColor) {
        this.tagColor = tagColor;
        paint.setColor(getTagColor());
        invalidate();

    }

    public void setTagWeight(int tagWeight) {
        this.tagWeight = tagWeight;
    }

    public void setFingerTag(Bitmap fingerTag) {
        this.fingerTag = fingerTag;
    }

    public void clear() {
        path = new Path();
        paint.setColor(Color.BLACK);
        invalidate();
    }

    public void saveJpg(String fichier) {

    }

    public void savePng(String fichier) {

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {//Création d'une direction
            path.moveTo(event.getX(), event.getY());
        }
        if(event.getAction() == MotionEvent.ACTION_MOVE) {
            path.lineTo(event.getX(), event.getY());
        }
        if (event.getX()<10 || event.getX()>getWidth()- 10){
            if (onOutListener != null){
                onOutListener.onOut(this);
            }
        }
        if (event.getX()<10 || event.getX()>getHeight()- 10){
            if (onOutListener != null){
                onOutListener.onOut(this);
            }
        }
        invalidate();
        return true;
    }

    public OnOutListener getOnOutListener() {
        return onOutListener;
    }

    public void setOnOutListener(OnOutListener onOutListener) {
        this.onOutListener = onOutListener;
    }

    public interface OnOutListener{
        void onOut(View view);
    }
}