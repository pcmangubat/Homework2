package com.example.mr.homework2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioUS, radioCanada;
    private Button buttonOK, buttonCancel;
    private TextView textView;
    private EditText userName;
    private Switch switchEighteen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.radio_group_country);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // find which radio button is selected
                if (checkedId == R.id.radio_us) {
                    Toast.makeText(getApplicationContext(), "choice: US",
                            Toast.LENGTH_SHORT).show();
                } else if (checkedId == R.id.radio_canada) {
                    Toast.makeText(getApplicationContext(), "choice: CANADA",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        switchEighteen = (Switch) findViewById(R.id.switch_eighteen);
        switchEighteen.setChecked(false);

        buttonOK = (Button) findViewById(R.id.button_ok);
        buttonOK.setEnabled(false);
        //attach a listener to check for changes in state
        switchEighteen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {

                if(isChecked){
                    buttonOK.setEnabled(true);
                    Toast.makeText(getApplicationContext(), "choice: 18 and over",
                            Toast.LENGTH_SHORT).show();
                }else{
                    buttonOK.setEnabled(false);
                    Toast.makeText(getApplicationContext(), "choice: under 18",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        //check the current state before we display the screen
        if(switchEighteen.isChecked()){
            buttonOK.setEnabled(true);
            Toast.makeText(getApplicationContext(), "choice: 18 and over",
                    Toast.LENGTH_SHORT).show();
        }
        else {
            buttonOK.setEnabled(false);
            Toast.makeText(getApplicationContext(), "choice: 18 and over",
                    Toast.LENGTH_SHORT).show();
        }


        buttonOK = (Button) findViewById(R.id.button_ok);
        userName = (EditText) findViewById(R.id.editText);
        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioUS = (RadioButton) findViewById(R.id.radio_us);
                radioCanada = (RadioButton) findViewById(R.id.radio_canada);
                String userNameString = userName.getText().toString();
                String countryString = radioUS.isChecked() ? radioUS.getText().toString() : (radioCanada.isChecked() ? radioCanada.getText().toString() : "");
                String ageString = switchEighteen.isChecked() ? "OVER 18" : "UNDER 18";
                Toast.makeText(getApplicationContext(), userNameString + " " + countryString + " " + ageString,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

}