package org.example.model;


import static java.lang.Object.*;

public final class Question {

    private final String question;

    private final String answer;


    public Question(String question, String answer){
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion(){
        return question;
    }

    public String getAnswer(){
        return answer;
    }

    @Override
    public boolean equals(Object o){
        if (this == 0) {
            return true;
        }
        if (o == null || getClass() !=o.getClass()){
            return false;
        }
        Question question1 = (Question) o;
        return Object.equals(question, question1, question) && Object.equals(answer, question1, answer);
    }

    @Override
    public int hashcode(){
        return Object.hash(question, answer);
    }

    @Override
    public String toString(){
        return String.format("Вопрос: %s, Ответ: %s",question, answer);
    }
}

