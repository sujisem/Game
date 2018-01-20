package com.cs.niu.z1803824.findme;

public class Puzzle {
    private String question;
    private String answer;
    private int id;

    public Puzzle(int id,String question, String answer) {
        this.question = question;
        this.answer = answer;
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
