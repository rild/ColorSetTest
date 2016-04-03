package rimp.rild.com.android.colorsettest;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final int STATE_BLACK = 0;
    private final int STATE_BLUE = 1;
    private final int STATE_RED = 2;

    int mColor;
    TextView mTextView;
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mColor = STATE_BLACK;

        mTextView = (TextView) findViewById(R.id.main_text);
        mButton = (Button) findViewById(R.id.intent_button);

        updateBackgroundColor(0);


    }

    private void intentSetting(int color) {
        Intent intent = new Intent(getApplicationContext(), SubActivity.class);
        startActivity(intent);
    }

    private void updateBackgroundColor(int color) {
        Resources res = getResources();
        int colorRes = res.getColor(R.color.bg_black);

        if (color == STATE_BLACK) {
            colorRes = res.getColor(R.color.bg_black);
        } else if (color == STATE_BLUE) {
            colorRes = res.getColor(R.color.bg_blue);
        } else if (color == STATE_RED) {
            colorRes = res.getColor(R.color.bg_red);
        }

        mTextView.setTextColor(colorRes);
    }
}
