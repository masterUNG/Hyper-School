package appewtc.masterung.hyperschool;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

                for (int i = 0; i < jsonArray.length(); i++) {

                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    if (userString.equals(jsonObject.getString("User"))) {
                        //True

                        aBoolean = false;
                        userStrings[0] = jsonObject.getString("id");
                        userStrings[1] = jsonObject.getString("Position");
                        userStrings[2] = jsonObject.getString("User");
                        userStrings[3] = jsonObject.getString("Password");
                        userStrings[4] = jsonObject.getString("Name");

                    }

                }   // for

                Log.d("26octV1", "passUser==> " + passwordString);
                Log.d("26octV1", "passTure==> " + userStrings[3]);


                if (aBoolean) {
                    //User False
                    MyAlert myAlert = new MyAlert(MainActivity.this, "User False",
                            "No This User in my Database");
                    myAlert.myDialog();
                } else if (passwordString.equals(userStrings[3])) {
                    //Password True
                    Toast.makeText(MainActivity.this, "Welcome " + userStrings[4],
                            Toast.LENGTH_SHORT).show();

                    //Intent to Hub
                    Intent intent = new Intent(MainActivity.this, MainHubActivity.class);
                    intent.putExtra("Login", userStrings);
                    startActivity(intent);
                    finish();



                } else {
                    //Password False
                    MyAlert myAlert = new MyAlert(MainActivity.this,
                            "Password Fasle", "Please Try Again Password False");
                    myAlert.myDialog();



                }


            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }   // SynUser Class


}   // Main Class นี่คือคลาสหลัก





