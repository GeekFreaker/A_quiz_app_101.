package android.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    /*---- Variable Declaration ----*/
    int totalScore = 0;

    // result
    String result = "";

    /*---- Component Declaration ----*/
    // Submission button
    Button getAnswers;

    //  Answers for Question 1
    CheckBox chkOption1; // correct answer
    CheckBox chkOption2;
    CheckBox chkOption3;
    CheckBox chkOption4;

    //  Answers for Question 2
    RadioButton chkOption5;
    RadioButton chkOption6;
    RadioButton chkOption7;
    RadioButton chkOption8; //correct answer

    //  Answers for Question 3
    EditText txtAnswer9; // check for govan mbeki

    //  Answers for Question 4
    RadioButton chkOption10; // correct answer
    RadioButton chkOption11;

    //  Answers for Question 5
    CheckBox chkOption12;
    CheckBox chkOption13;
    CheckBox chkOption14;
    CheckBox chkOption15;
    CheckBox chkOption16;
    CheckBox chkOption17; // correct answer

    Toast resultsToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiation of components.
        getAnswers = (Button) findViewById(R.id.answer);

        chkOption1 = (CheckBox) findViewById(R.id.q1_option_a);
        chkOption2 = (CheckBox) findViewById(R.id.q1_option_b);
        chkOption3 = (CheckBox) findViewById(R.id.q1_option_c);
        chkOption4 = (CheckBox) findViewById(R.id.q1_option_d);

        chkOption5 = (RadioButton) findViewById(R.id.q2_option_a);
        chkOption6 = (RadioButton) findViewById(R.id.q2_option_b);
        chkOption7 = (RadioButton) findViewById(R.id.q2_option_c);
        chkOption8 = (RadioButton) findViewById(R.id.q2_option_d);

        txtAnswer9 = (EditText) findViewById(R.id.text_answer_3);

        chkOption10 = (RadioButton) findViewById(R.id.q4_option_a);
        chkOption11 = (RadioButton) findViewById(R.id.q4_option_b);

        chkOption12 = (CheckBox) findViewById(R.id.q5_option_a);
        chkOption13 = (CheckBox) findViewById(R.id.q5_option_b);
        chkOption14 = (CheckBox) findViewById(R.id.q5_option_c);
        chkOption15 = (CheckBox) findViewById(R.id.q5_option_d);
        chkOption16 = (CheckBox) findViewById(R.id.q5_option_e);
        chkOption17 = (CheckBox) findViewById(R.id.q5_option_f);
    }

    public void SubmitAnswers(View view) {
        totalScore = 0;
        totalScore += SubmitAnswer1();
        totalScore += SubmitAnswer2();
        totalScore += SubmitAnswer3();
        totalScore += SubmitAnswer4();
        totalScore += SubmitAnswer5();
        DisplayResult();
    }

    private void DisplayResult() {
        int percentage = 0;
        percentage = (totalScore *100)/5;
        resultsToast = Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT);

        if(totalScore >= 4){
            resultsToast.getView().setBackgroundColor(getResources().getColor(R.color.green));
            result = getText(R.string.first_result).toString() + " : " + percentage+ " %";
        }else if(totalScore <=0){
            resultsToast.getView().setBackgroundColor(getResources().getColor(R.color.red));
            result= getText(R.string.third_result).toString();
        }else {
            resultsToast.getView().setBackgroundColor(getResources().getColor(R.color.blue));
            result = getText(R.string.second_result).toString() + " : " + percentage + " %";
        }
        resultsToast.show();
    }

    private int SubmitAnswer1() {
        if(chkOption1.isChecked() && !chkOption2.isChecked() && !chkOption3.isChecked() && !chkOption4.isChecked()){
            return 1;
        }else{
            return 0;
        }
    }

    private int SubmitAnswer2() {
        if(chkOption8.isChecked()){
            return 1;
        }else{
            return 0;
        }
    }

    private int SubmitAnswer3(){
       String Answer = txtAnswer9.getText().toString();
      if(Answer.equals(getText(R.string.answer_three).toString())){
          return 1;
      }
      else{
          return 0;
      }
    }

    private int SubmitAnswer4() {
        if(chkOption10.isChecked()){
            return 1;
        }else{
            return 0;
        }
    }

    private int SubmitAnswer5(){
        if(chkOption17.isChecked() && !chkOption12.isChecked() && !chkOption13.isChecked() && !chkOption14.isChecked() && !chkOption15.isChecked() && !chkOption16.isChecked()){
            return 1;
        }else{
            return 0;
        }
    }

    }
