package m2iformation.fr.tagdemo;

import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditTag editTag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTag = findViewById(R.id.editTag);

    }

    public void rouge(View view) {
        editTag.setTagColor(Color.RED);
    }

    public void bleu(View view) {
        editTag.setTagColor(Color.BLUE);
    }
}
