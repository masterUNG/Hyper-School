package appewtc.masterung.hyperschool;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private EditText userEditText, passwordEditText;
    private Button button;
    private String userString, passwordString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind Widget
        userEditText = (EditText) findViewById(R.id.editText);
        passwordEditText = (EditText) findViewById(R.id.editText2);
        button = (Button) findViewById(R.id.button);

        //Button Controller
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Get Value From Edittext
                userString = userEditText.getText().toString().trim();
                passwordString = passwordEditText.getText().toString().trim();

                //Check Space
                if (userString.equals("") || passwordString.equals("")) {

                    MyAlert myAlert = new MyAlert(MainActivity.this, "มีช่องว่าง", "กรุณากรอกทุกช่องคะ");
                    myAlert.myDialog();


                } else {
                    //NO Space
                    String strURL = "http://swiftcodingthai.com/voc/get_user_master.php";
                    SynUser synUser = new SynUser(MainActivity.this);
                    synUser.execute(strURL);

                }   // if

            }   // onClick
        });


    }   // Main Method


    //Inner Class
    private class SynUser extends AsyncTask<String, Void, String> {

        private Context context;
        private boolean aBoolean = true;
        private String[] userStrings;
        private String truePasswordString;

        public SynUser(Context context) {
            this.context = context;
        }

        @Override
        protected String doInBackground(String... strings) {

            try {

                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url(strings[0]).build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();


            } catch (Exception e) {
                Log.d("26octV1", "e doIn ==> " + e.toString());
                return null;
            }


        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Log.d("26octV1", "JSON ==> " + s);

            try {

                JSONArray jsonArray = new JSONArray(s);
                userStrings = new String[5];

                for (int i=0;i<jsonArray.length();i++) {

                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    if () {
                        //True

                    }

                }   // for



            } catch (Exception e) {
                e.printStackTrace();
            }



        }
    }   // SynUser Class


}   // Main Class นี่คือคลาสหลัก





