package com.mrwojack.gameopardy.fragments.questions;

public class VerdaderoFalsoQuestions {
    private String question;
    private String option1;
    private String option2;
    private int answer;

    public VerdaderoFalsoQuestions(){

    }

    public VerdaderoFalsoQuestions(String question, String option1, String option2, int answer) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.answer = answer;
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}

