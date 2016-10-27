package appewtc.masterung.hyperschool;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainHubActivity extends AppCompatActivity implements View.OnClickListener {

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

        //Image Controller
        sub1ImageView.setOnClickListener(MainHubActivity.this);
        sub2ImageView.setOnClickListener(MainHubActivity.this);
        sub3ImageView.setOnClickListener(MainHubActivity.this);
        sub4ImageView.setOnClickListener(MainHubActivity.this);
        sub5ImageView.setOnClickListener(MainHubActivity.this);
        sub6ImageView.setOnClickListener(MainHubActivity.this);


    }   // Main Method

    @Override
    public void onClick(View view) {

        int index = 0;

        //For Teacher
        if (Integer.parseInt(loginStrings[1]) == 1) {

            switch (view.getId()) {

                case R.id.imageView2:
                    index = 0;
                    break;
                case R.id.imageView3:
                    index = 1;
                    break;
                case R.id.imageView4:
                    index = 2;
                    break;
                case R.id.imageView5:
                    index = 3;
                    break;
                case R.id.imageView6:
                    index = 4;
                    break;
                case R.id.imageView7:
                    index = 5;
                    break;

            }   // switch

            Intent intent = new Intent(MainHubActivity.this, TeacherService.class);
            intent.putExtra("Login", loginStrings);
            intent.putExtra("Index", index);
            startActivity(intent);


        }   // if


    }   // onClick

}   // Main Class นี่คือคลาสหลัก นะจร้า








