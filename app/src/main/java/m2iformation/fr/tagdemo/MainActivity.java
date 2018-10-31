package m2iformation.fr.tagdemo;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements EditTag.OnOutListener {
    EditTag editTag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTag = findViewById(R.id.editTag);
        editTag.setOnOutListener(this);
    }

    public void rouge(View view) {
        editTag.setTagColor(Color.RED);
    }

    public void bleu(View view) {
        editTag.setTagColor(Color.BLUE);
    }

    public void clearTag(View view) {
        editTag.clear();
    }

    @Override
    public void onOut(View view) {
        editTag.setTagColor(Color.GREEN);
        editTag.setTagWeight(35);
    }
}
