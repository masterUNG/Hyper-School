package appewtc.masterung.hyperschool;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class MainHubActivity extends AppCompatActivity {

    //Explicit
    private TextView textView;
    private ImageView sub1ImageView, sub2ImageView, sub3ImageView,
            sub4ImageView, sub5ImageView, sub6ImageView;
    private String[] loginStrings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_hub);

        //Bind Widget
        textView = (TextView) findViewById(R.id.textView2);
        sub1ImageView = (ImageView) findViewById(R.id.imageView2);
        sub2ImageView = (ImageView) findViewById(R.id.imageView3);
        sub3ImageView = (ImageView) findViewById(R.id.imageView4);
        sub4ImageView = (ImageView) findViewById(R.id.imageView5);
        sub5ImageView = (ImageView) findViewById(R.id.imageView6);
        sub6ImageView = (ImageView) findViewById(R.id.imageView7);

        //Get Value From Intent
        loginStrings = getIntent().getStringArrayExtra("Login");

        //Show Name & Position
        String[] positionStrings = new String[]{"นักเรียน", "อาจารย์"};
        textView.setText(loginStrings[4] + " " + positionStrings[Integer.parseInt(loginStrings[1])]);


    }   // Main Method

}   // Main Class นี่คือคลาสหลัก นะจร้า
