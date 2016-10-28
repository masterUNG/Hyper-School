package appewtc.masterung.hyperschool;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_service);

        //Bind Widget
        questionEditText = (EditText) findViewById(R.id.editText3);
        choice1EditText = (EditText) findViewById(R.id.editText4);
        choice2EditText = (EditText) findViewById(R.id.editText5);
        choice3EditText = (EditText) findViewById(R.id.editText6);
        choice4EditText = (EditText) findViewById(R.id.editText7);
        spinner = (Spinner) findViewById(R.id.spinner);
        button = (Button) findViewById(R.id.button2);
        textView = (TextView) findViewById(R.id.textView8);

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

}   // Main Class
