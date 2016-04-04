package rimp.rild.com.android.colorsettest;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Intent で値のやり取りをする

    private final int STATE_LIGHT = 0;
    private final int STATE_DARK = 1;
    private final int STATE_VIVID = 2;

    int mColorState;

    LinearLayout mContentHolder;
    TextView mContentHeader;
    TextView mContentUpper;
    TextView mContentLower;

    TextView mTextView;
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadIntentInfo();

        assignViews();

        updateContentColor(mColorState);
        updateTextViewBackgroundColor(mColorState);

        setOnClickToButton();
    }

    //Viewのインスタンスをlayoutファイルから読み込む
    private void assignViews() {
        mContentHolder = (LinearLayout) findViewById(R.id.main_content);
        mContentHeader = (TextView) findViewById(R.id.main_header);
        mContentUpper = (TextView) findViewById(R.id.main_text_upper);
        mContentLower = (TextView) findViewById(R.id.main_text_lower);

        mTextView = (TextView) findViewById(R.id.main_text);
        mButton = (Button) findViewById(R.id.intent_button);
    }

    private void updateContentColor(int colorState) {
        Resources res = getResources();
        //default is color set 0
        int colorBaseId = res.getColor(R.color.color_scheme_base_color_0);
        int colorLightId = res.getColor(R.color.color_scheme_light_color_0);
        int colorNomalId = res.getColor(R.color.color_scheme_nomal_color_0);
        int colorDarkId = res.getColor(R.color.color_scheme_dark_color_0);
        int colorAccentId = res.getColor(R.color.color_scheme_accent_color_0);


        if (colorState == STATE_LIGHT) {
            colorBaseId = res.getColor(R.color.color_scheme_base_color_0);
            colorLightId = res.getColor(R.color.color_scheme_light_color_0);
            colorNomalId = res.getColor(R.color.color_scheme_nomal_color_0);
            colorDarkId = res.getColor(R.color.color_scheme_dark_color_0);
            colorAccentId = res.getColor(R.color.color_scheme_accent_color_0);
        } else if (colorState == STATE_DARK) {
            colorBaseId = res.getColor(R.color.color_scheme_base_color_1);
            colorLightId = res.getColor(R.color.color_scheme_light_color_1);
            colorNomalId = res.getColor(R.color.color_scheme_nomal_color_1);
            colorDarkId = res.getColor(R.color.color_scheme_dark_color_1);
            colorAccentId = res.getColor(R.color.color_scheme_accent_color_1);
        } else if (colorState == STATE_VIVID) {
            colorBaseId = res.getColor(R.color.color_scheme_base_color_2);
            colorLightId = res.getColor(R.color.color_scheme_light_color_2);
            colorNomalId = res.getColor(R.color.color_scheme_nomal_color_2);
            colorDarkId = res.getColor(R.color.color_scheme_dark_color_2);
            colorAccentId = res.getColor(R.color.color_scheme_accent_color_2);
        }

        mContentHolder.setBackgroundColor(colorDarkId);
        mContentHeader.setBackgroundColor(colorAccentId);
        mContentHeader.setTextColor(colorBaseId);
        mContentUpper.setBackgroundColor(colorNomalId);
        mContentUpper.setTextColor(colorLightId);
        mContentLower.setBackgroundColor(colorLightId);
        mContentLower.setTextColor(colorNomalId);

    }

    //設定画面に遷移する (Intent)
    private void intentSetting(int colorState) {
        Intent intent = new Intent(getApplicationContext(), SubActivity.class);
        intent.putExtra("current_color", colorState);
        startActivity(intent);
    }

    private void loadIntentInfo() {
        //色の情報をintentから受け取る
        Intent intent = getIntent();
        mColorState = intent.getIntExtra("changed_color", STATE_LIGHT);
    }

    private void updateTextViewBackgroundColor(int colorState) {
        Resources res = getResources();
        int colorRes = res.getColor(R.color.bg_black);

        if (colorState == STATE_LIGHT) {
            colorRes = res.getColor(R.color.bg_black);
        } else if (colorState == STATE_DARK) {
            colorRes = res.getColor(R.color.bg_blue);
        } else if (colorState == STATE_VIVID) {
            colorRes = res.getColor(R.color.bg_red);
        }

        mTextView.setTextColor(getResources().getColor(R.color.bg_black));

        mTextView.setTextColor(colorRes);
    }

    private void setOnClickToButton() {
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentSetting(mColorState);
            }
        });
    }
}
