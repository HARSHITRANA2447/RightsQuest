package com.example.rightsquest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{


    TextView totalQuestionstextView;
    TextView questionTextView;
    Button ansA,ansB,ansC,ansD;
    Button submitBtn;

    int score=0;
    int totalQuestion = QuestionAnswers.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer ="";
    List<Integer> questionIndices;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        totalQuestionstextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.Ans_A);
        ansB = findViewById(R.id.Ans_B);
        ansC = findViewById(R.id.Ans_C);
        ansD = findViewById(R.id.Ans_D);
        submitBtn= findViewById(R.id.submit_btn);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        totalQuestionstextView.setText("Total question : "+totalQuestion);

        shuffleQuestions();
        loadNewQuestion();
    }

    void shuffleQuestions() {
        questionIndices = new ArrayList<>();
        for (int i = 0; i < totalQuestion; i++) {
            questionIndices.add(i);
        }
        Collections.shuffle(questionIndices);
    }
    @Override
    public void onClick(View v) {
        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);
        Button clickedButton = (Button) v;
        if (clickedButton.getId() == R.id.submit_btn) {
            if (currentQuestionIndex < totalQuestion - 1) { // Check if there are more questions to load
                currentQuestionIndex++;
                loadNewQuestion();
                if (selectedAnswer.equals(QuestionAnswers.correctAnswer[currentQuestionIndex])) {
                    score++;
                }
            } else {
                // Handle the case when there are no more questions
                finishQuiz();
            }
        } else {
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.BLUE);
        }
        int shuffledIndex =questionIndices.get(currentQuestionIndex);
        questionTextView.setText(QuestionAnswers.question[shuffledIndex]);
        ansA.setText(QuestionAnswers.choices[shuffledIndex][0]);
        ansB.setText(QuestionAnswers.choices[shuffledIndex][1]);
        ansC.setText(QuestionAnswers.choices[shuffledIndex][2]);
        ansD.setText(QuestionAnswers.choices[shuffledIndex][3]);
    }
    void loadNewQuestion(){
        if(currentQuestionIndex == totalQuestion){
            finishQuiz();
            return;
        }

        questionTextView.setText(QuestionAnswers.question[currentQuestionIndex]);
        ansA.setText(QuestionAnswers.choices[currentQuestionIndex][0]);
        ansB.setText(QuestionAnswers.choices[currentQuestionIndex][1]);
        ansC.setText(QuestionAnswers.choices[currentQuestionIndex][2]);
        ansD.setText(QuestionAnswers.choices[currentQuestionIndex][3]);
    }
    void finishQuiz(){
        String passStatus ="";
        if(score > totalQuestion*0.60){
            passStatus = "Passed";
        }else {
            passStatus="Failed";
        }

       new AlertDialog.Builder(this)
               .setTitle(passStatus)
               .setMessage("Score is "+score+"out of "+totalQuestion)
               .setPositiveButton("Restart",(dialogInterface, i) -> restartQuiz() )
               .setCancelable(false)
               .show();
    }
    void restartQuiz(){
        score=0;
        currentQuestionIndex=0;
        loadNewQuestion();
    }
}