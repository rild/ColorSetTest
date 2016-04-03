package rimp.rild.com.android.colorsettest;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final int STATE_BLACK = 0;
    private final int STATE_BLUE = 1;
    private final int STATE_RED = 2;

    int mColorState;

    TextView mTextView;
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadIntentInfo();

        mTextView = (TextView) findViewById(R.id.main_text);
        mButton = (Button) findViewById(R.id.intent_button);

        updateTextViewBackgroundColor(mColorState);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentSetting(mColorState);
            }
        });


    }

    private void intentSetting(int colorState) {
        Intent intent = new Intent(getApplicationContext(), SubActivity.class);
        intent.putExtra("current_color", colorState);
        startActivity(intent);
    }

    private void loadIntentInfo() {
        //色の情報をintentから受け取る
        Intent intent = getIntent();
        mColorState = intent.getIntExtra("changed_color", STATE_BLUE);
    }

    private void updateTextViewBackgroundColor(int color) {
        Resources res = getResources();
        int colorRes = res.getColor(R.color.bg_black);

        if (color == STATE_BLACK) {
            colorRes = res.getColor(R.color.bg_black);
        } else if (color == STATE_BLUE) {
            colorRes = res.getColor(R.color.bg_blue);
        } else if (color == STATE_RED) {
            colorRes = res.getColor(R.color.bg_red);
        }

        mTextView.setTextColor(getResources().getColor(R.color.bg_black));

        mTextView.setTextColor(colorRes);
    }
}
