package appewtc.masterung.hyperschool;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TeacherService extends AppCompatActivity {

    //Explicit
    private EditText questionEditText, choice1EditText, choice2EditText,
            choice3EditText, choice4EditText;
    private Spinner spinner;
    private Button button;
    private TextView textView;
    private String questionString, choice1String, choice2String,
            choice3String, choice4String, trueAnswerString;
    private int anInt = 0;
    private String[] loginStrings;
    private String dateString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_service);

        loginStrings = getIntent().getStringArrayExtra("Login");

        //Bind Widget
        questionEditText = (EditText) findViewById(R.id.editText3);
        choice1EditText = (EditText) findViewById(R.id.editText4);
        choice2EditText = (EditText) findViewById(R.id.editText5);
        choice3EditText = (EditText) findViewById(R.id.editText6);
        choice4EditText = (EditText) findViewById(R.id.editText7);
        spinner = (Spinner) findViewById(R.id.spinner);
        button = (Button) findViewById(R.id.button2);
        textView = (TextView) findViewById(R.id.textView8);

        textView.setText("อาจารย์ " + loginStrings[4]);

        //Find Date
        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateString = dateFormat.format(calendar.getTime());


        //Button Controller
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Get Value From EditText
                questionString = questionEditText.getText().toString().trim();
                choice1String = choice1EditText.getText().toString().trim();
                choice2String = choice2EditText.getText().toString().trim();
                choice3String = choice3EditText.getText().toString().trim();
                choice4String = choice4EditText.getText().toString().trim();

                //Check Space
                if (questionString.equals("") || choice1String.equals("") ||
                        choice2String.equals("") || choice3String.equals("") ||
                        choice4String.equals("")) {
                    // Have Space

                    MyAlert myAlert = new MyAlert(TeacherService.this,
                            "มีช่องว่าง", "กรุณากรอกทุกช่อง คะ");
                    myAlert.myDialog();

                } else if (anInt == 0) {
                    //Non Choose Answer
                    MyAlert myAlert = new MyAlert(TeacherService.this,
                            "ยังไม่เลือกคำตอบ", "กรุณาเลือกสักข้อสิ คะ");
                    myAlert.myDialog();

                } else {

                    uploadAnConfirmData();

                }

                Log.d("28octV1", "TrueAnswer ==> " + anInt);


            }   // onClick
        });


        //Spinner Controller
        String[] showAnswer = new String[]{"โปรดเลือกคำตอบ", "1", "2", "3", "4"};
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(TeacherService.this,
                android.R.layout.simple_list_item_1, showAnswer);
        spinner.setAdapter(stringArrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                anInt = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                anInt = 0;
            }

        });


    }   // Main Method


    //Inner Class
    private class UploadDataToServer extends AsyncTask<String, Void, String> {

        //Explicit
        private Context context;

        public UploadDataToServer(Context context) {
            this.context = context;
        }

        @Override
        protected String doInBackground(String... strings) {

            try {

                Log.d("28octV2", "Teacher ==> " + loginStrings[4]);
                Log.d("28octV2", "ExDate ==> " + dateString);
                Log.d("28octV2", "Question ==> " + questionString);
                Log.d("28octV2", "Choice1 ==> " + choice1String);
                Log.d("28octV2", "Choice2 ==> " + choice2String);
                Log.d("28octV2", "Choice3 ==> " + choice3String);
                Log.d("28octV2", "Choice4 ==> " + choice4String);
                Log.d("28octV2", "TrueAnswer ==> " + anInt);


            } catch (Exception e) {
                Log.d("28octV2", "e doIn ==>" + e.toString());
                return null;
            }


            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }   // Upload Class


    private void uploadAnConfirmData() {

        MyConstant myConstant = new MyConstant();
        UploadDataToServer uploadDataToServer = new UploadDataToServer(TeacherService.this);
        uploadDataToServer.execute(myConstant.getUrlAddQuestionString());

    }

}   // Main Class
