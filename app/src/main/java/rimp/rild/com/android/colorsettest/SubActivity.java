package rimp.rild.com.android.colorsettest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {
    private final int STATE_BLACK = 0;
    private final int STATE_BLUE = 1;
    private final int STATE_RED = 2;

    int mColorState;

    TextView mCurrentColor;

    Button mBlackButton;
    Button mBlueButton;
    Button mRedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        loadIntentInfo();

        mCurrentColor = (TextView) findViewById(R.id.current_color_textview);

        updateColorInfo(mColorState);

        //ボタンの設定
        mBlackButton = (Button) findViewById(R.id.black_button);
        mBlueButton = (Button) findViewById(R.id.blue_button);
        mRedButton = (Button) findViewById(R.id.red_button);
        setOnClickToButtons(); //長いからメソッド化

    }

    private void loadIntentInfo() {
        //色の情報をintentから受け取る
        Intent intent = getIntent();
        mColorState = intent.getIntExtra("current_color", STATE_BLACK);
    }

    private void intentMain(int colorState) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("changed_color", colorState);
        startActivity(intent);
    }

    private void updateColorInfo(int color) {

        if (color == STATE_BLACK) {
            mCurrentColor.setText("現在の色は 黒 色です");
        } else if (color == STATE_BLUE) {
            mCurrentColor.setText("現在の色は 青 色です");
        } else if (color == STATE_RED) {
            mCurrentColor.setText("現在の色は 赤 色です");
        }
    }

    private void setOnClickToButtons() {
        mBlackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mColorState = STATE_BLACK;
                intentMain(mColorState);
            }
        });
        mBlueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mColorState = STATE_BLUE;
                intentMain(mColorState);
            }
        });
        mRedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mColorState = STATE_RED;
                intentMain(mColorState);
            }
        });
    }
}
