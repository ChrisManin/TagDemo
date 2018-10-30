package m2iformation.fr.tagdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

public class EditTag extends AppCompatImageView {
    private Color tagColor;
    private int tagWeight;
    private Bitmap fingerTag;
    private Color bakcgroundColor;

    public EditTag(Context context) {
        super(context);
    }

    //Ce constructeur est nécessaire car utilisé par l'inflater
    // (le programme qui construit l'écran)
    public EditTag(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setBakcgroundColor(Color bakcgroundColor) {
        this.bakcgroundColor = bakcgroundColor;
    }

    public Color getBakcgroundColor() {
        return bakcgroundColor;
    }

    public Color getTagColor() {
        return tagColor;
    }

    public int getTagWeight() {
        return tagWeight;
    }

    public Bitmap getFingerTag() {
        return fingerTag;
    }

    public void setTagColor(Color tagColor) {
        this.tagColor = tagColor;
    }

    public void setTagWeight(int tagWeight) {
        this.tagWeight = tagWeight;
    }

    public void setFingerTag(Bitmap fingerTag) {
        this.fingerTag = fingerTag;
    }

    public void clear(){

    }

    public void saveJpg(String fichier){

    }

    public void savePng(String fichier){

    }
}
