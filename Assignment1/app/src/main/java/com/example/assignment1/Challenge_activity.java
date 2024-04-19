package com.example.rectangles;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Challenge_activity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    private static final String PREF_NAME = "MyPrefs";
    private static final String KEY_ANSWER1 = "answer1";
    private static final String KEY_ANSWER2 = "answer2";
    private static final String KEY_ANSWER3 = "answer3";
    private static final String KEY_ANSWER4 = "answer4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rectangle_challenge);

        sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);

        Button btn_submit = (Button) findViewById(R.id.btn_submit);
        TextView txt_result =(TextView) findViewById(R.id.txt_result);

        Spinner choices1 =(Spinner)findViewById(R.id.question1_choices);
        Spinner choices2 =(Spinner)findViewById(R.id.question2_choices);
        Spinner choices3 =(Spinner)findViewById(R.id.question3_choices);
        Spinner choices4 =(Spinner)findViewById(R.id.question4_choices);


        String savedAnswer1 = sharedPreferences.getString(KEY_ANSWER1, "");
        String savedAnswer2 = sharedPreferences.getString(KEY_ANSWER2, "");
        String savedAnswer3 = sharedPreferences.getString(KEY_ANSWER3, "");
        String savedAnswer4 = sharedPreferences.getString(KEY_ANSWER4, "");


        setSpinnerSelection(choices1, savedAnswer1, R.array.question1_choices);
        setSpinnerSelection(choices2, savedAnswer2, R.array.question2_choices);
        setSpinnerSelection(choices3, savedAnswer3, R.array.question3_choices);
        setSpinnerSelection(choices4, savedAnswer4, R.array.question4_choices);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input1 = String.valueOf(choices1.getSelectedItem());
                String input2 = String.valueOf(choices2.getSelectedItem());
                String input3 = String.valueOf(choices3.getSelectedItem());
                String input4 = String.valueOf(choices4.getSelectedItem());


                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_ANSWER1, input1);
                editor.putString(KEY_ANSWER2, input2);
                editor.putString(KEY_ANSWER3, input3);
                editor.putString(KEY_ANSWER4, input4);
                editor.apply();


                double count = 0;
                if (input1.equals("12")) {
                    count += 2.5;
                }
                if (input2.equals("120")) {
                    count += 2.5;
                }
                if (input3.equals("9")) {
                    count += 2.5;
                }
                if (input4.equals("40")) {
                    count += 2.5;
                }

                TextView check1 = findViewById(R.id.check1);
                TextView check2 = findViewById(R.id.check2);
                TextView check3 = findViewById(R.id.check3);
                TextView check4 = findViewById(R.id.check4);

                check1.setText(input1.equals("12") ? getString(R.string.Correct) : getString(R.string.Incorrect));
                check2.setText(input2.equals("120") ? getString(R.string.Correct) : getString(R.string.Incorrect));
                check3.setText(input3.equals("9") ? getString(R.string.Correct) : getString(R.string.Incorrect));
                check4.setText(input4.equals("40") ? getString(R.string.Correct) : getString(R.string.Incorrect));

                check1.setTextColor(getResources().getColor(input1.equals("12") ? R.color.Green : R.color.Red));
                check2.setTextColor(getResources().getColor(input2.equals("120") ? R.color.Green : R.color.Red));
                check3.setTextColor(getResources().getColor(input3.equals("9") ? R.color.Green : R.color.Red));
                check4.setTextColor(getResources().getColor(input4.equals("40") ? R.color.Green : R.color.Red));

                txt_result.setText("Your mark is " + count + "/10");
            }
        });
    }

    private void setSpinnerSelection(Spinner spinner, String savedAnswer, int choicesArrayResId) {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                choicesArrayResId, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        int spinnerPosition = adapter.getPosition(savedAnswer);
        spinner.setSelection(spinnerPosition);
    }
}