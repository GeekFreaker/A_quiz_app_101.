package android.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    /*---- Variable Declaration ----*/
    public int Answer1=0;
    public int Answer2=0;
    public String Answer3="";
    public int Answer4=0;
    public int Answer5=0;

    int TotalScore = 0;

    // result
    TextView Results;
    String result = "";

    /*---- Component Declaration ----*/
    // Submission button
    Button getAnswers;

    //  Answers for Question 1
    CheckBox Option1; // correct answer
    CheckBox Option2;
    CheckBox Option3;
    CheckBox Option4;

    //  Answers for Question 2
    RadioButton Option5;
    RadioButton Option6;
    RadioButton Option7;
    RadioButton Option8; //correct answer

    //  Answers for Question 3
    EditText txtAnswer9; // check for govan mbeki

    //  Answers for Question 4
    RadioButton Option10; // correct answer
    RadioButton Option11;

    //  Answers for Question 5
    CheckBox Option12;
    CheckBox Option13;
    CheckBox Option14;
    CheckBox Option15;
    CheckBox Option16;
    CheckBox Option17; // correct answer

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiation of components.
        getAnswers = (Button) findViewById(R.id.answer);

        Option1 = (CheckBox) findViewById(R.id.q1_option_a);
        Option2 = (CheckBox) findViewById(R.id.q1_option_b);
        Option3 = (CheckBox) findViewById(R.id.q1_option_c);
        Option4 = (CheckBox) findViewById(R.id.q1_option_d);

        Option5 = (RadioButton) findViewById(R.id.q2_option_a);
        Option6 = (RadioButton) findViewById(R.id.q2_option_b);
        Option7 = (RadioButton) findViewById(R.id.q2_option_c);
        Option8 = (RadioButton) findViewById(R.id.q2_option_d);

        txtAnswer9 = (EditText) findViewById(R.id.text_answer_3);

        Option10 = (RadioButton) findViewById(R.id.q4_option_a);
        Option11 = (RadioButton) findViewById(R.id.q4_option_b);

        Option12 = (CheckBox) findViewById(R.id.q5_option_a);
        Option13 = (CheckBox) findViewById(R.id.q5_option_b);
        Option14 = (CheckBox) findViewById(R.id.q5_option_c);
        Option15 = (CheckBox) findViewById(R.id.q5_option_d);
        Option16 = (CheckBox) findViewById(R.id.q5_option_e);
        Option17 = (CheckBox) findViewById(R.id.q5_option_f);

        Results = (TextView) findViewById(R.id.results);
    }

    public void SubmitAnswers(View view) {
        TotalScore = 0;
        TotalScore += SubmitAnswer1();
        TotalScore += SubmitAnswer2();
        TotalScore += SubmitAnswer3();
        TotalScore += SubmitAnswer4();
        TotalScore += SubmitAnswer5();
        DisplayResult();
    }

    private void DisplayResult() {
        int percentage =(TotalScore/5)*100;
        if(TotalScore > 4){
            Results.setTextColor(getResources().getColor(R.color.green));
            result = getText(R.string.first_result).toString() + " : " + percentage+ "%";
        }else if(TotalScore <= 3 && TotalScore!=0){
            Results.setTextColor(getResources().getColor(R.color.blue));
            result= getText(R.string.second_result).toString() + " : " + percentage +"%";
        }else if(TotalScore == 0){
            Results.setTextColor(getResources().getColor(R.color.red));
            result= getText(R.string.third_result).toString();
        }
        Results.setText(result);
    }

    private int SubmitAnswer1() {
        if(Option1.isChecked() && !Option2.isChecked() && !Option3.isChecked() && !Option4.isChecked()){
            return 1;
        }else{
            return 0;
        }
    }

    private int SubmitAnswer2() {
        if(Option8.isChecked()){
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
        if(Option10.isChecked()){
            return 1;
        }else{
            return 0;
        }
    }

    private int SubmitAnswer5(){
        if(Option17.isChecked() && !Option12.isChecked() && !Option13.isChecked() && !Option14.isChecked() && !Option15.isChecked() && !Option16.isChecked()){
            return 1;
        }else{
            return 0;
        }
    }

    }
